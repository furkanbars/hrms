package hrms.hrmsProject.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForJobSeekerDto {
	private String firstName;
	private String lastName;
	private String identityNumber;
	private String birthDate;
	private String email;
	private String password;
	private String passwordRep;
}
