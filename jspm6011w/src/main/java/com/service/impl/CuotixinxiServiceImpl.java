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


import com.dao.CuotixinxiDao;
import com.entity.CuotixinxiEntity;
import com.service.CuotixinxiService;
import com.entity.vo.CuotixinxiVO;
import com.entity.view.CuotixinxiView;

@Service("cuotixinxiService")
public class CuotixinxiServiceImpl extends ServiceImpl<CuotixinxiDao, CuotixinxiEntity> implements CuotixinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CuotixinxiEntity> page = this.selectPage(
                new Query<CuotixinxiEntity>(params).getPage(),
                new EntityWrapper<CuotixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CuotixinxiEntity> wrapper) {
		  Page<CuotixinxiView> page =new Query<CuotixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CuotixinxiVO> selectListVO(Wrapper<CuotixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CuotixinxiVO selectVO(Wrapper<CuotixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CuotixinxiView> selectListView(Wrapper<CuotixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CuotixinxiView selectView(Wrapper<CuotixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
