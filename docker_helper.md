#Инструкция docker

Инструкция подразумевает, что пользователь уже развернул docker на локальной машине 

Для компиляции docker-compose.yml требуется создать подсеть docker:
docker network create -d bridge wild_west_network

Для запуска контейнеров в одной сети в режиме Multi-Container Apps требуется выполнить команду 
из директории с docker-compose.yml:
docker-compose up -d --build

Для запуска конкретного контейнера из Multi-Container выполнить (к примеру tomcat):
docker-compose up -d --build tomcat

###Dockerfile 
В Dockerfile составлен скрипт-build сервера приложений Tomcat. В pom.xlm добавлен плагин maven-war-plugin. 
Указан название war-file: <finalName>WildWest</finalName>

###docker-compose.yml
В файле указан сервис создания контейнеров tomcat + postgres + adminer. 
Контейнеры поднимаются в одной сети wild_west_network.
Tomcat поднимается по Dockerfile. Postgres поднимается с переменными окружения:
      POSTGRES_USER: postgres   (пользователь БД)
      POSTGRES_PASSWORD: qwerty (пароль пользователя)
      POSTGRES_DB: wildwest     (название БД)
Контейнер adminer вспомогательный, служит как веб-морда для БД (localhost:9990). Для авторизации указывается: 
Движок - PostgreSQL
Сервер - postgres
Польз  - postgres
Пароль - qwerty
БД     - wildwest

