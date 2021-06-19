package hrms.hrmsProject.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.CvService;
import hrms.hrmsProject.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {
	private CvService cvService;
	
	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService=cvService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Cv cv){
		
		return ResponseEntity.ok(this.cvService.add(cv)); 
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.cvService.getAll());
	}
}
