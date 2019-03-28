package com.soa.ierp.supplier;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "amount_used")
public class AmountUsed {

    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "uuid",length = 32)
    private String uuid;

    private double zjze=0;//资金总额
    private double yyje=0;//已用金额
    private double kyje=0;//可用金额=资金总额-已用金额

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public double getKyje() {
        return kyje;
    }

    public void setKyje(double kyje) {
        this.kyje = kyje;
    }
}
