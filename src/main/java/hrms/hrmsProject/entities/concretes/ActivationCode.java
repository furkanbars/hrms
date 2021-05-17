package hrms.hrmsProject.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ActivationCodes")
public class ActivationCode {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int id;
	
	@Column(name = "ActivationCode")
	private String activationCode;
	
	@Column(name = "IsConfirmed")
	private boolean isConfirmed;
	
	@Column(name = "ConfirmedDate")
	private Date ConfirmedDate;
	
	public ActivationCode() {
		
	}
	
	public ActivationCode(int id, String activationCode, boolean isConfirmed, Date confirmedDate) {
		super();
		this.id = id;
		this.activationCode = activationCode;
		this.isConfirmed = isConfirmed;
		ConfirmedDate = confirmedDate;
	}
}
