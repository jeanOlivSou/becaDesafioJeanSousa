# Resumo do sistema

Visando em automatizar a vendas de uma lanchonete, esta aplicação consiste em um sistema de vendas de lanche em que o cliente visualiza os produtos a vendas no cardápio e em seguida os seleciona, bem como a quantidade deles, conforme os itens vão sendo adicionados vai sendo somado o subtotal dos itens, ao finalizar a compra, o cliente pode acompanhar o status do pedido até o momento de ser entregue.
_____________

# Modelo conceitual

![classesJSnackbar.drawio.png](classesJSnackbar.drawio.png)

_____________

# Endpoints

 Requisições | Descrição
:---------: | :------------------: 
 POST >/cliente | Cadastra um cliente dentro do sistema
 POST >/lanche  | Cadastra um lanche dentro do sistema
 POST >/itempedido | Adciona um item de pedido ao pedido do cliente
 
