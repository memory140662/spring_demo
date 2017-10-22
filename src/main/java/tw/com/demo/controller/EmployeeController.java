package tw.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tw.com.demo.entity.Employee;
import tw.com.demo.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public void setService(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/registered")
    public String registered(Employee employee) {
        service.addEmployee(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/list")
    public String toList(Model model) {
        List<Employee> employees = service.getEmployees();
        model.addAttribute("employees", employees);
        return "employee/employee_list";
    }

    @GetMapping("/toModify")
    public String toModify(Model model) {
        model.addAttribute("employees", service.getEmployees());
        return "employee/employee_modify";
    }

    @PostMapping("/update")
    public String update(Employee employee) {
        service.update(employee);
        return "redirect:/employee/toModify";
    }

    @GetMapping("/delete")
    public String delete(String id) {
        service.delete(id);
        return "redirect:/employee/toModify";
    }

    @GetMapping("/toRegistered")
    public String registered() {
        return "employee/employee_registered";
    }

}
