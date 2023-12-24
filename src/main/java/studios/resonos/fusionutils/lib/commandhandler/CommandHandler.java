package studios.resonos.fusionutils.lib.commandhandler;

import com.google.common.reflect.ClassPath;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import studios.resonos.fusionutils.lib.commandhandler.help.Help;
import studios.resonos.fusionutils.lib.commandhandler.help.HelpNode;
import studios.resonos.fusionutils.lib.commandhandler.node.CommandNode;
import studios.resonos.fusionutils.lib.commandhandler.paramter.ParamProcessor;
import studios.resonos.fusionutils.lib.commandhandler.paramter.Processor;
import org.bukkit.plugin.Plugin;

import java.util.*;

public class CommandHandler {
    @Getter @Setter private static Plugin plugin;

    /**
     * Registers commands based off a file path
     * @param path Path
     */
    @SneakyThrows
    public static void registerCommands(String path, Plugin plugin) {
        ClassPath.from(plugin.getClass().getClassLoader()).getAllClasses().stream()
                .filter(info -> info.getPackageName().startsWith(path))
                .forEach(info -> registerCommands(info.load(), plugin));
    }

    /**
     * Registers the commands in the class
     * @param commandClass Class
     */
    @SneakyThrows
    public static void registerCommands(Class<?> commandClass, Plugin plugin) {
        CommandHandler.setPlugin(plugin);
        registerCommands(commandClass.newInstance());
    }

    /**
     * Registers the commands in the class
     * @param commandClass Class
     */
    public static void registerCommands(Object commandClass) {
        Arrays.stream(commandClass.getClass().getDeclaredMethods()).forEach(method -> {
            Command command = method.getAnnotation(Command.class);
            if(command == null) return;

            new CommandNode(commandClass, method, command);
        });

        Arrays.stream(commandClass.getClass().getDeclaredMethods()).forEach(method -> {
            Help help = method.getAnnotation(Help.class);
            if(help == null) return;

            HelpNode helpNode = new HelpNode(commandClass, help.names(), help.permission(), method);
            CommandNode.getNodes().forEach(node -> node.getNames().forEach(name -> Arrays.stream(help.names())
                    .map(String::toLowerCase)
                    .filter(helpName -> name.toLowerCase().startsWith(helpName))
                    .forEach(helpName -> node.getHelpNodes().add(helpNode))));
        });
    }

    /**
     * Registers processors based off a file path
     * @param path Path
     */
    @SneakyThrows
    public static void registerProcessors(String path, Plugin plugin) {
        ClassPath.from(plugin.getClass().getClassLoader()).getAllClasses().stream()
                .filter(info -> info.getPackageName().startsWith(path))
                .filter(info -> info.load().getSuperclass().equals(Processor.class))
                .forEach(info -> {
                    try { ParamProcessor.createProcessor((Processor<?>) info.load().newInstance());
                    } catch(Exception exception) { exception.printStackTrace(); }
                });
    }

}
