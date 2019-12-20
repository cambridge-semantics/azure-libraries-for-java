///**
// * Copyright (c) Microsoft Corporation. All rights reserved.
// * Licensed under the MIT License. See License.txt in the project root for
// * license information.
// *
// * Code generated by Microsoft (R) AutoRest Code Generator.
// */
//
//package com.azure.management.resources;
//
//import java.util.Collection;
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.microsoft.rest.ExpandableStringEnum;
//
///**
// * Defines values for PolicyMode.
// */
//public final class PolicyMode extends ExpandableStringEnum<PolicyMode> {
//    /** Static value NotSpecified for PolicyMode. */
//    public static final PolicyMode NOT_SPECIFIED = fromString("NotSpecified");
//
//    /** Static value Indexed for PolicyMode. */
//    public static final PolicyMode INDEXED = fromString("Indexed");
//
//    /** Static value All for PolicyMode. */
//    public static final PolicyMode ALL = fromString("All");
//
//    /**
//     * Creates or finds a PolicyMode from its string representation.
//     * @param name a name to look for
//     * @return the corresponding PolicyMode
//     */
//    @JsonCreator
//    public static PolicyMode fromString(String name) {
//        return fromString(name, PolicyMode.class);
//    }
//
//    /**
//     * @return known PolicyMode values
//     */
//    public static Collection<PolicyMode> values() {
//        return values(PolicyMode.class);
//    }
//}
