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

import hrms.hrmsProject.business.abstracts.CvLanguageService;
import hrms.hrmsProject.entities.concretes.CvLanguage;
import hrms.hrmsProject.entities.concretes.dtos.CvLanguageAddDto;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/cvLanguages")
public class CvLanguagesController {
	private CvLanguageService cvLanguageService;
	
	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		this.cvLanguageService=cvLanguageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CvLanguageAddDto cvLanguageAddDto){
		var result =this.cvLanguageService.add(cvLanguageAddDto);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = this.cvLanguageService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getbycvid")
	public ResponseEntity<?> getByCvId(@RequestParam int cvId){
		var result = this.cvLanguageService.getByCvId(cvId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id){
		var result = this.cvLanguageService.delete(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody CvLanguage cvLanguage){
		var result = this.cvLanguageService.update(cvLanguage);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
