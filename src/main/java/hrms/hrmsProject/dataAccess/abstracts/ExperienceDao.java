package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{

}
