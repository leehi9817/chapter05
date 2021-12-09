package com.javaex.ex05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		//ArrayList 메모리에 올리기
		List<Person> pList = new ArrayList<Person>();

		//PhoneDB 읽어오기
		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			//한줄씩 읽기
			String data = br.readLine();
			
			if(data == null) {	//마지막 끝 --> 주소가 없음
				break;
			}
			
			//마지막이 아니면 ,로 구분
			String[] dArray = data.split(",");
			
			String name = dArray[0];
			String hp = dArray[1];
			String company = dArray[2];
			
			//Person 객체를 생성하고 값 입력
			Person p = new Person(name, hp, company);
			
			//리스트에 추가
			pList.add(p);
			
		}
		
		//화면출력
		for(int i=0; i<pList.size(); i++) {
			System.out.println("이름: " + pList.get(i).getName());
			System.out.println("핸드폰: " + pList.get(i).getHp());
			System.out.println("회사: " + pList.get(i).getCompany());
			System.out.println("");
		}
		
		br.close();
		
	}

}
