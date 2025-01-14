package in.sameer.service;

import in.sameer.entity.Employee;
import in.sameer.exception.ResourceNotFound;
import in.sameer.payload.EmployeeDto;
import in.sameer.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    // Method to add an employee
    public EmployeeDto addEmployee(EmployeeDto dto) {
        Employee employee = mapToEntity(dto);
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert saved Employee to EmployeeDto
        EmployeeDto employeeDto = mapToDto(savedEmployee);

        // Optionally, set other fields like sqlDate if necessary

        return employeeDto;
    }

    // Method to delete an employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Method to update an employee's details
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee employee = mapToEntity(dto);
        employee.setId(id);
        Employee updatedEmployee = employeeRepository.save(employee);
        return mapToDto(updatedEmployee);
    }

    // Method to get a paginated list of employees
    public List<EmployeeDto> getEmployee(int pageNo, int pageSize, String sortBy) {
        String sortDir = "";
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable page = PageRequest.of(pageNo, pageSize);

          Page<Employee> all =  employeeRepository.findAll(page);
               List<Employee>employees= all.getContent();
        List<EmployeeDto>dto=
                employees.stream().map(e-> mapToDto(e)).collect(Collectors.toUnmodifiableList());
        return dto;
    }

    // Method to get a single employee by ID
    public EmployeeDto getEmployeeById(long empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFound("Employee not found"));

        return mapToDto(employee);
    }

    // Helper method to map Employee entity to EmployeeDto
    private EmployeeDto mapToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    // Helper method to map EmployeeDto to Employee entity
    private Employee mapToEntity(EmployeeDto dto) {
        return modelMapper.map(dto, Employee.class);
    }
}
