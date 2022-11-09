package br.edu.iftm.base.service;

import br.edu.iftm.base.entity.ReferenceAttributes;
import br.edu.iftm.base.entity.Table;
import br.edu.iftm.base.entity.attributes.DateDocument;
import br.edu.iftm.base.entity.attributes.NumberDocument;
import br.edu.iftm.base.entity.attributes.StringDocument;
import br.edu.iftm.base.repository.DateDocumentRepository;
import br.edu.iftm.base.repository.NumberDocumentRepository;
import br.edu.iftm.base.repository.ReferenceAttributesRepository;
import br.edu.iftm.base.repository.StringDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReferenceAttributesService {

    @Autowired
    private ReferenceAttributesRepository referenceAttributesRepository;

    @Autowired
    private TableService tableService;

    @Autowired
    private NumberDocumentRepository numberDocumentRepository;

    @Autowired
    private DateDocumentRepository dateDocumentRepository;

    @Autowired
    private StringDocumentRepository stringDocumentRepository;

    public ReferenceAttributes save() {
        List<NumberDocument> numberDocuments = new ArrayList<>(Arrays.asList(numberDocumentRepository.save(new NumberDocument(null))));
        List<DateDocument> dateDocuments = new ArrayList<>(Arrays.asList(dateDocumentRepository.save(new DateDocument(null))));
        List<StringDocument> stringDocuments = new ArrayList<>(Arrays.asList(stringDocumentRepository.save(new StringDocument(null))));
        return referenceAttributesRepository.save(new ReferenceAttributes(numberDocuments, dateDocuments, stringDocuments));
    }

    public ReferenceAttributes insertLine(String tableId) {
        Table table = tableService.findById(tableId);
        List<NumberDocument> numberDocuments = new ArrayList<>(Arrays.asList(numberDocumentRepository.save(new NumberDocument(null))));
        List<DateDocument> dateDocuments = new ArrayList<>(Arrays.asList(dateDocumentRepository.save(new DateDocument(null))));
        List<StringDocument> stringDocuments = new ArrayList<>(Arrays.asList(stringDocumentRepository.save(new StringDocument(null))));
        ReferenceAttributes referenceAttributes = referenceAttributesRepository.save(new ReferenceAttributes(numberDocuments, dateDocuments, stringDocuments));
        return referenceAttributes;
    }

    public NumberDocument insertNumberValue(String id, Long value) {
        return numberDocumentRepository.save(new NumberDocument(id, value));
    }

    public DateDocument insertDateValue(String id, String value) {
        return dateDocumentRepository.save(new DateDocument(id, value));
    }

    public StringDocument insertStringValue(String id, String value) {
        return stringDocumentRepository.save(new StringDocument(id, value));
    }
}
