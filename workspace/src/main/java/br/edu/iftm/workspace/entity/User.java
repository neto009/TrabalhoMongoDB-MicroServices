package br.edu.iftm.workspace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    private String id;
    private String email;
    private String name;
    private Address address;
}
