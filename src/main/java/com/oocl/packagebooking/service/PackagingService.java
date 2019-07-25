package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Packaging;
import com.oocl.packagebooking.repo.PackagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PackagingService {

    @Autowired
    private PackagingRepository packagingRepository;

    @Transactional
    public Packaging updatePackStatus(String id) {
        packagingRepository.changePackStatus(id);
        return packagingRepository.findById(id).get();
    }

}
