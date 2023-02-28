package org.example.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RegisterForReflection
public class Foo {

    private UUID uuid;

    private List<Bar> bars;

    private String value;

    public Foo() {
    }

    public Foo(UUID uuid, List<Bar> bar, String value) {
        this.uuid = uuid;
        this.bars = bar;
        this.value = value;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foo foo = (Foo) o;
        return Objects.equals(uuid, foo.uuid) && Objects.equals(bars, foo.bars) && Objects.equals(value, foo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, bars, value);
    }

    @Override
    public String toString() {
        return "Foo{" +
              "uuid=" + uuid +
              ", bars=" + bars +
              ", value='" + value + '\'' +
              '}';
    }

}
