package com.decorator.patterns;

import com.decorator.ContractWithClassImplementor;

public abstract class PizzaDecorator implements ContractWithClassImplementor {

	ContractWithClassImplementor contractWithClassImplementor;
	
	public PizzaDecorator(ContractWithClassImplementor contractWithClassImplementor) {
		this.contractWithClassImplementor = contractWithClassImplementor;
	}
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return contractWithClassImplementor.getDesc();
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return contractWithClassImplementor.getCost();
	}

}
