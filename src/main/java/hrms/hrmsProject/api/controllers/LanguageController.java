package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.LanguageService;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService=languageService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result = this.languageService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
