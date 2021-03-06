package hrms.hrmsProject.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvLanguageAddDto {
	private int id;
	private int cvId;
	private int languageId;
	private int languageLevel;
}
