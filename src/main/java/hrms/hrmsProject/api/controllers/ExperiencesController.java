package hrms.hrmsProject.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.ExperienceService;
import hrms.hrmsProject.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
	private ExperienceService experienceService;
	
	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		this.experienceService=experienceService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.experienceService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Experience experience){
		return ResponseEntity.ok(this.experienceService.add(experience));
	}
}
