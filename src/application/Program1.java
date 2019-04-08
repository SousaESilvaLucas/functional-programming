package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.Product;

public class Program1 {

	public static void main(String[] args) {
		
		List <Product> products = new ArrayList<>();
		
		products.add(new Product("Tv", 900.00));
		products.add(new Product("Notebook", 1200.00));
		products.add(new Product("Tablet", 450.00));
		products.add(new Product("Mango", 10.00));
		
		products.forEach(p -> System.out.println(p));
		
		products.sort((p1,p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println();
		
		products.forEach(p -> {
			p.setPrice(p.getPrice() * 1.1);
			p.setName(p.getName().toUpperCase());
			
		});
		
		products.forEach(p -> System.out.println(p));
		
		System.out.println();
		
		products.removeIf(p -> p.getPrice() < 100);
		products.forEach(p -> System.out.println(p));
	}

}
