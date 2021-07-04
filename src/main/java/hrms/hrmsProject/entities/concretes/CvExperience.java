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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "working_type_id")
	private WorkType workType;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "added_date")
	private Date addedDate;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Job jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@JoinColumn(name = "cv_id")
	@ManyToOne
	private Cv cv;
	
	public CvExperience(String companyName,int cvId,int positionId,int workTypeId,int cityId,String description, Date startDate,Date endDate) {
		this.companyName=companyName;
		this.startDate=startDate;
		this.endDate=endDate;
		this.addedDate=java.sql.Date.valueOf(LocalDate.now());
		this.description=description;
		
		this.jobPosition=new Job();
		this.jobPosition.setId(positionId);
		
		this.cv=new Cv();
		this.cv.setId(cvId);
		
		this.workType=new WorkType();
		this.workType.setId(workTypeId);
		
		this.city=new City();
		this.city.setId(cityId);
	}
}




