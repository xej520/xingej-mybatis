package com.xingej.mybatis.po;

/**
 * 包装类型，将来在使用时从页面传到controller,service,mapper
 * 
 * @author erjun
 *
 */
public class UserQueryVo {

    // 用户信息
    private User user;

    // 自定义user的扩展对象
    private UserCustom userCustom;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
