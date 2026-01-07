package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobRequestDTO {
    Long id;
    String profile;
    String company;
    List<String> skills;
    Long offeredSalary;

}
