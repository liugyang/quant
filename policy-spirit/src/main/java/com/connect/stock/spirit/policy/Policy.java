package com.connect.stock.spirit.policy;

public abstract class Policy<T,S> {
    public abstract S execute(T input);
}
