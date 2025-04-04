include local.env
# Define default target
.PHONY: all
all: rebuild

dev_enviroment:
	docker-compose --env-file local.env up -d

stop_dev_enviroment:
	docker-compose down

clean_compile:
	gradle clean
	gradle compileJava

rebuild_dev_enviroment:
	make stop_dev_enviroment
	make clean_compile
	docker-compose --env-file local.env build --no-cache
	docker-compose --env-file local.env up  --remove-orphans -d

deploy_enviroment:
	docker-compose --env-file local.env  -f docker-compose.deploy.yml up --remove-orphans -d
	@echo "CMS Server: http://${API_ADDRESS}:${API_PORT}/swagger-ui/index.html"

stop_deploy_enviroment:
	docker-compose -f docker-compose.deploy.yml down

buildJar:
	make clean_compile
	gradle bootJar

rebuild_deploy_enviroment:
	make stop_deploy_enviroment
	make buildJar
	docker-compose --env-file local.env   -f docker-compose.deploy.yml build  --no-cache
	docker-compose --env-file local.env  -f docker-compose.deploy.yml up  --remove-orphans -d
	@echo "CMS Server: http://${API_ADDRESS}:${API_PORT}/swagger-ui/index.html"

stop_all:
	make stop_dev_enviroment
	make stop_deploy_enviroment

sql_dump:
	make stop_all
	make rebuild_deploy_enviroment
	docker-compose -f docker-compose.deploy.yml exec mysql-prod mysqldump -uroot -p${MYSQL_ROOT_PASSWORD} ${MYSQL_DATABASE} --complete-insert --add-drop-table --skip-lock-tables --ignore-table=${MYSQL_DATABASE}.admin > .docker/dump/database-insert.sql
	make stop_all