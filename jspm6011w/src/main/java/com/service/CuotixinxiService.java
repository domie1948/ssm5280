package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CuotixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CuotixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CuotixinxiView;


/**
 * 错题信息
 *
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface CuotixinxiService extends IService<CuotixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CuotixinxiVO> selectListVO(Wrapper<CuotixinxiEntity> wrapper);
   	
   	CuotixinxiVO selectVO(@Param("ew") Wrapper<CuotixinxiEntity> wrapper);
   	
   	List<CuotixinxiView> selectListView(Wrapper<CuotixinxiEntity> wrapper);
   	
   	CuotixinxiView selectView(@Param("ew") Wrapper<CuotixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CuotixinxiEntity> wrapper);
   	
}

