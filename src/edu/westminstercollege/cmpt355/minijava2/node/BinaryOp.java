package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;
import java.util.Objects;

public record BinaryOp(ParserRuleContext ctx, Expression left, Expression right, String op) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(left, right);
    }

    @Override
    public String getNodeDescription() {
        return String.format("BinaryOp [op: %s]", op);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        left.typecheck(symbols);
        right.typecheck(symbols);

        Type leftType = left.getType(symbols), rightType = right.getType(symbols);
        Type stringType = new ClassType("String");

        if (Objects.equals(op, "-") || Objects.equals(op, "*") || Objects.equals(op, "/") || Objects.equals(op, "%")) {
            if (leftType != PrimitiveType.Int && leftType != PrimitiveType.Double || rightType != PrimitiveType.Int && rightType != PrimitiveType.Double) {
                throw new SyntaxException(this, "Both operands on a multiplicative or subtraction operator must be of type int or double");
            }
        } else if (Objects.equals(op, "+")) {
            if (!(leftType == PrimitiveType.Int || leftType == PrimitiveType.Double || Objects.equals(leftType, stringType))
                || !(rightType == PrimitiveType.Int || rightType == PrimitiveType.Double || Objects.equals(rightType, stringType))) {
                    if (!(leftType == PrimitiveType.Boolean || Objects.equals(rightType, stringType))
                        && !(Objects.equals(leftType, stringType) || rightType == PrimitiveType.Boolean)) {
                        throw new SyntaxException(this, "Both operands must be of type int, double, or string for the addition operator");
                    }
            }
        }
    }


    @Override
    public Type getType(SymbolTable symbols) {
        Type leftType = left.getType(symbols), rightType = right.getType(symbols);

        if (Objects.equals(op, "*") || Objects.equals(op, "/") || Objects.equals(op, "-") || Objects.equals(op, "%")) { //this method partially generated using Copilot
            if (leftType == PrimitiveType.Int && rightType == PrimitiveType.Int) {
                return PrimitiveType.Int;
            } else {
                return PrimitiveType.Double;
            }
        } else if (Objects.equals(op, "+")) {
            if (leftType.equals(new ClassType("String")) || rightType.equals(new ClassType("String"))) {
                return new ClassType("String");
            } else if (leftType == PrimitiveType.Int && rightType == PrimitiveType.Int) {
                return PrimitiveType.Int;
            } else if (leftType == PrimitiveType.Double || rightType == PrimitiveType.Double) {
                return PrimitiveType.Double;
            } else {
                return new ClassType("String");
            }
        } else {
            return PrimitiveType.Boolean;
        }
    }
}
