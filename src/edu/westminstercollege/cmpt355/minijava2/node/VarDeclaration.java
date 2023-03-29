package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record VarDeclaration(ParserRuleContext ctx, String name) implements Node, VarDecs {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }

    @Override
    public String getNodeDescription() {
        return String.format("VarDeclaration [name: %s]", name);
    }
}
