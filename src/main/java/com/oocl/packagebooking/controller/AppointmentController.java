package com.oocl.packagebooking.controller;


import com.oocl.packagebooking.entity.Packaging;
import com.oocl.packagebooking.repo.PackagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AppointmentController {

    @Autowired
    public PackagingRepository packagingRepository;


    @PostMapping("/appointment")
    public String appointmentPack(@RequestBody Packaging packaging) {

        Packaging byBillno = packagingRepository.findByBillno(packaging.getBillno());

        if (byBillno == null) {
            return "nobill";
        }

        if ("已取件".equals(byBillno.getStatus())) {
            return "haspick";
        }
        byBillno.setApptime(packaging.getApptime());
        byBillno.setStatus("已预约");
        packagingRepository.save(byBillno);
        System.out.println(packaging);
        return "appointment success";
    }

}
