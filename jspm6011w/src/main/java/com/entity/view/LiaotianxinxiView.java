package com.entity.view;

import com.entity.LiaotianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 聊天信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
@TableName("liaotianxinxi")
public class LiaotianxinxiView  extends LiaotianxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LiaotianxinxiView(){
	}
 
 	public LiaotianxinxiView(LiaotianxinxiEntity liaotianxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, liaotianxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
