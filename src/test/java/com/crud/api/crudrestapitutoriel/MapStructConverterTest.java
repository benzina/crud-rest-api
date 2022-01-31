package com.crud.api.crudrestapitutoriel;

import com.crud.api.crudrestapitutoriel.model.Employe;
import com.crud.api.crudrestapitutoriel.model.dto.EmployeDto;
import com.crud.api.crudrestapitutoriel.model.mapper.EmployeMapper;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapStructConverterTest {
    @Test
    public void shouldMapEmployeToDto() {
        //given
        Employe employe = new Employe( "benzina", "el mahdi","benzina@gmail.com");

        //when
        EmployeDto employeDto = EmployeMapper.INSTANCE.employeToDto( employe );

        //then
        assertThat( employeDto ).isNotNull();
        assertThat( employeDto.getFirstName() ).isEqualTo( "benzina" );
        assertThat( employeDto.getLastName() ).isEqualTo( "el mahdi" );
        assertThat( employeDto.getEmail() ).isEqualTo( "benzina@gmail.com" );
    }

    @Test
    public void shouldMapdtoToEmploye() {
        //given
        EmployeDto employeDto = new EmployeDto( "benzina", "el mahdi","benzina@gmail.com");

        //when
        Employe employe = EmployeMapper.INSTANCE.dtoToEmploye( employeDto );

        //then
        assertThat( employe ).isNotNull();
        assertThat( employe.getFirstName() ).isEqualTo( "benzina" );
        assertThat( employe.getLastName() ).isEqualTo( "el mahdi" );
        assertThat( employe.getEmail() ).isEqualTo( "benzina@gmail.com" );
    }

    @Test
    public void shouldMapdtosToEmployes() {
        //given
        List<EmployeDto> dtoList = new ArrayList<>();
        dtoList.add(new EmployeDto("benzina", "el mahdi","benzina@gmail.com"));
        dtoList.add(new EmployeDto("said", "el mahdi","said@gmail.com"));
        dtoList.add(new EmployeDto("samir", "el mahdi","samir@gmail.com"));

        //when
        List<Employe> employes = EmployeMapper.INSTANCE.dtosTomodels( dtoList );

        //then
          assertTrue(employes.size() == dtoList.size());
        //  assertTrue(employeList.size() == dtoList.size() && employeList.containsAll(dtoList) && dtoList.containsAll(employeList));
    }
}
