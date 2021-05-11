package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="jobs") 
public class Jobs {
	
	
	@Id
	@GeneratedValue
	@Column(name="jobid")
	private int jobId;
	
	@Column(name="jobname")
	private String jobName;
	
	public Jobs() {
		
	}
	
	public Jobs(int jobId, String jobName) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
	}

}
