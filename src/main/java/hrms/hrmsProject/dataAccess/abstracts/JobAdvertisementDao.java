package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrms.hrmsProject.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getAllByIsActive();
	
	@Query("From JobAdvertisement where isActive=true Order By createdDate DESC")
	List<JobAdvertisement> getAllByIsActiveAndCreatedDateDesc();
	
	@Query("From JobAdvertisement where isActive=true Order By lastDate ASC")
	List<JobAdvertisement> getAllByIsActiveAndLastDateAsc();
	
	@Query("From JobAdvertisement where isActive=true And isConfirm=true Order By lastDate ASC")
	List<JobAdvertisement> getAllByIsActiveAndIsConfirmAndLastDateAsc();
	
	List<JobAdvertisement> getByEmployer_Id(int userId);
	
	@Query("From JobAdvertisement where isActive=true And isConfirm=false Order By lastDate ASC")
	List<JobAdvertisement> getAllNotConfirmed();
	
	@Modifying
	@Query("Update JobAdvertisement set isConfirm=true where id=:id")
	int updateConfirmStatus(@Param("id") int id);
	
	@Modifying
	@Query("Update JobAdvertisement set isActive=false where id=:id")
	int updateIsActive(@Param("id") int id);
	
	JobAdvertisement getById(int id);
}
