package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MingtixinxiEntity;
import com.entity.view.MingtixinxiView;

import com.service.MingtixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 命题信息
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
@RestController
@RequestMapping("/mingtixinxi")
public class MingtixinxiController {
    @Autowired
    private MingtixinxiService mingtixinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MingtixinxiEntity mingtixinxi, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			mingtixinxi.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MingtixinxiEntity> ew = new EntityWrapper<MingtixinxiEntity>();
    	PageUtils page = mingtixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mingtixinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MingtixinxiEntity mingtixinxi, HttpServletRequest request){
        EntityWrapper<MingtixinxiEntity> ew = new EntityWrapper<MingtixinxiEntity>();
    	PageUtils page = mingtixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mingtixinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MingtixinxiEntity mingtixinxi){
       	EntityWrapper<MingtixinxiEntity> ew = new EntityWrapper<MingtixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mingtixinxi, "mingtixinxi")); 
        return R.ok().put("data", mingtixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MingtixinxiEntity mingtixinxi){
        EntityWrapper< MingtixinxiEntity> ew = new EntityWrapper< MingtixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mingtixinxi, "mingtixinxi")); 
		MingtixinxiView mingtixinxiView =  mingtixinxiService.selectView(ew);
		return R.ok("查询命题信息成功").put("data", mingtixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        MingtixinxiEntity mingtixinxi = mingtixinxiService.selectById(id);
        return R.ok().put("data", mingtixinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        MingtixinxiEntity mingtixinxi = mingtixinxiService.selectById(id);
        return R.ok().put("data", mingtixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MingtixinxiEntity mingtixinxi, HttpServletRequest request){
    	mingtixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mingtixinxi);

        mingtixinxiService.insert(mingtixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MingtixinxiEntity mingtixinxi, HttpServletRequest request){
    	mingtixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mingtixinxi);

        mingtixinxiService.insert(mingtixinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MingtixinxiEntity mingtixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mingtixinxi);
        mingtixinxiService.updateById(mingtixinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mingtixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MingtixinxiEntity> wrapper = new EntityWrapper<MingtixinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = mingtixinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
