package com.crud.api.crudrestapitutoriel.service;

import com.crud.api.crudrestapitutoriel.model.Employe;

import java.util.List;

public interface EmployeService {
    public Employe saveEmploye(Employe employe);
    public List<Employe> getAllEmployes();
}
