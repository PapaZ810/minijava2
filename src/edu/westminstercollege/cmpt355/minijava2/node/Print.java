package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record Print(ParserRuleContext ctx, List<Expression> expressions) implements Expression {
    @Override
    public List<? extends Node> children() {
        return expressions;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (var statement: expressions) {
            statement.typecheck(symbols);
        }

    }

    @Override
    public Type getType(SymbolTable symbols) {
        return VoidType.Instance;
    }
}
