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
@Table(name = "cv_technologies")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "technology_name")
	private String technologyName;
	
	@Column(name = "added_date")
	private Date addedDate;
	
	@JoinColumn(name = "cv_id")
	@ManyToOne(targetEntity = Cv.class)
	private Cv cv;
	
	public Technology(int cvId, String technologyName) {
		this.cv=new Cv();
		this.cv.setId(cvId);
		
		this.technologyName=technologyName;
		this.addedDate=java.sql.Date.valueOf(LocalDate.now());
	}
}