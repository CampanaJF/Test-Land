package com.inkwell.contentfulservice;

import com.contentful.java.cda.TransformQuery.ContentfulField;
import com.contentful.java.cda.TransformQuery.ContentfulEntryModel;
import com.contentful.java.cda.TransformQuery.ContentfulSystemField;


@ContentfulEntryModel("product")
public class Product {

    @ContentfulSystemField
    private String id;

    @ContentfulField("brand")
    private String brand;

    @ContentfulField("slug")
    private String slug;

}
