package com.hub.data.springdataexample.services;

/**
 * @author Dmitriy Lyashenko
 */
public interface SimpleCrudService<T, ID> {

    T create(T t);
    T read(ID id);
    Iterable<T> readAll();
    T update(T t);
    void delete(ID id);

}
