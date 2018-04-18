package org.softuni.main.casebook.utilities;

import java.util.Map;

public final class TemplateEngine {
    public TemplateEngine() {}

    public String renderHtml(String html, Map<String, String> viewData) {
        for (Map.Entry<String,String> viewDataObject : viewData.entrySet()) {
            html = html.replace(
                    "$(" + viewDataObject.getKey() + ")"
                    , viewDataObject.getValue());
        }

        return html;
    }
}
