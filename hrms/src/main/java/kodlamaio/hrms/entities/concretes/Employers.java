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
@Table (name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employers {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="verified_by_system")
	private boolean verifiedBySystem;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="user_id")
	private Users user;
	
	

}
