package hrms.hrmsProject.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.EducationService;
import hrms.hrmsProject.entities.concretes.Education;
import lombok.var;

@RestController
@RequestMapping("/api/educations")
public class EducationsController {
	private EducationService educationService;
	
	@Autowired
	public EducationsController(EducationService educationService) {
		this.educationService=educationService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		
		var result=this.educationService.getAll();
		if (result.getData()!=null) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Education education){
		var result=this.educationService.add(education);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.badRequest().body(result);
		}
	}
}
