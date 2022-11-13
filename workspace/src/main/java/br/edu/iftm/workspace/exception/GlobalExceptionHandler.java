package br.edu.iftm.workspace.exception;

import br.edu.iftm.workspace.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(WorkspaceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleWorkspaceNotFoundException(final WorkspaceNotFoundException ex) {
        return new ResponseEntity<>(ErrorDTO
                .builder()
                .errorCode("001")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build(),
                HttpStatus.NOT_FOUND);
    }
}
