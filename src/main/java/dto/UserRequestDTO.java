package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.BaseModel;
import model.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO extends BaseModel {
    String name;
    Long age;
    List<String> skills;
    Long expectedSalary;

}
