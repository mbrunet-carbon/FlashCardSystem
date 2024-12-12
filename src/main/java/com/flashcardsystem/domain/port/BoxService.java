package com.flashcardsystem.domain.port;

import com.flashcardsystem.domain.model.Box;

public interface BoxService {
    Box findById(int id);
}
