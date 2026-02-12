package com.ent;

public class Car {
    Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Engine CC: "+ engine.cc;
    }
}
