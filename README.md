# SpringShop
Technologies: Java, Spring, PostgreSQL

During Epam Java Lab created own Spring Boot application:
* Created RESTful service
* Userd DTO classes with validation (ConstraintValidator)
* Used mapping tool (MapStruct)
* Implemented error handling controller (RestControllerAdvice)
* Configured Spring Boot Actuator
* Implemented Swagger
* Created RestTemplate controller that makes REST calls to main service endpoints and parses response
* Integrated Spring Data JPA
* Implemented mappings OneToOne, ManyToOne
* Used @Query and pageable,sortable reads from database
* Added Transactions using declarative approach
* Covered all business logic with unit tests (JUnit, Mockito)
* Used MockMVC to cover API layer
* Used PostreSQL

Інтернет магазин

Магазин має каталог Товарів, для якого необхідно реалізувати можливість:

сортування за назвою товару (az, za);
сортування товарів за ціною (від дешевих до дорогих, від дорогих до дешевих);
сортування товарів за новизною;
вибірки товарів за параметрами (категорія, проміжок ціни, колір, розмір, тощо). Користувач переглядає каталог і може додавати товари до свого кошика. Після додавання товарів у кошик, зареєстрований користувач може зробити Замовлення. Для незареєстрованого користувача ця опція недоступна. Після розміщення замовлення, йому (замовленню) присвоюється статус 'зареєстрований'. Користувач має особистий кабінет, в якому може переглянути свої замовлення. Адміністратор системи володіє правами:
додавання/видалення товарів, зміни інформації про товар;
блокування/розблокування користувача;
переведення замовлення зі статусу 'зареєстрований' до 'оплачений' або 'скасований'.
