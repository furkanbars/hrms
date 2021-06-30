package hrms.hrmsProject.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.EducationGraduateService;
import hrms.hrmsProject.entities.concretes.EducationGraduate;
import lombok.var;

@CrossOrigin
@RequestMapping("/api/educationgraduates")
@RestController
public class EducationGraduatesController {
	
	private EducationGraduateService educationGraduateService;
	
	@Autowired
	public EducationGraduatesController(EducationGraduateService educationGraduateService) {
		this.educationGraduateService=educationGraduateService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		var result = this.educationGraduateService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody EducationGraduate educationGraduate){
		var result = this.educationGraduateService.add(educationGraduate);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
