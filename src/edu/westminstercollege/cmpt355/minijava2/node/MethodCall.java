package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.ClassType;
import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import edu.westminstercollege.cmpt355.minijava2.Type;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public record MethodCall(ParserRuleContext ctx, Expression object, String methodName, List<Expression> args) implements Expression {

    @Override
    public Type getType(SymbolTable symbols) {
        var args2 = args.subList(3, args.size());
        List<Type> types = new ArrayList<>();

        for (Expression arg : args2) {
            types.add(arg.getType(symbols));
        }

        return symbols.findMethod((ClassType) (object.getType(symbols)), methodName, types).get().returnType();
    }

    @Override
    public List<? extends Node> children() {
        args.add(0, object);
        return args;
    }

    @Override
    public String getNodeDescription() {
        return String.format("MethodCall [method: %s]", methodName);
    }

    @Override
    public ParserRuleContext ctx() {
        return ctx;
    }


    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        object.typecheck(symbols);
        Type objectType = object.getType(symbols);
        var args2 = args.subList(3, args.size());

        if (objectType instanceof ClassType cType) {
            List<Type> argTypes = new ArrayList<>();
            for (Expression arg : args2) {
                arg.typecheck(symbols);
                argTypes.add(arg.getType(symbols));
            }

            if (symbols.findMethod(cType, methodName, argTypes).isEmpty()) {
                throw new SyntaxException(this, "Method " + methodName + " not found in class " + cType.getName());
            }
        } else {
            throw new SyntaxException(this, "Cannot call method " + methodName + " on non-class type " + object.getType(symbols));
        }
    }
}
