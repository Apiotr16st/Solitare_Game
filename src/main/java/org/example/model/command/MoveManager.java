package org.example.model.command;

import java.util.Stack;

public class MoveManager {
    private final Stack<ICommand> undoStack = new Stack<>();
    private final Stack<ICommand> redoStack = new Stack<>();

    public void executeCommand(ICommand command) {
        if(command.isExecutable()) {
            command.execute();
            undoStack.push(command);
            redoStack.clear();
        }
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            ICommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            ICommand command = redoStack.pop();
            command.redo();
            undoStack.push(command);
        }
    }
}
