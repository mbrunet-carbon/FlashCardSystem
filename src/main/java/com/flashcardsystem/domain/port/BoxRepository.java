package com.flashcardsystem.domain.port;

import com.flashcardsystem.domain.model.Box;

public interface BoxRepository {
    Box findById(int id);
}
