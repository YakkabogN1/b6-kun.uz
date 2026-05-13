package uz.antisocial.kun.uz.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class RegionDTO {

    private Long id;
    private Long orderNumber;
    private String key;
    private String nameUz;
    private String nameRu;
    private String nameEn;
    private String name;
    private LocalDateTime createdDate;

    public RegionDTO(Long id, String key, Long orderNumber,LocalDateTime createdDate) {
        this.id=id;
        this.key=key;
        this.orderNumber=orderNumber;
        this.createdDate=createdDate;

    }

    public RegionDTO(Long id, Long orderNumber, String key, String nameUz, String nameRu, String nameEn, String name, LocalDateTime createdDate) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.key = key;
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.nameEn = nameEn;
        this.name = name;
        this.createdDate = createdDate;
    }

    public RegionDTO() {
    }
}
