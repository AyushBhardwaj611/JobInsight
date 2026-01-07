package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Job;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostJobResponseDTO {
    Job job;
}
