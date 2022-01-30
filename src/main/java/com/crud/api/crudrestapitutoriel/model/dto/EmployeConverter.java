package com.crud.api.crudrestapitutoriel.model.dto;

import com.crud.api.crudrestapitutoriel.model.Employe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeConverter {
    public EmployeDto entityToDto(Employe employe){
        EmployeDto dto= new EmployeDto();
        dto.setId(employe.getId());
        dto.setEmail(employe.getEmail());
        dto.setFirstName(employe.getFirstName());
        dto.setLastName(employe.getLastName());
        return dto;
    }

    public List<EmployeDto> entityToDto(List<Employe> employes){
        return employes.stream().map(x->entityToDto(x)).collect(Collectors.toList());
    }

    public Employe dtoToEntity(EmployeDto employeDto){
        Employe employe = new Employe();
        employe.setId(employeDto.getId());
        employe.setLastName(employeDto.getLastName());
        employe.setEmail(employeDto.getEmail());
        employe.setFirstName(employeDto.getFirstName());
        return employe;
    }

    public List<Employe> dtoToEntity(List<EmployeDto> employeDtos){
        return employeDtos.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }
}
