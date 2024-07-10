package com.entity.view;

import com.entity.LaorenEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 老人信息预约
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("laoren")
public class LaorenView extends LaorenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 老人身体状态的值
		*/
		private String laorenValue;
		/**
		* 是否有疾病的值
		*/
		private String jibingValue;



	public LaorenView() {

	}

	public LaorenView(LaorenEntity laorenEntity) {
		try {
			BeanUtils.copyProperties(this, laorenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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















}
