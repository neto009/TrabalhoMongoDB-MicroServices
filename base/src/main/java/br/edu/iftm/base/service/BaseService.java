package br.edu.iftm.base.service;

import br.edu.iftm.base.entity.Base;
import br.edu.iftm.base.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    private BaseRepository baseRepository;

    public Base findById(String id) {
        return baseRepository.findById(id).orElseThrow(()-> new RuntimeException("No Exist"));
    }

    public Base save (Base base) {
        return baseRepository.save(base);
    }
}
