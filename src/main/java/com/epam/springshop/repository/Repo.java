package com.epam.springshop.repository;


public interface Repo<T> {
    public T create(T obj);
    public T read(Long field);
    public T update(T obj);
    public void delete(Long field);
}
