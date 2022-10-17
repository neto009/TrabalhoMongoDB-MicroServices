package br.edu.iftm.LOG.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "log")
public class Log {

    @Id
    private String id;
    private Date date;
    private String spaceId;
    private String spaceName;
    private String user;
    private String collaborator;
}
