package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.EducationSchool;

public interface EducationSchoolDao extends JpaRepository<EducationSchool, Integer>{
	EducationSchool getByName(String name);
}
