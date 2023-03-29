package edu.westminstercollege.cmpt355.minijava2;

public final class VoidType implements Type {

    public static final VoidType Instance = new VoidType();
    private VoidType() {}

    @Override
    public String toString() {
        return "VoidType";
    }
}
