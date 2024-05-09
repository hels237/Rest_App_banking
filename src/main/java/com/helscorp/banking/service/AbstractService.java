package com.helscorp.banking.service;

import java.util.List;

public interface AbstractService<T> {

    Integer save();

    List<T> findAll();

    T findById(Integer id);

    void delete(T object);
}
