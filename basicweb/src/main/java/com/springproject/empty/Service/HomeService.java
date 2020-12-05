package com.springproject.empty.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
	private List<String> cars;

	@PostConstruct
	public void postConstruct() {
		this.cars = new ArrayList<>();
	}
	
	public void addNewCar(String car) {
		cars.add(car);
	}
	
	public List<String> getCars(){
		return new ArrayList<>(this.cars);
	}
}
