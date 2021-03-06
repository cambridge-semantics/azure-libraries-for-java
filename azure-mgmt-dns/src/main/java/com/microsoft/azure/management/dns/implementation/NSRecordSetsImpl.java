/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.management.dns.implementation;

import com.microsoft.azure.PagedList;
import com.microsoft.azure.management.apigeneration.LangDefinition;
import com.microsoft.azure.management.dns.NSRecordSet;
import com.microsoft.azure.management.dns.NSRecordSets;
import com.microsoft.azure.management.dns.RecordType;
import rx.Observable;

/**
 * Implementation of NSRecordSets.
 */
@LangDefinition
class NSRecordSetsImpl
        extends DnsRecordSetsBaseImpl<NSRecordSet, NSRecordSetImpl>
        implements NSRecordSets {

    NSRecordSetsImpl(DnsZoneImpl dnsZone) {
        super(dnsZone, RecordType.NS);
    }

    @Override
    public NSRecordSetImpl getByName(String name) {
        RecordSetInner inner = this.parent().manager().inner().recordSets().get(
                this.dnsZone.resourceGroupName(),
                this.dnsZone.name(),
                name,
                this.recordType);
        if (inner == null) {
            return null;
        }
        return new NSRecordSetImpl(inner.name(), this.dnsZone, inner);
    }

    @Override
    protected PagedList<NSRecordSet> listIntern(String recordSetNameSuffix, Integer pageSize) {
        return super.wrapList(this.parent().manager().inner().recordSets().listByType(
                this.dnsZone.resourceGroupName(),
                this.dnsZone.name(),
                this.recordType,
                pageSize,
                recordSetNameSuffix));
    }

    @Override
    protected Observable<NSRecordSet> listInternAsync(String recordSetNameSuffix, Integer pageSize) {
        return wrapPageAsync(this.parent().manager().inner().recordSets().listByTypeAsync(
                this.dnsZone.resourceGroupName(),
                this.dnsZone.name(),
                this.recordType));
    }

    @Override
    protected NSRecordSetImpl wrapModel(RecordSetInner inner) {
        if (inner == null) {
            return null;
        }
        return new NSRecordSetImpl(inner.name(), this.dnsZone, inner);
    }
}