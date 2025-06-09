package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiaotianxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LiaotianxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LiaotianxinxiView;


/**
 * 聊天信息
 *
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface LiaotianxinxiService extends IService<LiaotianxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiaotianxinxiVO> selectListVO(Wrapper<LiaotianxinxiEntity> wrapper);
   	
   	LiaotianxinxiVO selectVO(@Param("ew") Wrapper<LiaotianxinxiEntity> wrapper);
   	
   	List<LiaotianxinxiView> selectListView(Wrapper<LiaotianxinxiEntity> wrapper);
   	
   	LiaotianxinxiView selectView(@Param("ew") Wrapper<LiaotianxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiaotianxinxiEntity> wrapper);
   	
}

