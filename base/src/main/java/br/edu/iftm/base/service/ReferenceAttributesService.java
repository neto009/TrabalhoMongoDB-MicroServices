package br.edu.iftm.base.service;

import br.edu.iftm.base.entity.ReferenceAttributes;
import br.edu.iftm.base.repository.ReferenceAttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReferenceAttributesService {

    @Autowired
    private ReferenceAttributesRepository referenceAttributesRepository;

    public ReferenceAttributes save() {
        return referenceAttributesRepository.save(new ReferenceAttributes());
    }
}
