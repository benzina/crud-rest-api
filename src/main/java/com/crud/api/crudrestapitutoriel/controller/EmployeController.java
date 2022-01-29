package com.crud.api.crudrestapitutoriel.controller;

import com.crud.api.crudrestapitutoriel.model.Employe;
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

    // build create employe rest api
    @PostMapping("/new-employe")
    public ResponseEntity<Employe> saveEmploye(@RequestBody Employe employe){
        return new ResponseEntity<>(employeService.saveEmploye(employe), HttpStatus.CREATED);
    }

    // build get all employes rest api
    @GetMapping("/employes")
    public List<Employe> getAllEmployes(){
        return employeService.getAllEmployes();
    }

    //build get employe by id rest api
    @GetMapping("/{ID}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable("ID") Long id){
        return new ResponseEntity<Employe>(employeService.getEmployeById(id),HttpStatus.OK);
    }

    //build update employe rest api
    @PutMapping("{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable("id") Long id,
                                                 @RequestBody Employe employe){
        return new ResponseEntity<Employe>(employeService.updateEmploye(employe,id),HttpStatus.OK);
    }

}
