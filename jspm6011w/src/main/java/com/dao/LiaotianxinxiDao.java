package com.dao;

import com.entity.LiaotianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LiaotianxinxiVO;
import com.entity.view.LiaotianxinxiView;


/**
 * 聊天信息
 * 
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface LiaotianxinxiDao extends BaseMapper<LiaotianxinxiEntity> {
	
	List<LiaotianxinxiVO> selectListVO(@Param("ew") Wrapper<LiaotianxinxiEntity> wrapper);
	
	LiaotianxinxiVO selectVO(@Param("ew") Wrapper<LiaotianxinxiEntity> wrapper);
	
	List<LiaotianxinxiView> selectListView(@Param("ew") Wrapper<LiaotianxinxiEntity> wrapper);

	List<LiaotianxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<LiaotianxinxiEntity> wrapper);
	
	LiaotianxinxiView selectView(@Param("ew") Wrapper<LiaotianxinxiEntity> wrapper);
	
}
