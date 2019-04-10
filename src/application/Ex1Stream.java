package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Product;

public class Ex1Stream {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		// /home/lucas/eclipse-workspace/functional-programming/in
		List<Product> products = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				products.add(new Product(fields[0],Double.valueOf(fields[1])));
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		double AveragePrice = products.stream()
				.mapToDouble(p -> p.getPrice())
				.reduce(0.0, (s,p) -> s + p)/products.size();
		System.out.printf("Average price: %.2f %n", AveragePrice);
		System.out.println();
		products.stream().filter(p -> p.getPrice() < AveragePrice)
		.sorted((p1,p2) -> -p1.getName().compareTo(p2.getName()))
		.collect(Collectors.toList()).forEach(p -> System.out.println(p.getName()));
				
		sc.close();
	}

}
