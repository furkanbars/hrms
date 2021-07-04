package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.WorkPlaceTypeService;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/workingplacetypes")
public class WorkPlaceTypesController {
	private WorkPlaceTypeService workPlaceTypeService;
	
	@Autowired
	public WorkPlaceTypesController(WorkPlaceTypeService workPlaceTypeService) {
		this.workPlaceTypeService=workPlaceTypeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		var result=this.workPlaceTypeService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
