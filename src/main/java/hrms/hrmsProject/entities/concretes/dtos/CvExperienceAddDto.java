package hrms.hrmsProject.entities.concretes.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvExperienceAddDto {
	private int id;
	private String companyName;
	private int cvId;
	private int positionId;
	private int workTypeId;
	private int cityId;
	private String description;
	//@Past(message =  "Başlama tarihi bugünden sonra olamaz.")
	private Date startDate;
	private Date endDate;
}
