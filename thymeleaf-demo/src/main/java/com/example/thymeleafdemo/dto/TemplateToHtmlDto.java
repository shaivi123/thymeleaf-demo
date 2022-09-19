package com.example.thymeleafdemo.dto;


public class TemplateToHtmlDto {
    private String templateName;
    private Object data;

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
