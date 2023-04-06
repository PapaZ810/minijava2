package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.Field;
import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

/*
    classNodes
returns [ClassNode n]
    : (methods+=method)* EOF {
        var methos = new ArrayList<MethodBody>();
        for (var method : $methods)
            methos.add(method.n);
        $n = new ClassNode($ctx, methos);
    }
    ;

method
    : NAME '(' (args+=expr (',' args+=expr )*)? ')' block {
        var arguments = new ArrayList<Expression>();
        for (var arg : $args)
            arguments.add(arg.n);
        $n = new MethodDefinition($ctx, $NAME.text, arguments, $block.n);
    }
    ;
 */

public record ClassNode(ParserRuleContext ctx, /*List<Import> imports,*/ List<Field> fields, List<MethodDefinition> methods/*, Optional<Main> main*/) implements Node {
    @Override
    public List<? extends Node> children() {
        return methods;
    }

    @Override
    public ParserRuleContext ctx() {
        return ctx;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }
}
