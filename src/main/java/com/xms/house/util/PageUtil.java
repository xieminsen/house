package com.xms.house.util;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PageUtil {

	/**
	 * 初始化分页参数信息
	 * @return
	 */
	public static PageParam initPageParam(){
		PageParam pageParam=new PageParam();
		pageParam.setRows(10);
		pageParam.setPage(1);
		
		//
		pageParam.setDraw(1);
		pageParam.setLength(10);
		pageParam.setStart(1);
		return pageParam;
	}
	
	/**
	 * 给bootstrop用
	 * @param pageParam
	 * @return
	 */
	public static PageParam pageParam(PageParam pageParam){
		if(pageParam.getLength()!=0){
			pageParam.setRows(pageParam.getLength());
			pageParam.setPage(pageParam.getStart()/pageParam.getLength()+1);
			pageParam.setDraw(pageParam.getDraw());
		}
		//第几页  多少数据
		PageHelper.startPage(pageParam.getPage(), pageParam.getRows());  
		return pageParam;
	}

	
	/**
	 * 封装分页信息
	 * 
	 * @param list
	 * @param pageParam
	 * @return
	 */
	public static <T> PageVo<T> getPage(List<T> list, PageParam pageParam) {
		PageInfo<T> p=getPageInfo(list);
		PageVo<T> pv = new PageVo<T>();
		pv.setRows(list);
		pv.setTotal(Integer.valueOf(p.getTotal()+""));
		
		//
		pv.setDraw(pageParam.getDraw());
		pv.setData(list);
		pv.setRecordsTotal(Integer.valueOf(p.getTotal()+""));
		pv.setRecordsFiltered(Integer.valueOf(p.getTotal()+""));
		return pv;
	}
	
	/**
	 * 设置分页
	 * @Title: SetPage 
	 * @Description: TODO 
	 * @param pageParam
	 * @author xieminsen  2018年9月15日 下午1:43:46
	 */
	public static void SetPage(PageParam pageParam){
		pageParam(pageParam);
		//第几页  多少数据
//		PageHelper.startPage(pageParam.getPage(), pageParam.getRows());  
	}
	
	/**
	 * 转化为PageInfo
	 * @Title: to 
	 * @Description: TODO 
	 * @param list
	 * @return
	 * @author xieminsen  2018年9月15日 下午1:55:21
	 */
	public static <T> PageInfo<T> getPageInfo(List<T> list){
		return new PageInfo<T>(list);  
	}
}