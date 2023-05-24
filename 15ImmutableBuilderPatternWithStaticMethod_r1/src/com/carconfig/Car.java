package com.carconfig;

public class Car {

	// necessary car parts
	private final int id;
	private final String tyres;
	private final String body;
	private final String steeringWheel;
	// optional car parts
	private String airConditioning;
	
	private Car(CarBuilder carBuilder) {
		this.id = carBuilder.id;
		this.tyres = carBuilder.tyres;
		this.body = carBuilder.body;
		this.steeringWheel = carBuilder.steeringWheel;
	}
	
	public static class CarBuilder{
		private int id;
		private String tyres;
		private String body;
		private String steeringWheel;
		
		public CarBuilder setId(int id) {
			this.id = id;
			return this;
		}
		
		public CarBuilder setTyres(String tyres) {
			this.tyres = tyres;
			return this;
		}
		
		public CarBuilder setBody(String body) {
			this.body = body;
			return this;
		}
		
		public CarBuilder setSteeringWheel(String steeringWheel) {
			this.steeringWheel = steeringWheel;
			return this;
		}
		
		public Car build() {
			if(this.id != 0 || this.body != null || this.tyres != null || this.steeringWheel != null)
				return new Car(this);
			else {
				throw new RuntimeException("Initialize");
			}
		}
	}
	
	public static CarBuilder getInstance() {
		return new CarBuilder();
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", tyres=" + tyres + ", body=" + body + ", steeringWheel=" + steeringWheel
				+ ", airConditioning=" + airConditioning + "]";
	}
	
	
}
