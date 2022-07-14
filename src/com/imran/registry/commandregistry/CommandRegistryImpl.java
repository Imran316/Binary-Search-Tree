package com.imran.registry.commandregistry;

import com.imran.commadline.CommandLine;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistryImpl implements CommandRegistry{
    List<CommandLine> commands = new ArrayList<>();

    @Override
    public void addCommand(CommandLine commandLine) {
        commands.add(commandLine);
    }

    @Override
    public void removeCommand(CommandLine commandLine) {
        commands.remove(commandLine);
    }

    @Override
    public CommandLine parseCommandForInput(String input) {
        for(CommandLine commandLine : commands)
        {
            if(commandLine.parse(input))
                return commandLine;
        }
        return null;
    }

    @Override
    public boolean executeCommandForInput(String input) {
        CommandLine commandLine = parseCommandForInput(input);
        if(commandLine == null) return false;

        return commandLine.execute(input);
    }
}
