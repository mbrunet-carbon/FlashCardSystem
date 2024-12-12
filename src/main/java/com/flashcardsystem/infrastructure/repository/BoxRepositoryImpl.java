package com.flashcardsystem.infrastructure.repository;

import com.flashcardsystem.domain.model.Box;
import com.flashcardsystem.domain.port.BoxRepository;
import com.flashcardsystem.infrastructure.repository.mapper.BoxMapper;
import com.flashcardsystem.infrastructure.repository.persistance.BoxPersistence;
import org.springframework.stereotype.Repository;

@Repository
public class BoxRepositoryImpl implements BoxRepository {
    BoxPersistence persistence;
    BoxMapper boxMapper;


    public BoxRepositoryImpl(BoxPersistence persistence, BoxMapper boxMapper) {
        this.persistence = persistence;
        this.boxMapper = boxMapper;
    }

    @Override
    public Box findById(int id) {
        return persistence.findById(id).map(boxMapper::toBox).orElse(null);
    }
}
