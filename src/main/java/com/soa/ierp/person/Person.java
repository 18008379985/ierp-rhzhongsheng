package com.soa.ierp.person;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "persons")
public class Person {
  private String uuid;
  private String accounts;//系统账号
  private String password;//登录密码
  private String state;//状态：启用,禁用

  private String name;//姓名
  private String code;//身份证号码
  private String sex;//性别：男,女
  private String telWork;//工作电话
  private String telHome;//家庭电话
  private String email;//邮箱

  private Date joinDate;//入职日期
  private Date leaveDate;//离职日期
  private String dept;//所在部门
  private String leader;//直属领导
  private String position;//职位
  private Integer salary;//基本工资
  private Integer jxSalary;//绩效工资
  private String type;//类型：正式，挂靠

  private String remark;//备注


  @Id
  @GenericGenerator(name = "idGenerator",strategy = "uuid")
  @GeneratedValue(generator="idGenerator")
  @Column(name = "uuid",length = 32)
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

  public Date getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }

  public Date getLeaveDate() {
    return leaveDate;
  }

  public void setLeaveDate(Date leaveDate) {
    this.leaveDate = leaveDate;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getJxSalary() {
    return jxSalary;
  }

  public void setJxSalary(Integer jxSalary) {
    this.jxSalary = jxSalary;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getLeader() {
    return leader;
  }

  public void setLeader(String leader) {
    this.leader = leader;
  }
}