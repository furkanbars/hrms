package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.WorkTypeService;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/workingtypes")
public class WorkTypesController {
	private WorkTypeService workTypeService;
	
	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		this.workTypeService=workTypeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result=this.workTypeService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
