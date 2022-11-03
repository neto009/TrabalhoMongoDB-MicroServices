package br.edu.iftm.workspace.feign.feignDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseFeignForm {
    private String id;
    private String name;
}
