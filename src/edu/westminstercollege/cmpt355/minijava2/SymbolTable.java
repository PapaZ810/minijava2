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
        return Optional.ofNullable(variables.get(name));
    }

    public int getVariableCount() {
        return variables.size();
    }

    public int allocateLocalVariable(int size) {
        return variableIndex+=size;
    }
}
