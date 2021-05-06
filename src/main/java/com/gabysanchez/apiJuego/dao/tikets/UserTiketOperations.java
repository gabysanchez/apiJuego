package com.gabysanchez.apiJuego.dao.tikets;

import java.util.List;

public interface UserTiketOperations<T,K,E> {
    public void create(E e);
    public void add(T t);
    public void delete(T t);
    public void clear();
    public List<T> get();
    public T get(K k);
    public void save(List<T> t);
}
