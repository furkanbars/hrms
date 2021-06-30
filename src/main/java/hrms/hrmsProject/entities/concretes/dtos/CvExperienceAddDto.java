package hrms.hrmsProject.entities.concretes.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvExperienceAddDto {
	private String companyName;
	private int cvId;
	private int positionId;
	//@Past(message =  "Başlama tarihi bugünden sonra olamaz.")
	private Date startDate;
	private Date endDate;
}
