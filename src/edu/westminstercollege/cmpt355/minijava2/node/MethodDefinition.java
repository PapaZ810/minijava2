package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;

public record MethodDefinition(ParserRuleContext ctx, String methodName, List<VariableAccess> params, Block block) implements Node{
    @Override
    public List<? extends Node> children() {
        List<Node> children = new ArrayList<>(params);
        children.addAll(List.of(block));
        return children;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {

    }
}
