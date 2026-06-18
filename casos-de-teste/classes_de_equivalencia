# Classe de Equivalência

## Modo conta assistida
US28 - Enquanto idoso, desejo ativar o modo de conta assistida para receber auxílio no gerenciamento da segurança e do controle financeiro da minha conta.

**Classes de Equivalência**

| **CONDIÇÃO DE ENTRADA**                                              | **CLASSE VÁLIDA**                                                                              | **CLASSE INVÁLIDA**                                       | **CLASSE INVÁLIDA**                                             |
| -------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- | ------------------------------------------------------- | ------------------------------------------------------------- |
| Usuário idoso acessa Configurações de Segurança                      | A aba "Ativação de Modo Assistido" é exibida corretamente (1)                                | A aba não é exibida nas configurações (2)               |                                                               |
| Usuário seleciona "Ativar Modo Assistido"                            | Sistema solicita confirmação de segurança (3)                                                | Sistema ativa o modo sem solicitar confirmação (4)      | Sistema apresenta erro e não solicita confirmação (5)         |
| Usuário escolhe autenticação por senha e informa credenciais válidas | Modo Assistido é ativado com sucesso (6)                                                     | Senha incorreta e ativação negada (7)                   |                                                               |
| Usuário escolhe autenticação por biometria válida                    | Modo Assistido é ativado com sucesso (8)                                                     | Biometria não reconhecida (9)                           | Dispositivo sem biometria cadastrada (10)                     |
| Usuário escolhe autenticação por biometria facial válida             | Modo Assistido é ativado com sucesso (11)                                                    | Biometria facial não reconhecida (12)                   | Câmera indisponível ou biometria facial não cadastrada (13)   |
| Usuário conclui ativação do modo assistido                           | Sistema solicita consentimento para compartilhamento de informações financeiras (14)         | Sistema não solicita consentimento (15)                 | Compartilhamento é realizado sem consentimento (16)           |
| Responsável vinculado à conta assistida                              | Responsável consegue visualizar informações autorizadas sem obter titularidade da conta (17) | Responsável consegue alterar titularidade da conta (18) | Responsável passa a ser registrado como titular da conta (19) |

**Casos de Teste**

| Classes de <br>Equivalencia | Entradas                                 | Resultado Esperado                                                                                  |
| --------------------------- | ---------------------------------------- | --------------------------------------------------------------------------------------------------- |
| 1,3,6,8,11,14,17            | Todas entradas válidas                   | Modo conta assistida é ativado com sucesso(Válido)                                                  |
| 1,4,6,8,11,14,17            | Selecionado a opção de modo assistido    | Modo conta assistida é ativa sem confirmação(Inválido)                                              |
| 1,5,6,8,11,14,17            | Selecionado a opção de modo assistido    | Modo conta assistida não é ativado por falta de confirmação(Inválido)                               |
| 1,3,7,8,11,14,17            | Senha                                    | Senha do usuário incorreta.(Inválido)                                                               |
| 1,3,6,9,11,141,17           | Biometria                                | Biometria não reconhecida(Inválido)                                                                 |
| 1,3,6,10,11,14,17           | Biometria                                | Biometria não cadastrada.(Inválido)                                                                 |
| 1,3,6,8,12,14,17            | Biometria Facial                         | Biometria facial não reconhecida(Inválido)                                                          |
| 1,3,6,8,13,14,17            | Biometria Facial                         | Biometria facial não cadastrada.(Inválido)                                                          |
| 1,3,6,8,11,15,17            | Resposta da solicitação de consentimento | Sistema não solicita consentimento de compartilhamento de dados, o modo c.a não é ativado(Inválido) |
| 1,3,6,8,11,16,17            | Resposta da solicitação de consentimento | Compartilhamento é feito sem solicitação(Inválido)                                                  |
| 1,3,6,8,11,16,18            | Responsavel vinculado                    | resposável consegue alterar titularidade(Inválido)                                                  |
| 1,3,6,8,11,16,19            | Responsavel vinculado                    | responsável é vinculado como titular da conta(Inválido)                                             |
