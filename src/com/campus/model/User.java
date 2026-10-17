package com.campus.model;

public class User {
private int userId;
private String fullName;
private String email;
private String phone;
public User(int userId, String fullName, String email, String phone) {
    this.userId = userId;
    this.fullName = fullName;
    this.email = email;
    this.phone = phone;
}
public int getUserId() { return userId; }
public String getFullName() { return fullName; }
public String getEmail() { return email; }
public String getPhone() { return phone; }
}
