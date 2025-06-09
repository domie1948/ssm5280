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

import com.entity.ShijuanpigaiEntity;
import com.entity.view.ShijuanpigaiView;

import com.service.ShijuanpigaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 试卷批改
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-28 13:38:20
 */
@RestController
@RequestMapping("/shijuanpigai")
public class ShijuanpigaiController {
    @Autowired
    private ShijuanpigaiService shijuanpigaiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShijuanpigaiEntity shijuanpigai, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			shijuanpigai.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			shijuanpigai.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShijuanpigaiEntity> ew = new EntityWrapper<ShijuanpigaiEntity>();
    	PageUtils page = shijuanpigaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijuanpigai), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShijuanpigaiEntity shijuanpigai, HttpServletRequest request){
        EntityWrapper<ShijuanpigaiEntity> ew = new EntityWrapper<ShijuanpigaiEntity>();
    	PageUtils page = shijuanpigaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shijuanpigai), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShijuanpigaiEntity shijuanpigai){
       	EntityWrapper<ShijuanpigaiEntity> ew = new EntityWrapper<ShijuanpigaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shijuanpigai, "shijuanpigai")); 
        return R.ok().put("data", shijuanpigaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShijuanpigaiEntity shijuanpigai){
        EntityWrapper< ShijuanpigaiEntity> ew = new EntityWrapper< ShijuanpigaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shijuanpigai, "shijuanpigai")); 
		ShijuanpigaiView shijuanpigaiView =  shijuanpigaiService.selectView(ew);
		return R.ok("查询试卷批改成功").put("data", shijuanpigaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ShijuanpigaiEntity shijuanpigai = shijuanpigaiService.selectById(id);
        return R.ok().put("data", shijuanpigai);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        ShijuanpigaiEntity shijuanpigai = shijuanpigaiService.selectById(id);
        return R.ok().put("data", shijuanpigai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShijuanpigaiEntity shijuanpigai, HttpServletRequest request){
    	shijuanpigai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shijuanpigai);

        shijuanpigaiService.insert(shijuanpigai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShijuanpigaiEntity shijuanpigai, HttpServletRequest request){
    	shijuanpigai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shijuanpigai);

        shijuanpigaiService.insert(shijuanpigai);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ShijuanpigaiEntity shijuanpigai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shijuanpigai);
        shijuanpigaiService.updateById(shijuanpigai);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shijuanpigaiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ShijuanpigaiEntity> wrapper = new EntityWrapper<ShijuanpigaiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			wrapper.eq("gonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = shijuanpigaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
