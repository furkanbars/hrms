package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.ActivationCode;

public interface VerificationCodeDao extends JpaRepository<ActivationCode, Integer>{

}
