package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.EducationGraduate;

public interface EducationGraduateDao extends JpaRepository<EducationGraduate, Integer>{
	EducationGraduate getByName(String name);
}
