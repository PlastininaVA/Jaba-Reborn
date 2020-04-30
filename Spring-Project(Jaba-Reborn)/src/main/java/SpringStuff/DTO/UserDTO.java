package SpringStuff.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String surname;
    private String patronymic;
    private String passport;
    private String phone;
    private String password;
}
