package com.decorator.patterns;

import com.decorator.ContractWithClassImplementor;

public class MozzarellaDecorator extends PizzaDecorator {

	public MozzarellaDecorator(ContractWithClassImplementor contractWithClassImplementor) {
		super(contractWithClassImplementor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return super.getDesc() + " with Mozzarella";
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return super.getCost()+10;
	}

 
}
