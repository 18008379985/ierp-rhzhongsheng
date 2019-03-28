package com.soa.ierp.client;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "client_house")
public class ClientHouse {

    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "uuid",length = 32)
    private String uuid;
    private String qxmc;//区县名称
    private String jdmc;//街道名称
    private String xqmc;//小区名称
    private float jzmj=0;//建筑面积
    private float tnmj=0;//套内面积
    private String tdxz;//土地性质
    private String fwxz;//房屋性质
    private String fwzt;//房屋状态
    private String ajyh;//按揭银行
    private float cdje=0;//冲贷金额
    private String clientUuid;//客户uuid


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQxmc() {
        return qxmc;
    }

    public void setQxmc(String qxmc) {
        this.qxmc = qxmc;
    }

    public String getJdmc() {
        return jdmc;
    }

    public void setJdmc(String jdmc) {
        this.jdmc = jdmc;
    }

    public String getXqmc() {
        return xqmc;
    }

    public void setXqmc(String xqmc) {
        this.xqmc = xqmc;
    }

    public float getJzmj() {
        return jzmj;
    }

    public void setJzmj(float jzmj) {
        this.jzmj = jzmj;
    }

    public float getTnmj() {
        return tnmj;
    }

    public void setTnmj(float tnmj) {
        this.tnmj = tnmj;
    }

    public String getTdxz() {
        return tdxz;
    }

    public void setTdxz(String tdxz) {
        this.tdxz = tdxz;
    }

    public String getFwxz() {
        return fwxz;
    }

    public void setFwxz(String fwxz) {
        this.fwxz = fwxz;
    }

    public String getFwzt() {
        return fwzt;
    }

    public void setFwzt(String fwzt) {
        this.fwzt = fwzt;
    }

    public String getAjyh() {
        return ajyh;
    }

    public void setAjyh(String ajyh) {
        this.ajyh = ajyh;
    }

    public String getClientUuid() {
        return clientUuid;
    }

    public void setClientUuid(String clientUuid) {
        this.clientUuid = clientUuid;
    }

    public float getCdje() {
        return cdje;
    }

    public void setCdje(float cdje) {
        this.cdje = cdje;
    }
}
