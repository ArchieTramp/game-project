#Инструкция docker

Инструкция подразумевает, что пользователь уже развернул docker на локальной машине 

Для компиляции docker-compose.yml требуется создать подсеть docker:
docker network create -d bridge wild_west_network

Для запуска контейнеров в одной сети в режиме Multi-Container Apps требуется выполнить команду 
из директории с docker-compose.yml:
docker-compose up -d --build

Для запуска конкретного контейнера из Multi-Container выполнить (к примеру wildwest):
docker-compose up -d --build wildwest

###Dockerfile 
В Dockerfile составлен скрипт-build сервера приложений Tomcat.
Указан название war-file: <finalName>WildWest</finalName>

###docker-compose.yml
В файле указан сервис создания контейнеров wildwest (app - spring-boot) + postgres + adminer. 
Контейнеры поднимаются в одной сети wild_west_network.
WildWest поднимается по Dockerfile. Postgres поднимается с переменными окружения:
      POSTGRES_USER: postgres   (пользователь БД)
      POSTGRES_PASSWORD: qwerty (пароль пользователя)
      POSTGRES_DB: wildwest     (название БД)
Контейнер adminer вспомогательный, служит как веб-морда для БД (localhost:9990). Для авторизации указывается: 
Движок - PostgreSQL
Сервер - postgres
Польз  - postgres
Пароль - qwerty
БД     - wildwest

###Rebuild проекта
При внесении изменений требуется пересобрать проект. Для этого нужно ввести след команды:
mvn clean package

Пересобираем контейнеры:
docker-compose up -d --build
или
docker-compose up -d --build wildwest 
если хотим конкретно приложение пересобрать, в том случае, когда остальные контейнеры подняты

