package edu.westminstercollege.cmpt355.minijava2;

import java.util.Objects;

public sealed class ClassType implements Type permits StaticType {

    private final String name;

    public ClassType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("ClassType[name=%s]", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StaticType that = (StaticType) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
