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

import hrms.hrmsProject.business.abstracts.CvEducationService;
import hrms.hrmsProject.entities.concretes.CvEducation;
import hrms.hrmsProject.entities.concretes.dtos.CvEducationAddDto;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/educations")
public class CvEducationsController {
	private CvEducationService cvEducationService;
	
	@Autowired
	public CvEducationsController(CvEducationService cvEducationService) {
		this.cvEducationService=cvEducationService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result=this.cvEducationService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CvEducationAddDto cvEducationAddDto){
		var result = this.cvEducationService.add(cvEducationAddDto);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getbycvid")
	public ResponseEntity<?> getByCvId(@RequestParam int cvId){
		var result = this.cvEducationService.getByCvId(cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id){
		var result = this.cvEducationService.delete(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody CvEducation education){
		var result = this.cvEducationService.update(education);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(int id){
		var result = this.cvEducationService.getById(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	
	
}
