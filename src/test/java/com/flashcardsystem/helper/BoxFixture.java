package com.flashcardsystem.helper;

import com.flashcardsystem.infrastructure.repository.entity.BoxEntity;

public class BoxFixture {

    public static BoxEntity buildBoxEntity() {
        BoxEntity boxEntity = new BoxEntity();
        boxEntity.setId(1);
        boxEntity.setFrequency(1);

        return boxEntity;
    }
}
