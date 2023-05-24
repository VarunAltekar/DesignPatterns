package com.carconfig;

public class CarUser {

	public static void main(String[] args) {
		Car car = Car.getInstance().setId(1).setBody("blue")
				.setSteeringWheel("Awesome").setTyres("MRF").build();
		System.out.println(car);
	}
}
