package hrms.hrmsProject.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerFavoriteDto {
	private int jobSeekerId;
	private int jobAdvertisementId;
}
