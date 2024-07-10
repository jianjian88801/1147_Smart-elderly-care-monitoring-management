package com.entity.view;

import com.entity.FankuiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 反馈信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fankui")
public class FankuiView extends FankuiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 反馈类型的值
		*/
		private String fankuiValue;



	public FankuiView() {

	}

	public FankuiView(FankuiEntity fankuiEntity) {
		try {
			BeanUtils.copyProperties(this, fankuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 反馈类型的值
			*/
			public String getFankuiValue() {
				return fankuiValue;
			}
			/**
			* 设置： 反馈类型的值
			*/
			public void setFankuiValue(String fankuiValue) {
				this.fankuiValue = fankuiValue;
			}















}
