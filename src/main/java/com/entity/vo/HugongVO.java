package com.entity.vo;

import com.entity.HugongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 护工
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("hugong")
public class HugongVO implements Serializable {
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
     * 护工姓名
     */

    @TableField(value = "hugong_name")
    private String hugongName;


    /**
     * 头像
     */

    @TableField(value = "hugong_photo")
    private String hugongPhoto;


    /**
     * 护工手机号
     */

    @TableField(value = "hugong_phone")
    private String hugongPhone;


    /**
     * 护工身份证号
     */

    @TableField(value = "hugong_id_number")
    private String hugongIdNumber;


    /**
     * 邮箱
     */

    @TableField(value = "hugong_email")
    private String hugongEmail;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 假删
     */

    @TableField(value = "hugong_delete")
    private Integer hugongDelete;


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
	 * 设置：护工姓名
	 */
    public String getHugongName() {
        return hugongName;
    }


    /**
	 * 获取：护工姓名
	 */

    public void setHugongName(String hugongName) {
        this.hugongName = hugongName;
    }
    /**
	 * 设置：头像
	 */
    public String getHugongPhoto() {
        return hugongPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setHugongPhoto(String hugongPhoto) {
        this.hugongPhoto = hugongPhoto;
    }
    /**
	 * 设置：护工手机号
	 */
    public String getHugongPhone() {
        return hugongPhone;
    }


    /**
	 * 获取：护工手机号
	 */

    public void setHugongPhone(String hugongPhone) {
        this.hugongPhone = hugongPhone;
    }
    /**
	 * 设置：护工身份证号
	 */
    public String getHugongIdNumber() {
        return hugongIdNumber;
    }


    /**
	 * 获取：护工身份证号
	 */

    public void setHugongIdNumber(String hugongIdNumber) {
        this.hugongIdNumber = hugongIdNumber;
    }
    /**
	 * 设置：邮箱
	 */
    public String getHugongEmail() {
        return hugongEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setHugongEmail(String hugongEmail) {
        this.hugongEmail = hugongEmail;
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
    public Integer getHugongDelete() {
        return hugongDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setHugongDelete(Integer hugongDelete) {
        this.hugongDelete = hugongDelete;
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
