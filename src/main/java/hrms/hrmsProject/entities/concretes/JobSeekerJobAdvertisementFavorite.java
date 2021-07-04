package hrms.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seeker_job_advertisement_favorite")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerJobAdvertisementFavorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@OneToOne
	@JoinColumn(name = "job_advertisement_id")
	private JobAdvertisement jobAdvertisement;
}
