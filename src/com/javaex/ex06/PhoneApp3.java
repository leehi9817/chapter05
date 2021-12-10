package com.javaex.ex06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 리스트 출력 메소드, Person 객체 생성 후 리스트에 추가하는 메소드를 분리한 코드

public class PhoneApp3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Person 객체 관리할 리스트 만들기
		List<Person> pList = new ArrayList<Person>();

		// 파일 읽기
		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		while (true) {

			String data = br.readLine();

			if (data == null) {
				break;
			}

			// data를 이용하여 객체 생성 후 pList에 추가하는 메소드 호출
			pList = makeList(data, pList); 

		}

		// 데이터 입력 받기
		Scanner sc = new Scanner(System.in);

		System.out.println("데이터를 입력하세요");
		String data = sc.nextLine();

		// data를 이용하여 객체 생성 후 pList에 추가하는 메소드 호출
		pList = makeList(data, pList); 

		// 화면출력
		listPrint(pList);

		// 리스트 전체를 파일로 쓰기
		Writer fw = new FileWriter("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		for (Person p02 : pList) {
			String str = p02.info();
			bw.write(str);
			bw.newLine();
		}

		br.close();
		bw.close();
		sc.close();

	}

	// 전달받은 데이터를 ,로 나누어 객체를 생성하고 객체를 리스트에 담아 리스트를 리턴하는 메소드
	public static List<Person> makeList(String data, List<Person> pList) {

		// 읽은 라인 ,로 나누기
		String[] dArray = data.split(",");

		String name = dArray[0];
		String hp = dArray[1];
		String company = dArray[2];

		// Person 객체 만들기
		Person p = new Person(name, hp, company);
		
		pList.add(p);

		return pList;
	}

	// 전달받은 메소드를 출력하는 메소드
	public static void listPrint(List<Person> pList) {

		for (Person p : pList) {
			System.out.println("이름:" + p.getName());
			System.out.println("핸드폰:" + p.getHp());
			System.out.println("회사:" + p.getCompany());
			System.out.println("");
		}

	}

}
