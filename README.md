# Resumo do sistema

Visando em automatizar a vendas de uma lanchonete, esta aplicação consiste em um sistema de vendas de lanche em que o cliente visualiza os produtos a vendas no cardápio e em seguida os seleciona, bem como a quantidade deles, conforme os itens vão sendo adicionados vai sendo somado o subtotal dos itens, ao finalizar a compra, o cliente pode acompanhar o status do pedido até o momento de ser entregue.
_____________

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
            "nome": "zeca",
            "cpf": 25415454,
            "endereco": "fgjdigodijgfoij",
            "tel": 625151,
            "senha": "dfkjgkdfjg",
            "email": "djfdsjf"
    },
    "itens": [
        {
                "id": 1,
                "qtd": 2,
                "preco": 3.0,
                "lanche": {
                    "id": 1,
                    "nome": "Coxinha",
                    "desc": "sdkjlksjflkjsdjshf",
                    "precoUnit": 1.5
                }
        }
    ],
    "total": 3.00,
    "status": "Preparando"
}
```

