package com.crud.api.crudrestapitutoriel.service;

import com.crud.api.crudrestapitutoriel.model.Employe;
import com.crud.api.crudrestapitutoriel.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeServiceImp implements EmployeService{
    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
}
