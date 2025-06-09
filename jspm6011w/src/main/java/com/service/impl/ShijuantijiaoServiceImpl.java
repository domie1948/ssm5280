package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShijuantijiaoDao;
import com.entity.ShijuantijiaoEntity;
import com.service.ShijuantijiaoService;
import com.entity.vo.ShijuantijiaoVO;
import com.entity.view.ShijuantijiaoView;

@Service("shijuantijiaoService")
public class ShijuantijiaoServiceImpl extends ServiceImpl<ShijuantijiaoDao, ShijuantijiaoEntity> implements ShijuantijiaoService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShijuantijiaoEntity> page = this.selectPage(
                new Query<ShijuantijiaoEntity>(params).getPage(),
                new EntityWrapper<ShijuantijiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShijuantijiaoEntity> wrapper) {
		  Page<ShijuantijiaoView> page =new Query<ShijuantijiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShijuantijiaoVO> selectListVO(Wrapper<ShijuantijiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShijuantijiaoVO selectVO(Wrapper<ShijuantijiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShijuantijiaoView> selectListView(Wrapper<ShijuantijiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShijuantijiaoView selectView(Wrapper<ShijuantijiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
