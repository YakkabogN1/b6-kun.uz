package uz.antisocial.kun.uz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.antisocial.kun.uz.entity.ProfileEntity;
import uz.antisocial.kun.uz.repository.ProfileRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // username
        System.out.println(" loadUserByUsername : " + username);
        Optional<ProfileEntity> optional = profileRepository.findByUsername(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        ProfileEntity profile = optional.get();
        return new CustomUserDetails(profile.getId(), profile.getUsername(), profile.getPassword(),profile.getStatus(), profile.getRoleList());
    }
}
