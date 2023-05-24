package com.decorator.user;

import com.decorator.ContractImplemtor;
import com.decorator.patterns.MozzarellaDecorator;
import com.decorator.patterns.VeggiesDecorator;

public class OrderPizza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MozzarellaDecorator mozzarellaDecorator = new MozzarellaDecorator(new VeggiesDecorator(new ContractImplemtor()));
		System.out.println( mozzarellaDecorator.getCost() );
		
	}

}
