<h2>Projeto referente a disciplina de arquitetura de Software</h2>



<b>PRIMEIRA PARTE</b>


API para transações bancárias de contas correntes (depositar, sacar e extrato)
- O serviço deve saber quem é o cliente.
- O serviço deve conseguir gerenciar vários clientes.
API para processar pagamentos de boletos.
- O serviço deve consultar o saldo do cliente para realizar o pagamento.
         
<b>SEGUNDA PARTE</b>

- Continuar o desenvolvimento tomando como base o projeto da P1.
-  Adequar o projeto da P1 as novas funcionalidades apresentadas (Load Balancer, OpenFeign e API Gateway)
- Criar 2 Instâncias para cada microsserviço (Exceto, API Gateway e Service Discovery)
- Lembre-se de implementar o serviço API Gateway e Service Discovery, conforme apresentado nas aulas
- Criar mais um microsserviço para transferência de valores entre as contas dos clientes. Os atributos são conta destino, conta origem e valor. A transferência deve ser registrada no extrato da conta (implementado na P1)
          
