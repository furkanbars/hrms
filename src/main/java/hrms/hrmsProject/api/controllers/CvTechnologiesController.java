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

import hrms.hrmsProject.business.abstracts.CvTechnologyService;
import hrms.hrmsProject.entities.concretes.CvTechnology;
import hrms.hrmsProject.entities.concretes.dtos.CvTechnologyAddDto;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/technologies")
public class CvTechnologiesController {
	private CvTechnologyService cvTechnologyService;
	
	@Autowired
	public CvTechnologiesController(CvTechnologyService cvTechnologyService) {
		this.cvTechnologyService=cvTechnologyService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = this.cvTechnologyService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CvTechnologyAddDto cvTechnologyAddDto){
		var result = this.cvTechnologyService.add(cvTechnologyAddDto);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getbycvid")
	public ResponseEntity<?> getByCvId(@RequestParam int cvId){
		var result = this.cvTechnologyService.getByCvId(cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id){
		var result = this.cvTechnologyService.delete(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody CvTechnology technology){
		var result = this.cvTechnologyService.update(technology);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
