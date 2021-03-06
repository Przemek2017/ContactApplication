package com.pc.conapp.pojo;

/**
 *
 * @author Przemek
 */
public class User {

    private Integer userId; //PK
    private String name;
    private String phone;
    private String email;
    private String address;
    private String login;
    private String password;
    private Integer role;
    private Integer loginStatus;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "\n User{" + "userId=" + userId
                + ", name=" + name
                + ", phone=" + phone
                + ", email=" + email
                + ", address=" + address
                + ", login=" + login
                + ", role=" + role
                + ", loginStatus=" + loginStatus + '}';
    }

}
