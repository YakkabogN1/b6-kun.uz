package uz.antisocial.kun.uz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.antisocial.kun.uz.dto.ProfileInfoDTO;
import uz.antisocial.kun.uz.dto.RegionDTO;
import uz.antisocial.kun.uz.entity.PhotoEntity;
import uz.antisocial.kun.uz.entity.ProfileEntity;
import uz.antisocial.kun.uz.repository.ProfileRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;


    public String helloWorld(){
        return "HelloWorld Azamat";
    }


    public Boolean changePasswordAny(Long prfId,String oldPassword,String newPassword){

        ProfileEntity entity =
                profileRepository.findById(prfId)
                        .orElseThrow(() ->
                                new RuntimeException("Profile not found"));


        if (entity.getPassword().equals(oldPassword)) {
            entity.setPassword(newPassword);

        }else{
            throw new RuntimeException("Password is incorrect");

        }
        return true;

    }
    public List<ProfileInfoDTO> getAllUser(){
        Iterable<ProfileEntity> listEntity= profileRepository.findAll();
        List<ProfileInfoDTO> listDto= new ArrayList<>();
        for (ProfileEntity profile : listEntity) {
            listDto.add(littleEntityToDTO(profile));
        }
        return listDto;

    }
    public ProfileInfoDTO createRole(ProfileInfoDTO student) {
        ProfileEntity newProfile= new ProfileEntity(student.getName(),student.getSurname(),student.getUsername(),student.getPassword(),student.getRoleList());
        student.setId(newProfile.getId());
        return student;
    }
    public ProfileInfoDTO getProfileById(Long id) {
       ProfileEntity profile= profileRepository.getById(id);
       return entityToDTO(profile);

    }
    public ProfileInfoDTO createProfile(ProfileInfoDTO profile){

        ProfileEntity prf= dtoToEntity(profile);
        profileRepository.save(prf);
        profile.setId(prf.getId());
        return profile;
    }
    public ProfileInfoDTO update(Long id,ProfileInfoDTO prf) {
        ProfileEntity profile= fullDtoToEntity(prf);
        ProfileEntity original =
                profileRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Profile not found"));

        if(profile.getName()!=null){
            original.setName(profile.getName());
        }
        if (profile.getSurname()!=null){
            original.setSurname(profile.getSurname());
        }
        if (profile.getUsername()!=null){
            original.setUsername(profile.getUsername());
        }
        if (profile.getPassword()!=null){
            original.setPassword(profile.getPassword());
        }
        if (profile.getPhoto()!=null){
            original.setPhoto(profile.getPhoto());
        }
        if(profile.getStatus()!=null){
            original.setStatus(profile.getStatus());
        }
        if(profile.getRoleList()!=null){
            original.setRoleList(profile.getRoleList());
        }
        original.setUpdatedDate(LocalDateTime.now());
        profileRepository.save(original);
        return prf;
    }
    public Boolean updatePhoto(Long prfId, PhotoEntity photoEntity){
        ProfileEntity entity;
        try {

            entity =
                    profileRepository.findById(prfId)
                            .orElseThrow(() ->
                                    new RuntimeException("Profile not found"));

        } catch (RuntimeException e) {

            throw new RuntimeException(e.getMessage());

        }

        entity.setPhoto(photoEntity);
        entity.getPhoto().setUpdatedDate(LocalDateTime.now());
        profileRepository.save(entity);
        return true;

    }
    public Boolean deleteProfileById(Long id) {

        ProfileEntity entity =
                profileRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Profile not found"));

        entity.setStatus(Boolean.FALSE);
        profileRepository.save(entity);

        return true;
    }
    private ProfileInfoDTO entityToDTO(ProfileEntity prf){
        return new ProfileInfoDTO(prf.getId(), prf.getName(), prf.getSurname(), prf.getUsername(),prf.getRoleList(),prf.getCreatedDate(),prf.getStatus(), prf.getPhoto());

    }
    private ProfileInfoDTO littleEntityToDTO(ProfileEntity prf){
        return new ProfileInfoDTO(prf.getId(), prf.getName(), prf.getSurname(), prf.getUsername(),prf.getRoleList(),prf.getCreatedDate());

    }
    private ProfileEntity dtoToEntity(ProfileInfoDTO prf){
        return new ProfileEntity(prf.getName(),prf.getSurname(),prf.getUsername(), prf.getPassword(),prf.getRoleList());

    }
    private ProfileEntity fullDtoToEntity(ProfileInfoDTO prf){
        return new ProfileEntity(prf.getName(), prf.getSurname(),prf.getUsername(),prf.getPassword(),prf.getStatus(),prf.getPhoto(),prf.getRoleList());

    }


}

