package com.imran.commadline;

public interface CommandLine {
    boolean parse(String input);
    boolean execute(String input);
}
