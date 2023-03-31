# Delivery REST API 

Delivery REST API  1.0.0<br>
Spring boot REST API for delivery.

O objetivo principal da API é fornecer aos clientes uma maneira fácil e conveniente de realizar pedidos de comida, tornando todo o processo de entrega mais rápido e eficiente. A API é documentada com o uso do Swagger, permitindo uma fácil compreensão dos endpoints e das informações necessárias para interagir com o sistema.

___
## Endpoints disponíveis


**Client Controller**

O Client Controller permite acessar informações relacionadas aos clientes cadastrados no sistema.

GET /client (Find all clients): retorna uma lista de todos os clientes cadastrados no sistema

GET /clients/{clientId} (Find Client By Id): retorna as informações do cliente com o ID especificado

POST /client (Create Client): adiciona um novo cliente

PUT /clients/{clientId} (Update Client): atualiza as informações do cliente com o ID especificado

DELETE /clients/{clientId} (Delete Client): exclui o cliente com o ID especificado

**Delivery Controller:**

O Delivery Controller permite acessar informações relacionadas aos pedidos de delivery.

GET /delivery (deliveryList): retorna uma lista de todos os pedidos de delivery registrados no sistema.

GET /delivery/{deliveryId} (findById): retorna as informações do pedido de delivery com o ID especificado
.
POST /delivery (request): adiciona um novo pedido de delivery ao sistema.

PUT /deliveries/{deliveryId}/finalization: atualiza as informações do pedido de delivery com o ID especificado.

**Occurrence Controller:**

O Occurrence Controller permite acessar informações relacionadas às ocorrências de entrega.

GET /delivery/{deliveryId}/occurrences: retorna as informações da ocorrência de entrega com o ID especificado.

POST /delivery/{deliveryId}/occurrences: adiciona uma nova ocorrência de entrega ao sistema.
