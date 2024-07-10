package com.entity.vo;

import com.entity.HouqinrenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 后勤人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("houqinrenyuan")
public class HouqinrenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 后勤人员姓名
     */

    @TableField(value = "houqinrenyuan_name")
    private String houqinrenyuanName;


    /**
     * 头像
     */

    @TableField(value = "houqinrenyuan_photo")
    private String houqinrenyuanPhoto;


    /**
     * 后勤人员手机号
     */

    @TableField(value = "houqinrenyuan_phone")
    private String houqinrenyuanPhone;


    /**
     * 后勤人员身份证号
     */

    @TableField(value = "houqinrenyuan_id_number")
    private String houqinrenyuanIdNumber;


    /**
     * 邮箱
     */

    @TableField(value = "houqinrenyuan_email")
    private String houqinrenyuanEmail;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 假删
     */

    @TableField(value = "houqinrenyuan_delete")
    private Integer houqinrenyuanDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：后勤人员姓名
	 */
    public String getHouqinrenyuanName() {
        return houqinrenyuanName;
    }


    /**
	 * 获取：后勤人员姓名
	 */

    public void setHouqinrenyuanName(String houqinrenyuanName) {
        this.houqinrenyuanName = houqinrenyuanName;
    }
    /**
	 * 设置：头像
	 */
    public String getHouqinrenyuanPhoto() {
        return houqinrenyuanPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setHouqinrenyuanPhoto(String houqinrenyuanPhoto) {
        this.houqinrenyuanPhoto = houqinrenyuanPhoto;
    }
    /**
	 * 设置：后勤人员手机号
	 */
    public String getHouqinrenyuanPhone() {
        return houqinrenyuanPhone;
    }


    /**
	 * 获取：后勤人员手机号
	 */

    public void setHouqinrenyuanPhone(String houqinrenyuanPhone) {
        this.houqinrenyuanPhone = houqinrenyuanPhone;
    }
    /**
	 * 设置：后勤人员身份证号
	 */
    public String getHouqinrenyuanIdNumber() {
        return houqinrenyuanIdNumber;
    }


    /**
	 * 获取：后勤人员身份证号
	 */

    public void setHouqinrenyuanIdNumber(String houqinrenyuanIdNumber) {
        this.houqinrenyuanIdNumber = houqinrenyuanIdNumber;
    }
    /**
	 * 设置：邮箱
	 */
    public String getHouqinrenyuanEmail() {
        return houqinrenyuanEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setHouqinrenyuanEmail(String houqinrenyuanEmail) {
        this.houqinrenyuanEmail = houqinrenyuanEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：假删
	 */
    public Integer getHouqinrenyuanDelete() {
        return houqinrenyuanDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setHouqinrenyuanDelete(Integer houqinrenyuanDelete) {
        this.houqinrenyuanDelete = houqinrenyuanDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
