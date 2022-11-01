package br.edu.iftm.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "attributes")
public class Attributes {

}
