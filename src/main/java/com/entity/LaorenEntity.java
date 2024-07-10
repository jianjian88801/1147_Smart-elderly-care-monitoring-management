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
 * 老人信息预约
 *
 * @author 
 * @email
 */
@TableName("laoren")
public class LaorenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LaorenEntity() {

	}

	public LaorenEntity(T t) {
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
     * 老人名称
     */
    @TableField(value = "laoren_name")

    private String laorenName;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 老人年纪
     */
    @TableField(value = "laoren_age")

    private Integer laorenAge;


    /**
     * 老人身体状态
     */
    @TableField(value = "laoren_types")

    private Integer laorenTypes;


    /**
     * 是否有疾病
     */
    @TableField(value = "jibing_types")

    private Integer jibingTypes;


    /**
     * 老人信息详情
     */
    @TableField(value = "laoren_content")

    private String laorenContent;


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
	 * 设置：老人名称
	 */
    public String getLaorenName() {
        return laorenName;
    }


    /**
	 * 获取：老人名称
	 */

    public void setLaorenName(String laorenName) {
        this.laorenName = laorenName;
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
	 * 设置：老人年纪
	 */
    public Integer getLaorenAge() {
        return laorenAge;
    }


    /**
	 * 获取：老人年纪
	 */

    public void setLaorenAge(Integer laorenAge) {
        this.laorenAge = laorenAge;
    }
    /**
	 * 设置：老人身体状态
	 */
    public Integer getLaorenTypes() {
        return laorenTypes;
    }


    /**
	 * 获取：老人身体状态
	 */

    public void setLaorenTypes(Integer laorenTypes) {
        this.laorenTypes = laorenTypes;
    }
    /**
	 * 设置：是否有疾病
	 */
    public Integer getJibingTypes() {
        return jibingTypes;
    }


    /**
	 * 获取：是否有疾病
	 */

    public void setJibingTypes(Integer jibingTypes) {
        this.jibingTypes = jibingTypes;
    }
    /**
	 * 设置：老人信息详情
	 */
    public String getLaorenContent() {
        return laorenContent;
    }


    /**
	 * 获取：老人信息详情
	 */

    public void setLaorenContent(String laorenContent) {
        this.laorenContent = laorenContent;
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
        return "Laoren{" +
            "id=" + id +
            ", laorenName=" + laorenName +
            ", sexTypes=" + sexTypes +
            ", laorenAge=" + laorenAge +
            ", laorenTypes=" + laorenTypes +
            ", jibingTypes=" + jibingTypes +
            ", laorenContent=" + laorenContent +
            ", createTime=" + createTime +
        "}";
    }
}
