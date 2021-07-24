package com.s3.employee.service.main.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s3.employee.service.main.model.Employee;

@RestController
@RequestMapping("/rest/emp")
public class EmployeeController {
    
   /**
    * 
    * @return Employee[]
    */
   @GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
   public Employee[] getEmployees() {
       return getEmployList();
   }

   /**
    * 
    * @param name
    * @return Employee
    */
   @GetMapping(value="/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
   public Employee getEmploy(@PathVariable String name) {
       Employee employee = null;
       Employee [] emps = getEmployList();
       for(Employee emp : emps) {
           if(emp.getName().equalsIgnoreCase(name)) {
               employee = emp;
           }
       }
      return employee;
   }
   
   /**
    * 
    * @param name
    * @return Employee
    */
   @GetMapping(value="/{name}/{deptCode}", produces=MediaType.APPLICATION_JSON_VALUE)
   public Employee getEmployByNameAndDeptCode(@PathVariable String name, @PathVariable String deptCode) {
       Employee employee = null;
       Employee [] emps = getEmployList();
       for(Employee emp : emps) {
           if((emp.getName().equalsIgnoreCase(name) && emp.getDeptCode().equalsIgnoreCase(deptCode))) {
               employee = emp;
           }
          
       }
      return employee;
   }
   
   
   /**
    * 
    * @return Employee[]
    */
   private Employee[] getEmployList() {
       Employee[] employees = new Employee[4];
       employees[0]= setEmployDetails("saravanan", "38", "IT","Tech Lead", 60000,"ITDE-001" );
       employees[1]= setEmployDetails("muthamil", "30", "AM","QA Lead", 40000 ,"ITQA-001");
       employees[2]= setEmployDetails("Shreenivasan", "23", "Govt","Asst Collector", 30000, "GOADM001");
       employees[3]= setEmployDetails("Thirukumarn", "18", "Govt","AGP", 25000, "GOPOL001" );
       return employees;
   }
   
   /**
    * 
    * @param name
    * @param age
    * @param job
    * @param designation
    * @param salary
    * @return
    */
   private Employee setEmployDetails(String name, String age, String job, String designation, long salary, String deptCode) {
       Employee emp = new Employee();
       emp.setName(name);
       emp.setDesignation(designation);
       emp.setJob(job);
       emp.setAge(age);
       emp.setSalary(salary);
       emp.setDeptCode(deptCode);
       return emp;
   }
}
