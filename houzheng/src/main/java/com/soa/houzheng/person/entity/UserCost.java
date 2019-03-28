package com.soa.houzheng.person.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_cost")
public class UserCost {
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "uuid",length = 32)
    private String uuid;

    private String userId;

    private java.sql.Date zfsj;//支付时间
    private double zfje=0;//支付金额

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getZfsj() {
        return zfsj;
    }

    public void setZfsj(Date zfsj) {
        this.zfsj = zfsj;
    }

    public double getZfje() {
        return zfje;
    }

    public void setZfje(double zfje) {
        this.zfje = zfje;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
