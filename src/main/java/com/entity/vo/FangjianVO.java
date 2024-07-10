package com.entity.vo;

import com.entity.FangjianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房间信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangjian")
public class FangjianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 房间号
     */

    @TableField(value = "fangjian_name")
    private String fangjianName;


    /**
     * 房间类型
     */

    @TableField(value = "fangjian_types")
    private Integer fangjianTypes;


    /**
     * 床位剩余数量
     */

    @TableField(value = "fangjian_number")
    private Integer fangjianNumber;


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
	 * 设置：房间号
	 */
    public String getFangjianName() {
        return fangjianName;
    }


    /**
	 * 获取：房间号
	 */

    public void setFangjianName(String fangjianName) {
        this.fangjianName = fangjianName;
    }
    /**
	 * 设置：房间类型
	 */
    public Integer getFangjianTypes() {
        return fangjianTypes;
    }


    /**
	 * 获取：房间类型
	 */

    public void setFangjianTypes(Integer fangjianTypes) {
        this.fangjianTypes = fangjianTypes;
    }
    /**
	 * 设置：床位剩余数量
	 */
    public Integer getFangjianNumber() {
        return fangjianNumber;
    }


    /**
	 * 获取：床位剩余数量
	 */

    public void setFangjianNumber(Integer fangjianNumber) {
        this.fangjianNumber = fangjianNumber;
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
