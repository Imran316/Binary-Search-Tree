package com.imran.registry.commandregistry;

import com.imran.commadline.CommandLine;

public interface CommandRegistry {
        void addCommand(CommandLine commandLine);
        void removeCommand(CommandLine commandLine);
        CommandLine parseCommandForInput(String input);
        boolean executeCommandForInput(String input);
}
