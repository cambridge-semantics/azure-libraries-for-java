/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.v2.management.resources.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.azure.v2.management.resources.DeploymentPropertiesExtended;
import com.microsoft.azure.v2.management.resources.ResourceManagementErrorWithDetails;

/**
 * Information from validate template deployment response.
 */
public final class DeploymentValidateResultInner {
    /**
     * Validation error.
     */
    @JsonProperty(value = "error")
    private ResourceManagementErrorWithDetails error;

    /**
     * The template deployment properties.
     */
    @JsonProperty(value = "properties")
    private DeploymentPropertiesExtended properties;

    /**
     * Get the error value.
     *
     * @return the error value.
     */
    public ResourceManagementErrorWithDetails error() {
        return this.error;
    }

    /**
     * Set the error value.
     *
     * @param error the error value to set.
     * @return the DeploymentValidateResultInner object itself.
     */
    public DeploymentValidateResultInner withError(ResourceManagementErrorWithDetails error) {
        this.error = error;
        return this;
    }

    /**
     * Get the properties value.
     *
     * @return the properties value.
     */
    public DeploymentPropertiesExtended properties() {
        return this.properties;
    }

    /**
     * Set the properties value.
     *
     * @param properties the properties value to set.
     * @return the DeploymentValidateResultInner object itself.
     */
    public DeploymentValidateResultInner withProperties(DeploymentPropertiesExtended properties) {
        this.properties = properties;
        return this;
    }
}