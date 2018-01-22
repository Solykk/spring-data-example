package com.hub.data.springdataexample.services;

/**
 * @author Dmitriy Lyashenko
 */
public interface MiddleCrudService<T, U> {

    T findUnique(U attribute);

}
