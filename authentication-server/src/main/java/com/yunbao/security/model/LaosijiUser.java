package com.yunbao.security.model;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class LaosijiUser {
    @Id
    private String id;

    private String username;

    private String password;

    /**
     * 0,非会员 1，会员
     */
    private Integer userLeavl;

    private Date createTime;

    private Date loginTime;

    /**
     * 用户头像
     */
    private String headimgurl;

    /**
     * 1 android 2 ios 3 web
     */
    private Integer devicecode;

    /**
     * 手机
     */
    private String phone;

    /**
     * 1 男 2女
     */
    private Integer sex;
    private boolean isEnabled;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private String hasRole;

    public String getHasRole() {
        return hasRole;
    }

    public void setHasRole(String hasRole) {
        this.hasRole = hasRole;
    }

    /**
     * 积分
     */
    private Integer point;

    /**
     * 预留字段
     */
    private Integer extraInt;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    /**
     * 预留字段
     */

    private String extraString;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取0,非会员 1，会员
     *
     * @return user_leavl - 0,非会员 1，会员
     */
    public Integer getUserLeavl() {
        return userLeavl;
    }

    /**
     * 设置0,非会员 1，会员
     *
     * @param userLeavl 0,非会员 1，会员
     */
    public void setUserLeavl(Integer userLeavl) {
        this.userLeavl = userLeavl;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return login_time
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取用户头像
     *
     * @return headimgurl - 用户头像
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * 设置用户头像
     *
     * @param headimgurl 用户头像
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * 获取1 android 2 ios 3 web
     *
     * @return devicecode - 1 android 2 ios 3 web
     */
    public Integer getDevicecode() {
        return devicecode;
    }

    /**
     * 设置1 android 2 ios 3 web
     *
     * @param devicecode 1 android 2 ios 3 web
     */
    public void setDevicecode(Integer devicecode) {
        this.devicecode = devicecode;
    }

    /**
     * 获取手机
     *
     * @return phone - 手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机
     *
     * @param phone 手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取1 男 2女
     *
     * @return sex - 1 男 2女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置1 男 2女
     *
     * @param sex 1 男 2女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取积分
     *
     * @return point - 积分
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * 设置积分
     *
     * @param point 积分
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * 获取预留字段
     *
     * @return extra_int - 预留字段
     */
    public Integer getExtraInt() {
        return extraInt;
    }

    /**
     * 设置预留字段
     *
     * @param extraInt 预留字段
     */
    public void setExtraInt(Integer extraInt) {
        this.extraInt = extraInt;
    }

    /**
     * 获取预留字段
     *
     * @return extra_string - 预留字段
     */
    public String getExtraString() {
        return extraString;
    }

    /**
     * 设置预留字段
     *
     * @param extraString 预留字段
     */
    public void setExtraString(String extraString) {
        this.extraString = extraString;
    }
}