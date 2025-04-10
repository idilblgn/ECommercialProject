package Project;

/*
 * Project: EcommerceProject
 
 */
import java.util.ArrayList;
import java.util.Scanner;

class Product {
	private String name;
	private double price;
	private int stock;
	private int id;

	public Product(String name, double price, int stock, int id) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public int getId() {
		return id;
	}

	public void reduceStock(int quantity) {
		stock = stock - quantity;
	}

	@Override
	public String toString() {
		return id + ". " + name + " - $" + price + " (" + stock + " in stock)";
	}
}

class ShoppingBasket {
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Integer> quantities = new ArrayList<>();

	public void addItem(Product product, int quantity) {
		products.add(product);
		quantities.add(quantity);
	}

	public void showBasket() {
		System.out.println("Your Basket:");
		double total = 0;
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			int quantity = quantities.get(i);
			double cost = product.getPrice() * quantity;
			System.out.println(product.getName() + " x" + quantity + " = $" + cost);
			total += cost;
		}
		System.out.println("Total: $" + total);
	}

	public double calculateTotal() {
		double total = 0;
		for (int i = 0; i < products.size(); i++) {
			total += products.get(i).getPrice() * quantities.get(i);
		}
		return total;
	}
}

abstract class Payment {
	public abstract void pay(double amount);
}

class CreditCard extends Payment {
	private String cardNumber;

	public CreditCard(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
	}
}

class PayPal extends Payment {
	private String email;

	public PayPal(String email) {
		this.email = email;
	}

	@Override
	public void pay(double amount) {
		System.out.println("Paid $" + amount + " using PayPal account: " + email);
	}
}

class Shipment {
	private String address;

	public Shipment(String address) {
		this.address = address;
	}

	public void showShipment() {
		System.out.println("Your order will be shipped to: " + address);
	}
}

public class project_java {
	public static void main(String[] args) {

		Product product1 = new Product("Laptop", 1000.00, 10, 1);
		Product product2 = new Product("Phone", 500.00, 5, 2);
		Product product3 = new Product("Headphones", 200.00, 15, 3);

		Product[] products = { product1, product2, product3 };
		ShoppingBasket basket = new ShoppingBasket();

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("\nAvailable Products:");
			for (Product product : products) {
				System.out.println(product.toString());
			}

			System.out.print("Enter product ID to add to basket (0 to checkout): ");
			int productId = input.nextInt();

			if (productId == 0)
				break;

			System.out.print("Enter quantity: ");
			int quantity = input.nextInt();

			Product selectedProduct = null;
			for (Product product : products) {
				if (product.getId() == productId) {
					selectedProduct = product;
				}
			}

			if (selectedProduct != null && selectedProduct.getStock() >= quantity) {
				basket.addItem(selectedProduct, quantity);
				selectedProduct.reduceStock(quantity);
				System.out.println("Added to basket: " + quantity + " x " + selectedProduct.getName());
			} else {
				System.out.println("Invalid product or not enough stock.");
			}
		}

		basket.showBasket();

		System.out.print("\nChoose Payment Method (1: Credit Card, 2: PayPal): ");
		int paymentChoice = input.nextInt();

		Payment payment = null;
		if (paymentChoice == 1) {
			System.out.print("Enter Credit Card Number: ");
			String cardNumber = input.next();
			payment = new CreditCard(cardNumber);
		} else if (paymentChoice == 2) {
			System.out.print("Enter PayPal Email: ");
			String email = input.next();
			payment = new PayPal(email);
		}

		if (payment != null) {
			payment.pay(basket.calculateTotal());
		}

		System.out.print("\nEnter Shipping Address: ");
		input.nextLine();
		String address = input.nextLine();
		Shipment shipment = new Shipment(address);
		shipment.showShipment();

		System.out.println("\nOrder completed. Thank you!");
		input.close();
	}
}

