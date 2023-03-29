package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import edu.westminstercollege.cmpt355.minijava2.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;
import java.util.Objects;

public record Assignment(ParserRuleContext ctx, Expression left, Expression expression) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(left, expression);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        left.typecheck(symbols);
        expression.typecheck(symbols);

        Type leftType = left.getType(symbols), exprType = expression.getType(symbols);

        if (!Objects.equals(leftType, exprType)) {
            if ((leftType != PrimitiveType.Double || exprType != PrimitiveType.Int))
                throw new SyntaxException(this, "Type of expression must match type of variable");
        }
    }

    @Override
    public Type getType(SymbolTable symbols) {
        return left.getType(symbols);
    }
}
