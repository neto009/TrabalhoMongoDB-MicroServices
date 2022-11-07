package br.edu.iftm.base.service;

import br.edu.iftm.base.entity.Base;
import br.edu.iftm.base.entity.ReferenceAttributes;
import br.edu.iftm.base.entity.Table;
import br.edu.iftm.base.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseService {

    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private TableService tableService;

    @Autowired
    private ReferenceAttributesService referenceAttributesService;

    public Base findById(String id) {
        return baseRepository.findById(id).orElseThrow(()-> new RuntimeException("No Exist"));
    }

    public Base update(Base base) {
        return baseRepository.save(base);
    }

    public Base save(String id, String name) {
        List<Table> tableList = new ArrayList<>();
        ReferenceAttributes referenceAttributes = referenceAttributesService.save();
        Table table = tableService.save(new Table("Teste", referenceAttributes));
        tableList.add(table);
        Base base = new Base(id, name, tableList);
        return baseRepository.save(base);
    }
}
