# Projeto: JSnackbar

## Autor: [Jean Sousa](https://github.com/jeanOlivSou/)     Mentor: [Lucas Guimarães](https://github.com/guimatech)


# Resumo do sistema

Visando em automatizar a vendas de uma lanchonete, esta aplicação consiste em um sistema de vendas de lanche em que o cliente visualiza os produtos a vendas no cardápio e em seguida os seleciona, bem como a quantidade deles, conforme os itens vão sendo adicionados vai sendo somado o subtotal dos itens, ao finalizar a compra, o cliente pode acompanhar o status do pedido até o momento de ser entregue.

<br/>

# Tecnologias Utilizadas

![spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white) ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)


# Modelo conceitual

![classesJSnackbar.drawio.png](classesJSnackbar.drawio.png)

_____________

# Endpoints

Para testes desta API é necessário uma aplicação cliente para enviar as requisições para os endpoints
como o [Postman](https://www.postman.com/)

 Requisições | Descrição
:--------- | :------------------
 POST `/cliente` | Cadastra um cliente dentro do sistema
 POST `/lanche` | Cadastra um lanche dentro do sistema
 POST `/itempedido` | Adciona um item de pedido ao pedido do cliente
 POST `/pedido` | Cdastra um pedido do cliente com o item de pedido
 GET `/cliente` | Retorna todos os clientes cadastrados
 GET `/cliente/{id}` | Retorna um cliente de um id específico
 GET `/lanche` | Retorna todos os lanches cadastrados
 GET `/lanche/{id}` | Retorna um lanche de id específico
 GET `/itempedido` | Retorna todos itens de pedido 
 GET `/itempedido/{id}` | Retorna um item de pedido de um id específico
 GET `/pedido` | Retorna todos os pedidos
 GET `/pedido{id}` | Retorna um pedido do id específico
 PATCH `/cliente/{id}`| Atualiza um cliente do id específico
 PATCH `/lanche/{id}` | Atualiza um lanche do id específico
 PATCH `/itempedido/{id}`  | Atualiza um item de pedido do id específico
 PATCH `/pedido/{id}` | Atualiza um pedido do id específico
 DELETE `/cliente/{id}`| Exclui um cliente do id específico
 DELETE `/lanche/{id}` | Exclui um lanche do id específico
 DELETE `/itempedido/{id}`  | Exclui um item de pedido do id específico
 DELETE `/pedido/{id}` | Exclui um pedido do id específico
<br/>

Exemplo de JSON para requisição POST `/pedido` :

```json 
{
    "id": 2,
    "dataPedido": "2022-01-24T16:07:55.958+00:00",
    "cliente": {
        "id": 1,
            "nome": "Zeca Da Silva",
            "cpf": "40265633087",
            "endereco": "Rua 3, apt. 101",
            "tel": "61994933278",
            "senha": "FH@43jkjo",
            "email": "zeca.silva@loremipsum.com"
    },
    "itens": [
        {
                "id": 1,
                "qtd": 2,
                "preco": 3.0,
                "lanche": {
                    "id": 1,
                    "nome": "Coxinha",
                    "desc": "Sabor: Frango com Catupiry",
                    "precoUnit": 1.5
                }
        }
    ],
    "total": 3.00,
    "status": "Preparando"
}
```

# Validações e Exceções tratadas

* Na Requisição de cadastrar um Cliente deve fornecer um CPF válido.
* No Campo nome do Cliente deve ser iniciar por uma letrar maiúsculas.
* Validações de campo vazio.
* O campo senha deve ter no 8 caracteres e no máximo 20.
* O campo email deve conter um email válido.
* A quantidade item de pedido deve ser no minimo um 1.
* Os valores de preço unitario do lanche, preço de itens e o total do pedido devem ser positivos.
* Na tentativa de consultar (GET) ou apagar(DELETE) um registro com id inexistente retorna uma resposta HTTP Erro 404.
* Ao mandar uma requisição via JSON com um JSON inválido retorna uma resposta HTTP Bad request 400 e informa que o JSON está com erro de sintaxe.
