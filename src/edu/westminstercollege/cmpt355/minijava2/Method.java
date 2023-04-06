package edu.westminstercollege.cmpt355.minijava2;

import java.util.List;

public record Method(ClassType containingType, String name, List<Type> parameterTypes, Type returnType) {

}
