package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
}
