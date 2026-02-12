package com.spider.beans.constructorInj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    int cc;
    public Engine(@Value(value = "500") int cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Engine cc: " + this.cc;
    }
}
