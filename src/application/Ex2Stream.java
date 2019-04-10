package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Employee;

public class Ex2Stream {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter full file path: ");
		// /home/lucas/eclipse-workspace/functional-programming/in2
		String path = sc.nextLine();
		
		List<Employee> employees = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				employees.add(new Employee(fields[0], 
						fields[1], Double.valueOf(fields[2])));
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Enter salary: ");
		Double salaryThreshold = sc.nextDouble();
		System.out.println();
		System.out.printf("Email of people whose salary is more than %.2f %n"
				, salaryThreshold);
		employees.stream().filter(e -> e.getSalary() > salaryThreshold)
						.sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
						.forEach(e -> System.out.println(e.getEmail()));
		System.out.println();
		double avg = employees.stream().filter(e -> e.getName().charAt(0) == 'M')
						.mapToDouble(e -> e.getSalary()).sum();
		System.out.printf("Sum of salary of "
				+ "people whose name starts with 'M': %.2f", avg);
		sc.close();

	}

}
