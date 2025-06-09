package com.dao;

import com.entity.ShijuanpigaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShijuanpigaiVO;
import com.entity.view.ShijuanpigaiView;


/**
 * 试卷批改
 * 
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface ShijuanpigaiDao extends BaseMapper<ShijuanpigaiEntity> {
	
	List<ShijuanpigaiVO> selectListVO(@Param("ew") Wrapper<ShijuanpigaiEntity> wrapper);
	
	ShijuanpigaiVO selectVO(@Param("ew") Wrapper<ShijuanpigaiEntity> wrapper);
	
	List<ShijuanpigaiView> selectListView(@Param("ew") Wrapper<ShijuanpigaiEntity> wrapper);

	List<ShijuanpigaiView> selectListView(Pagination page,@Param("ew") Wrapper<ShijuanpigaiEntity> wrapper);
	
	ShijuanpigaiView selectView(@Param("ew") Wrapper<ShijuanpigaiEntity> wrapper);
	
}
