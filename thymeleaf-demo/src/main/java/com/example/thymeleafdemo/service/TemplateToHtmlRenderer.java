package com.example.thymeleafdemo.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class TemplateToHtmlRenderer {
    private final SpringTemplateEngine engine;

    public TemplateToHtmlRenderer(SpringTemplateEngine engine) {
        this.engine = engine;
    }

    public String renderHtml(String templateName, Object data) {
        Context context = new Context();
        context.setVariable("data", data);
        return engine.process(templateName, context);
    }
}
