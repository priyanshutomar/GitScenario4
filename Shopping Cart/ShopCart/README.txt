
                              +———-——————————-+
                              | SHOPPING CART |
                              +——————————————-+


Brief: The Project consist of 4 Packages (Clients, DAO, Domain and Services)

A. HOW TO RUN THE APPLICATION
==================================
- All resource files like usersInput.csv, Invoice.csv etc are placed in ‘<projectHome>/res/‘ directory.
- Format of representing data in resource files is specified within the files only.
- Files in ‘client’ package contain the main() functions
- Run clientUsers.java to take input from usersInput.csv and add the values to ‘users’ table in database named ‘shopCart’
- Run clientProducts.java to take input from productsInput.csv and add the values to ‘products’ table in database named ‘shopCart’
- Run clientOrders.java to take input from orderInput.csv and add the values to ‘orders’ and ‘orderdetails’ table in database named ‘shopCart’
- After running clientOrders.java, final output invoice is automatically generated which is also in Invoice.csv location.



B&C. How many clients and Sequence of the clients to run 
============================================================
- There are three clients main() files to be run according to the given sequence.(1 -> 2 -> 3)
		1. clientUsers.java	
		2. clientProducts.java
		3. clientOrders.java



D. Supported Functionalities 
============================================================
- Insert the values from the .csv file into the Database.
- Lines starting with a ‘#’ in any of the input CSVs are treated as comments and are ignored by the shopping cart application.
- Adding same user again does not adds the user again into the database, a warning message is also displayed.
- Adding same product again does not duplicate the entry in the database, rather quantity of the product is updated accordingly.
- All the CRUD operations are functioned.
- Deletion of Users, Products.
- Updation of Users, Products.
- Before performing any operation on database, validations are also performed. For e.g. before placing a new order, the program checks if the order already exists in the database or not.
- The final Invoice.csv contains all major information like Order ID, Order Date, User Name, User Address, Product Names, Quantities, Grand total etc.


E. Summary
============================================================
- After running all the clients in the given order, the user will get the final Invoice in .csv format
- All the given input can be seen reflected in the respective tables in the database named ’shopCart’.

