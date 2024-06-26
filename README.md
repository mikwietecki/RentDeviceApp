# RentDeviceApp
## Description

This is a simple Spring Boot application that manages devices, categories, and customers. It allows users to perform CRUD (Create, Read, Update, Delete) operations on these entities via a command-line interface.

### Components:
  * Device: Represents electronic devices such as smartphones, laptops, etc. Each device belongs to a specific category and can be rented by customers.
  * Category: Represents categories of devices. Each category can have multiple devices associated with it.
  * Customer: Represents customers who can rent devices. Each customer can rent multiple devices.

### Functionality:
  * Add, Remove Devices: Users can add new devices to the system or remove existing ones.
  * Add, Remove Categories: Users can add new categories or remove existing ones.
  * Add, Remove Customers: Users can add new customers or remove existing ones.
  * Rent Device: Users can rent devices to customers.
  * Search Device by Name: Users can search for devices by their names.

### Technologies Used:
  * Spring Boot: Framework for building the application.
  * Spring Data JPA: For data access and persistence.
  * H2 Database: In-memory database for storing device, category, and customer data.
  * Java Persistence API (JPA): Standard specification for object-relational mapping in Java applications.
