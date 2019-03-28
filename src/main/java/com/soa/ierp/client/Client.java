package com.soa.ierp.client;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "client")
public class Client {
    //1-基本信息
    @Id
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    @GeneratedValue(generator="idGenerator")
    @Column(name = "uuid",length = 32)
    private String uuid;
    private String khxm;//客户姓名
    private String khlx;//客户类型
    private String sfzh;//身份证号
    private String cydh;//常用电话
    private String bydh;//备用电话
    private String lxdz;//联系地址
    private String qsxm;//亲属姓名
    private String qsgx;//亲属关系
    private String qsdh;//亲属电话

    //2-房产信息(客户与房产信息一对多单向关联)
    //@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    //@JoinColumn(name = "client_uuid")
    //private List<ClientHouse> houses;

    //3-企业信息
    private String gsmc;//公司名称
    private String gsdz;//公司地址
    private double zczj=0;//注册资金
    private String swpj;//税务评级
    private String sfns;//是否纳税
    private java.sql.Date zcrq;//注册日期

    //4-产品信息
    private String yh;//银行
    private double dkze=0;//贷款总额
    private String pggs;//评估公司
    private String hkfs;//还款方式
    private Integer hkqs;//还款期数
    private double hkje=0;//还款金额

    //5-合同信息
    private String htlx;//合同类型
    private double dkje=0;//贷款金额
    private double fwf=0;//服务费
    private double fwfl=0;//服务费率
    private double tcfs=0;//提成方式
    private double tcje=0;//提成金额
    private double gsml=0;//公司毛利

    //6-来源信息
    private String khjl;//客户经理
    private String qdjl;//销售渠道
    private String sczj;//市场总监

    //7-进度信息
    private java.sql.Date zbsj;//资料准备
    private String zbjd="未完";//资料准备

    private double pgze=0;//评估总额
    private java.sql.Date pgsj;//评估时间
    private String pgjd="未完";//评估进度

    private java.sql.Date kcsj;//考察时间
    private String kcjd="未完";//

    private java.sql.Date fhsj;//报分行时间
    private String fhjd="未完";//

    private double spje=0;//审批金额
    private java.sql.Date spsj;//审批时间
    private String spjd="未完";//

    private java.sql.Date qysj;//签约时间
    private String qyjd="未完";//

    private java.sql.Date dysj;//办抵押日期
    private String dyjd="未完";//办抵押

    private java.sql.Date fksj;//放款时间
    private String fkjd="未完";//

    private double fwfhkje=0;//服务费回款金额
    private java.sql.Date fwfhksj;//服务费回款时间
    private String fwfhkjd="未完";//


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

    public String getKhxm() {
        return khxm;
    }

    public void setKhxm(String khxm) {
        this.khxm = khxm;
    }

    public String getKhlx() {
        return khlx;
    }

    public void setKhlx(String khlx) {
        this.khlx = khlx;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getCydh() {
        return cydh;
    }

    public void setCydh(String cydh) {
        this.cydh = cydh;
    }

    public String getBydh() {
        return bydh;
    }

    public void setBydh(String bydh) {
        this.bydh = bydh;
    }

    public String getLxdz() {
        return lxdz;
    }

    public void setLxdz(String lxdz) {
        this.lxdz = lxdz;
    }

    public String getQsxm() {
        return qsxm;
    }

    public void setQsxm(String qsxm) {
        this.qsxm = qsxm;
    }

    public String getQsgx() {
        return qsgx;
    }

    public void setQsgx(String qsgx) {
        this.qsgx = qsgx;
    }

    public String getQsdh() {
        return qsdh;
    }

    public void setQsdh(String qsdh) {
        this.qsdh = qsdh;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getGsdz() {
        return gsdz;
    }

    public void setGsdz(String gsdz) {
        this.gsdz = gsdz;
    }

    public double getZczj() {
        return zczj;
    }

    public void setZczj(double zczj) {
        this.zczj = zczj;
    }

    public String getSwpj() {
        return swpj;
    }

    public void setSwpj(String swpj) {
        this.swpj = swpj;
    }

    public String getSfns() {
        return sfns;
    }

    public void setSfns(String sfns) {
        this.sfns = sfns;
    }

    public String getYh() {
        return yh;
    }

    public void setYh(String yh) {
        this.yh = yh;
    }

    public double getDkze() {
        return dkze;
    }

    public void setDkze(double dkze) {
        this.dkze = dkze;
    }

    public double getSpje() {
        return spje;
    }

    public void setSpje(double spje) {
        this.spje = spje;
    }

    public Date getSpsj() {
        return spsj;
    }

    public void setSpsj(Date spsj) {
        this.spsj = spsj;
    }

    public String getPggs() {
        return pggs;
    }

    public void setPggs(String pggs) {
        this.pggs = pggs;
    }

    public double getPgze() {
        return pgze;
    }

    public void setPgze(double pgze) {
        this.pgze = pgze;
    }

    public Date getPgsj() {
        return pgsj;
    }

    public void setPgsj(Date pgsj) {
        this.pgsj = pgsj;
    }

    public Date getKcsj() {
        return kcsj;
    }

    public void setKcsj(Date kcsj) {
        this.kcsj = kcsj;
    }

    public Date getQysj() {
        return qysj;
    }

    public void setQysj(Date qysj) {
        this.qysj = qysj;
    }

    public Date getFksj() {
        return fksj;
    }

    public void setFksj(Date fksj) {
        this.fksj = fksj;
    }

    public String getHkfs() {
        return hkfs;
    }

    public void setHkfs(String hkfs) {
        this.hkfs = hkfs;
    }

    public Integer getHkqs() {
        return hkqs;
    }

    public void setHkqs(Integer hkqs) {
        this.hkqs = hkqs;
    }

    public double getHkje() {
        return hkje;
    }

    public void setHkje(double hkje) {
        this.hkje = hkje;
    }

    public String getHtlx() {
        return htlx;
    }

    public void setHtlx(String htlx) {
        this.htlx = htlx;
    }

    public double getDkje() {
        return dkje;
    }

    public void setDkje(double dkje) {
        this.dkje = dkje;
    }

    public double getFwf() {
        return fwf;
    }

    public void setFwf(double fwf) {
        this.fwf = fwf;
    }

    public double getFwfhkje() {
        return fwfhkje;
    }

    public void setFwfhkje(double fwfhkje) {
        this.fwfhkje = fwfhkje;
    }

    public Date getFwfhksj() {
        return fwfhksj;
    }

    public void setFwfhksj(Date fwfhksj) {
        this.fwfhksj = fwfhksj;
    }

    public double getTcfs() {
        return tcfs;
    }

    public void setTcfs(double tcfs) {
        this.tcfs = tcfs;
    }

    public double getTcje() {
        return tcje;
    }

    public void setTcje(double tcje) {
        this.tcje = tcje;
    }

    public double getGsml() {
        return gsml;
    }

    public void setGsml(double gsml) {
        this.gsml = gsml;
    }

    public String getKhjl() {
        return khjl;
    }

    public void setKhjl(String khjl) {
        this.khjl = khjl;
    }

    public String getQdjl() {
        return qdjl;
    }

    public void setQdjl(String qdjl) {
        this.qdjl = qdjl;
    }

    public String getSczj() {
        return sczj;
    }

    public void setSczj(String sczj) {
        this.sczj = sczj;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public Date getZcrq() {
        return zcrq;
    }

    public void setZcrq(Date zcrq) {
        this.zcrq = zcrq;
    }

    public double getFwfl() {
        return fwfl;
    }

    public void setFwfl(double fwfl) {
        this.fwfl = fwfl;
    }

    public Date getZbsj() {
        return zbsj;
    }

    public void setZbsj(Date zbsj) {
        this.zbsj = zbsj;
    }

    public String getZbjd() {
        return zbjd;
    }

    public void setZbjd(String zbjd) {
        this.zbjd = zbjd;
    }

    public String getPgjd() {
        return pgjd;
    }

    public void setPgjd(String pgjd) {
        this.pgjd = pgjd;
    }

    public String getKcjd() {
        return kcjd;
    }

    public void setKcjd(String kcjd) {
        this.kcjd = kcjd;
    }

    public Date getFhsj() {
        return fhsj;
    }

    public void setFhsj(Date fhsj) {
        this.fhsj = fhsj;
    }

    public String getFhjd() {
        return fhjd;
    }

    public void setFhjd(String fhjd) {
        this.fhjd = fhjd;
    }

    public String getSpjd() {
        return spjd;
    }

    public void setSpjd(String spjd) {
        this.spjd = spjd;
    }

    public String getQyjd() {
        return qyjd;
    }

    public void setQyjd(String qyjd) {
        this.qyjd = qyjd;
    }

    public Date getDysj() {
        return dysj;
    }

    public void setDysj(Date dysj) {
        this.dysj = dysj;
    }

    public String getDyjd() {
        return dyjd;
    }

    public void setDyjd(String dyjd) {
        this.dyjd = dyjd;
    }

    public String getFkjd() {
        return fkjd;
    }

    public void setFkjd(String fkjd) {
        this.fkjd = fkjd;
    }

    public String getFwfhkjd() {
        return fwfhkjd;
    }

    public void setFwfhkjd(String fwfhkjd) {
        this.fwfhkjd = fwfhkjd;
    }
}