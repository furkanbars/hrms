package hrms.hrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotEmpty
	@NotBlank
	@Column(name = "school_name")
	private String schoolName;
	
	@NotBlank
	@NotEmpty
	@Column(name = "department")
	private String department;
	
	@NotBlank
	@NotEmpty
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@ManyToOne(targetEntity = Cv.class)
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	@ManyToOne(targetEntity = Graduate.class)
	@JoinColumn(name = "graduate_id")
	private Graduate graduate;
}
