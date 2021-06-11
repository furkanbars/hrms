package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

}
