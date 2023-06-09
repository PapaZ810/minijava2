package edu.westminstercollege.cmpt355.minijava2;

import java.lang.reflect.Method;

public class Reflection {

    public static void main(String[] args) {
        Class<?> c1 = Reflection.class;

        for (var method : c1.getMethods()) {
            System.out.println(method);
        }

        System.out.println();

        Object o = "Hi"; //c2 generated by copilot
        Class<?> c2 = o.getClass();

        for (var method : c2.getMethods()) {
            System.out.println(method);
        }

        System.out.println(c2.getModifiers());
        System.out.println();

        try { // block generated by copilot
            Class<?> c3 = Class.forName("java.util.Scanner");
            for (var method : c3.getMethods()) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println(findParameterlessMethod(c1, "f"));
    }

    public void f() {}

    public static Method findParameterlessMethod(Class<?> c, String name) {// block generated by copilot
        for (var method : c.getMethods()) {
            if (method.getName().equals(name) && method.getParameterCount() == 0)
                return method;
        }
        return null;
    }


}
