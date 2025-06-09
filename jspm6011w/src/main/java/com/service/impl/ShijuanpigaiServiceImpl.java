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


import com.dao.ShijuanpigaiDao;
import com.entity.ShijuanpigaiEntity;
import com.service.ShijuanpigaiService;
import com.entity.vo.ShijuanpigaiVO;
import com.entity.view.ShijuanpigaiView;

@Service("shijuanpigaiService")
public class ShijuanpigaiServiceImpl extends ServiceImpl<ShijuanpigaiDao, ShijuanpigaiEntity> implements ShijuanpigaiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShijuanpigaiEntity> page = this.selectPage(
                new Query<ShijuanpigaiEntity>(params).getPage(),
                new EntityWrapper<ShijuanpigaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShijuanpigaiEntity> wrapper) {
		  Page<ShijuanpigaiView> page =new Query<ShijuanpigaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShijuanpigaiVO> selectListVO(Wrapper<ShijuanpigaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShijuanpigaiVO selectVO(Wrapper<ShijuanpigaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShijuanpigaiView> selectListView(Wrapper<ShijuanpigaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShijuanpigaiView selectView(Wrapper<ShijuanpigaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
