package uz.antisocial.kun.uz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.antisocial.kun.uz.entity.ProfileEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity,Long>{


    ProfileEntity getById(Long id);
    @Query("SELECT c FROM ProfileEntity c WHERE c.username = :username")
    Optional<ProfileEntity> findByUsername(@Param("username") String username);


}
