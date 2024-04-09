# Define default target
.PHONY: all
all: rebuild

dev_enviroment:
	docker-compose up

rebuild_dev_enviroment:
	docker-compose down
	docker-compose -f docker-compose.prod.yml down
	gradle clean
	gradle compileJava
	docker-compose build --no-cache
	docker-compose up  --remove-orphans

stop:
	docker-compose down
	docker-compose -f docker-compose.prod.yml down

prod_enviroment:
	docker-compose down
	docker-compose -f docker-compose.prod.yml down
	gradle clean
	gradle compileJava
	gradle bootJar
	docker-compose down
	docker-compose -f docker-compose.prod.yml build --no-cache
	docker-compose -f docker-compose.prod.yml up --remove-orphans

