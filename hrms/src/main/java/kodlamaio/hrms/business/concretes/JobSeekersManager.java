package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.business.abstracts.UsersService;
import kodlamaio.hrms.core.utilies.PersonValidationService;
import kodlamaio.hrms.core.utilies.results.DataResult;
import kodlamaio.hrms.core.utilies.results.ErrorResult;
import kodlamaio.hrms.core.utilies.results.Result;
import kodlamaio.hrms.core.utilies.results.SuccessDataResult;
import kodlamaio.hrms.core.utilies.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.Users;
import kodlamaio.hrms.entities.concretes.dtos.JobSeekersForRegisterDto;

@Service
public class JobSeekersManager implements JobSeekersService {

	private JobSeekersDao jobSeekersDao;
	private PersonValidationService personValidationService;
	private UsersService userService;
	
	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao, PersonValidationService personValidationService,
			UsersService userService) {
		super();
		this.jobSeekersDao = jobSeekersDao;
		this.personValidationService = personValidationService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<JobSeekers>> getAll() {
		
		return new SuccessDataResult<List<JobSeekers>>(jobSeekersDao.findAll());
	}

	@Override
	public Result register(JobSeekersForRegisterDto jobSeekersForRegisterDto) {
		if(registrationRulesCheck(jobSeekersForRegisterDto) !=null) return registrationRulesCheck(jobSeekersForRegisterDto);
		if(!personValidationService.validate(jobSeekersForRegisterDto.getNationalityId(), 
				jobSeekersForRegisterDto.getFirstName(), 
				jobSeekersForRegisterDto.getLastName(), 
				jobSeekersForRegisterDto.getDateOfBirth().getYear()).isSuccess()) {
			return new ErrorResult("Kimlik doğrulama başarısız.");
		}
		Users userToRegister = new Users(jobSeekersForRegisterDto.getEmail(), jobSeekersForRegisterDto.getPassword(), false , "doğrulamakodu");
		userService.add(userToRegister);
		
		JobSeekers jobSeekerToRegister = new JobSeekers(userToRegister.getId(),
										jobSeekersForRegisterDto.getFirstName(), jobSeekersForRegisterDto.getLastName(), 
										jobSeekersForRegisterDto.getNationalityId(), jobSeekersForRegisterDto.getDateOfBirth()); 
		this.jobSeekersDao.save(jobSeekerToRegister);
		return new SuccessResult("İş arayan kaydı başarılı. Email doğrulama islemini gerçekleştiriniz. ");
	}
	
	private Result registrationRulesCheck(JobSeekersForRegisterDto jobSeekersForRegisterDto) {
		
		if(emptyParameterCheck(jobSeekersForRegisterDto) != null) return emptyParameterCheck(jobSeekersForRegisterDto);
		if(passwordCheck(jobSeekersForRegisterDto) != null) return passwordCheck(jobSeekersForRegisterDto);
		if(registeredEmailCheck(jobSeekersForRegisterDto) != null) return registeredEmailCheck(jobSeekersForRegisterDto);
		if(registeredNationalityIdCheck(jobSeekersForRegisterDto) != null) return registeredNationalityIdCheck(jobSeekersForRegisterDto);
		
		return new SuccessResult();
	}
	
	private Result emptyParameterCheck(JobSeekersForRegisterDto jobSeekersForRegisterDto) {
		if(jobSeekersForRegisterDto.getFirstName()==null || jobSeekersForRegisterDto.getFirstName().equals("") 
				|| jobSeekersForRegisterDto.getLastName()==null || jobSeekersForRegisterDto.getLastName().equals("") 
				|| jobSeekersForRegisterDto.getEmail() ==null || jobSeekersForRegisterDto.getEmail().equals("")
				|| jobSeekersForRegisterDto.getNationalityId() ==null || jobSeekersForRegisterDto.getNationalityId().equals("")
				|| jobSeekersForRegisterDto.getPassword() ==null || jobSeekersForRegisterDto.getPassword().equals("")
				|| jobSeekersForRegisterDto.getVerifyPassword() ==null || jobSeekersForRegisterDto.getVerifyPassword().equals("")
				|| jobSeekersForRegisterDto.getDateOfBirth() ==null )
			return new ErrorResult("Lütfen tüm alanları doldurun.");
		return null;	
	}
	
	private Result passwordCheck(JobSeekersForRegisterDto jobSeekersForRegisterDto) {
		if(!jobSeekersForRegisterDto.getPassword().equals(jobSeekersForRegisterDto.getVerifyPassword()))
			return new ErrorResult("Şifreler uyuşmuyor. Kontrol ediniz.");
		return new SuccessResult();
	} 
	
	private Result registeredEmailCheck(JobSeekersForRegisterDto jobSeekersForRegisterDto) {
		if(userService.getByEmail(jobSeekersForRegisterDto.getEmail()) !=null)
			return new ErrorResult("Email zaten kayıtlı.");
		return new SuccessResult();
		
	}
	
	private Result registeredNationalityIdCheck(JobSeekersForRegisterDto jobSeekersForRegisterDto) {
		if(jobSeekersDao.findByNationalityId(jobSeekersForRegisterDto.getNationalityId()) !=null)
			return new ErrorResult("Kimlik numarası zaten kayıtlı.");
		return new SuccessResult();
	}

}
