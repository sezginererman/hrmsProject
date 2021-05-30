package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="systemworkers")
@AllArgsConstructor
@NoArgsConstructor
public class SystemWorkers {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="worker_first_name")
	private String workerFirstName;
	
	@Column(name="worker_last_name")
	private String workerLastName;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="user_id")
	private Users user;

}
