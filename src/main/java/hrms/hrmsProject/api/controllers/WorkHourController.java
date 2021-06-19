package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.WorkHourService;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/workinghours")
public class WorkHourController {
	private WorkHourService workHourService;
	
	@Autowired
	public WorkHourController(WorkHourService workHourService) {
		this.workHourService=workHourService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result=this.workHourService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
