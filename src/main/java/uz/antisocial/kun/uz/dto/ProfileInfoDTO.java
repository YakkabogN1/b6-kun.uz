package uz.antisocial.kun.uz.dto;

import lombok.Getter;
import lombok.Setter;
import uz.antisocial.kun.uz.entity.PhotoEntity;
import uz.antisocial.kun.uz.enums.ProfileRole;

import java.util.Set;

@Setter
@Getter
public class ProfileInfoDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Boolean status;
    private PhotoEntity photo;
    private Set<ProfileRole> roleList;

    public ProfileInfoDTO(Long id,String name, String surname, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    public ProfileInfoDTO(Boolean status, Long id, String name, String surname, String username, Set<ProfileRole> roleList) {
        this.status = status;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.roleList = roleList;
    }

    public ProfileInfoDTO(Long id, String name, String surname, String username, String password, Boolean status, PhotoEntity photo, Set<ProfileRole> roleList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.status = status;
        this.photo = photo;
        this.roleList = roleList;
    }

}
