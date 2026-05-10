package uz.antisocial.kun.uz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.antisocial.kun.uz.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public String helloWorld(){
        return "HelloWorld Azamat";
    }


}
