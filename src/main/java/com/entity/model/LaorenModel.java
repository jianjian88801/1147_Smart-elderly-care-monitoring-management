package com.entity.model;

import com.entity.LaorenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 老人信息预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaorenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老人名称
     */
    private String laorenName;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 老人年纪
     */
    private Integer laorenAge;


    /**
     * 老人身体状态
     */
    private Integer laorenTypes;


    /**
     * 是否有疾病
     */
    private Integer jibingTypes;


    /**
     * 老人信息详情
     */
    private String laorenContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：老人名称
	 */
    public String getLaorenName() {
        return laorenName;
    }


    /**
	 * 设置：老人名称
	 */
    public void setLaorenName(String laorenName) {
        this.laorenName = laorenName;
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
	 * 获取：老人年纪
	 */
    public Integer getLaorenAge() {
        return laorenAge;
    }


    /**
	 * 设置：老人年纪
	 */
    public void setLaorenAge(Integer laorenAge) {
        this.laorenAge = laorenAge;
    }
    /**
	 * 获取：老人身体状态
	 */
    public Integer getLaorenTypes() {
        return laorenTypes;
    }


    /**
	 * 设置：老人身体状态
	 */
    public void setLaorenTypes(Integer laorenTypes) {
        this.laorenTypes = laorenTypes;
    }
    /**
	 * 获取：是否有疾病
	 */
    public Integer getJibingTypes() {
        return jibingTypes;
    }


    /**
	 * 设置：是否有疾病
	 */
    public void setJibingTypes(Integer jibingTypes) {
        this.jibingTypes = jibingTypes;
    }
    /**
	 * 获取：老人信息详情
	 */
    public String getLaorenContent() {
        return laorenContent;
    }


    /**
	 * 设置：老人信息详情
	 */
    public void setLaorenContent(String laorenContent) {
        this.laorenContent = laorenContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
