package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsProject.business.abstracts.JobSeekerImageService;
import lombok.var;

//@CrossOrigin
//@RestController
//@RequestMapping("/api/images")
public class JobSeekerImagesController {
	//private JobSeekerImageService imageService;
	
	//@Autowired
	//public JobSeekerImagesController(JobSeekerImageService imageService) {
	//	this.imageService=imageService;
	//}
	
	//@PostMapping("/save")
	//public ResponseEntity<?> uploadImage(@RequestBody MultipartFile multipartFile,@RequestParam int cvId){
	//	var result = this.imageService.uploadImage(multipartFile, cvId);
	//	if (result.isSuccess()) {
	//		return ResponseEntity.ok(result);
	//	}
	//	return ResponseEntity.badRequest().body(result);
	//}
}
