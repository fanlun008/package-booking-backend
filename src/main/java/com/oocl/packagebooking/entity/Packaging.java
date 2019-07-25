package com.oocl.packagebooking.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Packaging {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column
    private String billno;

    @Column
    private String receiver;

    @Column
    private String phonenum;

    @Column
    private String status = "nopick";

    @Column
    private Date apptime;

    @Column
    private Integer weight;


}