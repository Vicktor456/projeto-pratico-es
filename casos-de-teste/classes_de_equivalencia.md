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

## Vinculação de um Contato de Apoio
US29 - Enquanto idoso, desejo adicionar um responsável à minha conta assistida para receber suporte no gerenciamento da segurança e das atividades financeiras da minha conta.

**Classes de Equivalência**

| **CONDIÇÃO DE ENTRADA**                                        | **CASO VÁLIDO**                                                  | **CASO INVÁLIDO**                                                     | **CASO INVÁLIDO**                       |
| -------------------------------------------------------------- | ---------------------------------------------------------------- | --------------------------------------------------------------------- | --------------------------------------- |
| Usuário seleciona a opção "Adicionar Responsável"              | Sistema exibe Link Temporário, QR Code e Código Alfanumérico (1) | Sistema não exibe as três opções de vinculação (2)                    |                                         |
| Usuário seleciona geração de Link Temporário                   | Sistema gera link válido para compartilhamento (3)               | Link não é gerado (4)                                                 |                                         |
| Responsável utiliza o Link Temporário                          | Vinculação realizada dentro do prazo de 15 minutos (5)           | Link expirado após 15 minutos (6)                                     |                                         |
| Usuário seleciona geração de QR Code                           | Sistema gera QR Code válido (7)                                  | QR Code não é gerado (8)                                              |                                         |
| Usuário seleciona geração de Código Alfanumérico               | Sistema gera código válido de 6 caracteres alfanuméricos (9)     | Código possui menos ou mais de 6 caracteres (10)                      | Código contém caracteres inválidos (11) |
| Responsável realiza processo de vinculação                     | Responsável possui cadastro ativo e autenticado (12)             | Responsável não possui cadastro ativo (13)                            | Responsável não está autenticado (14)   |
| Responsável é vinculado enquanto o idoso está fora do APP      | Sistema envia notificação push de confirmação (15)               | Notificação push não é enviada (16)                                   |                                         |
| Responsável é vinculado enquanto o idoso está utilizando o APP | Sistema exibe pop-up de confirmação (17)                         | Pop-up não é exibido (18)                                             |                                         |
| Responsável vinculado com sucesso                              | Nome completo e CPF são exibidos na aba Modo Assistido (19)      | Nome não é exibido (20)                                               | CPF não é exibido (21)                  |
| Conta sem responsável vinculado                                | Primeiro responsável é vinculado com sucesso (22)                | Tentativa de adicionar segundo responsável (23)                       |                                         |
| Responsável recém-vinculado                                    | Sistema concede permissões mínimas iniciais (24)                 | Sistema concede permissões superiores às mínimas automaticamente (25) |                                         |

**Casos de Teste**

| Classes de Equivalência      | Entradas                          | Resultado Esperado                                               |
| ---------------------------- | --------------------------------- | ---------------------------------------------------------------- |
| 1,3,5,7,9,12,15,17,19,22,24  | Todas entradas válidas            | Responsável vinculado com sucesso (Válido)                       |
| 2,3,5,7,9,12,15,17,19,22,24  | Adicionar responsável             | Sistema não apresenta as formas de vinculação (Inválido)         |
| 1,4,5,7,9,12,15,17,19,22,24  | Link temporário                   | Link não é gerado (Inválido)                                     |
| 1,3,6,7,9,12,15,17,19,22,24  | Link temporário                   | Link expirado após 15 minutos (Inválido)                         |
| 1,3,5,8,9,12,15,17,19,22,24  | QR Code                           | QR Code não é gerado (Inválido)                                  |
| 1,3,5,7,10,12,15,17,19,22,24 | Código alfanumérico               | Código possui quantidade inválida de caracteres (Inválido)       |
| 1,3,5,7,11,12,15,17,19,22,24 | Código alfanumérico               | Código contém caracteres inválidos (Inválido)                    |
| 1,3,5,7,9,13,15,17,19,22,24  | Responsável                       | Responsável não possui cadastro ativo (Inválido)                 |
| 1,3,5,7,9,14,15,17,19,22,24  | Responsável                       | Responsável não autenticado (Inválido)                           |
| 1,3,5,7,9,12,16,17,19,22,24  | Notificação Push                  | Notificação não enviada ao idoso (Inválido)                      |
| 1,3,5,7,9,12,15,18,19,22,24  | Pop-up de confirmação             | Pop-up não exibido ao idoso (Inválido)                           |
| 1,3,5,7,9,12,15,17,20,22,24  | Exibição dos dados do responsável | Nome completo não é exibido (Inválido)                           |
| 1,3,5,7,9,12,15,17,21,22,24  | Exibição dos dados do responsável | CPF não é exibido (Inválido)                                     |
| 1,3,5,7,9,12,15,17,19,23,24  | Responsável vinculado             | Sistema permite adicionar um segundo responsável (Inválido)      |
| 1,3,5,7,9,12,15,17,19,22,25  | Permissões do responsável         | Sistema concede permissões acima das mínimas iniciais (Inválido) |

## Remoção de um Contato de Apoio
US30 - Enquanto idoso, desejo remover um responsável vinculado à minha conta para manter controle sobre quem possui acesso assistido à minha conta.

**Classes de Equivalência**

| **CONDIÇÃO DE ENTRADA**                                              | **CASO VÁLIDO**                                                      | **CASO INVÁLIDO**                                          | **CASO INVÁLIDO**                                           |
| -------------------------------------------------------------------- | -------------------------------------------------------------------- | ---------------------------------------------------------- | ----------------------------------------------------------- |
| Usuário seleciona a opção "Remover Responsável"                      | Sistema permite iniciar o processo de remoção a qualquer momento (1) | Sistema não permite iniciar a remoção (2)                  |                                                             |
| Usuário solicita a remoção do responsável                            | Sistema solicita confirmação de segurança (3)                        | Sistema remove o responsável sem solicitar confirmação (4) | Sistema apresenta erro e não solicita confirmação (5)       |
| Usuário escolhe autenticação por senha e informa credenciais válidas | Responsável é removido com sucesso (6)                               | Senha incorreta e remoção negada (7)                       |                                                             |
| Usuário escolhe autenticação por biometria válida                    | Responsável é removido com sucesso (8)                               | Biometria não reconhecida (9)                              | Dispositivo sem biometria cadastrada (10)                   |
| Usuário escolhe autenticação por biometria facial válida             | Responsável é removido com sucesso (11)                              | Biometria facial não reconhecida (12)                      | Biometria facial não cadastrada ou câmera indisponível (13) |
| Responsável removido com sucesso                                     | Todas as permissões do responsável são revogadas imediatamente (14)  | Permissões permanecem ativas após remoção (15)             |                                                             |
| Responsável removido com sucesso                                     | Sistema registra a remoção nos logs de auditoria (16)                | Remoção não é registrada nos logs (17)                     |                                                             |

**Casos de Teste**

| Classes de Equivalência | Entradas                | Resultado Esperado                                                                     |
| ----------------------- | ----------------------- | -------------------------------------------------------------------------------------- |
| 1,3,6,8,11,14,16        | Todas entradas válidas  | Responsável removido com sucesso, permissões revogadas e auditoria registrada (Válido) |
| 2,3,6,8,11,14,16        | Remoção de responsável  | Sistema não permite iniciar a remoção (Inválido)                                       |
| 1,4,6,8,11,14,16        | Solicitação de remoção  | Responsável removido sem confirmação de segurança (Inválido)                           |
| 1,5,6,8,11,14,16        | Solicitação de remoção  | Sistema não solicita confirmação de segurança (Inválido)                               |
| 1,3,7,8,11,14,16        | Senha                   | Senha incorreta e remoção negada (Inválido)                                            |
| 1,3,6,9,11,14,16        | Biometria               | Biometria não reconhecida (Inválido)                                                   |
| 1,3,6,10,11,14,16       | Biometria               | Biometria não cadastrada (Inválido)                                                    |
| 1,3,6,8,12,14,16        | Biometria Facial        | Biometria facial não reconhecida (Inválido)                                            |
| 1,3,6,8,13,14,16        | Biometria Facial        | Biometria facial não cadastrada ou câmera indisponível (Inválido)                      |
| 1,3,6,8,11,15,16        | Revogação de permissões | Permissões do responsável permanecem ativas após remoção (Inválido)                    |
| 1,3,6,8,11,14,17        | Auditoria               | Remoção não registrada nos logs de auditoria (Inválido)                                |
