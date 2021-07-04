package hrms.hrmsProject.entities.concretes.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvEducationAddDto {
	private int id;
	private int cvId;
	private int graduateId;
	private int schoolId;
	private int facultyId;
	private int departmentId;
	private Date startDate;
	private Date endDate;
}
