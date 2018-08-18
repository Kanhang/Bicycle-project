package com.aowin.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aowin.dao.BaseMapper;
import com.aowin.dao.CardMapper;
import com.aowin.page.Page;

public class PageUtil {
	/**
	 * oracle分页
	 * @param mapper
	 * @param currentPage
	 * @param map
	 * @return
	 */

	public static <T> Page<T> selectPage(BaseMapper<T> mapper,int currentPage,Map<String, String> map){
		Page<T> page = new Page<T>();
		
		//1.查询符合条件的总记录条数
		int totalCount = mapper.selectCount(map);
		if(totalCount != 0){
			//2.计算总页数
			int totalPage = 0;
			if(totalCount % page.getPageSize() == 0){
				totalPage = totalCount / page.getPageSize();
			}else{
				totalPage = totalCount / page.getPageSize() + 1;
			}
			page.setTotalPage(totalPage);
			//当前页大于总页数 默认跳转至第一页
			if(currentPage > totalPage || currentPage <= 0){
				currentPage = 1;
			}
			page.setCurrentPage(currentPage);
			//3.查询详细记录
			if(map == null){
				map = new HashMap<String, String>();
			}
			map.put("startNo", (currentPage-1)*page.getPageSize()+1+"");
			map.put("endNo", currentPage*page.getPageSize()+"");
			
			List<T> dataList =  mapper.selectData(map);
			for(int i=0;i<dataList.size();i++){
				System.out.println("****************"+dataList.get(i));
			}
			page.setDataList(dataList);
			
		}
		page.setTotalCount(totalCount);
		return page;
	}

}
