package com.greedy.section01.xml;

import java.util.List;
import java.util.Map;

import com.greedy.common.MenuDTO;
import com.greedy.common.SearchCriteria;

public interface DynamicSqlMapper {
	
	List<MenuDTO> selectAllMenu();

	List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

	List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuByRandomMenuCode(Map<String, List<Integer>> criteria);

	List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> searchCriteriaMap);

	int modifyMenu(Map<String, Object> changeInfo);
	
	int deleteMenu(Map<String, Object> deletMenuCode);

	int registMenu(Map<String, Object> inputMenu);
	


}
