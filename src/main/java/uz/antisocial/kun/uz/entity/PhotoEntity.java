package uz.antisocial.kun.uz.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Entity
@Setter
@Getter
public class PhotoEntity extends BaseEntity{

    private String url;
}
