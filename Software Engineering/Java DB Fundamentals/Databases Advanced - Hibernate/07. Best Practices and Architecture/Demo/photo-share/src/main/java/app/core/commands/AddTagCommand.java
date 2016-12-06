package app.core.commands;

import app.domain.model.Tag;
import app.service.TagService;
import app.utilities.TagUtilities;
import org.springframework.beans.factory.annotation.Autowired;

public class AddTagCommand extends Command {

    @Autowired
    private TagService tagService;

    protected AddTagCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String tagName = TagUtilities.validateOrTransform(this.getData()[1]);
        Tag tag = new Tag();
        tag.setName(tagName);
        tagService.create(tag);
        return tagName + " was added successfully to database";
    }
}
