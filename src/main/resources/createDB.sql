create table client
(
	clientId int primary key,
	clientName varchar not null,
	clientCheck float not null
)

create table product
(
	productId int primary key,
	countProduct int not null,
	priceProduct float not null,
	productName varchar not null
)

create table client_product
(
	clientId int references client(clientId),
	productId int references product(productId),
	constraint client_product_pk primary key(clientId, productId)
)