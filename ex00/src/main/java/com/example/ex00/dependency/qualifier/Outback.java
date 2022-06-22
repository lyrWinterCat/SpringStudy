package com.example.ex00.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@Qualifier("outback")
@ToString
public class Outback implements Restaurants {

	@Override
	public int getStakePrice() {

		return 80000;
	}

	@Override
	public String hasSidebar() {
		// TODO Auto-generated method stub
		return "없음";
	}

	@Override
	public boolean hasSalad() {
		// TODO Auto-generated method stub
		return false;
	}
	


	

}
