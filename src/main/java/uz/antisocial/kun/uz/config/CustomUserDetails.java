package uz.antisocial.kun.uz.config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.antisocial.kun.uz.enums.ProfileRole;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Boolean status;
    private List<SimpleGrantedAuthority> roles;
    public CustomUserDetails(Long id, String username, String password, Boolean status,
                             List<ProfileRole> role_List) {
        this.id = id;
        this.username = username;
        this.password = password;
        List<SimpleGrantedAuthority> roles= new LinkedList<>();
        role_List.forEach(role->roles.add(new SimpleGrantedAuthority(role.name())));
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true; // status == 'ACTIVE'
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

}
