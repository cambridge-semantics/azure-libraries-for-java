/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.v2.management.compute.implementation;

import com.microsoft.azure.v2.Page;
import com.microsoft.azure.v2.PagedList;
import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.v2.management.compute.VirtualMachineImage;
import com.microsoft.azure.v2.management.compute.VirtualMachineImagesInSku;
import com.microsoft.azure.v2.management.compute.VirtualMachineSku;
import com.microsoft.azure.v2.management.resources.fluentcore.arm.collection.implementation.ReadableWrappersImpl;
import com.microsoft.rest.v2.RestException;
import io.reactivex.Observable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The implementation for {@link VirtualMachineImagesInSku}.
 */
@LangDefinition
class VirtualMachineImagesInSkuImpl implements VirtualMachineImagesInSku {

    private final VirtualMachineImagesInner innerCollection;
    private final VirtualMachineSku sku;

    VirtualMachineImagesInSkuImpl(VirtualMachineSku sku, VirtualMachineImagesInner innerCollection) {
        this.sku = sku;
        this.innerCollection = innerCollection;
    }

    public PagedList<VirtualMachineImage> list() {
        final List<VirtualMachineImage> images = new ArrayList<>();
        for (VirtualMachineImageResourceInner inner
                : innerCollection.list(
                this.sku.region().toString(),
                this.sku.publisher().name(),
                this.sku.offer().name(),
                this.sku.name())) {
            String version = inner.name();
            images.add(new VirtualMachineImageImpl(
                    this.sku.region(),
                    this.sku.publisher().name(),
                    this.sku.offer().name(),
                    this.sku.name(),
                    version,
                    innerCollection.get(this.sku.region().toString(),
                            this.sku.publisher().name(),
                            this.sku.offer().name(),
                            this.sku.name(),
                            version)));
        }
        Page<VirtualMachineImage> page = new Page<VirtualMachineImage>() {
            @Override
            public String nextPageLink() {
                return null;
            }

            @Override
            public List<VirtualMachineImage> items() {
                return images;
            }
        };
        return new PagedList<VirtualMachineImage>(page) {
            @Override
            public Page<VirtualMachineImage> nextPage(String nextPageLink) throws RestException, IOException {
                return null;
            }
        };
    }

    @Override
    public Observable<VirtualMachineImage> listAsync() {
        final String skuRegion = this.sku.region().toString();
        final String skuPublisherName = this.sku.publisher().name();
        final String skuOfferName = this.sku.offer().name();
        final String skuName = this.sku.name();

        return ReadableWrappersImpl.convertListToInnerAsync(innerCollection.listAsync(skuRegion, skuPublisherName, skuOfferName, skuName).toObservable())
                .flatMap(virtualMachineImageResourceInner -> innerCollection.getAsync(skuRegion, skuPublisherName, skuOfferName, skuName, virtualMachineImageResourceInner.name())
                        .toObservable()
                        .map(virtualMachineImageInner -> {
                            final VirtualMachineImageImpl virtualMachineImage = new VirtualMachineImageImpl(
                                    this.sku.region(),
                                    skuPublisherName,
                                    skuOfferName,
                                    skuName,
                                    virtualMachineImageResourceInner.name(),
                                    virtualMachineImageInner);
                            return virtualMachineImage;
                        }));
    }
}