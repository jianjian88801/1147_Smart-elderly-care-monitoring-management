package com.entity.vo;

import com.entity.FankuiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 反馈信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fankui")
public class FankuiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间 show1 show2 photoShow
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
