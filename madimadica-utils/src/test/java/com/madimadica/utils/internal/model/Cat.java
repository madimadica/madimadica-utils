package com.madimadica.utils.internal.model;

import java.util.Objects;

public class Cat extends Animal {
    protected String name;
    protected double clawLength;

    public Cat(int age, String name, double clawLength) {
        super(age);
        this.name = name;
        this.clawLength = clawLength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getClawLength() {
        return clawLength;
    }

    public void setClawLength(double clawLength) {
        this.clawLength = clawLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Double.compare(clawLength, cat.clawLength) == 0 && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, clawLength);
    }
}
