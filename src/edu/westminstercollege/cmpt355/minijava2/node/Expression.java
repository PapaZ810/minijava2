package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.Type;

public sealed interface Expression extends Node
        permits IntLiteral, DoubleLiteral, BooleanLiteral, StringLiteral, VariableAccess,
        Assignment, BinaryOp, Negate, PreIncrement, PostIncrement, Cast, Print, FieldAccess, MethodCall, ConstructorCall {

    Type getType(SymbolTable Symbols);
}
