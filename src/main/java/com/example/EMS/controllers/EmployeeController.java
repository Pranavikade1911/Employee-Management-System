package com.example.EMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.EMS.model.Employee;
import com.example.EMS.services.EmployeeService;

import java.util.List;

@Controller
// @RequestMapping("/employees")
public class EmployeeController {

     @Autowired
     private EmployeeService employeeService;

     @GetMapping("/employees")
     public String getAllEmployees(Model model) {
          List<Employee> employees = employeeService.getAllEmployees();
          model.addAttribute("employees", employees);
          return "employees";
     }

     @GetMapping("/index")
     public String index(){
          return "addEmployee";
     }
 
     @PostMapping("/index")
     public String addEmployee(@ModelAttribute Employee employee) {
         employeeService.addEmployee(employee);
         System.out.println("User Added");
         return "addEmployee";
     }

     @GetMapping("/delete/{id}")
     public String deleteEmployee(@PathVariable Long id) {
          employeeService.deleteEmployee(id);
          return "redirect:/employees";
     }
}
