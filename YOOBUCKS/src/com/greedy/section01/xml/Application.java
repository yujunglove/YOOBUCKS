package com.greedy.section01.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.greedy.common.MenuDTO;
import com.greedy.common.SearchCriteria;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("****** YOOBUCKS에 오신 걸 환영합니다. ******");
			System.out.println("0. 메뉴 전체 조회하기");
			System.out.println("1. 원하는 기준으로 메뉴 고르기");
			System.out.println("2. 친구들과 함께 재미있는 랜덤음식!");
			System.out.println("3. 관리자 모드");
			System.out.println("9. 종료하기");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 0: trimSubMenu(); break;
			case 1 : ifSubMenu(); break;
			case 2 : foreachSubMenu(); break;
			case 3 : modifySubMenu(); break;
			case 9 : System.out.println("프로그램을 종료합니다."); return;
			}
		} while(true);
	}
	
	private static void selectAllMenu() {
		Scanner sc = new Scanner(System.in);
		MenuService menuService = new MenuService();
		//List<MenuDTO> menuList = menuService.selectAllMenu();
		do {
			System.out.println("===== YOOBUCKS =====");
			System.out.println("YOOBUCKS 전체메뉴 조회");
			System.out.println("9. 이전 메뉴로");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : menuService.selectAllMenuCode(null);
			//selectAllMenuCode(selectAllMenu()); break;
			case 9 : return;
			}
			
		} while(true);
		
		
	}


	private static void ifSubMenu() {
		
		Scanner sc = new Scanner(System.in);
		MenuService menuService = new MenuService();
		
		do {
			System.out.println("===== YOOBUCKS =====");
			System.out.println("1. 금액 순으로 보기, 최대 금액을 입력하세요. ");
			System.out.println("2. 메뉴 이름이나 카테고리명으로 조회합니다. ");
			System.out.println("9. 이전 메뉴로");
			System.out.print("메뉴 번호 입력 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : menuService.selectMenuByPrice(inputPrice()); break;
			case 2 : menuService.searchMenu(inputSearchCriteria()); break;
			case 9 : return;
			}
			
		} while(true);
		
	}
	
	private static int inputPrice() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하실 가격의 최대 금액을 입력 해주세요 : ");
		
		return sc.nextInt();
	}
	
	private static SearchCriteria inputSearchCriteria() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("카테고리 번호는 \n9번 커피, \n10번 피지오, \n11번 블렌디드, \n12번 라떼, \n13번 케익, \n14번 쿠키, \n15번 마카롱, \n16번 기타입니다.");
		System.out.println("\n이름 기준은 드시고 싶은 메인 메뉴만 입력하세요. 예) 커피, 라떼");
		System.out.print("검색 기준을 입력해주세요(name or category) : ");
		String condition = sc.nextLine();
		System.out.print("검색어를 입력해주세요 : ");
		String value = sc.nextLine();
		
		return new SearchCriteria(condition, value);
	}


	private static void foreachSubMenu() {
		
		Scanner sc = new Scanner(System.in);
		MenuService menuService = new MenuService();
		
		do {
			System.out.println("****** YOOBUCKS의 랜덤 메뉴 고르기! ******");
			System.out.println("1. 랜덤한 메뉴 3개 추출해서 주문하기");
			System.out.println("9. 이전 메뉴로");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();

			switch(no) {
			case 1 : menuService.searchMenuByRandomMenuCode(createRandomMenuCodeList()); 
			case 9 : return;
			}
		} 
			while(true);
		
	}
		
	//랜덤으로 음식 뽑기
	private static List<Integer> createRandomMenuCodeList() {
		
		Set<Integer> set = new HashSet<>();
		while(set.size() < 3) {
			int temp = ((int) (Math.random() * 40)) + 1;
			set.add(temp);
		}
		
		List<Integer> list = new ArrayList<>(set);
		
		return list;
	}
	
	//전체 조회
	private static void trimSubMenu() {
		Scanner sc = new Scanner(System.in);
		MenuService menuService = new MenuService();
		 menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap());
	}

	private static Map<String, Object> inputSearchCriteriaMap() {
		
		Map<String, Object> criteria = new HashMap<>();
		
		return null;
	}

	private static void modifySubMenu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("======관리자 모드 ======\n암호를 입력하시오. :");
		String yoo = sc.nextLine();
		
		if(yoo.equals("yooyoo")) {
		System.out.println("관리자 입니다.");
		Scanner sc1 = new Scanner(System.in);
		MenuService menuService = new MenuService();
		
		do {
			System.out.println("===== YOOBUCKS 관리자모드 접속 =====");
			System.out.println("1. 관리자모드로 메뉴 수정하기");
			System.out.println("2. 관리자모드로 메뉴 삽입하기");
			System.out.println("3. 관리자모드로 메뉴 삭제하기");
			System.out.println("9. 이전 메뉴로");
			System.out.print("메뉴 번호를 입력하세요 : ");
			int no = sc.nextInt();
			
			switch(no) {
			case 1 : menuService.modifyMenu(inputChangeInfo()); break;
			case 2 : SelectBuilderService.modifyMenu(inputModifyMenu()); break;
			case 3 : SelectBuilderService.deleteMenu(inputMenuCode()); break;
			case 9 : return;
			}
			
		} while(true);
		
		}
		else {
			System.out.println("관리자가 아닙니다.");
		}
	}


	private static Map<String, Object> inputMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("등록할 메뉴 코드 입력 : ");
		int code = sc.nextInt();
		System.out.println("등록할 메뉴 이름 입력 : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("등록 할 카테고리 코드 입력 : ");
		int categoryCode = sc.nextInt();
		sc.nextLine();
		String orderableStatus = sc.nextLine();
		
		Map<String, Object> criteria = new HashMap<>();
		criteria.put("code", code);
		criteria.put("name", name);
		criteria.put("categoryCode", categoryCode);
		criteria.put("orderableStatus", orderableStatus);

		return criteria;
	}
//-----------------------
	private static Map<String, Object> inputChangeInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("변경할 메뉴 코드 입력 : ");
		int code = sc.nextInt();
		System.out.println("변경할 메뉴 이름 입력 : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("변경 할 카테고리 코드 입력 : ");
		int categoryCode = sc.nextInt();
		sc.nextLine();
		String orderableStatus = sc.nextLine();
		
		Map<String, Object> criteria = new HashMap<>();
		criteria.put("code", code);
		criteria.put("name", name);
		criteria.put("categoryCode", categoryCode);
		criteria.put("orderableStatus", orderableStatus);

		return criteria;
	}	
	
	private static MenuDTO inputModifyMenu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 메뉴 코드를 입력하세요 : ");
		int code = sc.nextInt();
		System.out.print("수정할 메뉴 이름을 입력하세요 : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("수정할 메뉴 가격을 입력하세요 : ");
		int price = sc.nextInt();
		System.out.print("수정할 카테고리를 입력하세요 : ");
		int categoryCode = sc.nextInt();
		System.out.print("수정할 판매 등록 여부를 입력하세요(Y/N) : ");
		sc.nextLine();
		String orderableStatus = sc.nextLine();
		
		return new MenuDTO(code, name, price, categoryCode, orderableStatus);
		
	}
	
	private static int inputMenuCode() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 메뉴 번호를 입력하세요 : ");
		int code = sc.nextInt();
		
		return code;
		
	
	
	
	
	
	
	
	
	
	
	
	}
	

}
