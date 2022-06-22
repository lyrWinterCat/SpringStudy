package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Getter
@ToString
//@AllArgsConstructor //모든 생성자 초기화 / 전체필드의 생성자를 자동으로 주입해주는 어노테이션
@RequiredArgsConstructor //final 또는 NonNull 애들만 초기화 생성자를 올려주는 어노테이션
public class Coding {

	/*
	 *Computer computer = new Computer(); >> 이렇게 생성하지 않음
	
	필드 주입
	장:굉장히 편하게 주입할 수 있으나 순환 참조(무한 루프)시 오류가 발생하지 않기 때문에 StackOverFlow 발생.
	>> Exception(nullPoint) 발생하지 않음 
	단: final을 붙일 수 없기 때문에 다른 곳에서 변형 가능
	
	@Data 어노테이션에 의해 final 선언이 가능해서 에러가 나지 않았음
	final : 외부에서 다른 값이 들어오지 못하게 막아줌 > 초기화 생성자가 롬북을 통해서 생성,주입이 가능했기 때문에 에러가 나지 않았음
 	생성자가 있다면 > 초기값을 생성자의 초기화 값으로 인식, final 오류 나지 않음
 	@AutoWired
 	private Computer computer;
	 */
	
//	@NonNull //>>final 없어도 됨
	private final Computer computer;
	
	
	/*
	 생성자 주입 (많이씀)
	순환참조 시 컴파일러가 인지 가능, 오류 발생
	메모리에 할당하면서 초기값으로 주입되므로 final키워드 사용 가능, 다른 곳에서 변형 불가능
	의존성 주입이 되지 않으면 객체가 생성되지 않으므로 
	
	@Autowired
	public Coding(Computer computer) {
		super();
		this.computer=computer;
	}
	
	 */
		
	/*
	 * 	Setter 주입
	 장:굉장히 편하게 주입할 수 있으나 순환 참조(무한 루프)시 오류가 발생하지 않기 때문에 StackOverFlow 발생.
	 단: final을 붙일 수 없기 때문에 다른 곳에서 변형 가능
	 외부에서 직접 주입이 가능함
		@Autowired
		public void setComputer(Computer computer) {
			this.computer=computer;
		}
	 */

}
