package br.edu.iftm.workspace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@Document(collection = "address")
public class Address {

    @Id
    private String id;
    private String number;
    private String street;
    private String district;
}
