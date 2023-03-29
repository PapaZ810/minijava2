package edu.westminstercollege.cmpt355.minijava2;

public class Variable {

    private Type type;
    private String name;
    private int index;

    public Variable(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
