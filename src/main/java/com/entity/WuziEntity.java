package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 物资申请
 *
 * @author 
 * @email
 */
@TableName("wuzi")
public class WuziEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuziEntity() {

	}

	public WuziEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 老人
     */
    @TableField(value = "laoren_id")

    private Integer laorenId;


    /**
     * 物资名称
     */
    @TableField(value = "wuzi_name")

    private String wuziName;


    /**
     * 物资类型
     */
    @TableField(value = "wuzi_types")

    private Integer wuziTypes;


    /**
     * 数量
     */
    @TableField(value = "wuzi_number")

    private Integer wuziNumber;


    /**
     * 单位
     */
    @TableField(value = "wuzi_danwei")

    private String wuziDanwei;


    /**
     * 发票上传
     */
    @TableField(value = "wuzi_photo")

    private String wuziPhoto;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：老人
	 */
    public Integer getLaorenId() {
        return laorenId;
    }


    /**
	 * 获取：老人
	 */

    public void setLaorenId(Integer laorenId) {
        this.laorenId = laorenId;
    }
    /**
	 * 设置：物资名称
	 */
    public String getWuziName() {
        return wuziName;
    }


    /**
	 * 获取：物资名称
	 */

    public void setWuziName(String wuziName) {
        this.wuziName = wuziName;
    }
    /**
	 * 设置：物资类型
	 */
    public Integer getWuziTypes() {
        return wuziTypes;
    }


    /**
	 * 获取：物资类型
	 */

    public void setWuziTypes(Integer wuziTypes) {
        this.wuziTypes = wuziTypes;
    }
    /**
	 * 设置：数量
	 */
    public Integer getWuziNumber() {
        return wuziNumber;
    }


    /**
	 * 获取：数量
	 */

    public void setWuziNumber(Integer wuziNumber) {
        this.wuziNumber = wuziNumber;
    }
    /**
	 * 设置：单位
	 */
    public String getWuziDanwei() {
        return wuziDanwei;
    }


    /**
	 * 获取：单位
	 */

    public void setWuziDanwei(String wuziDanwei) {
        this.wuziDanwei = wuziDanwei;
    }
    /**
	 * 设置：发票上传
	 */
    public String getWuziPhoto() {
        return wuziPhoto;
    }


    /**
	 * 获取：发票上传
	 */

    public void setWuziPhoto(String wuziPhoto) {
        this.wuziPhoto = wuziPhoto;
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

    @Override
    public String toString() {
        return "Wuzi{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", laorenId=" + laorenId +
            ", wuziName=" + wuziName +
            ", wuziTypes=" + wuziTypes +
            ", wuziNumber=" + wuziNumber +
            ", wuziDanwei=" + wuziDanwei +
            ", wuziPhoto=" + wuziPhoto +
            ", createTime=" + createTime +
        "}";
    }
}
