package hrms.hrmsProject.api.controllers;

import javax.transaction.Transactional;

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

import hrms.hrmsProject.business.abstracts.JobSeekerJobAdvertisementFavoriteService;
import hrms.hrmsProject.entities.concretes.JobSeekerJobAdvertisementFavorite;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/jobseekerfavorites")
public class JobSeekerJobAdvertisementFavoriteController {
	private JobSeekerJobAdvertisementFavoriteService jobSeekerFavorite;
	
	@Autowired
	public JobSeekerJobAdvertisementFavoriteController(JobSeekerJobAdvertisementFavoriteService jobSeekerFavorite) {
		this.jobSeekerFavorite=jobSeekerFavorite;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobSeekerJobAdvertisementFavorite jobAdvertisementFavorite){
		var result = this.jobSeekerFavorite.add(jobAdvertisementFavorite);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam(name = "userId") int userId,@RequestParam(name = "jobAdvertisementId") int jobAdvertisementId){
		var result = this.jobSeekerFavorite.delete(userId,jobAdvertisementId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getbyuserid")
	public ResponseEntity<?> getById(@RequestParam int userId){
		var result = this.jobSeekerFavorite.getByJobSeekerId(userId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	
	
}
