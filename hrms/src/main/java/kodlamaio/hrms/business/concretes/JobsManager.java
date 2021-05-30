package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobsService;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Jobs;


@Service
public class JobsManager implements JobsService {

	private JobDao jobDao;
	
	@Autowired
	public JobsManager(JobDao jobdao) {
		super();
		this.jobDao = jobdao;
	}





	@Override
	public List<Jobs> getall() {
		return this.jobDao.findAll();
	}

}
