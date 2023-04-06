package edu.westminstercollege.cmpt355.minijava2;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Optional;

public class Reflect {

    /**
     * Converts a Java type (in a java.lang.Class object) to a miniType (instance of the Type interface).
     * Returns an empty Optional if there is no corresponding miniJava type (for example, there is no miniJava type
     * corresponding to a long).
     */
    public static Optional<Type> typeFromClass(Class<?> c) {
        if (c.equals(Integer.TYPE))
            return Optional.of(PrimitiveType.Int);
        else if (c.equals(Double.TYPE))
            return Optional.of(PrimitiveType.Double);
        else if (c.equals(Boolean.TYPE))
            return Optional.of(PrimitiveType.Boolean);
        else if (c.equals(Void.TYPE))
            return Optional.of(VoidType.Instance);
        else if (!c.isPrimitive() && !c.isArray())
            return Optional.of(new ClassType(c.getName()));
        else
            return Optional.empty();
    }

    /**
     * Returns an Optional containing the class corresponding to the given name, or an empty Optional if there is no
     * class with that name. (The name should include the package, e.g. "java.lang.String", not just "String".)
     * This method is just a thin wrapper around Class.forName() that returns an Optional instead of throwing an
     * exception.
     */
    public static Optional<Class<?>> classForName(String name) {
        try {
            return Optional.of(Class.forName(name));
        } catch (ClassNotFoundException ex) {
            return Optional.empty();
        }
    }

    /**
     * Returns a Field object corresponding to the given field of the given class, or an empty Optional if there is no
     * such field. The returned field, if there is one, will meet the following requirements:
     * - belongs to the given class;
     * - is public;
     * - has the given name;
     * - its ClassType will be an instance of StaticType if the field is static;
     * - has a type that is a miniJava type (e.g. not long, float, etc.).
     */
    public static Optional<Field> findField(Class<?> clazz, String name) {
        // Use clazz.getField(String fieldName) to find the field with the given name, then check that its type is
        // compatible with miniJava (you can use typeFromClass() to map the Class object to a Type one, giving an
        // empty Optional if it is not representable in miniJava).

        // Note that clazz.getField(String fieldName) returns a java.lang.reflect.Field object, whereas this method
        // returns a *miniJava* Field object.

        // Use getModifiers() on the java.lang.reflect.Field object to check whether it is static.
        java.lang.reflect.Field field = null;
        Optional<Type> type = null;

        try {
            field = clazz.getField(name);
            type = typeFromClass(field.getType());
        } catch (NoSuchFieldException e) {
            return Optional.empty();
        }

        String modifiers = Modifier.toString(field.getModifiers());

        if (modifiers.contains("static")) {
            return Optional.of(new Field(new StaticType(field.getClass().toString()), name, type.get()));
        } else {
            return Optional.of(new Field(new ClassType(field.getClass().toString()), name, type.get()));
        }
    }

    /**
     * Returns a Method object corresponding to the relevant method of the given class, or an empty Optional if there is
     * no such method. The returned method, if there is one, will meet the following requirements:
     * - belongs to the given class;
     * - is public;
     * - has the given name;
     * - has parameters whose types exactly correspond to those given;
     * - its ClassType will be an instance of StaticType if the method is static;
     * - all relevant types (return type, parameter types) are miniJava types (e.g. not long, float, etc.).
     */
    public static Optional<Method> findMethod(Class<?> clazz, String name, List<Class<?>> parameterTypes) {
        // Use clazz.getMethods() to find all the public methods of the class, then find one whose parameter types
        // exactly match the given parameter types.

        // Any method whose parameters don't match the parameter or are not representable in miniJava should be
        // excluded. (You can use typeFromClass() to map the Class objects to Type ones, giving an empty Optional if
        // they are not representable in miniJava.)

        // Note that this method returns a *miniJava* Method object, not a java.lang.reflect.Method! This means that
        // the return/parameter types will need to be mapped to Types.
        List<Type> miniTypes = new java.util.ArrayList<>(List.of());

        for (var method : clazz.getMethods()) {
            if (method.getName().equals(name)) {
                var parameters = method.getParameters();
                if (parameters.length == parameterTypes.size()) {
                    for (int i = 0; i < parameters.length; i++) {
                        if (!parameters[i].getType().equals(parameterTypes.get(i))) {
                            return Optional.empty();
                        }
                    }
                    for (var param : parameterTypes) {
                        if (!typeFromClass(param).isPresent()) {
                            return Optional.empty();
                        }
                        miniTypes.add(typeFromClass(param).get());
                    }
                    return Optional.of(new Method(new ClassType(clazz.getName()), name, miniTypes, typeFromClass(method.getReturnType()).get()));
                }
            }
        }
        return Optional.empty();
    }

    /**
     * Returns a Method object corresponding to the relevant constructor of the given class, or an empty Optional if
     * there is no such method. The returned method, if there is one, will meet the following requirements:
     * - belongs to the given class;
     * - is public;
     * - is named "<init>";
     * - has parameters whose types exactly correspond to those given;
     * - has void return type;
     * - its ClassType is *not* a StaticType;
     * - all parameter types are miniJava types (e.g. not long, float, etc.).
     */
    public static Optional<Method> findConstructor(Class<?> clazz, List<Class<?>> parameterTypes) {
        // Use clazz.getConstructors() to find all the public constructors of the class, then find one whose parameter
        // types exactly match the given parameter types.

        // Any constructor whose parameters don't match the parameter or are not representable in miniJava should be
        // excluded. (You can use typeFromClass() to map the Class objects to Type ones, giving an empty Optional if
        // they are not representable in miniJava.)

        // This method will be very similar to findMethod(). The main differences are that
        // - the method name is always "<init>";
        // - the return type is always void;
        // - the class type is never a StaticType.

        List<Type> miniTypes = new java.util.ArrayList<>(List.of());

        for (var constructor : clazz.getConstructors()) {
            if (constructor.getName().equals("<init>")) {
                var parameters = constructor.getParameters();
                if (parameters.length == parameterTypes.size()) {
                    for (int i = 0; i < parameters.length; i++) {
                        if (!parameters[i].equals(parameterTypes.get(i))) {
                            return Optional.empty();
                        }
                    }
                    for (var param : parameterTypes) {
                        if (!typeFromClass(param).isPresent()) {
                            return Optional.empty();
                        }
                        miniTypes.add(typeFromClass(param).get());
                    }
                    return Optional.of(new Method(new ClassType(clazz.getName()), "<init>", miniTypes, VoidType.Instance));
                }
            }
        }
        return Optional.empty();
    }
}
