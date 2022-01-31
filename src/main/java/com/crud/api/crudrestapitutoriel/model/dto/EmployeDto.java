package com.crud.api.crudrestapitutoriel.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class EmployeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public EmployeDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
