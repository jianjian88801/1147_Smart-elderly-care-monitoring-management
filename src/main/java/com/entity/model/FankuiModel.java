package com.entity.model;

import com.entity.FankuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 反馈信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FankuiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 反馈信息
     */
    private String fankuiName;


    /**
     * 反馈类型
     */
    private Integer fankuiTypes;


    /**
     * 反馈详情
     */
    private String laorenText;


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
	 * 获取：反馈信息
	 */
    public String getFankuiName() {
        return fankuiName;
    }


    /**
	 * 设置：反馈信息
	 */
    public void setFankuiName(String fankuiName) {
        this.fankuiName = fankuiName;
    }
    /**
	 * 获取：反馈类型
	 */
    public Integer getFankuiTypes() {
        return fankuiTypes;
    }


    /**
	 * 设置：反馈类型
	 */
    public void setFankuiTypes(Integer fankuiTypes) {
        this.fankuiTypes = fankuiTypes;
    }
    /**
	 * 获取：反馈详情
	 */
    public String getLaorenText() {
        return laorenText;
    }


    /**
	 * 设置：反馈详情
	 */
    public void setLaorenText(String laorenText) {
        this.laorenText = laorenText;
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
