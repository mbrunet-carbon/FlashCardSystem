package com.flashcardsystem.domain.service;

import com.flashcardsystem.domain.exception.BoxNotFoundException;
import com.flashcardsystem.domain.model.Box;
import com.flashcardsystem.domain.port.BoxRepository;
import com.flashcardsystem.domain.port.BoxService;
import org.springframework.stereotype.Service;

@Service
public class BoxServiceImpl implements BoxService {
    private final BoxRepository boxRepository;

    public BoxServiceImpl(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    @Override
    public Box findById(int id) {
        Box box = boxRepository.findById(id);

        if(box != null) {
            return box;
        }

        throw new BoxNotFoundException(id);
    }
}
