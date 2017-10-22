package tw.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.com.demo.entity.Employee;
import tw.com.demo.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public void setRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void addEmployee(Employee employee) {
        repository.save(employee);
    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public void update(Employee employee) {
        if (repository.exists(employee.getId())) {
            repository.save(employee);
        }
    }

    public void delete(String id) {
        repository.delete(Long.valueOf(id));
    }
}
