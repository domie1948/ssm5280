package com.dao;

import com.entity.ShijuantijiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShijuantijiaoVO;
import com.entity.view.ShijuantijiaoView;


/**
 * 试卷提交
 * 
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
public interface ShijuantijiaoDao extends BaseMapper<ShijuantijiaoEntity> {
	
	List<ShijuantijiaoVO> selectListVO(@Param("ew") Wrapper<ShijuantijiaoEntity> wrapper);
	
	ShijuantijiaoVO selectVO(@Param("ew") Wrapper<ShijuantijiaoEntity> wrapper);
	
	List<ShijuantijiaoView> selectListView(@Param("ew") Wrapper<ShijuantijiaoEntity> wrapper);

	List<ShijuantijiaoView> selectListView(Pagination page,@Param("ew") Wrapper<ShijuantijiaoEntity> wrapper);
	
	ShijuantijiaoView selectView(@Param("ew") Wrapper<ShijuantijiaoEntity> wrapper);
	
}
