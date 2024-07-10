package com.entity.model;

import com.entity.WuziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuziModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 老人
     */
    private Integer laorenId;


    /**
     * 物资名称
     */
    private String wuziName;


    /**
     * 物资类型
     */
    private Integer wuziTypes;


    /**
     * 数量
     */
    private Integer wuziNumber;


    /**
     * 单位
     */
    private String wuziDanwei;


    /**
     * 发票上传
     */
    private String wuziPhoto;


    /**
     * 创建时间
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：老人
	 */
    public Integer getLaorenId() {
        return laorenId;
    }


    /**
	 * 设置：老人
	 */
    public void setLaorenId(Integer laorenId) {
        this.laorenId = laorenId;
    }
    /**
	 * 获取：物资名称
	 */
    public String getWuziName() {
        return wuziName;
    }


    /**
	 * 设置：物资名称
	 */
    public void setWuziName(String wuziName) {
        this.wuziName = wuziName;
    }
    /**
	 * 获取：物资类型
	 */
    public Integer getWuziTypes() {
        return wuziTypes;
    }


    /**
	 * 设置：物资类型
	 */
    public void setWuziTypes(Integer wuziTypes) {
        this.wuziTypes = wuziTypes;
    }
    /**
	 * 获取：数量
	 */
    public Integer getWuziNumber() {
        return wuziNumber;
    }


    /**
	 * 设置：数量
	 */
    public void setWuziNumber(Integer wuziNumber) {
        this.wuziNumber = wuziNumber;
    }
    /**
	 * 获取：单位
	 */
    public String getWuziDanwei() {
        return wuziDanwei;
    }


    /**
	 * 设置：单位
	 */
    public void setWuziDanwei(String wuziDanwei) {
        this.wuziDanwei = wuziDanwei;
    }
    /**
	 * 获取：发票上传
	 */
    public String getWuziPhoto() {
        return wuziPhoto;
    }


    /**
	 * 设置：发票上传
	 */
    public void setWuziPhoto(String wuziPhoto) {
        this.wuziPhoto = wuziPhoto;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
