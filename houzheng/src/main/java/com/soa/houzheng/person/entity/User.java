package com.soa.houzheng.person.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GenericGenerator(name = "idGenerator",strategy = "uuid")
  @GeneratedValue(generator="idGenerator")
  @Column(name = "uuid",length = 32)
  private String uuid;
  //系统账号
  private String accounts;//系统账号
  private String password;//登录密码
  private String state;//状态：启用,禁用

  //基本信息
  private String name;//姓名
  private String code;//身份证号码
  private String sex;//性别：男,女
  private String telWork;//工作电话
  private String telHome;//家庭电话
  private String email;//邮箱
  private Date htqx;//合同期限
  private Date rzrq;//入职日期
  private Date zzrq;//转正日期
  private Date lzrq;//离职日期
  private String dept;//所在部门
  private String leader;//直属领导
  private String position;//职位
  private double jbgz=0;//基本工资
  private double jxgz=0;//绩效工资
  private String type;//类型：在职，离职，实习，挂靠，人才库
  private String zhuanye;//专业
  private String zhicheng;//职称

  //费用情况
  private double fyze=0;
  private String zffs;//支付方式（月付/年付）

  //社保情况
  private String sbzt;//社保状态（参保/停保）
  private String sbbz;//社保备注

  //执业状态
  private String yzgs;//印章归属(公司/个人)
  private String yzyxq;//印章有效期

  //系统账号
  private String pcPwd;//工作电脑密码

  //备注
  private String remark;//备注

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getAccounts() {
    return accounts;
  }

  public void setAccounts(String accounts) {
    this.accounts = accounts;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getTelWork() {
    return telWork;
  }

  public void setTelWork(String telWork) {
    this.telWork = telWork;
  }

  public String getTelHome() {
    return telHome;
  }

  public void setTelHome(String telHome) {
    this.telHome = telHome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getHtqx() {
    return htqx;
  }

  public void setHtqx(Date htqx) {
    this.htqx = htqx;
  }

  public Date getRzrq() {
    return rzrq;
  }

  public void setRzrq(Date rzrq) {
    this.rzrq = rzrq;
  }

  public Date getZzrq() {
    return zzrq;
  }

  public void setZzrq(Date zzrq) {
    this.zzrq = zzrq;
  }

  public Date getLzrq() {
    return lzrq;
  }

  public void setLzrq(Date lzrq) {
    this.lzrq = lzrq;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public String getLeader() {
    return leader;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public double getJbgz() {
    return jbgz;
  }

  public void setJbgz(double jbgz) {
    this.jbgz = jbgz;
  }

  public double getJxgz() {
    return jxgz;
  }

  public void setJxgz(double jxgz) {
    this.jxgz = jxgz;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getZhuanye() {
    return zhuanye;
  }

  public void setZhuanye(String zhuanye) {
    this.zhuanye = zhuanye;
  }

  public String getZhicheng() {
    return zhicheng;
  }

  public void setZhicheng(String zhicheng) {
    this.zhicheng = zhicheng;
  }

  public double getFyze() {
    return fyze;
  }

  public void setFyze(double fyze) {
    this.fyze = fyze;
  }

  public String getZffs() {
    return zffs;
  }

  public void setZffs(String zffs) {
    this.zffs = zffs;
  }

  public String getSbzt() {
    return sbzt;
  }

  public void setSbzt(String sbzt) {
    this.sbzt = sbzt;
  }

  public String getSbbz() {
    return sbbz;
  }

  public void setSbbz(String sbbz) {
    this.sbbz = sbbz;
  }

  public String getYzgs() {
    return yzgs;
  }

  public void setYzgs(String yzgs) {
    this.yzgs = yzgs;
  }

  public String getYzyxq() {
    return yzyxq;
  }

  public void setYzyxq(String yzyxq) {
    this.yzyxq = yzyxq;
  }

  public String getPcPwd() {
    return pcPwd;
  }

  public void setPcPwd(String pcPwd) {
    this.pcPwd = pcPwd;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}