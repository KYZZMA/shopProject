# shopProject
Проект представляет собой сервис покупок в магазине, реализованы сущности самимих клиентов, а также товаров. При покупке товаров уменьшается баланс клиента, а также количество товара на складе.
Первоначально необходимо будет создать таблицы, внутри проекта есть все скрипты.
Запросы можно выполнять через Postman:
- http://localhost:9091/shop/getAllProduct - показать список всех продуктов
- http://localhost:9091/shop/getAllClients - показать список всех клиентов
- http://localhost:9091/shop/findClient/1 - получить клиента по необходимому id
- http://localhost:9091/shop/buyProduct - совершить покупку 
- http://localhost:9091/shop/refillCheck?clientId=1&sum=500 - пополнить счет клиента
- http://localhost:9091/shop/refillProduct?productId=3&count=2 - пополнить товары

