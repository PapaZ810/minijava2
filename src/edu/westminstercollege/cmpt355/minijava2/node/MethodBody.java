package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record MethodBody(ParserRuleContext ctx, List<Statement> statements) implements Node{
    @Override
    public List<? extends Node> children() {
        return statements;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (var statement: statements) {
            statement.typecheck(symbols);
        }
    }
}
