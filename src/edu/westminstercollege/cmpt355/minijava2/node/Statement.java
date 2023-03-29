package edu.westminstercollege.cmpt355.minijava2.node;

public sealed interface Statement extends Node
    permits EmptyStatement, Block, ExpressionStatement, VarDeclarations {
}
