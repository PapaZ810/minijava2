package edu.westminstercollege.cmpt355.minijava2.node;

public sealed interface VarDecs extends Node
    permits VarDeclaration, VarDeclarationInit{

    public String name();
}
