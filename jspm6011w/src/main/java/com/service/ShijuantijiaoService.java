package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShijuantijiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShijuantijiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShijuantijiaoView;


/**
 * 试卷提交
 *
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface ShijuantijiaoService extends IService<ShijuantijiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShijuantijiaoVO> selectListVO(Wrapper<ShijuantijiaoEntity> wrapper);
   	
   	ShijuantijiaoVO selectVO(@Param("ew") Wrapper<ShijuantijiaoEntity> wrapper);
   	
   	List<ShijuantijiaoView> selectListView(Wrapper<ShijuantijiaoEntity> wrapper);
   	
   	ShijuantijiaoView selectView(@Param("ew") Wrapper<ShijuantijiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShijuantijiaoEntity> wrapper);
   	
}

