package edu.westminstercollege.cmpt355.minijava2;

import edu.westminstercollege.cmpt355.minijava2.node.*;

import java.util.*;

import static edu.westminstercollege.cmpt355.minijava2.PrimitiveType.*;
import static edu.westminstercollege.cmpt355.minijava2.VoidType.Instance;

public class SymbolTable {

    private Map<String, Variable> variables = new HashMap<>();
    private int variableIndex = 0;

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

    public Optional<Class<?>> findJavaClass(String className) {
        var c = Reflect.classForName(className);
        if (c.isPresent()) {
            return c;
        }
        if (Reflect.classForName("java.lang." + className).isPresent()) {
            return Reflect.classForName("java.lang." + className);
        } else {
            return Reflect.classForName("java.util." + className);
        }
    }

    public Optional<Class<?>> classFromType(Type type) {

        if (type == PrimitiveType.Int) {
            return Optional.of(int.class);
        } else if (type == PrimitiveType.Double) {
            return Optional.of(double.class);
        } else if (type == PrimitiveType.Boolean) {
            return Optional.of(boolean.class);
        } else if (type instanceof ClassType classType) {
            return findJavaClass(classType.getName());
        } else if (type instanceof VoidType){
            return Optional.of(Void.class);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Field> findField(ClassType classType, String fieldName) {
        return Reflect.findField(findJavaClass(classType.getName()).get(), fieldName);
    }

    public Optional<Method> findMethod(ClassType classType, String methodName, List<Type> parameterTypes) {
        List<Class<?>> types = new ArrayList<>();
        for (Type t : parameterTypes) {
            types.add(classFromType(t).get());
        }
        if (findJavaClass(classType.getName()).isPresent()) {
            return Reflect.findMethod(findJavaClass(classType.getName()).get(), methodName, types);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Method> findConstructor(ClassType classType, List<Type> parameterTypes) {
        List<Class<?>> types = new ArrayList<>();
        for (Type t : parameterTypes) {
            types.add(classFromType(t).get());
        }
        return Reflect.findConstructor(findJavaClass(classType.getName()).get(), types);
    }
}
