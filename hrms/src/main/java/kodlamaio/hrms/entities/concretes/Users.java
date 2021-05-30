package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table (name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pasword")
	private String pasword;
	
	@Column(name="email_verified")
	private boolean emailVerified;
	
	@Column(name="verification_code")
	private String verificationCode;

	public Users(String email, String pasword, boolean emailVerified, String verificationCode) {
		super();
		this.email = email;
		this.pasword = pasword;
		this.emailVerified = emailVerified;
		this.verificationCode = verificationCode;
	}
	
	

}
