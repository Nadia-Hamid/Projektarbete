package se.yrgo.employee.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import se.yrgo.employee.dto.EmployeeDTO;
import se.yrgo.employee.entities.Employee;
import se.yrgo.employee.services.EmployeeService;

@RestController
@RequestMapping(value = "/v1/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		List<Employee> list = employeeService.findAll();
		List<EmployeeDTO> listDTO = list.stream()
				.map(EmployeeDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
		Employee object = employeeService.findById(id);
		return ResponseEntity.ok().body(new EmployeeDTO(object));
	}

	@RequestMapping(value = "/jobtitle/{jobTitle}", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeDTO>> findByJobTitle(@PathVariable String jobTitle) {
		List<Employee> list = employeeService.findByJobTitle(jobTitle);
		List<EmployeeDTO> listDTO = list.stream()
				.map(EmployeeDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value= "", method=RequestMethod.POST)
	public ResponseEntity<EmployeeDTO> registerEmployee(@RequestBody EmployeeDTO registerDTO) {
		Employee entity = employeeService.generateUserId(registerDTO);
		employeeService.addEmployee(entity);
		return ResponseEntity.ok().body(new EmployeeDTO(entity));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
		Employee object = employeeService.fromDTO(employeeDTO);
		object = employeeService.updateEmployee(id, object);
		return ResponseEntity.ok().body(new EmployeeDTO(object));
	}

	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeDTO> findEqualEmail(@PathVariable String email) {
		Employee entity = employeeService.findByEmail(email);
		return ResponseEntity.ok().body(new EmployeeDTO(entity));
	}
}