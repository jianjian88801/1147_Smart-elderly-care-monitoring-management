package com.entity.view;

import com.entity.FangjianruzhuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房间入住信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangjianruzhu")
public class FangjianruzhuView extends FangjianruzhuEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 fangjian
			/**
			* 房间号
			*/
			private String fangjianName;
			/**
			* 房间类型
			*/
			private Integer fangjianTypes;
				/**
				* 房间类型的值
				*/
				private String fangjianValue;
			/**
			* 床位剩余数量
			*/
			private Integer fangjianNumber;

		//级联表 laoren
			/**
			* 老人名称
			*/
			private String laorenName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 老人年纪
			*/
			private Integer laorenAge;
			/**
			* 老人身体状态
			*/
			private Integer laorenTypes;
				/**
				* 老人身体状态的值
				*/
				private String laorenValue;
			/**
			* 是否有疾病
			*/
			private Integer jibingTypes;
				/**
				* 是否有疾病的值
				*/
				private String jibingValue;
			/**
			* 老人信息详情
			*/
			private String laorenContent;

	public FangjianruzhuView() {

	}

	public FangjianruzhuView(FangjianruzhuEntity fangjianruzhuEntity) {
		try {
			BeanUtils.copyProperties(this, fangjianruzhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}










				//级联表的get和set fangjian
					/**
					* 获取： 房间号
					*/
					public String getFangjianName() {
						return fangjianName;
					}
					/**
					* 设置： 房间号
					*/
					public void setFangjianName(String fangjianName) {
						this.fangjianName = fangjianName;
					}
					/**
					* 获取： 房间类型
					*/
					public Integer getFangjianTypes() {
						return fangjianTypes;
					}
					/**
					* 设置： 房间类型
					*/
					public void setFangjianTypes(Integer fangjianTypes) {
						this.fangjianTypes = fangjianTypes;
					}


						/**
						* 获取： 房间类型的值
						*/
						public String getFangjianValue() {
							return fangjianValue;
						}
						/**
						* 设置： 房间类型的值
						*/
						public void setFangjianValue(String fangjianValue) {
							this.fangjianValue = fangjianValue;
						}
					/**
					* 获取： 床位剩余数量
					*/
					public Integer getFangjianNumber() {
						return fangjianNumber;
					}
					/**
					* 设置： 床位剩余数量
					*/
					public void setFangjianNumber(Integer fangjianNumber) {
						this.fangjianNumber = fangjianNumber;
					}
















				//级联表的get和set laoren
					/**
					* 获取： 老人名称
					*/
					public String getLaorenName() {
						return laorenName;
					}
					/**
					* 设置： 老人名称
					*/
					public void setLaorenName(String laorenName) {
						this.laorenName = laorenName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 老人年纪
					*/
					public Integer getLaorenAge() {
						return laorenAge;
					}
					/**
					* 设置： 老人年纪
					*/
					public void setLaorenAge(Integer laorenAge) {
						this.laorenAge = laorenAge;
					}
					/**
					* 获取： 老人身体状态
					*/
					public Integer getLaorenTypes() {
						return laorenTypes;
					}
					/**
					* 设置： 老人身体状态
					*/
					public void setLaorenTypes(Integer laorenTypes) {
						this.laorenTypes = laorenTypes;
					}


						/**
						* 获取： 老人身体状态的值
						*/
						public String getLaorenValue() {
							return laorenValue;
						}
						/**
						* 设置： 老人身体状态的值
						*/
						public void setLaorenValue(String laorenValue) {
							this.laorenValue = laorenValue;
						}
					/**
					* 获取： 是否有疾病
					*/
					public Integer getJibingTypes() {
						return jibingTypes;
					}
					/**
					* 设置： 是否有疾病
					*/
					public void setJibingTypes(Integer jibingTypes) {
						this.jibingTypes = jibingTypes;
					}


						/**
						* 获取： 是否有疾病的值
						*/
						public String getJibingValue() {
							return jibingValue;
						}
						/**
						* 设置： 是否有疾病的值
						*/
						public void setJibingValue(String jibingValue) {
							this.jibingValue = jibingValue;
						}
					/**
					* 获取： 老人信息详情
					*/
					public String getLaorenContent() {
						return laorenContent;
					}
					/**
					* 设置： 老人信息详情
					*/
					public void setLaorenContent(String laorenContent) {
						this.laorenContent = laorenContent;
					}


















}
