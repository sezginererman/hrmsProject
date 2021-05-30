package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;


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
@Table(name="jobseekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekers {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;	
	
	@Column(name="birth_of_date")
	private LocalDate birthOfDate;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="user_id")
	private Users user;

	public JobSeekers(int userId, String firstName, String lastName, String nationalityId, LocalDate birthOfDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birthOfDate = birthOfDate;
	}
	
	

}
