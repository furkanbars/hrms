package hrms.hrmsProject.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.EducationFacultyService;
import hrms.hrmsProject.entities.concretes.EducationFaculty;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/educationfaculties")
public class EducationFacultiesController {
	
	private EducationFacultyService educationFacultyService;
	
	@Autowired
	public EducationFacultiesController(EducationFacultyService educationFacultyService) {
		this.educationFacultyService=educationFacultyService;
	}
	
	@GetMapping("/getbyschoolid")
	public ResponseEntity<?> getBySchoolId(@RequestParam int schoolId){
		var result = this.educationFacultyService.getBySchoolId(schoolId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody EducationFaculty educationFaculty) {
		var result = this.educationFacultyService.add(educationFaculty);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}







