package uz.antisocial.kun.uz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.antisocial.kun.uz.enums.ProfileRole;

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
    private Set<ProfileRole> roleList;

}
