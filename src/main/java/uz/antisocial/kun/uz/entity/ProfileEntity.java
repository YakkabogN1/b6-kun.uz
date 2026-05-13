package uz.antisocial.kun.uz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.antisocial.kun.uz.enums.ProfileRole;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class ProfileEntity extends BaseEntity {


    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name="username")
    private String username;
    @Column(name= "password")
    private String password;
    @Column(name = "status")
    private Boolean status=Boolean.TRUE;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private PhotoEntity photo;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<ProfileRole> roleList = new HashSet<>();

    public ProfileEntity(String name, String surname, String username, String password, Set<ProfileRole> roleList) {
        super();
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.roleList = roleList;
    }

    public ProfileEntity() {
        super();
        roleList.add(ProfileRole.ROLE_USER);
    }

    public ProfileEntity(String name, String surname, String username, String password) {
        super();
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.roleList.add(ProfileRole.ROLE_USER);
        this.status=Boolean.TRUE;
    }

    public ProfileEntity(String name, String surname, String username, String password, Boolean status, PhotoEntity photo, Set<ProfileRole> roleList) {
        super();
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.status = status;
        this.photo = photo;
        this.roleList = roleList;
    }
}
