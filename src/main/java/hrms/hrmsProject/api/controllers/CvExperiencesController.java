package hrms.hrmsProject.api.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.CvExperienceService;
import hrms.hrmsProject.entities.concretes.CvExperience;
import hrms.hrmsProject.entities.concretes.dtos.CvExperienceAddDto;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/experiences")
public class CvExperiencesController {
	private CvExperienceService cvExperienceService;
	
	@Autowired
	public CvExperiencesController(CvExperienceService cvExperienceService) {
		this.cvExperienceService=cvExperienceService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result=this.cvExperienceService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CvExperienceAddDto cvExperienceAddDto){
		var result=this.cvExperienceService.add(cvExperienceAddDto);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getbycvid")
	public ResponseEntity<?> getByCvId(int cvId){
		var result = this.cvExperienceService.getByCvId(cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id){
		var result = this.cvExperienceService.delete(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody CvExperience experience){
		var result = this.cvExperienceService.update(experience);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
}
