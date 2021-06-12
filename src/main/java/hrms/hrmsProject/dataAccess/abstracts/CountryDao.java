package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Country;

public interface CountryDao extends JpaRepository<Country, Integer>{
	
}
