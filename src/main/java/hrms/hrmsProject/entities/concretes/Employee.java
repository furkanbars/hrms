package hrms.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "first_name")
	@NotNull
	@NotBlank
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull
	@NotBlank
	private String lastName;
	
}
