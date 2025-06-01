Dockerfile
docker build -t springboot-app .

docker-compose
docker-compose up -d --build
docker-compose -f docker-compose.app.yml -f docker-compose.data.yml up -d --build
docker-compose -f docker-compose.app.yml -f docker-compose.data.yml logs kafka
docker-compose up -d

docker network ls
docker network inspect <network-name>

docker logs -f <container-name>

docker exec -it kafka kafka-topics.sh --bootstrap-server kafka:9092 --list
docker exec -it kafka kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic postgres_changes.public.users --from-beginning

docker exec -it springboot-app /bin/sh

curl --version
curl --fail --silent http://localhost:8080/actuator/health
docker ps -q -f health=unhealthy


curl -X POST -H "Content-Type: application/json" \
  --data '{
    "name": "my-postgres-connector",
    "config": {
        "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
        "tasks.max": "1",
        "database.hostname": "db",
        "database.port": "5432",
        "database.user": "postgres",
        "database.password": "postgres",
        "database.dbname": "userevents",
        "database.server.name": "debezium_server",
        "plugin.name": "pgoutput",
        "slot.name": "debezium_slot",
        "publication.name": "debezium_pub",
        "database.history.kafka.bootstrap.servers": "kafka:9092",
        "database.history.kafka.topic": "schema-changes.inventory",
        "topic.prefix": "postgres_changes"
        }
  }' http://localhost:8083/connectors


docker exec -it postgres-db psql -U postgres -d userevents -f /docker-entrypoint-initdb.d/init.sql

