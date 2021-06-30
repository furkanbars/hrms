package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{
	Cv getById(int id);
	Cv getByJobSeeker_id(int id);
}
