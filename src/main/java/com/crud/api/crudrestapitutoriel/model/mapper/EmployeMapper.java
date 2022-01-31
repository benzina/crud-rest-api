package com.crud.api.crudrestapitutoriel.model.mapper;

import com.crud.api.crudrestapitutoriel.model.Employe;
import com.crud.api.crudrestapitutoriel.model.dto.EmployeDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeMapper {
    EmployeMapper INSTANCE = Mappers.getMapper( EmployeMapper.class );

    EmployeDto employeToDto(Employe employe);

    List<EmployeDto> modelsToDtos(List<Employe> employes);

    @InheritInverseConfiguration
    Employe dtoToEmploye(EmployeDto employeDto);

    List<Employe> dtosTomodels(List<EmployeDto> employesDtos);

}
