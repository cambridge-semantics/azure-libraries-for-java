/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.implementation;

import org.joda.time.Period;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The response to a metrics query.
 */
public class ResponseInner {
    /**
     * The integer value representing the cost of the query, for data case.
     */
    @JsonProperty(value = "cost")
    private Double cost;

    /**
     * The timespan for which the data was retrieved. Its value consists of two
     * datetimes concatenated, separated by '/'.  This may be adjusted in the
     * future and returned back from what was originally requested.
     */
    @JsonProperty(value = "timespan", required = true)
    private String timespan;

    /**
     * The interval (window size) for which the metric data was returned in.
     * This may be adjusted in the future and returned back from what was
     * originally requested.  This is not present if a metadata request was
     * made.
     */
    @JsonProperty(value = "interval")
    private Period interval;

    /**
     * The namespace of the metrics been queried.
     */
    @JsonProperty(value = "namespace")
    private String namespace;

    /**
     * The region of the resource been queried for metrics.
     */
    @JsonProperty(value = "resourceregion")
    private String resourceregion;

    /**
     * the value of the collection.
     */
    @JsonProperty(value = "value", required = true)
    private List<MetricInner> value;

    /**
     * Get the integer value representing the cost of the query, for data case.
     *
     * @return the cost value
     */
    public Double cost() {
        return this.cost;
    }

    /**
     * Set the integer value representing the cost of the query, for data case.
     *
     * @param cost the cost value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withCost(Double cost) {
        this.cost = cost;
        return this;
    }

    /**
     * Get the timespan for which the data was retrieved. Its value consists of two datetimes concatenated, separated by '/'.  This may be adjusted in the future and returned back from what was originally requested.
     *
     * @return the timespan value
     */
    public String timespan() {
        return this.timespan;
    }

    /**
     * Set the timespan for which the data was retrieved. Its value consists of two datetimes concatenated, separated by '/'.  This may be adjusted in the future and returned back from what was originally requested.
     *
     * @param timespan the timespan value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withTimespan(String timespan) {
        this.timespan = timespan;
        return this;
    }

    /**
     * Get the interval (window size) for which the metric data was returned in.  This may be adjusted in the future and returned back from what was originally requested.  This is not present if a metadata request was made.
     *
     * @return the interval value
     */
    public Period interval() {
        return this.interval;
    }

    /**
     * Set the interval (window size) for which the metric data was returned in.  This may be adjusted in the future and returned back from what was originally requested.  This is not present if a metadata request was made.
     *
     * @param interval the interval value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withInterval(Period interval) {
        this.interval = interval;
        return this;
    }

    /**
     * Get the namespace of the metrics been queried.
     *
     * @return the namespace value
     */
    public String namespace() {
        return this.namespace;
    }

    /**
     * Set the namespace of the metrics been queried.
     *
     * @param namespace the namespace value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * Get the region of the resource been queried for metrics.
     *
     * @return the resourceregion value
     */
    public String resourceregion() {
        return this.resourceregion;
    }

    /**
     * Set the region of the resource been queried for metrics.
     *
     * @param resourceregion the resourceregion value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withResourceregion(String resourceregion) {
        this.resourceregion = resourceregion;
        return this;
    }

    /**
     * Get the value of the collection.
     *
     * @return the value value
     */
    public List<MetricInner> value() {
        return this.value;
    }

    /**
     * Set the value of the collection.
     *
     * @param value the value value to set
     * @return the ResponseInner object itself.
     */
    public ResponseInner withValue(List<MetricInner> value) {
        this.value = value;
        return this;
    }

}
