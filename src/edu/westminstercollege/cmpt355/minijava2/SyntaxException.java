package edu.westminstercollege.cmpt355.minijava2;

import edu.westminstercollege.cmpt355.minijava2.node.Node;

public class SyntaxException extends Exception {

    Node node;
    public SyntaxException() {
        super();
    }

    public SyntaxException(String message) {
        super(message);
    }

    public SyntaxException(Node node) {
        super();
        this.node = node;
    }

    public SyntaxException(Node node, String message) {
        super("\u001B[31m" + message + "\u001B[0m");
        this.node = node;
    }

    public SyntaxException(String message, Throwable cause) {
        super("\u001B[31m" + message + "\u001B[0m", cause);
    }

    public SyntaxException(Throwable cause) {
        super(cause);
    }

    protected SyntaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Node getNode() {
        return node;
    }
}
