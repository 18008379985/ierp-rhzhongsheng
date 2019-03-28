package com.soa.ierp.supplier;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "uuid",length = 32)
    private String uuid;
    private String name;//姓名
    private double zjze=0;//资金总额
    private double czje=0;//出账金额
    private double yyje=0;//已用金额
    private double hkje=0;//回款金额
    private double kyje=0;//可用金额=资金总额-已用金额+回款金额

    private java.sql.Date tgsj;//提供时间
    private java.sql.Date czsj;//出账时间
    private java.sql.Date sysj;//使用时间
    private java.sql.Date hksj;//回款时间

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private java.util.Date createTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getZjze() {
        return zjze;
    }

    public void setZjze(double zjze) {
        this.zjze = zjze;
    }

    public double getYyje() {
        return yyje;
    }

    public void setYyje(double yyje) {
        this.yyje = yyje;
    }

    public double getHkje() {
        return hkje;
    }

    public void setHkje(double hkje) {
        this.hkje = hkje;
    }

    public double getKyje() {
        return kyje;
    }

    public void setKyje(double kyje) {
        this.kyje = kyje;
    }

    public Date getTgsj() {
        return tgsj;
    }

    public void setTgsj(Date tgsj) {
        this.tgsj = tgsj;
    }

    public Date getCzsj() {
        return czsj;
    }

    public void setCzsj(Date czsj) {
        this.czsj = czsj;
    }

    public Date getSysj() {
        return sysj;
    }

    public void setSysj(Date sysj) {
        this.sysj = sysj;
    }

    public Date getHksj() {
        return hksj;
    }

    public void setHksj(Date hksj) {
        this.hksj = hksj;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public double getCzje() {
        return czje;
    }

    public void setCzje(double czje) {
        this.czje = czje;
    }
}