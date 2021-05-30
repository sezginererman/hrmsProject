package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemWorkers;

public interface SystemWorkersDao extends JpaRepository<SystemWorkers, Integer> {

}
