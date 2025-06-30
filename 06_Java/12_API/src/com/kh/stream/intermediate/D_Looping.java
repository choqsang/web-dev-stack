package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/*
 * 반복
 * - 요소 전체를 반복하는 역할
 * - peek : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * - forEach : 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * */
public class D_Looping {

	public static void main(String[] args) {
		
		int[] values = {1, 2, 3, 4, 5};
		
		// 1~5까지 짝수만 출력(forEach)하고 짝수의 합계(sum)
		Arrays.stream(values)
			  .filter(num -> num%2 == 0)
			  .forEach(num -> System.out.println(num)); // forEach와 sum 둘 다 최종처리 함수라서 동시 사용 불가! 
		// stream의 경우, 한 번 소진되면 새롭게 열어야 함
		int sum = Arrays.stream(values)
				.filter(num -> num%2 == 0)
				.sum();
		System.out.println("합계 : " + sum);
		
		// peek 같이 사용
		sum = Arrays.stream(values)
			.filter(num -> num%2 == 0)
			.peek(System.out::println)
			.sum();
		System.out.println("합계 : " + sum);
		
	}

}
