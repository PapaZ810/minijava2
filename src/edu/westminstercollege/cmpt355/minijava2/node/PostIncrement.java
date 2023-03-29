package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import edu.westminstercollege.cmpt355.minijava2.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record PostIncrement(ParserRuleContext ctx, Expression expr, String op) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(expr);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expr.typecheck(symbols);

        var type = expr.getType(symbols);
        if (type != PrimitiveType.Int && type != PrimitiveType.Double) {
            throw new SyntaxException(this, "Operand must be of type int or double");
        }
    }

    @Override
    public String getNodeDescription() {
        return String.format("PreIncrement [op: %s]", op);
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return expr.getType(symbols);
    }
}
