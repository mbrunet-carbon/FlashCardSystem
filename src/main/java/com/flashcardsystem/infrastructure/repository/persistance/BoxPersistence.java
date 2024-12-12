package com.flashcardsystem.infrastructure.repository.persistance;

import com.flashcardsystem.infrastructure.repository.entity.BoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxPersistence extends JpaRepository<BoxEntity, Integer> {
}
