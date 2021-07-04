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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv_languages")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;
	
	@Min(1)
	@Max(5)
	@Column(name = "language_level")
	private int languageLevel;
	
	@Column(name = "added_date")
	private Date addedDate;
	
	@ManyToOne(targetEntity = Cv.class)
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	public CvLanguage(int cvId,int languageId,int languageLevel) {
		this.cv=new Cv();
		this.cv.setId(cvId);
		
		this.language=new Language();
		this.language.setId(languageId);
		
		this.languageLevel=languageLevel;
		this.addedDate=java.sql.Date.valueOf(LocalDate.now());
	}
}
