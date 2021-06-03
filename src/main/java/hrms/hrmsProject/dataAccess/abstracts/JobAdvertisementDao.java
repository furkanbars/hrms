package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.hrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getAllByIsActive();
	
	@Query("From JobAdvertisement where isActive=true Order By createdDate DESC")
	List<JobAdvertisement> getAllByIsActiveAndCreatedDateDesc();
	
	@Query("From JobAdvertisement where isActive=true Order By lastDate ASC")
	List<JobAdvertisement> getAllByIsActiveAndLastDateAsc();
	
	List<JobAdvertisement> getByEmployer_Id(int userId);
	
	JobAdvertisement getById(int id);
}
