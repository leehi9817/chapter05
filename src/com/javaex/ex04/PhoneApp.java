package com.javaex.ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		//PhoneDB 읽어오기
		Reader fr = new FileReader("C:\\javaStudy\\file\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			//한줄씩 읽기
			String data = br.readLine();
			
			if(data==null) {	//마지막 끝 --> 주소가 없음
				break;
			}
			
			//마지막이 아니면 ,로 구분
			String[] dArray = data.split(",");
			String name = dArray[0];
			String hp = dArray[1];
			String company = dArray[2];
			
			//화면출력
			System.out.println("이름: " + name);
			System.out.println("핸드폰: " + hp);
			System.out.println("회사: " + company);
			System.out.println("");
		}
		
		br.close();

	}

}
