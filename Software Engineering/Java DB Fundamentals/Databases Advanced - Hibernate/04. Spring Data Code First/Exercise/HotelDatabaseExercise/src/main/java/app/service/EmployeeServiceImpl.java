package app.service;

import app.domain.Employee;
import app.repositories.EmployeeRepository;
import app.service.contracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        this.employeeRepository.saveAndFlush(employee);
    }
}
