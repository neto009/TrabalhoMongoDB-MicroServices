package br.edu.iftm.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@Document(collection = "baseContent")
public class Base {
    @Id
    private String id;
    private String name;
}
