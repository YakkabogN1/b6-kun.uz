package uz.antisocial.kun.uz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class RegionEntity extends BaseEntity{

    @Column(name="order_number")
    private Long orderNumber;
    @Column(name="key")
    private String key;
    @Column(name="nameUz")
    private String nameUz;
    @Column(name="nameRu")
    private String nameRu;
    @Column(name="nameEn")
    private String nameEn;
    @Column(name="name")
    private String name;
    @Column(name = "status")
    private Boolean status;

    public RegionEntity(Long orderNumber, String key) {
        this.status=Boolean.TRUE;
        this.orderNumber = orderNumber;
        this.key = key;
    }

    public RegionEntity() {
        this.status=Boolean.TRUE;
    }

    public RegionEntity(String key, Long orderNumber) {
        this.key=key;
        this.orderNumber=orderNumber;
        this.status=Boolean.TRUE;
    }

    public RegionEntity(String key,Long orderNumber,  String nameUz, String nameRu, String nameEn) {
        this.status=Boolean.TRUE;
        this.orderNumber = orderNumber;
        this.key = key;
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.nameEn = nameEn;

    }

    public RegionEntity(String key,Long orderNumber,  String nameUz, String nameRu, String nameEn,String name) {
        this.status=Boolean.TRUE;
        this.orderNumber = orderNumber;
        this.key = key;
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.name = name;
    }
}
