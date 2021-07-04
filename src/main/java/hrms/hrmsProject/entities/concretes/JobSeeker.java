package hrms.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User{
	
	@Column(name = "first_name")
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name = "identity_number")
	@NotBlank
	@NotNull
	private String identityNumber;

	@Column(name = "birth_date")
	@NotNull
	private String birthDate;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
}
