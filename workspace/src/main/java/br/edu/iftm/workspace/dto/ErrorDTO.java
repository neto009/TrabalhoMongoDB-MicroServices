package br.edu.iftm.workspace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String errorCode;
    private int status;
    private String message;
    private String timestamp;

    public ErrorDTO (String errorCode, String message, int status){
        this.errorCode = errorCode;
        this.message = message;
        this.status = status;
        this.timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a z Z"));
    }
}
