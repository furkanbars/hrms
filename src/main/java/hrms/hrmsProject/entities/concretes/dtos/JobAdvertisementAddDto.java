package hrms.hrmsProject.entities.concretes.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementAddDto {
	private int employerId;
	
	private int jobId;
	
	private int cityId;
	
	private int workingTypeId;
	
	private int workingHourId;
	
	private int minSalary;
	
	private int maxSalary;
	
	private short numberOfPosition;
	
	@JsonIgnore
	private boolean isActive=true;
	
	@JsonIgnore
	private boolean isConfirm=false;
	
	private Date lastDate;
	
	private String title;
	
	private String description;
}
