package com.entity.model;

import com.entity.HugongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 护工
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HugongModel implements Serializable {
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
     * 护工姓名
     */
    private String hugongName;


    /**
     * 头像
     */
    private String hugongPhoto;


    /**
     * 护工手机号
     */
    private String hugongPhone;


    /**
     * 护工身份证号
     */
    private String hugongIdNumber;


    /**
     * 邮箱
     */
    private String hugongEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 假删
     */
    private Integer hugongDelete;


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
	 * 获取：护工姓名
	 */
    public String getHugongName() {
        return hugongName;
    }


    /**
	 * 设置：护工姓名
	 */
    public void setHugongName(String hugongName) {
        this.hugongName = hugongName;
    }
    /**
	 * 获取：头像
	 */
    public String getHugongPhoto() {
        return hugongPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setHugongPhoto(String hugongPhoto) {
        this.hugongPhoto = hugongPhoto;
    }
    /**
	 * 获取：护工手机号
	 */
    public String getHugongPhone() {
        return hugongPhone;
    }


    /**
	 * 设置：护工手机号
	 */
    public void setHugongPhone(String hugongPhone) {
        this.hugongPhone = hugongPhone;
    }
    /**
	 * 获取：护工身份证号
	 */
    public String getHugongIdNumber() {
        return hugongIdNumber;
    }


    /**
	 * 设置：护工身份证号
	 */
    public void setHugongIdNumber(String hugongIdNumber) {
        this.hugongIdNumber = hugongIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getHugongEmail() {
        return hugongEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setHugongEmail(String hugongEmail) {
        this.hugongEmail = hugongEmail;
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
    public Integer getHugongDelete() {
        return hugongDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setHugongDelete(Integer hugongDelete) {
        this.hugongDelete = hugongDelete;
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
