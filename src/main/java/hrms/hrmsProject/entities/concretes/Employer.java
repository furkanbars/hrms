package hrms.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Employers")
public class Employer {
	@Id
	@Column(name = "UserId")
	private int userId;
	
	@Column(name = "CompanyName")
	private String companyName;
	
	@Column(name = "WebAddress")
	private String webAddress;
	
	@Column(name = "PhoneNumber")
	private long phoneNumber;
	
	@Column(name = "IsActivated")
	private boolean isActivated;
	
	public Employer() {
		
	}
	
	public Employer(int userId, String companyName, String webAddress, long phoneNumber, boolean isActivated) {
		super();
		this.userId = userId;
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
		this.isActivated = isActivated;
	}
}
