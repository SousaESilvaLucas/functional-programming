package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program3 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3,4,5,10,7);
		
		Stream<Integer> st = list.stream().map(I -> 10*I);
		
		Stream<String> st2 = Stream.of("John", "Lennon", "Is", "A", "Bitch");
		
		Stream<Double> st3 = Stream.iterate(0.0, x -> Math.pow(2, x));
		
		Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L},
				p -> new Long[] {p[1], p[0] + p[1]}).map(p -> p[0]);
		
		System.out.println(Arrays.toString(st.toArray()));
		System.out.println(Arrays.toString(st2.toArray()));
		System.out.println(Arrays.toString(st3.limit(5).toArray()));
		System.out.println(Arrays.toString(st4.limit(10).toArray()));

		int sum = list.stream().reduce(0, (x,y) -> x + y);
		
		System.out.println(sum);
		
		List<Integer> newlist = list.stream()
				.filter(x -> x % 2 == 0)
				.map(x -> 10*x)
				.collect(Collectors.toList());
		System.out.println(newlist);
	}

}
