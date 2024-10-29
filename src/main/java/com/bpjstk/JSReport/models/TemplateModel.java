package com.bpjstk.JSReport.models;

import lombok.Getter;

@Getter
public class TemplateModel {
    private final String shortid;
    private final String recipe;

    public TemplateModel(String shortid, String recipe) {
        this.shortid = shortid;
        this.recipe = recipe;
    }

}
