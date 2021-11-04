INSERT into motorhomes (is_available, price_per_day, season, size_category, brand_name, model_name)
VALUES (true, 500, "low season", "S", "Toyota", "Corolla");

INSERT into motorhomes (is_available, price_per_day, season, size_category, brand_name, model_name)
VALUES (false, 800, "middle season", "M", "Mercedes", "A500");

INSERT into motorhomes (is_available, price_per_day, season, size_category, brand_name, model_name)
VALUES (true, 1000, "peak season", "L", "BMW", "i3");

INSERT into motorhomes (is_available, price_per_day, season, size_category, brand_name, model_name)
VALUES (false, 500, "low season", "S", "Honda", "etellerandetseason");

INSERT into employee (jobtitle, employee_name)
VALUES ("Sales assistent", "Lars Larsen");

INSERT into employee (jobtitle, employee_name)
VALUES ("Sales assistent", "Peter Petersen");

INSERT into employee (jobtitle, employee_name)
VALUES ("Sales assistent", "Henrik Henriksen");

INSERT into employee (jobtitle, employee_name)
VALUES ("Sales assistent", "Hello Hellosen");

INSERT into employee (jobtitle, employee_name)
VALUES ("Cleaning staff", "Mulle Mullesen");

INSERT into employee (jobtitle, employee_name)
VALUES ("Cleaning staff", "Niels Nielsen");

INSERT into employee (jobtitle, employee_name)
VALUES ("Auto mechanic", "Mo Mosen");

INSERT into employee (jobtitle, employee_name)
VALUES ("Book keeper", "Nina Ninasen");

INSERT into customers (customer_name, customer_phone_number, customer_mail)
VALUES ("Mette Mettesen", 12345678, "Mette@mail.dk");

INSERT into customers (customer_name, customer_phone_number, customer_mail)
VALUES ("Ayo Ayosen", 12341234, "Ayo@mail.dk");

INSERT into customers (customer_name, customer_phone_number, customer_mail)
VALUES ("Pip Langstrømpe", 87654321, "Pipi@mail.dk");

INSERT into customers (customer_name, customer_phone_number, customer_mail)
VALUES ("Bamse Bamsen", 12348765, "Bamse@mail.dk");

SELECT * FROM customers
#SELECT * FROM employee;
#SELECT * FROM motorhomes;

