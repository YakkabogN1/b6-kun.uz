package uz.antisocial.kun.uz.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.antisocial.kun.uz.dto.ProfileInfoDTO;
import uz.antisocial.kun.uz.dto.RegionDTO;
import uz.antisocial.kun.uz.entity.ProfileEntity;
import uz.antisocial.kun.uz.entity.RegionEntity;
import uz.antisocial.kun.uz.repository.RegionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;


    public List<RegionDTO> getAll() {
        Iterable<RegionEntity> list= regionRepository.findAll();
        List<RegionDTO> dtoList= new ArrayList<>();
        for (RegionEntity region : list) {
            dtoList.add(entityToDTO(region));

        }
        return dtoList;
    }

    public RegionDTO save(RegionDTO region){
        RegionEntity regionEntity =new RegionEntity(region.getKey(),region.getOrderNumber(),region.getNameEn(),region.getNameRu(),region.getNameUz());
        regionRepository.save(regionEntity);

        region.setId(regionEntity.getId());
        region.setCreatedDate(LocalDateTime.now());
        return region;
    }




    private RegionEntity dtoToEntity(RegionDTO region){
        return new RegionEntity(region.getKey(),region.getOrderNumber());

    }
    private RegionDTO entityToDTO(RegionEntity region){
        return new RegionDTO(region.getId(), region.getKey(), region.getOrderNumber(),region.getCreatedDate());

    }

}
