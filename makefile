# Define default target
.PHONY: all
all: rebuild

run:
	gradle bootJar
	docker-compose down
	docker-compose build --no-cache
	docker-compose up


stop:
	gradle bootJar
	docker-compose down