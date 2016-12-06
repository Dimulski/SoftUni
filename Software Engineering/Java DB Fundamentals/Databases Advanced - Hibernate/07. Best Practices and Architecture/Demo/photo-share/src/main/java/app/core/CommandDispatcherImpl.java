package app.core;

import app.annotations.Insert;
import app.core.commands.Command;
import app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

@Component
public class CommandDispatcherImpl implements CommandDispatcher {
    private final String COMMANDS_PACKAGE = "app.core.commands.";
    private final String COMMAND_SUFFIX = "Command";

    @Autowired
    private TagService tagService;

    @Override
    public Executable dispatchCommand(String commandName, String[] commandParameters) {
        commandName = COMMANDS_PACKAGE + commandName + COMMAND_SUFFIX;

        Executable commandInstance = null;
        try {
            Class<Command> commandClass = (Class<Command>) Class.forName(commandName);
            Constructor ctor = commandClass.getDeclaredConstructor(String[].class);
            ctor.setAccessible(true);
            commandInstance = (Command) ctor.newInstance((Object) commandParameters);
            this.injectDependencies(commandInstance, commandClass);
        } catch (ReflectiveOperationException e) {
            throw new UnsupportedOperationException("Invalid command");
        }
        return commandInstance;
    }

    private void injectDependencies(Executable commandInstance,
                                    Class<Command> commandClass) throws
            IllegalAccessException {
        Field[] cmdFields = commandClass.getDeclaredFields();
        Field[] theseFields = CommandDispatcherImpl.class.getDeclaredFields();

        for (Field field : cmdFields) {
            if (field.isAnnotationPresent(Insert.class)) {
                continue;
            }
            field.setAccessible(true);

            for (Field thisField : theseFields) {
                if (!thisField.getType().equals(field.getType())) {
                    continue;
                }
                thisField.setAccessible(true);
                field.set(commandInstance, thisField.get(this));
            }
        }
    }
}
