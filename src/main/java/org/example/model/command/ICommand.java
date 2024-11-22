package org.example.model.command;

public interface ICommand {
    void execute();
    void undo();
    void redo();
    boolean isExecutable();
}
