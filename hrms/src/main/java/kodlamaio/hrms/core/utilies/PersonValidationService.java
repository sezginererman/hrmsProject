package kodlamaio.hrms.core.utilies;

import kodlamaio.hrms.core.utilies.results.Result;

public interface PersonValidationService {
	
	Result validate(String tcKimlik , String firstName, String lastName, int yearOfDate );

}
