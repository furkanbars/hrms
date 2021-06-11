package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{

}
