# projetos-web-api-rest


Para executar a aplicação
# Certifique-se de ter o Spring Tool Suite instalado.
# Certifique-se de ter o lombok configurado. segue um link para demostração: https://www.youtube.com/watch?v=W0ywxkvc4_M
# Certifique-se de ter o Postman instalado.

git clone https://github.com/Carlosjrw/projetos-web-api-rest

# Importe o projeto no STS
No STS aberto, importe o projeto como projeto Maven, File --> Import --> Maven --> Projeto Maven Existente -->

#ENDPOINTS: 

Inicie adicionando um usuario no banco:
{
	"nome": "Carlos castro Junior",
	"email": "carloscastrojr@gmail.com",
	"telefone": "92 99999-0001"
}

POST http://localhost:8080/pessoas [cadastra uma nova pessoa]

GET http://localhost:8080/pessoas [lista todas as pessoas]

GET http://localhost:8080/pessoas/{id} [lista um pessoa por ID]

PUT http://localhost:8080/pessoas/{id} [atualiza os dados de um pessoa]

DELETE http://localhost:8080/pessoas/{id} [remove um pessoa por ID]
