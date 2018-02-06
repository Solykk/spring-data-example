package com.hub.data.springdataexample.services;

import java.io.Serializable;
import java.util.List;

/**
 * @author Dmitriy Lyashenko
 */
public interface SimpleCrudService<T, ID extends Serializable> {

    T create(T t);
    T read(ID id);
    List<T> readAll();
    T update(T t);
    void delete(ID id);

}
