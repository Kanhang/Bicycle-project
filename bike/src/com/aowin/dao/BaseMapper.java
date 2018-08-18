package com.aowin.dao;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
	/**
	 * 带条件查询记录总条数
	 * @param map
	 * @return
	 */
	public int selectCount(Map<String, String> map);
	/**
	 * 带条件查询分页的具体记录
	 * @param map
	 * @return
	 */
	public List<T> selectData(Map<String, String> map);
}

