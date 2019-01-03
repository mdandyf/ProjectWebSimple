package com.example.mitrais.ProjectWebSimple.service;

import java.util.Collection;

public interface BaseService <T, ID> {
    void create(T t);
    void update(ID id, T t);
    void delete(ID id);
    Collection<T> getAll();
    T get(ID id);
}
