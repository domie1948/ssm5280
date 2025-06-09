package com.dao;

import com.entity.MingtixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MingtixinxiVO;
import com.entity.view.MingtixinxiView;


/**
 * 命题信息
 * 
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface MingtixinxiDao extends BaseMapper<MingtixinxiEntity> {
	
	List<MingtixinxiVO> selectListVO(@Param("ew") Wrapper<MingtixinxiEntity> wrapper);
	
	MingtixinxiVO selectVO(@Param("ew") Wrapper<MingtixinxiEntity> wrapper);
	
	List<MingtixinxiView> selectListView(@Param("ew") Wrapper<MingtixinxiEntity> wrapper);

	List<MingtixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<MingtixinxiEntity> wrapper);
	
	MingtixinxiView selectView(@Param("ew") Wrapper<MingtixinxiEntity> wrapper);
	
}
