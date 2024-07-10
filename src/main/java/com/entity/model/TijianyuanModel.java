package com.entity.model;

import com.entity.TijianyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 体检员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TijianyuanModel implements Serializable {
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
     * 体检员姓名
     */
    private String tijianyuanName;


    /**
     * 头像
     */
    private String tijianyuanPhoto;


    /**
     * 体检员手机号
     */
    private String tijianyuanPhone;


    /**
     * 体检员身份证号
     */
    private String tijianyuanIdNumber;


    /**
     * 邮箱
     */
    private String tijianyuanEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 假删
     */
    private Integer tijianyuanDelete;


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
	 * 获取：体检员姓名
	 */
    public String getTijianyuanName() {
        return tijianyuanName;
    }


    /**
	 * 设置：体检员姓名
	 */
    public void setTijianyuanName(String tijianyuanName) {
        this.tijianyuanName = tijianyuanName;
    }
    /**
	 * 获取：头像
	 */
    public String getTijianyuanPhoto() {
        return tijianyuanPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setTijianyuanPhoto(String tijianyuanPhoto) {
        this.tijianyuanPhoto = tijianyuanPhoto;
    }
    /**
	 * 获取：体检员手机号
	 */
    public String getTijianyuanPhone() {
        return tijianyuanPhone;
    }


    /**
	 * 设置：体检员手机号
	 */
    public void setTijianyuanPhone(String tijianyuanPhone) {
        this.tijianyuanPhone = tijianyuanPhone;
    }
    /**
	 * 获取：体检员身份证号
	 */
    public String getTijianyuanIdNumber() {
        return tijianyuanIdNumber;
    }


    /**
	 * 设置：体检员身份证号
	 */
    public void setTijianyuanIdNumber(String tijianyuanIdNumber) {
        this.tijianyuanIdNumber = tijianyuanIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getTijianyuanEmail() {
        return tijianyuanEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setTijianyuanEmail(String tijianyuanEmail) {
        this.tijianyuanEmail = tijianyuanEmail;
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
    public Integer getTijianyuanDelete() {
        return tijianyuanDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setTijianyuanDelete(Integer tijianyuanDelete) {
        this.tijianyuanDelete = tijianyuanDelete;
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
