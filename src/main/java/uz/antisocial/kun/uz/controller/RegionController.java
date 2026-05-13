package uz.antisocial.kun.uz.controller;

import org.hibernate.sql.exec.spi.PostAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.antisocial.kun.uz.dto.RegionDTO;
import uz.antisocial.kun.uz.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("/getAllRegions")
    public List<RegionDTO> list(){
        return regionService.getAll();
    }

    @PostMapping("/save")
    public RegionDTO save(@RequestBody RegionDTO region){
       return regionService.save(region);

    }



}
