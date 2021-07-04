package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrms.hrmsProject.entities.concretes.EducationDepartment;

public interface EducationDepartmentDao extends JpaRepository<EducationDepartment, Integer>{
	
	@Query("From EducationDepartment d Join EducationFaculty f On d.faculty.id=f.id "
			+ "where f.school.id=:schoolId")
	List<EducationDepartment> getAllBySchoolId(@Param("schoolId") int schoolId);
}
