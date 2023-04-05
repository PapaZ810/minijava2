package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import edu.westminstercollege.cmpt355.minijava2.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record MethodCall(ParserRuleContext ctx, Expression object, String methodName, List<Expression> args) implements Expression {
    @Override
    public Type getType(SymbolTable Symbols) {
        return null;
    }

    @Override
    public List<? extends Node> children() {
        args.add(0, object);
        return args;
    }

    @Override
    public ParserRuleContext ctx() {
        return ctx;
    }


    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }
}
