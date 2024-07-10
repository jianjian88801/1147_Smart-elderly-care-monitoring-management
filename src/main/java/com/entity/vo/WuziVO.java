package com.entity.vo;

import com.entity.WuziEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzi")
public class WuziVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
