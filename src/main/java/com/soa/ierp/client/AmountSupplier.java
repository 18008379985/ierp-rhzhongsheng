package com.soa.ierp.client;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "amount_supplier")
public class AmountSupplier {

    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "uuid",length = 32)
    private String uuid;
    private String zfmc;//资方名称
    private double tgje=0;//提供金额
    private double cdje=0;//冲贷金额
    private java.sql.Date cdksrq;//冲贷开始日期
    private java.sql.Date cdjsrq;//冲贷结束日期
    private long syts=0;//使用天数
    private double cdll=0;//冲贷利率
    private double cdml=0;//冲贷毛利
    private double cdcb=0;//冲贷成本
    private double gsml=0;//公司毛利
    private java.sql.Date hkrq;//冲贷回款日期
    private double hkje=0;//冲贷回款金额


    private String clientUuid;//客户uuid

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getZfmc() {
        return zfmc;
    }

    public void setZfmc(String zfmc) {
        this.zfmc = zfmc;
    }

    public double getTgje() {
        return tgje;
    }

    public void setTgje(double tgje) {
        this.tgje = tgje;
    }

    public double getCdje() {
        return cdje;
    }

    public void setCdje(double cdje) {
        this.cdje = cdje;
    }

    public Date getCdksrq() {
        return cdksrq;
    }

    public void setCdksrq(Date cdksrq) {
        this.cdksrq = cdksrq;
    }

    public Date getCdjsrq() {
        return cdjsrq;
    }

    public void setCdjsrq(Date cdjsrq) {
        this.cdjsrq = cdjsrq;
    }

    public long getSyts() {
        return syts;
    }

    public void setSyts(long syts) {
        this.syts = syts;
    }

    public double getCdml() {
        return cdml;
    }

    public void setCdml(double cdml) {
        this.cdml = cdml;
    }

    public double getCdcb() {
        return cdcb;
    }

    public void setCdcb(double cdcb) {
        this.cdcb = cdcb;
    }

    public double getGsml() {
        return gsml;
    }

    public void setGsml(double gsml) {
        this.gsml = gsml;
    }

    public String getClientUuid() {
        return clientUuid;
    }

    public void setClientUuid(String clientUuid) {
        this.clientUuid = clientUuid;
    }

    public double getCdll() {
        return cdll;
    }

    public void setCdll(double cdll) {
        this.cdll = cdll;
    }

    public double getHkje() {
        return hkje;
    }

    public void setHkje(double hkje) {
        this.hkje = hkje;
    }

    public Date getHkrq() {
        return hkrq;
    }

    public void setHkrq(Date hkrq) {
        this.hkrq = hkrq;
    }
}
