package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.WorkPlaceType;

public interface WorkPlaceTypeDao extends JpaRepository<WorkPlaceType, Integer>{

}
