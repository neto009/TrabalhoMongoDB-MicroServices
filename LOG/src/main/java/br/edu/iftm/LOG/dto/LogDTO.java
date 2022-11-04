package br.edu.iftm.LOG.dto;

import br.edu.iftm.LOG.entity.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogDTO {
    private String date;
    private String spaceId;
    private String spaceName;
    private String user;
    private String collaboratorAccess;

    public LogDTO (Log log) {
        this.date = log.getDate().toString();
        this.spaceId = log.getSpaceId();
        this.user = log.getUser();
        this.collaboratorAccess = log.getCollaboratorAccess();
    }
}
