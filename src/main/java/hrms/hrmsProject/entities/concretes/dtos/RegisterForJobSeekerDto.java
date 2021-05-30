package hrms.hrmsProject.entities.concretes.dtos;

import java.time.LocalDate;

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
	private LocalDate birthDate;
	private String email;
	private String password;
	private String passwordRep;
}
