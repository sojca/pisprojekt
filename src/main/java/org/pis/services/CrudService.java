package org.pis.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CrudService<T> {

    @PersistenceContext(unitName = "test")
    protected EntityManager em;


    public CrudService() {
    }

    public T merge(T entity){
        em.merge(entity);
        return entity;
    }

    public void remove(T entity){
        em.remove(em.merge(entity));
    }

    public T find(Class<T> typeParameterClass, int id){
        return em.find(typeParameterClass, id);
    }

    public List<T> findAll(Class<T> typeParameterClass){
        return em.createQuery("SELECT c from " + typeParameterClass.getName() +" c", typeParameterClass).getResultList();
    }

}
