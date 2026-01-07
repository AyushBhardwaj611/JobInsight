package repositories;

import model.Job;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class JobRepository {
    public HashMap<Long, Job> jobMap = new HashMap<>();

    public Job addJob(Job job) {
        jobMap.put(job.getId(), job);
        return job;
    }

    public Job getJob(Long id) {
        return jobMap.get(id);
    }
}
