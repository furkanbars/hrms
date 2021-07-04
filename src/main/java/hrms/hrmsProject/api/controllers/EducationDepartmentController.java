package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.EducationDepartmentService;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/educationdepartments")
public class EducationDepartmentController {
	private EducationDepartmentService educationDepartmentService;
	
	@Autowired
	public EducationDepartmentController(EducationDepartmentService educationDepartmentService) {
		this.educationDepartmentService=educationDepartmentService;
	}
	
	@GetMapping("/getallbyschoolid")
	public ResponseEntity<?> getAllBySchoolId(int schoolId){
		var result = this.educationDepartmentService.getAllBySchoolId(schoolId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
