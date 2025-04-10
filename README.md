# EcommerceProject Simulation Project
 
## Description
This project simulates an e-commerce system where users can:
- View available products.
- Add products to a shopping basket.
- Make payments using Credit Card or PayPal.
- Provide a shipping address for order delivery.

It is implemented in Java and demonstrates basic object-oriented programming concepts such as classes, inheritance, and polymorphism.

---

## Project Structure
The project consists of the following classes:

1. *Product*:  
   Represents a product with the following attributes:
   - name: The name of the product.
   - price: The price of the product.
   - stock: The available stock of the product.
   - id: A unique identifier for the product.  
   Includes methods for managing stock, retrieving details, and printing product information.

2. *ShoppingBasket*:  
   Manages the shopping basket, which includes:
   - A list of products added to the basket.
   - Quantities of each product.  
   Includes methods to add items, calculate the total cost, and display the basket contents.

3. *Payment (abstract class)*:  
   Serves as a base class for different payment methods. Includes the pay() method, which is implemented in subclasses.

4. *CreditCard* and *PayPal*:  
   Concrete implementations of the Payment class:
   - CreditCard processes payments using a credit card number.
   - PayPal processes payments using an email address.

5. *Shipment*:  
   Manages the shipping address and displays delivery information.

6. *Main*:  
   The entry point of the program:
   - Displays available products.
   - Handles user interaction to add products to the basket.
   - Processes payments and collects shipping details.
   - Completes the order and displays a summary.
