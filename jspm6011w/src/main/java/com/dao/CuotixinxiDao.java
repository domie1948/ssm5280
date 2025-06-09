package com.dao;

import com.entity.CuotixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CuotixinxiVO;
import com.entity.view.CuotixinxiView;


/**
 * 错题信息
 * 
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface CuotixinxiDao extends BaseMapper<CuotixinxiEntity> {
	
	List<CuotixinxiVO> selectListVO(@Param("ew") Wrapper<CuotixinxiEntity> wrapper);
	
	CuotixinxiVO selectVO(@Param("ew") Wrapper<CuotixinxiEntity> wrapper);
	
	List<CuotixinxiView> selectListView(@Param("ew") Wrapper<CuotixinxiEntity> wrapper);

	List<CuotixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<CuotixinxiEntity> wrapper);
	
	CuotixinxiView selectView(@Param("ew") Wrapper<CuotixinxiEntity> wrapper);
	
}
