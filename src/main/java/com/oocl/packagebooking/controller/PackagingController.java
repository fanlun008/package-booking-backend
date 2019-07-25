package com.oocl.packagebooking.controller;


import com.oocl.packagebooking.entity.Packaging;
import com.oocl.packagebooking.repo.PackagingRepository;
import com.oocl.packagebooking.service.PackagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/pack")
public class PackagingController {

    @Autowired
    private PackagingRepository packagingRepository;

    @Autowired
    private PackagingService packagingService;


    @PostMapping()
    public Packaging savePackage(@RequestBody Packaging packaging) {
        Packaging save = packagingRepository.save(packaging);
        return save;
    }

    @GetMapping()
    public List<Packaging> getAllPack() {
        return packagingRepository.findAll();
    }

    @PutMapping("/status/{id}")
    public Packaging changPackStatus(@PathVariable(value = "id")String id) {
        return packagingService.updatePackStatus(id);
    }

}
