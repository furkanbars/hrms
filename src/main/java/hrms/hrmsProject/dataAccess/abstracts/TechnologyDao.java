package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{

}
