## Docker

### pull latest redis image
docker pull redis:latest

### run local on default port
docker run -d --name redis-container -p 6379:6379 redis:latest

### docker compose spring app with redis
docker-compose up --build

## Usual stuff....

### build & tag
mvn clean package -DskipTests
docker build -t demo-app:latest .


###
Default spring port 8080  
``http://localhost:80880/ping``
