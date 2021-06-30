package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{
	List<City> getByCountry_Id(int id);
}
