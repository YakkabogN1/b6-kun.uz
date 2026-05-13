package uz.antisocial.kun.uz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.antisocial.kun.uz.entity.RegionEntity;
@Repository
public interface RegionRepository extends CrudRepository<RegionEntity,Long> {

}
