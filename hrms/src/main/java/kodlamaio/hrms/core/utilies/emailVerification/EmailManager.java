package kodlamaio.hrms.core.utilies.emailVerification;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilies.results.Result;
import kodlamaio.hrms.core.utilies.results.SuccessResult;

@Service
public class EmailManager implements EmailService {

	@Override
	public Result send(String message) {
		
		return new SuccessResult("Email gönderildi.");
	}

}
