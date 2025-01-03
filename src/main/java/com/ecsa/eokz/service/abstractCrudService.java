package com.ecsa.eokz.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class abstractCrudService<T, ID> {
    protected abstract JpaRepository<T, ID> getRepository();
    public List<T> findAll(){
        return getRepository().findAll();
    }
    public Optional<T> findById(ID id){
        return getRepository().findById(id);
    }
    public T save(T entity){
        return getRepository().save(entity);
    }
    public void deleteById(ID id){
        getRepository().deleteById(id);
    }
}
