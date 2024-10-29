package com.bpjstk.JSReport.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostDataBuilder {
    private final TemplateModel template;
    private final PostData data;

    public PostDataBuilder(String shortId, String recipe, PostData data) {
        this.template = new TemplateModel(shortId, recipe);
        this.data = data;
    }

}
