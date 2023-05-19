package org.example.repository.impl;

import org.example.base.repository.impl.BaseRepositoryImpl;
import org.example.entity.Director;
import org.example.repository.DirectorRepository;

public class DirectorRepositoryImpl extends BaseRepositoryImpl<Director,Long> implements DirectorRepository {


    @Override
    public Class<Director> getEntityClass() {
        return Director.class;
    }
}
