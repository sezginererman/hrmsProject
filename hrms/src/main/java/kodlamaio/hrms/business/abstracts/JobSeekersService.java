package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilies.results.DataResult;
import kodlamaio.hrms.core.utilies.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.dtos.JobSeekersForRegisterDto;

public interface JobSeekersService {
	
	DataResult<List<JobSeekers>> getAll();
	Result register(JobSeekersForRegisterDto jobSeekersForRegisterDto);
	
	
	

	

}
