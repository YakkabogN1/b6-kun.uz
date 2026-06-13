package uz.antisocial.kun.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.antisocial.kun.uz.enums.ProfileRole;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JwtDTO {
    private String username;
    private List<ProfileRole> role;
}
