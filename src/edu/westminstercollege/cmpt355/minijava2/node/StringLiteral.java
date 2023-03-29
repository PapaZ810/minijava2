package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.ClassType;
import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import edu.westminstercollege.cmpt355.minijava2.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record StringLiteral(ParserRuleContext ctx, String text) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of();
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }

    @Override
    public String getNodeDescription () {
        return String.format("StringLiteral [text: %s]", text);
    }

    @Override
    public Type getType(SymbolTable Symbols) {
        return new ClassType("String");
    }
}
