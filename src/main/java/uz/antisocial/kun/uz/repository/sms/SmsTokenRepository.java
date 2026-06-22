package uz.antisocial.kun.uz.repository.sms;

import org.springframework.data.repository.CrudRepository;
import uz.antisocial.kun.uz.entity.sms.SmsTokenEntity;

import java.util.Optional;

public interface SmsTokenRepository extends CrudRepository<SmsTokenEntity, Integer> {
    Optional<SmsTokenEntity> findTopByOrderByCreatedDateDesc();
}
