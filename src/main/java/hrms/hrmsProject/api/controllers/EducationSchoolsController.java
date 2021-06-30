package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.EducationSchoolService;
import hrms.hrmsProject.entities.concretes.EducationSchool;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/educationschools")
public class EducationSchoolsController {
	
	private EducationSchoolService educationSchoolService;
	
	@Autowired
	public EducationSchoolsController(EducationSchoolService educationSchoolService) {
		this.educationSchoolService=educationSchoolService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		var result = this.educationSchoolService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody EducationSchool educationSchool){
		var result = this.educationSchoolService.add(educationSchool);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
