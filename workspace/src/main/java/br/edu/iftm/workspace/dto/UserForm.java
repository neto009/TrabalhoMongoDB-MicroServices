package br.edu.iftm.workspace.dto;

import br.edu.iftm.workspace.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String email;
    private String name;
    private Address address;
}
