package com.taifutech.entity;

/**
 * Created by baiyang
 * Email: 1419408386@qq.com
 * Creation time : 2017/4/5
 * If you don't konw it,Please ask Google
 */
public class UserEntity {
    private int id;
    private String userName;
    private String password;

    public UserEntity() {

    }

    public UserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for property 'userName'.
     *
     * @return Value for property 'userName'.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for property 'userName'.
     *
     * @param userName Value to set for property 'userName'.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for property 'password'.
     *
     * @return Value for property 'password'.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for property 'password'.
     *
     * @param password Value to set for property 'password'.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
