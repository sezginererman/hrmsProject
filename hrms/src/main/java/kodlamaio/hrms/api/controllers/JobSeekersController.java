package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.utilies.results.DataResult;
import kodlamaio.hrms.core.utilies.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.dtos.JobSeekersForRegisterDto;



@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
	
	
	private JobSeekersService jobSeekersService;
	
	@Autowired
	public JobSeekersController(JobSeekersService jobSeekersService) {
		super();
		this.jobSeekersService = jobSeekersService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeekers>> getAll(){
		return this.jobSeekersService.getAll();
	}
	
	@PostMapping("/register")
	public Result add(@RequestBody JobSeekersForRegisterDto jobSeeker) {
		return this.jobSeekersService.register(jobSeeker);
	}
}
