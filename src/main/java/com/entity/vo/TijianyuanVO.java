package com.entity.vo;

import com.entity.TijianyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 体检员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tijianyuan")
public class TijianyuanVO implements Serializable {
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
     * 体检员姓名
     */

    @TableField(value = "tijianyuan_name")
    private String tijianyuanName;


    /**
     * 头像
     */

    @TableField(value = "tijianyuan_photo")
    private String tijianyuanPhoto;


    /**
     * 体检员手机号
     */

    @TableField(value = "tijianyuan_phone")
    private String tijianyuanPhone;


    /**
     * 体检员身份证号
     */

    @TableField(value = "tijianyuan_id_number")
    private String tijianyuanIdNumber;


    /**
     * 邮箱
     */

    @TableField(value = "tijianyuan_email")
    private String tijianyuanEmail;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 假删
     */

    @TableField(value = "tijianyuan_delete")
    private Integer tijianyuanDelete;


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
	 * 设置：体检员姓名
	 */
    public String getTijianyuanName() {
        return tijianyuanName;
    }


    /**
	 * 获取：体检员姓名
	 */

    public void setTijianyuanName(String tijianyuanName) {
        this.tijianyuanName = tijianyuanName;
    }
    /**
	 * 设置：头像
	 */
    public String getTijianyuanPhoto() {
        return tijianyuanPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setTijianyuanPhoto(String tijianyuanPhoto) {
        this.tijianyuanPhoto = tijianyuanPhoto;
    }
    /**
	 * 设置：体检员手机号
	 */
    public String getTijianyuanPhone() {
        return tijianyuanPhone;
    }


    /**
	 * 获取：体检员手机号
	 */

    public void setTijianyuanPhone(String tijianyuanPhone) {
        this.tijianyuanPhone = tijianyuanPhone;
    }
    /**
	 * 设置：体检员身份证号
	 */
    public String getTijianyuanIdNumber() {
        return tijianyuanIdNumber;
    }


    /**
	 * 获取：体检员身份证号
	 */

    public void setTijianyuanIdNumber(String tijianyuanIdNumber) {
        this.tijianyuanIdNumber = tijianyuanIdNumber;
    }
    /**
	 * 设置：邮箱
	 */
    public String getTijianyuanEmail() {
        return tijianyuanEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setTijianyuanEmail(String tijianyuanEmail) {
        this.tijianyuanEmail = tijianyuanEmail;
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
    public Integer getTijianyuanDelete() {
        return tijianyuanDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setTijianyuanDelete(Integer tijianyuanDelete) {
        this.tijianyuanDelete = tijianyuanDelete;
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
