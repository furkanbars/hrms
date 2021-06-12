package hrms.hrmsProject.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddForCvDto {
	private int jobSeekerId;
	private String githubLink;
	private String linkedinLink;
	private String description;
	private String image;
}
