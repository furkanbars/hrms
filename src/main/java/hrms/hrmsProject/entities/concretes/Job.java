package hrms.hrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Jobs")
public class Job {
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int id;
	 
	@Column(name = "Name")
	private String name;
	
	public Job() {
		
	}
	
	public Job(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
