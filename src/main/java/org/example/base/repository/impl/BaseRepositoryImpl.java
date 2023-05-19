package org.example.base.repository.impl;

import jakarta.persistence.EntityManager;
import org.example.base.entity.BaseEntity;
import org.example.base.repository.BaseRepository;
import org.example.util.HibernateUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<T extends BaseEntity<U>, U extends Serializable>
        implements BaseRepository<T, U> {
    protected final EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public T save(T entity) {
        if (entity.getId() == null) {
            entityManager.persist(entity);
            return entity;
        }
        return null;
    }

    @Override
    public T update(T entity) {
        if (entity.getId() != null) {
            entityManager.merge(entity);
            return entity;
        }
        return null;
    }

    @Override
    public Optional<T> loadById(U id) {

        return Optional.ofNullable(entityManager.find(getEntityClass(), id));

    }

    @Override
    public List<T> loadAll() {
        // select from table name,type of output
        return entityManager.createQuery(" FROM  " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public void remove(T entity) {
        if (entity.getId() != null) {
            entityManager.remove(entity);
        }
        else System.out.println("this entity is not found");
    }

    public abstract Class<T> getEntityClass();
}
