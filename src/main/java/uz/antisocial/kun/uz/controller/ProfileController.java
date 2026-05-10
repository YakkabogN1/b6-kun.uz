package uz.antisocial.kun.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.antisocial.kun.uz.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @GetMapping("/helloWorld")
    public String getAll() {
        return profileService.helloWorld();
    }


}
