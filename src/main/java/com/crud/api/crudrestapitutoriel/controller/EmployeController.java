package com.crud.api.crudrestapitutoriel.controller;

import com.crud.api.crudrestapitutoriel.model.Employe;
import com.crud.api.crudrestapitutoriel.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
