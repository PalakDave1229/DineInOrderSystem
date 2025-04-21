# 🍽️ Dine-In Order System

This project is a **Dine-In Order System** that allows restaurant customers to scan a QR code at their table to view the menu, place orders, and track their order status in real-time. The backend is built using Java Spring Boot.

## 📌 Features

- Scan QR code to view menu
- Browse categorized food items
- Add/remove items to cart
- Place order directly from table
- Real-time order status updates
- Admin panel to manage orders, tables, and menu

## Technologies and Dependencies Used
* [Maven](https://maven.apache.org/) used as a dependency management tool.
* [Spring Boot](https://spring.io/projects/spring-boot) used to build hassle free web applications and writing REST APIs.
* [Spring Security](https://spring.io/projects/spring-security) used for Authentication and Authorizations.
* [Spring data JPA (Hibernate)](https://hibernate.org/) Used to reduce the time of writing hardcoded sql queries and instead allows to write much more readable and scalable code 
* [MySQL](https://www.mysql.com/) used as a Java persistence store
* [Project Lombok](https://projectlombok.org/) Reduces the time  of writing java boiler plate code.

## Using Dine-In Order System 
CLI-->
```
git clone https://github.com/PalakDave1229/Dine-In-Order-System.git
cd Dine-In-Order-System
mvn package 
java -jar target/dinein-order-0.0.1-SNAPSHOT.jar
```

IntelliJ/Eclipse -->
Let Maven resolve dependencies.
Run the SpringBootApplication class.

## Backend Design 
### Entities
Actors/Entities are inspired by the real-world actors interacting with a restaurant system.
1. **Customer** having attributes:
* unique primary key customer_id, name, emailId, age,phone  
2. **MenuItem** having attributes:
* unique primary key item_id, name,description, price, available, createdOn, updatedOn, status(ACTVATED/DEACTIVATED)
3. **Order** having attributes:
* Unique primary key order_id, table_number, total_amount, timestamp, status(PENDING/SERVED/CANCELLED), customer_id
4. **OrderItem** having attributes:
* unique primary key order_item_id, order_id, menu_item_id, quantity
5. **User** used mainly for authentication and authorization has attributes:
* unique primary key user_id, Authorization--> (STAFF/ADMIN), Username, Password. 

