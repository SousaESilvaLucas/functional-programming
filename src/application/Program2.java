package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.Product;
import model.services.ProductService;

public class Program2 {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();

		products.add(new Product("Tv", 900.00));
		products.add(new Product("Notebook", 1200.00));
		products.add(new Product("Tablet", 450.00));
		products.add(new Product("Mango", 10.00));
		products.add(new Product("Mouse",30.00));

		products.forEach(p -> System.out.println(p));
		
		System.out.println();
		
		ProductService ps = new ProductService();
		
		System.out.println("The sum of all prices of products that begin"
				+ "with the letter 'T' is: " + 
				ps.filteredSum(products, p -> p.getName().charAt(0) == 'M'));
		
		

	}

}
