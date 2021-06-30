package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.EducationFaculty;

public interface EducationFacultyDao extends JpaRepository<EducationFaculty, Integer>{
	EducationFaculty getBySchool_Id(int schoolId);
	EducationFaculty getByName(String name);
}
