package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import edu.westminstercollege.cmpt355.minijava2.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record Negate(ParserRuleContext ctx, Expression expression) implements Expression {
    @Override
    public List<? extends Node> children() {
        return List.of(expression);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
            expression.typecheck(symbols);

            var type = expression.getType(symbols);
            if (type != PrimitiveType.Int && type != PrimitiveType.Double) {
                throw new SyntaxException(this, "Operand must be of type int or double");
            }
        }

    @Override
    public Type getType(SymbolTable symbols) {
        return expression.getType(symbols);
    }
}
