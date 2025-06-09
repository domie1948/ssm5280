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


import com.dao.LiaotianxinxiDao;
import com.entity.LiaotianxinxiEntity;
import com.service.LiaotianxinxiService;
import com.entity.vo.LiaotianxinxiVO;
import com.entity.view.LiaotianxinxiView;

@Service("liaotianxinxiService")
public class LiaotianxinxiServiceImpl extends ServiceImpl<LiaotianxinxiDao, LiaotianxinxiEntity> implements LiaotianxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiaotianxinxiEntity> page = this.selectPage(
                new Query<LiaotianxinxiEntity>(params).getPage(),
                new EntityWrapper<LiaotianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiaotianxinxiEntity> wrapper) {
		  Page<LiaotianxinxiView> page =new Query<LiaotianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LiaotianxinxiVO> selectListVO(Wrapper<LiaotianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LiaotianxinxiVO selectVO(Wrapper<LiaotianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LiaotianxinxiView> selectListView(Wrapper<LiaotianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiaotianxinxiView selectView(Wrapper<LiaotianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
