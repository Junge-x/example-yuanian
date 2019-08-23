package com.example.demo.Model;


import java.util.Date;

public class XieyjBill {

  private long id;
  private String code;
  private String name;
  private double amount;
  private String memo;
  private String status;
  private String createdTime;
  private String updatedTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public String getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
  }

  @Override
  public String toString() {
    return "XieyjBill{" +
            "id=" + id +
            ", code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", amount=" + amount +
            ", memo='" + memo + '\'' +
            ", status='" + status + '\'' +
            ", createdTime=" + createdTime +
            ", updatedTime=" + updatedTime +
            '}';
  }
}
