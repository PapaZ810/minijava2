package edu.westminstercollege.cmpt355.minijava2.node;

import edu.westminstercollege.cmpt355.minijava2.PrimitiveType;
import edu.westminstercollege.cmpt355.minijava2.SymbolTable;
import edu.westminstercollege.cmpt355.minijava2.SyntaxException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public record VarDeclarations(ParserRuleContext ctx, TypeNode type, List<VarDecs> vars) implements Statement {

    @Override
    public List<? extends Node> children() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(type);
        nodes.addAll(vars);
        return nodes;
    }

    @Override
    public void typecheck(SymbolTable symbols) throws SyntaxException {
        for (var var: vars) {
            var.typecheck(symbols);
            var tp = type.getType();
            if (var instanceof VarDeclarationInit) {
                var varType = ((VarDeclarationInit) var).value().getType(symbols);
                if (!Objects.equals(tp, PrimitiveType.Double) || !Objects.equals(varType, PrimitiveType.Int)) {
                    if (!Objects.equals(tp, varType)) {
                        throw new SyntaxException(this, "Type of value does not match type of variable in VariableDeclarations: " + var.name());
                    }
                }
            }

            if (tp == PrimitiveType.Double) //if statement generated using Copilot
                symbols.findVariable(var.name()).get().setIndex(symbols.allocateLocalVariable(2));
            else
                symbols.findVariable(var.name()).get().setIndex(symbols.allocateLocalVariable(1));
        }    
    }

}
