package util;

import java.util.Comparator;

import model.entities.Product;

public class ProductComparator implements Comparator <Product>{

	@Override
	public int compare(Product p1, Product p2) {
		return p1.getName().compareTo(p2.getName());
	}

}
