package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record Block(ParserRuleContext ctx, List<Statement> stmt) implements Statement {
    @Override
    public List<? extends Node> children() {
        return stmt;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (var statement : stmt)
            statement.typecheck(symbols);
    }
}
