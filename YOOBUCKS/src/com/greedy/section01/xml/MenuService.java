package com.greedy.section01.xml;

import static com.greedy.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.greedy.common.MenuDTO;
import com.greedy.common.SearchCriteria;

public class MenuService {
	
	private DynamicSqlMapper mapper;

	public void selectMenuByPrice(int price) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
	
		Map<String, Integer> map = new HashMap<>();
		map.put("price", price);
		
		List<MenuDTO> menuList = mapper.selectMenuByPrice(map);
		
		if(menuList != null && !menuList.isEmpty()) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
	}

	public void searchMenu(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);
		
		if(menuList != null && !menuList.isEmpty()) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}




	public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);
		
		if(menuList != null && !menuList.isEmpty()) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}



	public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		Map<String, List<Integer>> criteria = new HashMap<>();
		criteria.put("randomMenuCodeList", randomMenuCodeList);
		
		List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(criteria);
		
		if(menuList != null && !menuList.isEmpty()) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}

	public void searchMenuByNameOrCategory(Map<String, Object> searchCriteriaMap) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(searchCriteriaMap);
		
		if(menuList != null && !menuList.isEmpty()) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}

	
	//전체 검색
	public void selectAllMenuCode(Map<String, Object> selectAllMenu) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.selectAllMenu();
		sqlSession.close();
		
	}

	public void modifyMenu(Map<String, Object> changeInfo) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		int result = mapper.modifyMenu(changeInfo);
		
		if(result > 0) {
			sqlSession.commit();
			System.out.println("메뉴 정보 변경에 성공하였습니다.");
		} else {
			sqlSession.rollback();
			System.out.println("메뉴 정보 변경에 실패하였습니다.");
		}
		sqlSession.close();
		
	}
	public void registMenu(Map<String, Object> inputMenu) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		int result = mapper.registMenu(inputMenu);
		
		if(result > 0) {
			sqlSession.commit();
			System.out.println("메뉴 정보 변경에 성공하였습니다.");
		} else {
			sqlSession.rollback();
			System.out.println("메뉴 정보 변경에 실패하였습니다.");
		}
		sqlSession.close();
		
	}
	
	public void deleteMenu(Map<String, Object> deleteInfo) {
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		int result = mapper.modifyMenu(deleteInfo);
		
		if(result > 0) {
			sqlSession.commit();
			System.out.println("메뉴 정보 변경에 성공하였습니다.");
		} else {
			sqlSession.rollback();
			System.out.println("메뉴 정보 변경에 실패하였습니다.");
		}
		sqlSession.close();
		
	}
//	public void deleteMenu(Map<String, String> deletMenuCode) {
//		SqlSession sqlSession = getSqlSession();
//		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
//		
//		//int result = mapper.deleteMenu(deletMenuCode);
//
//		if(result > 0) {
//			sqlSession.commit();
//			System.out.println("메뉴 정보 변경에 성공하였습니다.");
//		} else {
//			sqlSession.rollback();
//			System.out.println("메뉴 정보 변경에 실패하였습니다.");
//		}
//		sqlSession.close();
//	}


	
}



	
	
	
	
