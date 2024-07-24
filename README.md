Database table structure
=========================

User Table
-----------

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
----------------------------------------------------------------------------------------
Customers Table
sql
Copy code
CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20),
    company VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
--------------------------------------------------------------------------------------------
Sales Table
sql
Copy code
CREATE TABLE sales (
    sale_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers(customer_id),
    product VARCHAR(100) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    sale_date DATE NOT NULL,
    status VARCHAR(50) NOT NULL
);
-----------------------------------------------------------------------------------------------------
4. Communication History Table
sql
Copy code
CREATE TABLE communication_history (
    communication_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers(customer_id),
    user_id INT REFERENCES users(user_id),
    communication_date TIMESTAMP NOT NULL,
    communication_type VARCHAR(50),
    notes TEXT
);
-----------------------------------------------------------------------------------------------------
CREATE TABLE leads (
    lead_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers(customer_id),
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

-------------------------------------------------------------------------------------------------
5. Leads Table
sql
Copy code
CREATE TABLE leads (
    lead_id SERIAL PRIMARY KEY,
    customer_id INT REFERENCES customers(customer_id),
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);
------------------------------------------------------------------------------------------------
6. Reports Table
sql
Copy code
CREATE TABLE reports (
    report_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    report_date DATE NOT NULL,
    report_type VARCHAR(50),
    report_data JSONB,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
----------------------------------------------------------------------------------------------------
1. User Authentication
Register a new user:


INSERT INTO users (username, password_hash, email, role)
VALUES ('john_doe', 'hashed_password', 'john.doe@example.com', 'sales_rep');
User login (fetch user details for authentication):


SELECT * FROM users WHERE username = 'john_doe';
---------------------------------------------------------------------------------------------------------------------------------------------
2. Contact Management
Add a new customer:


INSERT INTO customers (first_name, last_name, email, phone, company)
VALUES ('Jane', 'Doe', 'jane.doe@example.com', '123-456-7890', 'Doe Inc.');
Retrieve customer details:


SELECT * FROM customers WHERE email = 'jane.doe@example.com';
---------------------------------------------------------------------------------------------------------------------------------------------
3. Sales Tracking
Record a new sale:


INSERT INTO sales (customer_id, product, amount, sale_date, status)
VALUES (1, 'Product A', 100.00, '2024-07-22', 'completed');
Get sales data for a customer:


SELECT * FROM sales WHERE customer_id = 1;
---------------------------------------------------------------------------------------------------------------------------------------------
4. Communication History
Log a communication:


INSERT INTO communication_history (customer_id, user_id, communication_date, communication_type, notes)
VALUES (1, 1, '2024-07-22 10:00:00', 'email', 'Discussed new product features.');
Retrieve communication history for a customer:


SELECT * FROM communication_history WHERE customer_id = 1;
---------------------------------------------------------------------------------------------------------------------------------------------
5. Lead Management
Add a new lead:

INSERT INTO leads (customer_id, status)
VALUES (1, 'interested');

UPDATE leads:
SET status = 'converted', updated_at = CURRENT_TIMESTAMP
WHERE lead_id = 1;

Get all leads:
SELECT * FROM leads;
---------------------------------------------------------------------------------------------------------------------------------------------
6. Reporting
Generate a new report:

INSERT INTO reports (user_id, report_date, report_type, report_data)
VALUES (1, '2024-07-22', 'sales_summary', '{"total_sales": 1000, "total_customers": 10}');
Retrieve reports for a user:


SELECT * FROM reports WHERE user_id = 1;
---------------------------------------------------------------------------------------------------------------------------------------------
Spring Boot Integration
To integrate these database tables into a Spring Boot application, you would typically follow these steps:

Set up Spring Boot Project: Create a new Spring Boot project and add dependencies for Spring Data JPA and PostgreSQL.

Create Entity Classes: Define entity classes corresponding to each database table.

Create Repository Interfaces: Create repository interfaces for each entity class to handle CRUD operations.

Service Layer: Implement service classes to handle business logic.

Controller Layer: Create REST controllers to handle HTTP requests and map them to service methods.

Security Configuration: Configure Spring Security for user authentication and authorization.

By following this approach, you can build a robust CRM system using Spring Boot, Java, and PostgreSQL.
