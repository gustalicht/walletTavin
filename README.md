# Wallet

## casos de uso

* criar usuario

* cadastrar cartoes

* inativar cartões

* autenticar usuario

* criar operação financeira p/ usuario
  * de entrada ou de saida
  

* consulta operações financeiras do usuario
  * por periodo
  * por tipo (entrada, saida)
  * por identificador

XXXXXXXXXXXXXXXXXXX

Funcionalidades e como testar

graceful shutdown
- suba aplicação normalmente
- busque o PID do processo (ou pegue no inicio dos logs de quando aplicação inicia)
  - ps aux | grep wallet
- encerre o processo com kill -TERM <pid>
A aplicação logará que iniciou o processo de graceful shutdown, aguardará 30s e finalmente logaraá novamente que a app será encerrada.
