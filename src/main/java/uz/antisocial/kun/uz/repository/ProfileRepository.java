package uz.antisocial.kun.uz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.antisocial.kun.uz.entity.ProfileEntity;

import java.util.List;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity,Long>{


    ProfileEntity getById(Long id);


}
