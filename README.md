# Fawry Quantum Internship Challenge 3

## Overview
E-commerce checkout system with product management, cart functionality, and shipping services.

## Features
- **Product Types**: Perishable/Non-perishable, Shippable/Non-shippable
- **Cart Management**: Add items, calculate totals
- **Checkout Process**: Stock validation, balance verification, shipping
- **Shipping Service**: Weight calculation, shipment notices

## Classes
- `Product` - Base product class
- `PerishableProduct` - Products with expiry dates
- `NonPerishableProduct` - Products without expiry
- `ShippableProduct` - Products that can be shipped
- `NonShippableProduct` - Digital/non-physical products
- `Cart` - Shopping cart functionality
- `Customer` - Customer with balance management
- `CheckoutService` - Handles checkout process
- `ShippingService` - Manages shipping operations

## Usage
```java
Customer customer = new Customer(1000.0);
ShippableNonPerishableProduct tv = new ShippableNonPerishableProduct("TV", 50.0, 5, 1500);
customer.getCart().addItem(tv, 3);

CheckoutService checkoutService = new CheckoutService();
checkoutService.checkout(customer);
```

## Test Cases
Located in `test cases/` directory with expected outputs.
