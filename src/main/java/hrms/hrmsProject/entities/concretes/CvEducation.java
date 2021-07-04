package hrms.hrmsProject.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "cv_educations")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "school_id")
	private EducationSchool school;
	
	@OneToOne()
	@JoinColumn(name = "faculty_id")
	private EducationFaculty faculty;
	
	@NotBlank
	@NotEmpty
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@ManyToOne(targetEntity = Cv.class)
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	@OneToOne()
	@JoinColumn(name = "graduate_id")
	private EducationGraduate graduate;
	
	@OneToOne
	@JoinColumn(name = "department_id")
	private EducationDepartment department;
	
	public CvEducation(int cvId,int graduateId,int schoolId,int facultyId,int departmentId,Date startDate,Date endDate) {
		this.cv=new Cv();
		this.cv.setId(cvId);
		
		this.graduate=new EducationGraduate();
		this.graduate.setId(graduateId);
		
		this.school=new EducationSchool();
		this.school.setId(schoolId);
		
		this.faculty=new EducationFaculty();
		this.faculty.setId(facultyId);
		
		this.department=new EducationDepartment();
		department.setId(departmentId);
		
		this.startDate=startDate;
		this.endDate=endDate;
	}
}
