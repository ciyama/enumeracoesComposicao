package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	
		Date today = new Date();

		System.out.println("Enter Client data: ");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emaiClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String statusOrder = sc.nextLine();
		
		Order order = new Order(today, OrderStatus.valueOf(statusOrder), new Client(nameClient, emaiClient, birthDate));
		
		System.out.print("How many items to this order? ");
		Integer itemsOrder = sc.nextInt();
		for (int i=1; i<=itemsOrder; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			OrderItem item = new OrderItem(productQuantity, productPrice,new Product(productName, productPrice));
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY: ");

		System.out.println(order);
		
		
		
		
		
		
		
		
		
		sc.close();
	}

}
