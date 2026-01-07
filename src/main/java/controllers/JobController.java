package controllers;

import dto.JobRequestDTO;
import dto.PostJobResponseDTO;
import exceptions.JobExistsException;
import lombok.Getter;
import model.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.JobService;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    JobService jobService;

    public JobController (JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> CreateJob (@RequestBody JobRequestDTO jobRequestDTO) throws JobExistsException {
        Job job = jobService.createJob(jobRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostJobResponseDTO> postJob(@PathVariable Long jobId) {
    Job job = jobService.postJob(jobId);

    PostJobResponseDTO postJobResponseDTO = new PostJobResponseDTO();
    postJobResponseDTO.setJob(job);
        return ResponseEntity.ok(new PostJobResponseDTO());
    }

    @GetMapping("/display")
    public ResponseEntity<List<Job>> displayAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }
}
