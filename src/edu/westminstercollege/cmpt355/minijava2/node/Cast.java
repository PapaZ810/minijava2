package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public record Cast(ParserRuleContext ctx, TypeNode type, Expression expr) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(type, expr);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        expr.typecheck(symbols);

        var exprType = expr.getType(symbols);
        if (!Objects.equals(type.getType(), exprType)) {
            if ((type.getType() == PrimitiveType.Int || type.getType() == PrimitiveType.Double) && !(exprType == PrimitiveType.Int || exprType == PrimitiveType.Double)) {
                throw new SyntaxException(this, "Ints or doubles can only be cast to ints or doubles");
            } else if (Objects.equals(type.getType().toString(), "ClassType[name=String]")
                    && !(exprType == PrimitiveType.Boolean || exprType == PrimitiveType.Int || exprType == PrimitiveType.Double || Objects.equals(exprType.toString(), "ClassType[name=String]"))) {
                throw new SyntaxException(this, "Only ints, doubles, booleans, and strings can be cast to strings");
            } else if (type.getType() == PrimitiveType.Boolean && exprType != PrimitiveType.Boolean) {
                throw new SyntaxException(this, "Only booleans can be cast to booleans");
            }
        }
    }

    @Override
    public Type getType(SymbolTable Symbols) {
        return type.getType();
    }
}
