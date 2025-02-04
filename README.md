# RestTemplateForSensor-java

Проект клиента RestTemplateForSensor-java для взаимодействия с сервером (получение и отправка запросов) - Проект SensorRestAPI-SpringBoot (https://github.com/AleksaAlesya/SensorRestAPI-SpringBoot)

Стек технологий и фреймворков:
Java17, Spring-web RestTemplate, xchart, Jackson


Используется класс RestTemplate, чтобы отправить 100 (в цикле) запросов со
случайными температурами и "дождями" на адрес:
POST /measurements/add
Перед этим необходимо зарегистрировать новый сенсор (тоже с
помощью запроса).
POST / sensors/registration
Для получения  всех измерений с сервера  также используется RestTemplate, , отправив GET /measurements
Для получения  списка всех сенсоров с сервера отправлем
GET запрос на адрес:
/sensors

Реализовано дополнительно :
Построение график температур, получив все измерения с сервера.
Для построения графика используется библиотека xchart