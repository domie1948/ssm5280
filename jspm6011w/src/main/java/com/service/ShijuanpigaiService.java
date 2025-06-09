package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShijuanpigaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShijuanpigaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShijuanpigaiView;


/**
 * 试卷批改
 *
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface ShijuanpigaiService extends IService<ShijuanpigaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShijuanpigaiVO> selectListVO(Wrapper<ShijuanpigaiEntity> wrapper);
   	
   	ShijuanpigaiVO selectVO(@Param("ew") Wrapper<ShijuanpigaiEntity> wrapper);
   	
   	List<ShijuanpigaiView> selectListView(Wrapper<ShijuanpigaiEntity> wrapper);
   	
   	ShijuanpigaiView selectView(@Param("ew") Wrapper<ShijuanpigaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShijuanpigaiEntity> wrapper);
   	
}

