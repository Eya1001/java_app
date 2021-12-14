package services;

import models.repositories.Repository;

import java.util.List;

public class Service<T>{
    protected Repository<T> repository;
    public Service(){}
    public List<T> list(){
        return this.repository.findAll();
    }

    public Repository<T> getRepository() {
        return repository;
    }

    public void setRepository(Repository<T> repository) {
        this.repository = repository;
    }
}
