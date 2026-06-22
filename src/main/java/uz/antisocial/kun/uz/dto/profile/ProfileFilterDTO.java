package uz.antisocial.kun.uz.dto.profile;


import lombok.Getter;
import lombok.Setter;
import uz.antisocial.kun.uz.enums.ProfileRoleEnum;

import java.time.LocalDate;

@Getter
@Setter
public class ProfileFilterDTO {
    private String query; // name, surname, username
    private ProfileRoleEnum role;
    private LocalDate createdDateFrom;
    private LocalDate createdDateTo;
}
