package com.example.springbootapp.controller;


import com.example.springbootapp.models.Employee;
import com.example.springbootapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping({"/","/viewEmployees"})
    public String viewEmployees(String message, Model model){
        List<Employee> employeeList = employeeService.getAllEmployees();

        model.addAttribute("empList",employeeList);
        model.addAttribute("message",message);
        return "viewEmployees";
    }
    @GetMapping("/addEmployee")
    public String newEmployee(@ModelAttribute("message") String message, Model model){
           model.addAttribute("emp", new Employee());
           model.addAttribute("message", message);
        return "AddEmployee";

    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee employee, RedirectAttributes redirectAttributes){
        if(employeeService.saveOrUpdateEmployee(employee)) {
            redirectAttributes.addFlashAttribute("message", "save Success");
            return "redirect:/viewEmployees";
        }
        redirectAttributes.addFlashAttribute("message", "save Failure");
        return "redirect:/addEmployee";
    }
    @GetMapping("/editEmployee/{id}")
    public String editEmployees(@PathVariable Integer id, String message, Model model){
 Employee employee = employeeService.getEmployeeId(id);
 model.addAttribute("emp",employee);
 model.addAttribute("message",message);
 return "EditEmployee";
    }

    @PostMapping("/editSaveEmployee")
    public String editSaveEmployee(Employee emp, RedirectAttributes redirectAttributes){

        if (employeeService.saveOrUpdateEmployee(emp)){
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewEmployees";
        }
        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editEmployee/" + emp.getId();
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if(employeeService.deleteEmployee(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            return "redirect:/viewEmployees";
        }
        redirectAttributes.addFlashAttribute("message", "Delete Failure");
        return "redirect:/viewEmployees";
    }
}
