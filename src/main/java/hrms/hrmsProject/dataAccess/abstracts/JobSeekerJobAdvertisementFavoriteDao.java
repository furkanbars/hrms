package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrms.hrmsProject.entities.concretes.JobSeekerJobAdvertisementFavorite;

public interface JobSeekerJobAdvertisementFavoriteDao extends JpaRepository<JobSeekerJobAdvertisementFavorite, Integer>{
	List<JobSeekerJobAdvertisementFavorite> getAllByJobSeeker_Id(int id);
	
	@Modifying
	@Query("Delete From JobSeekerJobAdvertisementFavorite where jobSeeker.id=:userId And jobAdvertisement.id=:jobAdvertisementId")
	void deleteByJobSeekerAndJobAdvertisement(@Param("userId") int userId,@Param("jobAdvertisementId") int jobAdvertisementId);
}
