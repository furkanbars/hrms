package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.CvImage;

public interface JobSeekerImageDao extends JpaRepository<CvImage, Integer>{
	CvImage getByCv_id(int id);
}
