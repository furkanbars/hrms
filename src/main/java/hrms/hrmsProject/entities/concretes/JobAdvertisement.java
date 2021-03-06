package hrms.hrmsProject.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@ManyToOne
	@JoinColumn(name = "working_place_type_id")
	private WorkPlaceType workingPlaceType;
	
	@ManyToOne
	@JoinColumn(name = "working_type_id")
	private WorkType workingType;
	
	@Column(name = "number_of_position")
	private short numberOfPosition;
	
	@Column(name = "last_date")
	private Date lastDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "is_confirm")
	private boolean isConfirm;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	public JobAdvertisement(int employerId,int jobId,int cityId,String title,String description,int minSalary,int maxSalary,int workingPlaceTypeId,int workingTypeId,
			short numberOfPosition,Date lastDate,boolean isActive,boolean isConfirm) {
		this.employer=new Employer();
		this.job=new Job();
		this.city=new City();
		this.workingPlaceType=new WorkPlaceType();
		this.workingType=new WorkType();
		
		this.employer.setId(employerId);
		this.job.setId(jobId);
		this.city.setId(cityId);
		this.title=title;
		this.description=description;
		this.minSalary=minSalary;
		this.maxSalary=maxSalary;
		this.workingPlaceType.setId(workingPlaceTypeId);
		this.workingType.setId(workingTypeId);
		this.numberOfPosition=numberOfPosition;
		this.lastDate=lastDate;
		this.isActive=isActive;
		this.isConfirm=isConfirm;
		this.createdDate=java.sql.Date.valueOf(LocalDate.now());
	}
}