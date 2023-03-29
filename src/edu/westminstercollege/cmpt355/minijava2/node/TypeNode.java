package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import edu.westminstercollege.cmpt355.minijava2.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record TypeNode(ParserRuleContext ctx, Type type) implements Node {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }

    @Override
    public String getNodeDescription() {
        return String.format("TypeNode [type: %s]", type);
    }

    public Type getType() {
        return type;
    }
}
