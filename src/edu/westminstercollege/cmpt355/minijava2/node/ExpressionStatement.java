package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record ExpressionStatement(ParserRuleContext ctx, Expression expr) implements Statement {
    @Override
    public List<? extends Node> children() {
        return List.of(expr);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expr.typecheck(symbols);
        System.out.println(expr.getType(symbols));
    }
}
