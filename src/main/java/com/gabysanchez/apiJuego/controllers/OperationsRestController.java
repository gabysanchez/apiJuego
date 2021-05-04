package com.gabysanchez.apiJuego.controllers;

import java.util.List;

public interface OperationsRestController<T,K> {
    public void add(T t);
    public void update(T t);
    public void delete(T t);
    public void clear();
    public List<T> get();
    public List<T> getPaged(int page);
    public T get(K k);
}
