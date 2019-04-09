package model.entities;

public class Product /*implements Comparable <Product>*/{

	String name;
	Double price;
	
	public Product() {
		
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + "," + String.format("%.2f", price);
	}

	public static boolean productPredicate(Product p) {
		return p.getPrice() < 100;
	}
	
	public boolean nonStaticProductPredicate() {
		return price < 100;
	}
	
	public static int productComparatorPrice(Product p1, Product p2) {
		return p1.getPrice().compareTo(p2.getPrice());
	}
	
	public int nonStaticProductComparatorPrice(Product product) {
		return price.compareTo(product.price);
	}
	
	public static void productConsumer(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}
	
	public void nonStaticProductConsumer() {
		price = price * 1.1;
	}
	
	public static String nameUpper(Product p) {
		return p.getName().toUpperCase();
	}
	
	public String nonStaticNameUpper() {
		return name.toUpperCase();
	}
	
/*	@Override
	public int compareTo(Product product) {
		return price.compareTo(product.price);
	}	*/
	
}
