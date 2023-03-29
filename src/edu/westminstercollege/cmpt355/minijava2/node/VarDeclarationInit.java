package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record VarDeclarationInit(ParserRuleContext ctx, String name, Expression value) implements Node, VarDecs {
    @Override
    public List<? extends Node> children() {
        return List.of(value);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        value.typecheck(symbols);
    }

    @Override
    public String getNodeDescription() {
        return String.format("VarDeclarationInit [name: %s]", name);
    }
}
