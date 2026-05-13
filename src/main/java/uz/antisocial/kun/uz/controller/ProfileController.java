package uz.antisocial.kun.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.antisocial.kun.uz.dto.ProfileInfoDTO;
import uz.antisocial.kun.uz.dto.TwoStringDto;
import uz.antisocial.kun.uz.entity.PhotoEntity;
import uz.antisocial.kun.uz.service.ProfileService;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;


    @GetMapping("/helloWorld")
    public String getAll() {
        return profileService.helloWorld();
    }

    @GetMapping("/getAllUsers")
    public List<ProfileInfoDTO> getAllUser(){
        return profileService.getAllUser();
    }

    @PostMapping("createRole")
    public ProfileInfoDTO create(@RequestBody ProfileInfoDTO student){

        return profileService.createRole(student);
    }
    @GetMapping("/getById/{id}")
    public ProfileInfoDTO  getProfileById(@PathVariable Long id){
        return profileService.getProfileById(id);
    }

    @PostMapping("/save")
    public ProfileInfoDTO save(@RequestBody ProfileInfoDTO profileInfoDTO){
        return profileService.createProfile(profileInfoDTO);

    }

    @PutMapping("/update/id/{id}")
    public ProfileInfoDTO update(@RequestBody ProfileInfoDTO prf,@PathVariable Long id){
        return profileService.update(id,prf);

    }

    @DeleteMapping("/delete/id/{id}")
    public Boolean deleteById(@PathVariable Long id){
        return profileService.deleteProfileById(id);

    }

    @PutMapping("/updatePhoto/prfId/{id}")
    public Boolean updatePhotoAny(@PathVariable Long id, @RequestBody PhotoEntity p){
    return profileService.updatePhoto(id,p);

    }

    @PutMapping("/updatePassword/any/prfId/{prfId}")
    public Boolean changePasswordAny(@PathVariable Long prfId, @RequestBody TwoStringDto strings){
     return profileService.changePasswordAny(prfId,strings.getOldPassword(),strings.getNewPassword());

    }

}
