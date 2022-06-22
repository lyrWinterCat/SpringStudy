package com.example.ex00.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@Qualifier("vips")
@Primary
@ToString
public class Vips implements Restaurants {

	@Override
	public int getStakePrice() {
		return 50000;
	}

	@Override
	public String hasSidebar() {
		// TODO Auto-generated method stub
		return "있음";
	}

	@Override
	public boolean hasSalad() {
		// TODO Auto-generated method stub
		return true;
	}



}
