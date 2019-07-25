package com.oocl.packagebooking.repo;

import com.oocl.packagebooking.entity.Packaging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PackagingRepository extends JpaRepository<Packaging, String> {

    @Modifying
    @Query("update Packaging as packaging set packaging.status = '已取件' where packaging.id = :id")
    void changePackStatus(@Param("id") String id);

    Packaging findByBillno(String billno);

}
