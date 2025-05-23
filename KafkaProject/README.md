# Project-Kafka

Este sistema é composto por dois projetos desenvolvidos com Spring Boot e integrados ao Apache Kafka:

1- Producer (Produtor): expõe uma API REST que recebe dados via requisições HTTP e os publica em um tópico Kafka específico. Ele atua como ponto de entrada das informações no ecossistema de mensageria.

2- Consumer (Consumidor): permanece escutando continuamente o tópico Kafka. Sempre que uma nova mensagem é recebida, ela é processada e persistida em um banco de dados MySQL.

Essa arquitetura permite o desacoplamento entre o recebimento de dados e seu processamento, tornando o sistema mais escalável, assíncrono e resiliente.
