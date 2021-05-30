package hrms.hrmsProject.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForEmployerDto {
	private String companyName;
	private String webSite;
	private String email;
	private String phoneNumber;
	private String password;
	private String passwordRep;
	
}
