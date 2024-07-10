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
 * 反馈信息
 *
 * @author 
 * @email
 */
@TableName("fankui")
public class FankuiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FankuiEntity() {

	}

	public FankuiEntity(T t) {
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
     * 反馈信息
     */
    @TableField(value = "fankui_name")

    private String fankuiName;


    /**
     * 反馈类型
     */
    @TableField(value = "fankui_types")

    private Integer fankuiTypes;


    /**
     * 反馈详情
     */
    @TableField(value = "laoren_text")

    private String laorenText;


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
	 * 设置：反馈信息
	 */
    public String getFankuiName() {
        return fankuiName;
    }


    /**
	 * 获取：反馈信息
	 */

    public void setFankuiName(String fankuiName) {
        this.fankuiName = fankuiName;
    }
    /**
	 * 设置：反馈类型
	 */
    public Integer getFankuiTypes() {
        return fankuiTypes;
    }


    /**
	 * 获取：反馈类型
	 */

    public void setFankuiTypes(Integer fankuiTypes) {
        this.fankuiTypes = fankuiTypes;
    }
    /**
	 * 设置：反馈详情
	 */
    public String getLaorenText() {
        return laorenText;
    }


    /**
	 * 获取：反馈详情
	 */

    public void setLaorenText(String laorenText) {
        this.laorenText = laorenText;
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
        return "Fankui{" +
            "id=" + id +
            ", fankuiName=" + fankuiName +
            ", fankuiTypes=" + fankuiTypes +
            ", laorenText=" + laorenText +
            ", createTime=" + createTime +
        "}";
    }
}
