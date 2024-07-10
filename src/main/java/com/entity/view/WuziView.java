package com.entity.view;

import com.entity.WuziEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 物资申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("wuzi")
public class WuziView extends WuziEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 物资类型的值
		*/
		private String wuziValue;



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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public WuziView() {

	}

	public WuziView(WuziEntity wuziEntity) {
		try {
			BeanUtils.copyProperties(this, wuziEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 物资类型的值
			*/
			public String getWuziValue() {
				return wuziValue;
			}
			/**
			* 设置： 物资类型的值
			*/
			public void setWuziValue(String wuziValue) {
				this.wuziValue = wuziValue;
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














				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}




}
