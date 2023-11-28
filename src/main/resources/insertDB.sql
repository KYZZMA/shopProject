INSERT INTO client (clientid,clientcheck,clientname)
VALUES (1,100,'Саша'),
       (2,500,'Mаша'),
       (3,50,'Паша');

INSERT INTO product (productid,productname,priceproduct,countproduct)
VALUES (1,'Масло',223.3,3),
       (2,'Мясо',480.7,1),
	   (3,'Шоколадка',69.9,2),
	   (4,'Молоко',110.4,5);

INSERT INTO client_product (clientid,productid)
VALUES (1,1)
