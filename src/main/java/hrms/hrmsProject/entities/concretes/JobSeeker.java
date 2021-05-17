package hrms.hrmsProject.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "JobSeeker")
public class JobSeeker {
	@Id
	@Column(name = "UserId")
	private int userId;
	
	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "IdentityNumber")
	private String identityNumber;
	
	@Column(name = "BirthDate")
	private Date BirthDate;
	
	public JobSeeker() {
		
	}
	
	public JobSeeker(int userId, String firstName, String lastName, String identityNumber, Date birthDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		BirthDate = birthDate;
	}
}
