package edu.westminstercollege.cmpt355.minijava2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SymbolTable {

    enum Level {
        CLASS,
        METHOD,
        BLOCK
    }

    private Map<String, Variable> variables = new HashMap<>();
    private int variableIndex = 0;
    private Level level;
    private SymbolTable parent;

    public SymbolTable(Level level) {
        this.level = level;
    }

    public Variable registerVariable(Type type, String name) {
        Variable v = variables.get(name);
        if (v == null) {
            v = new Variable(type, name);
            /*if (type == PrimitiveType.Double) {
                variableIndex += 2;
            } else {
                variableIndex++;
            }*/
            variables.put(name, v);
        }
        return v;
    }

    public Optional<Variable> findVariable(String name) {

        var maybeVar = Optional.ofNullable(variables.get(name));
        var ancestor = parent;

        while (maybeVar.isEmpty()) {
            if (ancestor != null) {
                maybeVar = ancestor.findVariable(name);
            } else {
                break;
            }
        }
        return maybeVar;
    }

    public int getVariableCount() {
        return variables.size();
    }

    public int allocateLocalVariable(int size) {
        return variableIndex+=size;
    }

    public int allocateVariable(int size) {
        if (level == Level.METHOD) {
            return allocateLocalVariable(size);
        } else if (level == Level.BLOCK) {
            return parent.allocateVariable(size);
        } else {
            throw new RuntimeException("Internal compiler error: symbol table weirdness");
        }
    }
}
