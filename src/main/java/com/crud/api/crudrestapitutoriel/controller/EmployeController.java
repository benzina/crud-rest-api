package com.crud.api.crudrestapitutoriel.controller;

import com.crud.api.crudrestapitutoriel.model.Employe;
import com.crud.api.crudrestapitutoriel.model.dto.EmployeConverter;
import com.crud.api.crudrestapitutoriel.model.dto.EmployeDto;
import com.crud.api.crudrestapitutoriel.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    @Autowired
    private EmployeService employeService;
    @Autowired
    private EmployeConverter employeConverter;

    // build create employe rest api
    @PostMapping("/new-employe")
    public ResponseEntity<Employe> saveEmploye(@RequestBody EmployeDto employeDto){
        Employe employe=employeConverter.dtoToEntity(employeDto);
        return new ResponseEntity<>(employeService.saveEmploye(employe), HttpStatus.CREATED);
    }

    // build get all employes rest api
    @GetMapping
    public List<EmployeDto> getAllEmployes(){
        return employeConverter.entityToDto(employeService.getAllEmployes());
    }

    //build get employe by id rest api
    @GetMapping("/{ID}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable("ID") Long id){
        return new ResponseEntity<Employe>(employeService.getEmployeById(id),HttpStatus.OK);
    }

    //build update employe rest api
    @PutMapping("{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable("id") Long id,
                                                 @RequestBody EmployeDto employeDto){
        Employe employe = employeConverter.dtoToEntity(employeDto);
        return new ResponseEntity<Employe>(employeService.updateEmploye(employe,id),HttpStatus.OK);
    }

    //build delete employe rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmploye(@PathVariable("id") Long id){
        //delete employe from DB
        employeService.deleteEmploye(id);
        return new ResponseEntity<String>("Employe deleted successfully !.",HttpStatus.OK);
    }

}
