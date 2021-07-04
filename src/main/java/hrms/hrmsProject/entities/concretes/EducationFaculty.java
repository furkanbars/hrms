package hrms.hrmsProject.entities.concretes;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "education_faculties")
@Entity
public class EducationFaculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = EducationSchool.class)
	@JoinColumn(name = "school_id")
	private EducationSchool school;
	
	@NotBlank
	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@Column(name = "active")
	private boolean active;
}

