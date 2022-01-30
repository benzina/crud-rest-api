package com.crud.api.crudrestapitutoriel.service;

import com.crud.api.crudrestapitutoriel.exception.ResourceNotFoundException;
import com.crud.api.crudrestapitutoriel.model.Employe;
import com.crud.api.crudrestapitutoriel.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImp implements EmployeService{
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElseThrow(()->
                                                 new ResourceNotFoundException("Employe","Id",id));
    }

    @Override
    public Employe updateEmploye(Employe employe, long id) {

        // we need to check whether employee with given id is exist in DB or not
        Employe existingEmploye = employeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employe","Id",id));
        existingEmploye.setFirstName(employe.getFirstName());
        existingEmploye.setEmail(employe.getEmail());
        existingEmploye.setLastName(employe.getLastName());
        employeRepository.save(existingEmploye);
        return existingEmploye;
    }

    @Override
    public void deleteEmploye(Long id) {

        //check whether a employe exist in DB or not
        employeRepository.findById(id).orElseThrow(()->
                                            new ResourceNotFoundException("Employe","ID",id));
        employeRepository.deleteById(id);
    }
}
