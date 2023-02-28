package org.example.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.UUID;

@RegisterForReflection
public class Bar {

    private UUID uuid;

    private Foo foo;

    private String value;

    public Bar() {
    }

    public Bar(UUID uuid, Foo foo, String value) {
        this.uuid = uuid;
        this.foo = foo;
        this.value = value;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Bar{" +
              "uuid=" + uuid +
              ", value='" + value + '\'' +
              '}';
    }

}
