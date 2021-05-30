package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilies.results.DataResult;
import kodlamaio.hrms.core.utilies.results.Result;
import kodlamaio.hrms.entities.concretes.Users;

public interface UsersService {
	
	DataResult<List<Users>> getAll();
	DataResult<Users> getByEmail(String email);
	Result add(Users user);
	Result verifyUser(Users user);

}
