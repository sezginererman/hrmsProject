package kodlamaio.hrms.core.utilies;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilies.results.Result;
import kodlamaio.hrms.core.utilies.results.SuccessResult;

@Service
public class MernisServiceAdapter implements PersonValidationService{

	@Override
	public Result validate(String tcKimlik, String firstName, String lastName, int yearOfDate) {
		
		return new SuccessResult("Mernis doğrulaması başarılı.");
	}
}
