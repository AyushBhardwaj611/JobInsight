package services;

import dto.JobRequestDTO;
import exceptions.JobExistsException;
import model.Job;
import org.springframework.stereotype.Service;
import repositories.JobRepository;

import java.util.List;

@Service
public class JobService {

    public JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(JobRequestDTO jobRequestDTO) throws JobExistsException {
    Job job = jobRepository.getJob(jobRequestDTO.getId());

    if (job != null) {
        throw new JobExistsException("Job with id " + jobRequestDTO.getId() + " already exists.");
    }

    Job savedJob = jobRepository.addJob(job);
    return savedJob;
    }

    public Job postJob(Long jobId) {
        Job job = jobRepository.getJob(jobId);
        // job not found error
        return job;
    }

    public List<Job> getAllJobs() {
        List<Job> jobs = jobRepository.jobMap.values().stream().toList();
        return jobs;
    }
}
