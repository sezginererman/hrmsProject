package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UsersService;
import kodlamaio.hrms.core.utilies.emailVerification.EmailService;
import kodlamaio.hrms.core.utilies.results.DataResult;
import kodlamaio.hrms.core.utilies.results.Result;
import kodlamaio.hrms.core.utilies.results.SuccessDataResult;
import kodlamaio.hrms.core.utilies.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UsersDao;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class UsersManager implements UsersService{

	private UsersDao usersDao;
	private EmailService emailService;
	
	
	@Autowired
	public UsersManager(UsersDao usersDao,EmailService emailService ) {
		super();
		this.usersDao = usersDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Users>> getAll() {
		
		return new SuccessDataResult<List<Users>>(usersDao.findAll(), "Kullanıcılar listelendi");
	}

	@Override
	public DataResult<Users> getByEmail(String email) {
		
		return new SuccessDataResult<Users>(usersDao.findByEmail(email));
	}

	@Override
	public Result add(Users user) {
		this.usersDao.save(user);
		this.emailService.send(user.getEmail());
		return new SuccessResult();
	}

	@Override
	public Result verifyUser(Users user) {
		user.setEmailVerified(true);
		this.usersDao.save(user);
		return new SuccessResult();
	}



}
