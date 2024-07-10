package com.entity.model;

import com.entity.HouqinrenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 后勤人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HouqinrenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 后勤人员姓名
     */
    private String houqinrenyuanName;


    /**
     * 头像
     */
    private String houqinrenyuanPhoto;


    /**
     * 后勤人员手机号
     */
    private String houqinrenyuanPhone;


    /**
     * 后勤人员身份证号
     */
    private String houqinrenyuanIdNumber;


    /**
     * 邮箱
     */
    private String houqinrenyuanEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 假删
     */
    private Integer houqinrenyuanDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：后勤人员姓名
	 */
    public String getHouqinrenyuanName() {
        return houqinrenyuanName;
    }


    /**
	 * 设置：后勤人员姓名
	 */
    public void setHouqinrenyuanName(String houqinrenyuanName) {
        this.houqinrenyuanName = houqinrenyuanName;
    }
    /**
	 * 获取：头像
	 */
    public String getHouqinrenyuanPhoto() {
        return houqinrenyuanPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setHouqinrenyuanPhoto(String houqinrenyuanPhoto) {
        this.houqinrenyuanPhoto = houqinrenyuanPhoto;
    }
    /**
	 * 获取：后勤人员手机号
	 */
    public String getHouqinrenyuanPhone() {
        return houqinrenyuanPhone;
    }


    /**
	 * 设置：后勤人员手机号
	 */
    public void setHouqinrenyuanPhone(String houqinrenyuanPhone) {
        this.houqinrenyuanPhone = houqinrenyuanPhone;
    }
    /**
	 * 获取：后勤人员身份证号
	 */
    public String getHouqinrenyuanIdNumber() {
        return houqinrenyuanIdNumber;
    }


    /**
	 * 设置：后勤人员身份证号
	 */
    public void setHouqinrenyuanIdNumber(String houqinrenyuanIdNumber) {
        this.houqinrenyuanIdNumber = houqinrenyuanIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getHouqinrenyuanEmail() {
        return houqinrenyuanEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setHouqinrenyuanEmail(String houqinrenyuanEmail) {
        this.houqinrenyuanEmail = houqinrenyuanEmail;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：假删
	 */
    public Integer getHouqinrenyuanDelete() {
        return houqinrenyuanDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setHouqinrenyuanDelete(Integer houqinrenyuanDelete) {
        this.houqinrenyuanDelete = houqinrenyuanDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
