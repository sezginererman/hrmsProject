package kodlamaio.hrms.core.utilies.emailVerification;

import kodlamaio.hrms.core.utilies.results.Result;

public interface EmailService {
	
	Result send(String message);

}
