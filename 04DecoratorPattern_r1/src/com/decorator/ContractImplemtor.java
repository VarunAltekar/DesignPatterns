package com.decorator;

public class ContractImplemtor implements ContractWithClassImplementor {

	private int cost = 10;
	private String desc = "base";
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		System.out.println();
		return desc;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		System.out.println();
		return cost;
	}

}
