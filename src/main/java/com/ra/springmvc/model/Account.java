package com.ra.springmvc.model;

import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.*;
import java.util.Date;

public class Account {
    @NotEmpty(message = "Tên tài khoản không được bỏ trống")
    @Size(min = 6, max = 12, message = "Tên tài khoản phải từ 6 - 12 ký tự")
    private String userName;

    @NotEmpty(message = "Mật khẩu không được bỏ trống")
    @Size(min = 8, max = 12, message = "Mật khẩu phải từ 8 - 12 ký tự")
    private String password;

    @NotEmpty(message = "SĐT không được bỏ trống")
    @Pattern(regexp = "^(0|\\+84)\\d{9,10}$", message = "Bạn chưa nhập đúng định dạng SĐT Việt Nam")
    private String phone;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past(message = "Phải trên 18 tuổi")
    private Date birthDay;

    public Account() {
    }

    public Account(String userName, String password, String phone, Date birthDay) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.birthDay = birthDay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
