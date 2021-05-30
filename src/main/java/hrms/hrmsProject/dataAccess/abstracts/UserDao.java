package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User getByEmail(String email);
}
