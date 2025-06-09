package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MingtixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MingtixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MingtixinxiView;


/**
 * 命题信息
 *
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface MingtixinxiService extends IService<MingtixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MingtixinxiVO> selectListVO(Wrapper<MingtixinxiEntity> wrapper);
   	
   	MingtixinxiVO selectVO(@Param("ew") Wrapper<MingtixinxiEntity> wrapper);
   	
   	List<MingtixinxiView> selectListView(Wrapper<MingtixinxiEntity> wrapper);
   	
   	MingtixinxiView selectView(@Param("ew") Wrapper<MingtixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MingtixinxiEntity> wrapper);
   	
}

