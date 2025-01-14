package in.sameer.controller;

import java.util.List;  // Correct import for List

import in.sameer.entity.Employee;
import in.sameer.payload.EmployeeDto;
import in.sameer.service.EmployeeService;
import jakarta.validation.Valid;
//import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

//import static com.sun.beans.introspect.PropertyInfo.Name.required;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // http://localhost:8080/api/v1/employee/add
    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(
        @Valid @RequestBody EmployeeDto dto,
        BindingResult result

    ){
        if (result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
      EmployeeDto employeeDto= employeeService .addEmployee(dto);
        return new ResponseEntity<>( employeeDto,HttpStatus.CREATED);
    }
    //localhost:8080/api/v1/employee?id=1
     @DeleteMapping
    public ResponseEntity<String> deleteEmployee(
            @RequestParam Long id
     ){

     employeeService.deleteEmployee(id);
     return new ResponseEntity<>(  "deleted",HttpStatus.OK);

    }
    //localhost:8080/api/v1/employee?id=1
    @PutMapping
    public ResponseEntity<EmployeeDto> UpdateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto
            ){


       EmployeeDto employeeDto = employeeService.updateEmployee(id,dto);
        return new ResponseEntity<>( employeeDto,HttpStatus.OK);

    }
    //http://localhost:8080/api/v1/employee?pageSize=3&pageNo=1&sortBy=email
    @GetMapping
    public ResponseEntity <List<EmployeeDto>>getEmployees(
         @RequestParam(name ="pageSize",required = false,defaultValue = "5")int pageSize,
         @RequestParam(name ="pageNo",required = false,defaultValue = "0")int pageNo,
         @RequestParam(name = "sortBy",required = false,defaultValue = "0")String sortBy


    ){

        List<EmployeeDto>employeesDto = employeeService.getEmployee(pageNo,pageSize,sortBy);
      return new ResponseEntity<>(employeesDto ,HttpStatus.OK);


    }

    }


