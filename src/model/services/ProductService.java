package model.services;

import java.util.List;
import java.util.function.Predicate;

import model.entities.Product;

public class ProductService {
	
	public Double filteredSum(List<Product> products, Predicate<Product> pred) {
		Double sum = 0.0;
		for (Product p : products) {
			if (pred.test(p)) {
				sum += p.getPrice();
			}
		}
		
		return sum;
	}

}
