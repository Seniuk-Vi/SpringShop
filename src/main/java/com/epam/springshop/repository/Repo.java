package com.epam.springshop.repository;


import java.util.List;

public interface Repo<T> {
    public T create(T obj);
    public T read(Long field);
    public List<T> readAll();
    public T update(T obj);
    public void delete(Long field);
}
