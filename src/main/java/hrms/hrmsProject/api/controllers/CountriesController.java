package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.CountryService;

@CrossOrigin
@RestController
@RequestMapping("/api/countries")
public class CountriesController {
	private CountryService countryService;
	
	@Autowired
	public CountriesController(CountryService countryService) {
		this.countryService=countryService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.countryService.getAll());
	}
}
