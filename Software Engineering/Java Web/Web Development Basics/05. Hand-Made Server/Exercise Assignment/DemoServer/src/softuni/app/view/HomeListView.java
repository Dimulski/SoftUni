package softuni.app.view;

import softuni.server.Model;
import softuni.server.View;

import java.util.List;

public class HomeListView implements View {

    private final Model model;

    public HomeListView(Model model) {
        this.model = model;
    }

    @Override
    public String view() {
        StringBuilder response = new StringBuilder();

        response.append("<html><body><ul>");
        List<String> elements = (List<String>) model.get("list");

        for (String element : elements) {
            if ("".equals(element)) {
                continue;
            }
            response.append("<li>");
            response.append(element);
            response.append("</li>");
        }

        response.append("</ul><form method=\"post\">");
        response.append("<input type=\"text\" name=\"new-item\"/>");
        response.append("<input type=\"submit\" value=\"Add\"/>");
        response.append("</form></body></html>");

        return response.toString();
    }
}
