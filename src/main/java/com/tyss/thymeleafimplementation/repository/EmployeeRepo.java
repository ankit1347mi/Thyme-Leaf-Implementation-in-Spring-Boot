package com.tyss.thymeleafimplementation.repository;

import com.tyss.thymeleafimplementation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
