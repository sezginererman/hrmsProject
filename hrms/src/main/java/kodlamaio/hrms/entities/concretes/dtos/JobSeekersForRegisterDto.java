package kodlamaio.hrms.entities.concretes.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekersForRegisterDto {
	
	private String firstName;
	private String lastName;
	private String nationalityId;
	private LocalDate dateOfBirth;
	private String email;
	private String password;
	private String verifyPassword;

}
