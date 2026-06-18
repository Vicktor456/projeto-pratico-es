# Classe de Equivalência

## Privacidade de Saldo
US1 - Enquanto usuário idoso, quero que o meu saldo apareça oculto por padrão, para que eu possa abrir o aplicativo em locais públicos com privacidade

**Classes de Equivalência**

| Condições de Entrada              | Classes Válidas                           | Classes Inválidas                            | Classes Inválidas |
| --------------------------------- | ----------------------------------------- | -------------------------------------------- | ----------------- |
| Estado inicial ao abrir o app     | Saldo inicia oculto (1)                   | Saldo inicia visível (2)                     |                   |
| Interação com o botão "Ver Saldo" | Clique exibe o saldo textual (3)          | Clique mantém oculto ou quebra layout (4)    |                   |
| Ação de trocar de tela            | Saldo volta a ocultar automaticamente (5) | Saldo permanece exposto na nova tela (6)     |                   |
| Preferência no Perfil             | Estado é salvo nas configurações (7)      | Preferência é perdida ao deslogar/fechar (8) |                   |

**Casos de Teste**

| Casos de Teste | Classes de Equivalência | Entradas                                                                                 | Resultado Esperado                 |
| -------------- | ----------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------- |
| Caso 1         | 1, 3, 5, 7              | Abrir o app, clicar em "Ver saldo", alternar outra tela e verificar o perfil.            | Sucesso ( Saldo inicia oculto ***) |
| Caso 2         | 1, 3, 5, 7              | Inicializar o aplicativo pela primeira vez na tela principal.                            | Falha                              |
| Caso 3         | 1, 4, 5, 7              | Tocar no botão grande com a etiqueta "Ver Saldo".                                        | Falha                              |
| Caso 4         | 1, 3, 6, 7              | Revelar o saldo clicando no botão e, em seguida, tocar para ir à tela de Extrato.        | Falha                              |
| Caso 5         | 1, 3, 5, 8              | Definir a preferência de ocultar saldo, fazer o logout e fechar o aplicativo totalmente. | Falha                              |

## Acesso Biométrico
US2 - Enquanto usuário idoso, desejo autenticar meu processo por meio de biometria (digital ou reconhecimento facial), a fim de simplificar o processo de login e eliminar a necessidade de memorização de credenciais complexas.

**Classes de Equivalência**

| Condição de Entrada                | Classes Válidas                                              | Classes Inválidas                                                   | Classes Inválidas                                                    |
| ---------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------------- | -------------------------------------------------------------------- |
| Suporte de Hardware do Dispositivo | Dispositivo possui leitor biométrico ativo e configurado (1) | Dispositivo não possui leitor ou ele está desativado no sistema (2) | Dispositivo tem o leitor, mas o usuário negou a permissão no app (3) |
| Autenticação Biométrica            | Biometria reconhecida com sucesso (4)                        | Biometria não reconhecida (dedo incorreto/rosto não mapeado) (5)    | Usuário cancela a leitura no pop-up do sistema (6)                   |
| Quantidade de Tentativas           | Até 3 falhas seguidas na leitura (7)                         | Mais de 3 falhas seguidas na leitura (8)                            |                                                                      |
| Fluxo de Contingência              | Usuário clica para digitar a senha numérica após erro (9)    | Sistema trava ou não exibe alternativa de senha numérica (10)       |                                                                      |

**Casos de Teste**

| Casos de Teste | Classes de Equivalência | Entradas                                                                                                         | Resultado Esperado |
| -------------- | ----------------------- | ---------------------------------------------------------------------------------------------------------------- | ------------------ |
| Caso 1         | 1, 4, 7, 9              | Aparelho com leitor , biometria reconhecida, dentro do limite de tentativas  e fluxo de contingência operacional | Sucesso            |
| Caso 2         | 2, 4, 7, 9              | Aparelho sem leitor biométrico                                                                                   | Falha              |
| Caso 3         | 3, 4, 7, 9              | Aparelho tem leitor, mas usuário negou a permissão no app                                                        | Falha              |
| Caso 4         | 1, 5, 7, 9              | Usuário insere o dedo errado                                                                                     | Falha              |
| Caso 5         | 1, 6, 7, 9              | Usuário clica em "Cancelar" no pop-up nativo do sistema                                                          | Falha              |
| Caso 6         | 1, 4, 8, 9              | Usuário atinge mais de 3 falhas seguidas na leitura                                                              | Falha              |
| Caso 7         | 1, 4, 7, 10             | O sistema sofre um travamento interno na chamada da API de contingência                                          | Falha              |

## Limite de Transferência Diária
US3 - Enquanto usuário idoso, desejo estabelecer um limite diário transacional, a fim de mitigar riscos de fraudes financeiras e prevenir execução de operações com valores equivocados por erro operacional.

**Classes de Equivalência**

| Condição de Entrada               | Classes Válidas                                        | Classes Inválidas                                          | Classes Inválidas                                                                  |
| --------------------------------- | ------------------------------------------------------ | ---------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| Valor inserido para o novo limite | valor numérico maior que zero (1)                      | Valor igual a zero ou negativo (2)                         | Inserção de letras ou caracteres especiais (ex: 'abc' ou '@#$') (3)                |
| Tipo de alteração solicitada      | Redução do limite atual ou aumento de limite atual (4) | Nenhuma alteração (valor igual ao atual) (5)               |                                                                                    |
| Tempo de processamento (Aumento)  | Aguarda a janela de 24h a 48h (6)                      | Tentativa de usar o novo limite aumentado antes de 24h (7) | Sistema aprova o aumento antes de 24h (violando a regra de segurança do BACEN) (8) |
| Tempo de processamento (Redução)  | Aplicação do novo limite de forma imediata (9)         | Atraso ou retenção na aplicação da redução (10)            |                                                                                    |

**Casos de Teste**

| Casos de Teste | Classes de Equivalência | Entradas                                                                                                                    | Resultado Esperado |
| -------------- | ----------------------- | --------------------------------------------------------------------------------------------------------------------------- | ------------------ |
| Caso 1         | 1, 4, 6, 9              | Tudo válido                                                                                                                 | Sucesso            |
| Caso 2         | 2, 4, 6, 9              | No campo de ajuste, o usuário tenta digitar R$ 0,00 ou um valor negativo                                                    | Falha              |
| Caso 3         | 3, 4, 6, 9              | O usuário tenta digitar letras ou caracteres especiais (ex: "abc" ou "@#$")                                                 | Falha              |
| Caso 4         | 1, 5, 6, 9              | O limite atual do idoso é R$ 800 e ele digita exatamente R$ 800 no campo, tentando salvar nenhuma alteração                 | Falha              |
| Caso 5         | 1, 4, 7, 9              | Usuário pede aumento válido e, apenas 2 horas depois (antes da janela de 24h) , tenta fazer um Pix usando esse novo limite. | Falha              |
| Caso 6         | 1, 4, 8, 9              | Usuário solicita um aumento de limite válido e o sistema aprova e disponibiliza o valor imediatamente antes das 24h         | Falha              |
| Caso 7         | 1, 4, 6, 10             | O usuário solicita uma redução de limite válida, mas o sistema sofre um atraso ou retenção interna no processamento.        | Falha              |

## Utilização de Chaves PIX
US4 - Enquanto usuário idoso, desejo inserir chaves PIX manualmente através de um campo de digitação direto,
para realizar transferências a novos recebedores de forma independente, sem depender de contatos previamente salvos.

**Classes de Equivalência**

| Condição de Entrada        | Classes Válidas                                                | Classes Inválidas                                                                 | Classes Inválidas |
| -------------------------- | -------------------------------------------------------------- | --------------------------------------------------------------------------------- | ----------------- |
| Abertura do Teclado        | Teclado abre exclusivamente numérico para CPF ou Telefone      | Teclado abre alfanumérico (com letras) para CPF ou Telefone                       |                   |
| Formato de Chave: CPF      | CPF contendo exatamente 11 dígitos numéricos                   | CPF com menos de 11 dígitos, mais de 11 dígitos ou caracteres especiais inválidos |                   |
| Formato de Chave: Telefone | Telefone contendo o prefixo internacional +55, DDD e 9 dígitos | Telefone sem o prefixo internacional (+55) ou com número incompleto               |                   |
| Ação do Botão "Limpar"     | Clique limpa todo o campo e mantém o foco do teclado           | Clique falha em limpar, limpa parcialmente ou esconde o teclado                   |                   |

**Casos de Teste**

| Casos de Teste | Classes de Equivalência | Entradas                                                                                                                    | Resultado Esperado |
| -------------- | ----------------------- | --------------------------------------------------------------------------------------------------------------------------- | ------------------ |
| Caso 1         | 1, 4, 6, 9              | Tudo válido                                                                                                                 | Sucesso            |
| Caso 2         | 2, 4, 6, 9              | No campo de ajuste, o usuário tenta digitar R$ 0,00 ou um valor negativo                                                    | Falha              |
| Caso 3         | 3, 4, 6, 9              | O usuário tenta digitar letras ou caracteres especiais (ex: "abc" ou "@#$")                                                 | Falha              |
| Caso 4         | 1, 5, 6, 9              | O limite atual do idoso é R$ 800 e ele digita exatamente R$ 800 no campo, tentando salvar nenhuma alteração                 | Falha              |
| Caso 5         | 1, 4, 7, 9              | Usuário pede aumento válido e, apenas 2 horas depois (antes da janela de 24h) , tenta fazer um Pix usando esse novo limite. | Falha              |
| Caso 6         | 1, 4, 8, 9              | Usuário solicita um aumento de limite válido e o sistema aprova e disponibiliza o valor imediatamente antes das 24h         | Falha              |
| Caso 7         | 1, 4, 6, 10             | O usuário solicita uma redução de limite válida, mas o sistema sofre um atraso ou retenção interna no processamento.        | Falha              |

## Visualização de Comprovante Ampliada
US13 - Enquanto usuário idoso, desejo visualizar o comprovante final com uma fonte ampliada e nítida, para conseguir conferir as informações da transferência sem forçar a vista.

**Classes de Equivalência**

| **Condições de Entrada**         | **Classes Válidas**                         | **Classes Inválidas**                        | **Classes Inválidas** |
| -------------------------------- | ------------------------------------------- | -------------------------------------------- | --------------------- |
| Tamanho da fonte das informações | Tamanho $\ge$ 20px (1)                      | Tamanho $<$ 20px (2)                         |                       |
| Contraste entre texto e fundo    | Atende aos padrões de acessibilidade (3)    | Abaixo do padrão (ilegível) (4)              |                       |
| Ação do botão "Salvar PDF"       | PDF gerado mantém a formatação e escala (5) | PDF gerado quebra a formatação ou escala (6) |                       |
| Leitura da escala do dispositivo | Sistema identifica a escala ativa (7)       | Sistema ignora a escala do aparelho (8)      |                       |
| Comportamento do Layout          | Elementos adaptam-se sem cortar texto (9)   | Layout quebra ou oculta informações (10)     |                       |

## Exibição de Aviso de Risco de Fraude
US14 - Enquanto usuário idoso, desejo visualizar um aviso de risco claro e em destaque antes de confirmar um Pix suspeito, para que eu possa interromper a operação a tempo e evitar cair em um golpe.

**Classes de Equivalência**

| **Condições de Entrada**                  | **Classes Válidas**                               | **Classes Inválidas**                                      | **Classes Inválidas**           |
| ----------------------------------------- | ------------------------------------------------- | ---------------------------------------------------------- | ------------------------------- |
| **Nível de Risco da Chave de Destino**    | Risco Suspeito / Elevado (1)                      | Risco Normal / Seguro (2)                                  | Risco Crítico / Lista Preta (3) |
| **Interface do Pop-up de Alerta**         | Tela cheia, fundo amarelo e fonte $\ge$ 20pt (4)  | Layout quebrado, sem fundo de alerta ou fonte $<$ 20pt (5) |                                 |
| **Linguagem da Mensagem**                 | Linguagem humana e acolhedora (6)                 | Presença de termos técnicos ou códigos de erro (7)         |                                 |
| **Interação com "Quero Cancelar"**        | Transação é interrompida com segurança (8)        | Sistema falha e prossegue com a transação (9)              |                                 |
| **Interação com "Continuar assim mesmo"** | Ativa cronômetro regressivo de 5 segundos (10)    | Libera o campo de senha imediatamente sem pausa (11)       |                                 |
| **Tratamento de Risco Crítico**           | Bloqueio sumário e direcionamento ao suporte (12) | Permite que o usuário insira a senha e envie o Pix (13)    |                                 |

## Compartilhar Comprovantes por Canais de Comunicação
US15 - Enquanto usuário idoso, desejo compartilhar o comprovante de transferência através das opções do meu aparelho, para enviar o recibo pelo canal de comunicação que eu preferir.

**Classes de Equivalência**

| **Condições de Entrada**             | **Classes Válidas**                                             | **Classes Inválidas**                                          | **Classes Inválidas** |
| ------------------------------------ | --------------------------------------------------------------- | -------------------------------------------------------------- | --------------------- |
| **Interface do Botão**               | Botão visível com ícone padrão e texto "Enviar Comprovante" (1) | Botão sem texto descritivo, ícone incorreto ou oculto (2)      |                       |
| **Acionamento do Botão**             | Abre a gaveta nativa de compartilhamento do SO (3)              | Não executa ação ou gera erro de sistema (4)                   |                       |
| **Formato e Resolução do Arquivo**   | Arquivo gerado em Imagem/PDF de alta resolução e legível (5)    | Arquivo corrompido, em baixa resolução ou formato ilegível (6) |                       |
| **Destino do Compartilhamento**      | Integra com apps de mensagens/redes sociais instalados (7)      | Falha ao transferir o arquivo para o app selecionado (8)       |                       |
| **Leitura da Escala do Dispositivo** | Sistema identifica a escala ativa do aparelho (9)               | Sistema ignora a escala configurada no aparelho (10)           |                       |
| **Comportamento do Layout**          | Elementos do comprovante adaptam-se sem cortar texto (11)       | Layout quebra, sobrepõe ou oculta dados do recibo (12)         |                       |


## Extrato Simplificado
US16 - Enquanto usuário idoso, desejo ver uma lista das minhas ultimas transações com nomes amigáveis (apelidos), para entender facilmente onde gastei meu dinheiro.

**Classes de Equivalência**

| **Condições de Entrada**      | **Classes Válidas**                                         | **Classes Inválidas**                                   | **Classes Inválidas** |
| ----------------------------- | ----------------------------------------------------------- | ------------------------------------------------------- | --------------------- |
| **Exibição do Nome na Lista** | Exibe Apelido salvo ou Nome Fantasia em destaque (1)        | Exibe apenas a Razão Social complexa ou códigos (2)     |                       |
| **Toque na Movimentação**     | Abre a tela secundária com os detalhes completos (3)        | Não responde ao toque ou quebra a navegação (4)         |                       |
| **Visualização dos Detalhes** | Exibe todos os dados, incluindo a Razão Social original (5) | Oculta dados obrigatórios ou omite a Razão Social (6)   |                       |
| **Cruzamento de Dados**       | Identifica o vínculo com o CPF/CNPJ salvo com sucesso (7)   | Falha ao consultar ou processar o vínculo dos dados (8) |                       |
| **Prioridade de Exibição**    | Prioriza o Apelido sobre o Nome Fantasia/Razão Social (9)   | Exibe a Razão Social mesmo com Apelido cadastrado (10)  |                       |

## Geração de QR Code
US17 - Enquanto usuário idoso, desejo gerar um QR Code com o valor da venda ou cobrança, para que outra pessoa possa me pagar sem eu precisar falar minha chave.

**Classes de Equivalência**

| **Condições de Entrada**     | **Classes Válidas**                                                 | **Classes Inválidas**                                      | **Classes Inválidas** |
| ---------------------------- | ------------------------------------------------------------------- | ---------------------------------------------------------- | --------------------- |
| **Entrada do Valor**         | Campo com teclado numérico ativo e fonte grande (1)                 | Abre teclado alfabético ou fonte padrão pequena (2)        |                       |
| **Tipo de QR Code Gerado**   | QR Code dinâmico com valor embutido no payload (3)                  | QR Code estático ou sem valor especificado (4)             |                       |
| **Exibição do Código**       | Centralizado, ampliado e em alto contraste (5)                      | Código pequeno, descentralizado ou com baixo contraste (6) |                       |
| **Vínculo da Chave Pix**     | Associa os dados da chave Pix principal corretamente (7)            | Gera o código sem chave ou com chave incorreta (8)         |                       |
| **Ação de Copiar Código**    | Copia a string do Pix Copia e Cola para a área de transferência (9) | Botão não responde ou copia string corrompida (10)         |                       |
| **Confirmação de Pagamento** | Exibe alerta visual e emite sinal sonoro ao receber (11)            | Atualiza o saldo sem emitir aviso visual ou sonoro (12)    |                       |

## Botão de Ajuda por Voz/Vídeo
US18 - Enquanto usuário idoso, desejo ter um botão de "Ajuda" fácil de encontrar, para falar com um atendente humano caso eu fique confuso.

**Classes de Equivalência**

| **Condições de Entrada**    | **Classes Válidas**                                                   | **Classes Inválidas**                                            | **Classes Inválidas** |
| --------------------------- | --------------------------------------------------------------------- | ---------------------------------------------------------------- | --------------------- |
| **Interface do Botão**      | Botão visível, com ícone correto e texto "Falar com Atendente" (1)    | Botão oculto, sem texto descritivo ou ícone confuso (2)          |                       |
| **Opções de Canais**        | Exibe claramente os botões "Chamada de Voz" e "Chat por Mensagem" (3) | Omite um dos canais ou exibe opções não suportadas (4)           |                       |
| **Tempo de Espera**         | Exibe o tempo estimado de forma legível e atualizada (5)              | Tempo de espera oculto, estático ou com fontes ilegíveis (6)     |                       |
| **Horário de Atendimento**  | Horário do dispositivo entre 7h00 e 22h00 (7)                         | Horário do dispositivo entre 22h01 e 6h59 (Opcional Noturno) (8) |                       |
| **Ação em Horário Ativo**   | Libera o direcionamento para o atendente humano (9)                   | Bloqueia a chamada ou falha ao iniciar a conexão (10)            |                       |
| **Ação em Horário Inativo** | Bloqueia chamadas e exibe tela informativa de funcionamento (11)      | Permite tentar a chamada gerando erro de linha discada/muda (12) |                       |


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

## Níveis de Acesso
US31 - Enquanto idoso, desejo configurar diferentes níveis de acesso para meu responsável através de modos pré-definidos ou personalizados para equilibrar minha privacidade, autonomia e segurança financeira.

**Classes de Equivalência**

| **CONDIÇÃO DE ENTRADA**                         | **CASO VÁLIDO**                                                             | **CASO INVÁLIDO**                                    | **CASO INVÁLIDO**                                     |
| ----------------------------------------------- | --------------------------------------------------------------------------- | ---------------------------------------------------- | ----------------------------------------------------- |
| Usuário acessa o Modo Assistido                 | Funcionalidade de configuração de acesso é exibida (1)                      | Funcionalidade não é exibida (2)                     |                                                       |
| Usuário acessa configuração de acesso           | Sistema exibe Acesso Básico, Supervisionado, Dependente e Personalizado (3) | Uma ou mais opções não são exibidas (4)              |                                                       |
| Usuário altera o modo de acesso                 | Sistema permite alteração do modo a qualquer momento (5)                    | Sistema impede alteração sem justificativa (6)       |                                                       |
| Usuário altera o modo de acesso                 | Sistema solicita autenticação (7)                                           | Sistema altera o acesso sem autenticação (8)         | Sistema não solicita autenticação (9)                 |
| Usuário autentica por senha válida              | Alteração realizada com sucesso (10)                                        | Senha incorreta (11)                                 |                                                       |
| Usuário autentica por biometria válida          | Alteração realizada com sucesso (12)                                        | Biometria não reconhecida (13)                       | Biometria não cadastrada (14)                         |
| Usuário autentica por biometria facial válida   | Alteração realizada com sucesso (15)                                        | Biometria facial não reconhecida (16)                | Biometria facial não cadastrada ou indisponível (17)  |
| Primeiro responsável é adicionado               | Sistema define automaticamente o modo Acesso Básico (18)                    | Sistema define outro modo automaticamente (19)       |                                                       |
| Usuário seleciona modo Personalizado            | Sistema permite configurar permissões manualmente (20)                      | Sistema não permite configurar permissões (21)       |                                                       |
| Usuário visualiza permissões personalizadas     | Sistema exibe descrição clara de cada permissão (22)                        | Permissões sem descrição adequada (23)               |                                                       |
| Usuário altera modo ou permissões               | Idoso e responsável recebem notificação (24)                                | Notificação não enviada ao responsável (25)          | Notificação não enviada ao idoso (26)                 |
| Usuário confirma alteração                      | Sistema salva imediatamente as novas permissões (27)                        | Alterações não são salvas (28)                       |                                                       |
| Usuário está em modo Personalizado              | Sistema permite retornar para qualquer modo pré-definido (29)               | Sistema impede retorno aos modos pré-definidos (30)  |                                                       |
| Usuário tenta alterar permissões                | Alteração permitida apenas após autenticação válida (31)                    | Alteração realizada sem autenticação válida (32)     |                                                       |
| Usuário configura permissões do responsável     | Nenhuma permissão restrita é disponibilizada (33)                           | Sistema permite alterar senha, CPF ou biometria (34) | Sistema permite cadastro ou remoção de chave PIX (35) |
| Usuário altera modo, permissões ou autenticação | Sistema registra ação em log de auditoria (36)                              | Alteração não registrada em auditoria (37)           |                                                       |

**Casos de Teste**

| Classes de Equivalência                     | Entradas               | Resultado Esperado                                             |
| ------------------------------------------- | ---------------------- | -------------------------------------------------------------- |
| 1,3,5,7,10,12,15,18,20,22,24,27,29,31,33,36 | Todas entradas válidas | Configuração de acesso alterada com sucesso (Válido)           |
| 2,3,5,7,10,12,15,18,20,22,24,27,29,31,33,36 | Modo Assistido         | Funcionalidade de configuração não exibida (Inválido)          |
| 1,4,5,7,10,12,15,18,20,22,24,27,29,31,33,36 | Configuração de acesso | Opções de acesso incompletas (Inválido)                        |
| 1,3,6,7,10,12,15,18,20,22,24,27,29,31,33,36 | Alteração de modo      | Sistema impede alteração de acesso (Inválido)                  |
| 1,3,5,8,10,12,15,18,20,22,24,27,29,31,33,36 | Autenticação           | Alteração realizada sem autenticação (Inválido)                |
| 1,3,5,9,10,12,15,18,20,22,24,27,29,31,33,36 | Autenticação           | Sistema não solicita autenticação (Inválido)                   |
| 1,3,5,7,11,12,15,18,20,22,24,27,29,31,33,36 | Senha                  | Senha incorreta (Inválido)                                     |
| 1,3,5,7,10,13,15,18,20,22,24,27,29,31,33,36 | Biometria              | Biometria não reconhecida (Inválido)                           |
| 1,3,5,7,10,14,15,18,20,22,24,27,29,31,33,36 | Biometria              | Biometria não cadastrada (Inválido)                            |
| 1,3,5,7,10,12,16,18,20,22,24,27,29,31,33,36 | Biometria Facial       | Biometria facial não reconhecida (Inválido)                    |
| 1,3,5,7,10,12,17,18,20,22,24,27,29,31,33,36 | Biometria Facial       | Biometria facial não cadastrada (Inválido)                     |
| 1,3,5,7,10,12,15,19,20,22,24,27,29,31,33,36 | Primeiro responsável   | Sistema não define Acesso Básico automaticamente (Inválido)    |
| 1,3,5,7,10,12,15,18,21,22,24,27,29,31,33,36 | Modo Personalizado     | Não permite configuração manual (Inválido)                     |
| 1,3,5,7,10,12,15,18,20,23,24,27,29,31,33,36 | Permissões             | Descrição das permissões inadequada (Inválido)                 |
| 1,3,5,7,10,12,15,18,20,22,25,27,29,31,33,36 | Notificações           | Responsável não recebe notificação (Inválido)                  |
| 1,3,5,7,10,12,15,18,20,22,26,27,29,31,33,36 | Notificações           | Idoso não recebe notificação (Inválido)                        |
| 1,3,5,7,10,12,15,18,20,22,24,28,29,31,33,36 | Salvamento             | Permissões não são salvas (Inválido)                           |
| 1,3,5,7,10,12,15,18,20,22,24,27,30,31,33,36 | Retorno de modo        | Sistema impede retorno para modo pré-definido (Inválido)       |
| 1,3,5,7,10,12,15,18,20,22,24,27,29,32,33,36 | Segurança              | Alteração realizada sem autenticação válida (Inválido)         |
| 1,3,5,7,10,12,15,18,20,22,24,27,29,31,34,36 | Permissões restritas   | Responsável recebe acesso a CPF, senha ou biometria (Inválido) |
| 1,3,5,7,10,12,15,18,20,22,24,27,29,31,35,36 | Permissões restritas   | Responsável recebe acesso às chaves PIX (Inválido)             |
| 1,3,5,7,10,12,15,18,20,22,24,27,29,31,33,37 | Auditoria              | Alteração não registrada em log de auditoria (Inválido)        |


## Cadastro do Usuário Idoso no SeuPix
US32 - Enquanto idoso, desejo realizar meu cadastro no aplicativo SeuPix utilizando CPF, e-mail e número de telefone e definindo minha senha para criar minha conta bancária digital.

**Classes Equivalência**
| **CONDIÇÃO DE ENTRADA**                    | **CASO VÁLIDO**                                                                                  | **CASO INVÁLIDO**                                      | **CASO INVÁLIDO**                            |
| ------------------------------------------ | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------ | -------------------------------------------- |
| Usuário acessa a tela de cadastro          | Sistema solicita CPF, e-mail, telefone e senha (1)                                               | Um ou mais campos obrigatórios não são exibidos (2)    |                                              |
| Usuário informa CPF                        | CPF possui formato válido, dígitos verificadores corretos e não está cadastrado (3)              | CPF inválido (4)                                       | CPF já cadastrado (5)                        |
| Usuário informa e-mail                     | E-mail possui formato válido e não está cadastrado (6)                                           | Formato de e-mail inválido (7)                         | E-mail já cadastrado (8)                     |
| Usuário informa telefone                   | Telefone possui formato válido e não está cadastrado (9)                                         | Formato de telefone inválido (10)                      | Telefone já cadastrado (11)                  |
| Usuário define e confirma senha            | Senhas coincidem e atendem aos requisitos mínimos (12)                                           | Senhas diferentes (13)                                 | Senha não atende aos requisitos mínimos (14) |
| Usuário deixa campos obrigatórios vazios   | Sistema exibe mensagem clara orientando o preenchimento (15)                                     | Sistema permite prosseguir com campos vazios (16)      |                                              |
| Usuário informa dados inválidos            | Sistema exibe mensagem clara e simplificada (17)                                                 | Sistema não exibe mensagem de erro (18)                |                                              |
| Usuário conclui cadastro com dados válidos | Conta é criada e dados armazenados (19)                                                          | Conta não é criada mesmo com dados válidos (20)        |                                              |
| Usuário visualiza campo senha              | Caracteres digitados permanecem ocultos (21)                                                     | Senha exibida em texto visível (22)                    |                                              |
| Usuário realiza cadastro                   | Sistema solicita consentimento LGPD (23)                                                         | Sistema não solicita consentimento (24)                |                                              |
| Usuário conclui cadastro                   | Senha é armazenada de forma segura (25)                                                          | Senha armazenada em texto puro (26)                    |                                              |
| Usuário conclui cadastro                   | Dados são armazenados de forma segura (27)                                                       | Dados armazenados sem proteção adequada (28)           |                                              |
| Usuário utiliza recursos de acessibilidade | Interface possui contraste adequado, linguagem simples e compatibilidade com leitor de tela (29) | Interface não atende requisitos de acessibilidade (30) |                                              |

**Casos de Teste**
| Classes de Equivalência             | Entradas               | Resultado Esperado                                           |
| ----------------------------------- | ---------------------- | ------------------------------------------------------------ |
| 1,3,6,9,12,15,17,19,21,23,25,27,29  | Todas entradas válidas | Cadastro realizado com sucesso (Válido)                      |
| 2,3,6,9,12,15,17,19,21,23,25,27,29  | Tela de cadastro       | Campos obrigatórios não exibidos (Inválido)                  |
| 1,4,6,9,12,15,17,19,21,23,25,27,29  | CPF                    | CPF inválido (Inválido)                                      |
| 1,5,6,9,12,15,17,19,21,23,25,27,29  | CPF                    | CPF já cadastrado (Inválido)                                 |
| 1,3,7,9,12,15,17,19,21,23,25,27,29  | E-mail                 | E-mail inválido (Inválido)                                   |
| 1,3,8,9,12,15,17,19,21,23,25,27,29  | E-mail                 | E-mail já cadastrado (Inválido)                              |
| 1,3,6,10,12,15,17,19,21,23,25,27,29 | Telefone               | Telefone inválido (Inválido)                                 |
| 1,3,6,11,12,15,17,19,21,23,25,27,29 | Telefone               | Telefone já cadastrado (Inválido)                            |
| 1,3,6,9,13,15,17,19,21,23,25,27,29  | Senha                  | Confirmação de senha diferente (Inválido)                    |
| 1,3,6,9,14,15,17,19,21,23,25,27,29  | Senha                  | Senha não atende aos requisitos mínimos (Inválido)           |
| 1,3,6,9,12,16,17,19,21,23,25,27,29  | Campos obrigatórios    | Sistema permite cadastro com campos vazios (Inválido)        |
| 1,3,6,9,12,15,18,19,21,23,25,27,29  | Mensagens de erro      | Sistema não exibe mensagem de erro (Inválido)                |
| 1,3,6,9,12,15,17,20,21,23,25,27,29  | Criação de conta       | Conta não é criada mesmo com dados válidos (Inválido)        |
| 1,3,6,9,12,15,17,19,22,23,25,27,29  | Campo senha            | Senha exibida em texto visível (Inválido)                    |
| 1,3,6,9,12,15,17,19,21,24,25,27,29  | LGPD                   | Consentimento não solicitado (Inválido)                      |
| 1,3,6,9,12,15,17,19,21,23,26,27,29  | Segurança da senha     | Senha armazenada em texto puro (Inválido)                    |
| 1,3,6,9,12,15,17,19,21,23,25,28,29  | Segurança dos dados    | Dados armazenados sem proteção adequada (Inválido)           |
| 1,3,6,9,12,15,17,19,21,23,25,27,30  | Acessibilidade         | Interface não atende requisitos de acessibilidade (Inválido) |

## Login do Usuário Idoso no SeuPix
US33 - Enquanto idoso, desejo realizar login no aplicativo SeuPix utilizando meu método de acesso preferido (CPF, e-mail ou número de telefone) e minha senha para acessar minha conta bancária.

**Classes de Equivalência**

| **CONDIÇÃO DE ENTRADA**                        | **CASO VÁLIDO**                                                        | **CASO INVÁLIDO**                                       | **CASO INVÁLIDO**                  |
| ---------------------------------------------- | ---------------------------------------------------------------------- | ------------------------------------------------------- | ---------------------------------- |
| Usuário acessa a tela de login                 | Sistema permite autenticação por CPF, e-mail ou telefone (1)           | Uma ou mais formas de autenticação não são exibidas (2) |                                    |
| Usuário informa CPF, e-mail ou telefone        | Credencial corresponde a uma conta existente (3)                       | Credencial não cadastrada (4)                           | Credencial em formato inválido (5) |
| Usuário informa senha                          | Senha corresponde à conta informada (6)                                | Senha incorreta (7)                                     |                                    |
| Usuário realiza login com credenciais válidas  | Sistema concede acesso à conta (8)                                     | Sistema nega acesso com credenciais válidas (9)         |                                    |
| Usuário realiza login com dados inválidos      | Sistema exibe mensagem clara e simplificada (10)                       | Sistema não exibe mensagem de erro (11)                 |                                    |
| Usuário visualiza campo senha                  | Caracteres permanecem ocultos durante a digitação (12)                 | Senha exibida em texto visível (13)                     |                                    |
| Usuário utiliza interface de login             | Interface atende requisitos de acessibilidade (14)                     | Interface não atende requisitos de acessibilidade (15)  |                                    |
| Usuário autenticado acessa a conta             | Sessão permanece ativa até logout ou expiração (16)                    | Sessão é encerrada indevidamente (17)                   |                                    |
| Usuário seleciona logout                       | Sessão é encerrada imediatamente (18)                                  | Sessão permanece ativa após logout (19)                 |                                    |
| Usuário realiza múltiplas tentativas inválidas | Sistema aplica bloqueio temporário conforme política de segurança (20) | Sistema não aplica bloqueio quando necessário (21)      |                                    |
| Usuário realiza autenticação                   | Dados de autenticação são tratados conforme LGPD (22)                  | Tratamento dos dados em desacordo com LGPD (23)         |                                    |
| Usuário realiza login ou logout                | Evento é registrado em log de auditoria (24)                           | Evento não é registrado em auditoria (25)               |                                    |
| Usuário possui senha cadastrada                | Senha armazenada de forma segura (26)                                  | Senha armazenada em texto puro (27)                     |                                    |
| Usuário possui sessão autenticada              | Sessão protegida contra acessos não autorizados (28)                   | Sessão sem mecanismos adequados de proteção (29)        |                                    |

**Casos de Teste**

| Classes de Equivalência               | Entradas               | Resultado Esperado                                                         |
| ------------------------------------- | ---------------------- | -------------------------------------------------------------------------- |
| 1,3,6,8,10,12,14,16,18,20,22,24,26,28 | Todas entradas válidas | Login realizado com sucesso e sessão autenticada (Válido)                  |
| 2,3,6,8,10,12,14,16,18,20,22,24,26,28 | Tela de login          | Método de autenticação não disponível (Inválido)                           |
| 1,4,6,8,10,12,14,16,18,20,22,24,26,28 | CPF/E-mail/Telefone    | Credencial não cadastrada (Inválido)                                       |
| 1,5,6,8,10,12,14,16,18,20,22,24,26,28 | CPF/E-mail/Telefone    | Formato da credencial inválido (Inválido)                                  |
| 1,3,7,8,10,12,14,16,18,20,22,24,26,28 | Senha                  | Senha incorreta (Inválido)                                                 |
| 1,3,6,9,10,12,14,16,18,20,22,24,26,28 | Autenticação           | Sistema nega acesso mesmo com credenciais válidas (Inválido)               |
| 1,3,6,8,11,12,14,16,18,20,22,24,26,28 | Mensagens de erro      | Sistema não exibe mensagem de autenticação (Inválido)                      |
| 1,3,6,8,10,13,14,16,18,20,22,24,26,28 | Campo senha            | Senha exibida em texto visível (Inválido)                                  |
| 1,3,6,8,10,12,15,16,18,20,22,24,26,28 | Acessibilidade         | Interface não atende requisitos de acessibilidade (Inválido)               |
| 1,3,6,8,10,12,14,17,18,20,22,24,26,28 | Sessão autenticada     | Sessão encerrada indevidamente (Inválido)                                  |
| 1,3,6,8,10,12,14,16,19,20,22,24,26,28 | Logout                 | Sessão permanece ativa após logout (Inválido)                              |
| 1,3,6,8,10,12,14,16,18,21,22,24,26,28 | Segurança              | Sistema não aplica bloqueio após múltiplas tentativas inválidas (Inválido) |
| 1,3,6,8,10,12,14,16,18,20,23,24,26,28 | LGPD                   | Dados tratados em desacordo com LGPD (Inválido)                            |
| 1,3,6,8,10,12,14,16,18,20,22,25,26,28 | Auditoria              | Login/logout não registrado em auditoria (Inválido)                        |
| 1,3,6,8,10,12,14,16,18,20,22,24,27,28 | Armazenamento de senha | Senha armazenada em texto puro (Inválido)                                  |
| 1,3,6,8,10,12,14,16,18,20,22,24,26,29 | Proteção da sessão     | Sessão vulnerável a acesso não autorizado (Inválido)                       |
