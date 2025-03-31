include local.env
# Define default target
.PHONY: all
all: rebuild

dev_enviroment:
	docker-compose --env-file local.env up -d

rebuild_dev_enviroment:
	docker-compose down
	gradle clean
	gradle compileJava
	docker-compose --env-file local.env build --no-cache
	docker-compose --env-file local.env up  --remove-orphans -d

stop_dev_enviroment:
	docker-compose down

deploy_enviroment:
	docker-compose --env-file local.env  -f docker-compose.deploy.yml up --remove-orphans -d
	@echo "CMS Server: http://${API_DOMAIN}:${API_PORT}/swagger-ui/index.html"

rebuild_deploy_enviroment:
	docker-compose -f docker-compose.deploy.yml down
	gradle clean
	gradle compileJava
	gradle bootJar
	docker-compose down
	docker-compose --env-file local.env   -f docker-compose.deploy.yml build  --no-cache
	docker-compose --env-file local.env  -f docker-compose.deploy.yml up  --remove-orphans -d
	@echo "CMS Server: http://localhost:8080/swagger-ui/index.html"

stop_deploy_enviroment:
	docker-compose -f docker-compose.deploy.yml down

stop_all:
	docker-compose down
	docker-compose -f docker-compose.deploy.yml down
