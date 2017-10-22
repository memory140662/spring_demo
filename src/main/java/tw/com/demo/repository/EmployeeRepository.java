package tw.com.demo.repository;

import org.springframework.data.repository.CrudRepository;
import tw.com.demo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findAll();
}
