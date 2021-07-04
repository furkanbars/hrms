package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.CvLanguage;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer>{
	List<CvLanguage> getByCv_Id(int id);
}
