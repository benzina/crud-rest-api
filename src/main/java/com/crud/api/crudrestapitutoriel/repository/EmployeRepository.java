package com.crud.api.crudrestapitutoriel.repository;

import com.crud.api.crudrestapitutoriel.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
