package com.departmantapi.controllers;

import com.departmantapi.entities.Department;
import com.departmantapi.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Listar todos os departamentos
    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        List<Department> departments = departmentRepository.findAll();
        return ResponseEntity.ok(departments);
    }

    // Criar um novo departamento
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Department department) {
        // Verificar se o nome do departamento já está em uso
        if (departmentRepository.existsByName(department.getName())) {
            return ResponseEntity.badRequest().body("Já existe um departamento com o nome: " + department.getName());
        }
        Department savedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(savedDepartment);
    }
}
