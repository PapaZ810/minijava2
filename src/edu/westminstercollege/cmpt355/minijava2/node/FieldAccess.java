package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.ClassType;
import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import edu.westminstercollege.cmpt355.minijava2.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public record FieldAccess(ParserRuleContext ctx, Expression object, String field) implements Expression {


    @Override
    public Type getType(SymbolTable symbols) {
        return symbols.findField((ClassType) object.getType(symbols), field).get().type();
    }

    @Override
    public List<? extends Node> children() {
        return List.of(object);
    }

    @Override
    public ParserRuleContext ctx() {
        return ctx;
    }

    @Override
    public String getNodeDescription() {
        return String.format("FieldAccess [field: %s]", field);
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        object.typecheck(symbols);
        System.out.println(object.getType(symbols));
        if (object.getType(symbols) instanceof ClassType) {
            ClassType classType = (ClassType) object.getType(symbols);
            if (symbols.findField(classType, field).isEmpty()) {
                throw new SyntaxException(this, "Field " + field + " not found in class " + classType.getName());
            }
        } else {
            throw new SyntaxException(this, "Cannot access field " + field + " on non-class type " + object.getType(symbols));
        }
    }
}
