package hrms.hrmsProject.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "updated_date")
	private Date updateDate;
	
	@Column(name = "active")
	private boolean isActive;
	
	@JoinColumn(name = "job_seeker_id")
	@ManyToOne(targetEntity = JobSeeker.class)
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
	private List<Technology> technologies;
	
	@OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
	private List<Education> educations;
	
	@OneToMany(mappedBy = "cv",cascade = CascadeType.ALL)
	private List<Language> languages;
	
	@OneToOne(mappedBy = "cv")
	private CvImage cvImage;
	
}
