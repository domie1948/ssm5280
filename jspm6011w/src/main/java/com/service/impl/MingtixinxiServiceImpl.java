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


import com.dao.MingtixinxiDao;
import com.entity.MingtixinxiEntity;
import com.service.MingtixinxiService;
import com.entity.vo.MingtixinxiVO;
import com.entity.view.MingtixinxiView;

@Service("mingtixinxiService")
public class MingtixinxiServiceImpl extends ServiceImpl<MingtixinxiDao, MingtixinxiEntity> implements MingtixinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MingtixinxiEntity> page = this.selectPage(
                new Query<MingtixinxiEntity>(params).getPage(),
                new EntityWrapper<MingtixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MingtixinxiEntity> wrapper) {
		  Page<MingtixinxiView> page =new Query<MingtixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MingtixinxiVO> selectListVO(Wrapper<MingtixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MingtixinxiVO selectVO(Wrapper<MingtixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MingtixinxiView> selectListView(Wrapper<MingtixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MingtixinxiView selectView(Wrapper<MingtixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
