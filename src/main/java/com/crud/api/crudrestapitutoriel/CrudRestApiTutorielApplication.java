package com.crud.api.crudrestapitutoriel;

import com.crud.api.crudrestapitutoriel.model.Employe;
import com.crud.api.crudrestapitutoriel.model.dto.EmployeDto;
import com.crud.api.crudrestapitutoriel.model.mapper.EmployeMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CrudRestApiTutorielApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudRestApiTutorielApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
