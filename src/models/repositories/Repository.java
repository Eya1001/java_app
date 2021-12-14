package models.repositories;

import java.util.List;

public interface Repository<T> {
    public List<T> findAll();
    public T create(T t);
}
