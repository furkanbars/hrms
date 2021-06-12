package hrms.hrmsProject.entities.concretes.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	private int employerId;
	private int jobId;
	private int cityId;
	private String description;
	private int minSalary;
	private int maxSalary;
	private int numberOfPosition;
	private Date lastDate;
}
