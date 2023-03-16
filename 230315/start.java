package week2;

import java.util.Scanner; // #include <stdio.h> in C 

public class Week2 { // make sure that the classname and the file name are same. 
	
	public static void sample (int values[]) {
		values[0] = 100;
	}
	
	public static void main(String[] args) {
		int intArray[] = new int[5]; // basic form of array declaration. 
		intArray[2] = 7;
		intArray[3] = 5;
		int sum = 0;
		//for (int i = 0; i < intArray.length; i++)
		//	sum += intArray[i];
		
		sample(intArray);
		
		for (int k : intArray)
			sum += k; // for each 구문. 원본 배열을 바꾸지는못하고, 읽기용으로ㅁ만 쓸 수 있음. k는 그냥 복사본
		
		System.out.println(sum);
		
		Scanner input = new Scanner(System.in);
		String token1 = input.next();
		String token2 = input.next();
		System.out.println(token1 + "," + token2);
		
		int token3 = input.nextInt();
		double token4 = input.nextDouble();
		System.out.println(token3 + "," + token4);
		
		//String s1 = new String("아 잠와");
		String s1 = "hello world";
		//s1.concat("poo");
		String s2 = s1+" poo";
		System.out.println(s2 + " " + 32);
	}

}
