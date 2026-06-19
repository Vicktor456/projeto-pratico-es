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

---

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

---

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

---

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

---

## Canais de Comunicação
US8 - Enquanto especialista de suporte, desejo canais de comunicação estáveis e interfaces simplificadas para guiar usuários com necessidades de acessibilidade com clareza

**Classes de Equivalência**

| Condições de Entrada         | classes válidas                                                                          | classes inválidas                                                                                                                      | classes inválidas |
| ---------------------------- | ---------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- | ----------------- |
| canal de comunicação estável | especialista visualiza a tela do usuário(1)                                              | não há tela disponível para o especialista em suporte visualizar(2)                                                                    |                   |
| permissão do usuário         | usuário faz a validação da permissão para acesso do especialista(3)                      | especialista em suporte não tem acesso concedido por parte do usuário (4)                                                              |                   |
| função de ajuda              | a interface contém o "botão de ajuda" para inicio de chamada ou chat (5)                 | o botão de ajuda não está disponível para ajudar o usuário, seja por bug ou outro motivo, portanto o chat/chamada não é iniciado(6)    |                   |
| feedback                     | o suporte acessa o painel de controle visualizando a ultima ação com falha do usuário(7) | não foi possível identificar por que  a ultima ação do usuário falhou, por bug, atraso na transmissão ou outros problemas técnicos.(8) |                   |
| censura de dados sensíveis   | campos com dados sensíveis são mascarados automaticamente para o suporte(9)              | não há censura de informações sensíveis na tela compartilhada para o suporte(10)                                                       |                   |

**Casos de Teste**

| Classes de Equivalência | Entradas                     | Resultado Esperado                                                                        |
| :---------------------- | :--------------------------- | :---------------------------------------------------------------------------------------- |
| 1,3,5,7,9               | todas entradas válidas       | suporte assistido inicia com sucesso, exibe as falhas e oculta os dados sensíveis(válido) |
| 2,3,5,7,9               | canal de comunicação estável | não há tela disponível para o especialista em suporte visualizar(inválido)                |
| 1,4,5,7,9               | permissão do usuário         | especialista em suporte não tem acesso concedido por parte do usuário(inválido)           |
| 1,3,6,7,9               | função de ajuda              | obotão de ajuda não está disponível e o chat/chamada não é iniciado(inválido)             |
| 1,3,5,8,9               | feedback                     | não é possível identificar por que a última ação do usuário falhou(inválido)              |
| 1,3,5,7,10              | censura de dados sensíveis   | não  há censura de informações sensíveis na tela compartilhada(inválido)                  |

---

## Controle de Funções Essenciais
US9 - Enquanto suporte, desejo um sistema com menus enxutos e funções essenciais para realização de ações fundamentais como geração de extratos.

**Classes de Equivalência**

| Condições de Entrada             | Classes válidas                                                                                                      | Classes inválidas                                                                            | Classes Inválidas |
| :------------------------------- | :------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------- | ----------------- |
| período do extrato               | seleção de filtros rápidos de 7, 15 ou 30 dias(1)                                                                    | período customizado inválido ou fora dos filtros rápidos(2)                                  |                   |
| formato de download              | exportação em formato PDF estruturado para leitores de tela ou CSV com UTF-8(3)                                      | exportação em formatos não confirmados (ex: XLS, TXT)(4)                                     |                   |
| busca de registros               | uso do campo de busca no topo para localização direta(5)                                                             | navegação profunda através de submenus sem uso da busca(6)                                   |                   |
| segurança na exportação          | usuário realiza a reautenticação via MFA com sucesso(7)                                                              | usuário falha ou cancela a reautenticação via MFA(8)                                         |                   |
| volume de registros (síncrono)   | solicitação de exportação com até 10.000 registros(9)                                                                | solicitação de exportação síncrona acima de 10.000 registros(10)                             |                   |
| volume de registros (assíncrono) | processamento em segundo plano entre 10.001 e 50.000 registros com envio de link por e-mail e notificação in-app(11) | tentativa de processamento assíncrono acima de 50.000 registros sem aprovação(12)            |                   |
| aprovação de grande volume       | exportação acima de 50.000 registros aprovada por um segundo suporte(13)                                             | exportação acima de 50.000 registros bloqueada por falta de aprovação do segundo suporte(14) |                   |
| limite diário de grandes volumes | suporte realiza até 5 exportações de grandes volumes no dia(15)                                                      | suporte tenta realizar a 6ª exportação de grande volume no mesmo dia(16)                     |                   |

**Casos de Teste**

| Classes de equivalência | Entradas                         | Resultado Esperado                                                                                |
| :---------------------- | :------------------------------- | :------------------------------------------------------------------------------------------------ |
| 1,3,5,7,9,11,13,15      | todas entradas válidas           | geração e exportação do extrato realizado com sucesso (válido)                                    |
| 2,3,5,7,9,11,13,15      | período do extrato               | período customizado inválido ou fora dos filtros rápidos(inválido)                                |
| 1,4,5,7,9,11,13,15      | formato do download              | exportação em formatos não confirmados (ex: XLS, TXT)(inválido)                                   |
| 1,3,6,7,9,11,13,15      | busca de registros               | navegação profunda através de submenus sem uso da busca(inválido)                                 |
| 1,3,5,8,9,11,13,15      | segurança na exportação          | usuário falha ou cancela a reautenticação via MFA(Inválido)                                       |
| 1,3,5,7,10,11,13,15     | volume de registros (síncrono)   | solicitação de exportação síncrona acima de 10.000 registros(Inválido)                            |
| 1,3,5,7,9,12,13,15      | volume de registros (assíncrono) | tentativa de processamento assíncrono acima de 50.000 registros sem aprovação(Inválido)           |
| 1,3,5,7,9,11,14,15      | aprovação de grande volume       | exportação acima de 50.000 registros bloqueada por falta de aprovação do segundo suporte(invlido) |
| 1,3,5,7,9,11,13,16      | limite diário de grandes volumes | suporte tenta realizar a 6ª exportação de grande volume no mesmo dia(inválido)                    |

---

## Acessibilidade Visual na Interface
US10 - Enquanto contato de apoio, desejo uma interface com fontes legíveis para garantir a acessibilidade de usuários com baixa visão.

**Classes de Equivalência**

| Condições de Entrada              | classes válidas                                                                          | classes inválidas                                                                                        | classes inválidas |
| :-------------------------------- | :--------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------------------- | ----------------- |
| espaçamento entre linhas          | interface configurada com o espaçamento mínimo exigido para evitar fadiga visual(1)      | interface com espaçamento inferior ao mínimo, leva a fadiga vidual (2)                                   |                   |
| rastreamento da leitura acessível | espaçamento mínimo entre linhas facilita o rastreamento da leitura pelo idoso(3)         | interface com espaçamento inferior ao mínimo, não torna possível o rastreamento acessível da leitura (4) |                   |
| estilo da fonte                   | uso de fontes sem serifa como Arial, Open Sans ou Roboto para garantir a legibilidade(5) | uso de estilos cursivos, muito finos ou fontes com serifa que dificultam a leitura(6)                    |                   |
| margem entre botões               | botões dispostos com espaçamento visual suficiente para impedir cliques por engano(7)    | botões excessivamente próximos, geram risco de o usuário clicar num item por engano(8)                   |                   |
| comprimento da linha              | textos estruturados respeitando o limite máximo de até 80 caracteres por linha(9)        | linhas extensas contendo mais de 80 caracteres, prejudicando a legibilidade(10)                          |                   |

**Casos de Teste**

| Classes de equivalência | Entradas                          | Resultado Esperado                                                                                             |
| :---------------------- | :-------------------------------- | :------------------------------------------------------------------------------------------------------------- |
| 1,3,5,7,9               | Todas entradas válidas            | interface configurada corretamente com alta legibilidade e acessibilidade pro usuário(valido)                  |
| 2,3,5,7,9               | Espaçamento entre linhas          | interface com espaçamento inferior ao mínimo, leva a fadiga visual(inválido)                                   |
| 1,4,5,7,9               | Rastreamento da leitura acessível | interface com espaçamento inferior ao mínimo, não torna possível o rastreamento acessível da leitura(inválido) |
| 1,3,6,7,9               | Estilo da fonte                   | uso de estilos cursivos, muito finos ou fontes com serifa que dificultam a leitura(inválido)                   |
| 1,3,5,8,9               | Margem entre botões               | botões muito próximos, geram risco de o usuário clicar num item por engano(inválido)                           |
| 1,3,5,7,10              | Comprimento da linha              | linhas extensas contendo mais de 80 caracteres, prejudicam a legibilidade(inválido)                            |

---

## Memorização de Contato para Futuras Transações
US11 - Enquanto usuário idoso, desejo gravar o contato da pessoa que acabou de receber meu dinheiro, para ter um atalho rápido nas minhas próximas operações.

**Classes de Equivalência**

| Condições de Entrada        | classes válidas                                                                                     | classes inválidas                                                                   | classes inválidas |
| :-------------------------- | :-------------------------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------- | ----------------- |
| exibição da opção de salvar | chave pix ou dados bancários não existem na lista e o app exibe a opção de "Salvar este contato"(1) | chave pix ou dados bancários já existem na lista e o app omite a opção de salvar(2) |                   |
| identificação do contato    | usuário atribui um nome ou apelido simples para o contato(3)                                        | usuário tenta salvar sem preencher o nome ou apelido(4)                             |                   |
| visualização de atalhos     | contatos salvos aparecem corretamente na seção de "favoritos" ou "recentes" na tela inicial(5)      | novos contatos cadastrados não são renderizados nos atalhos da tela inicial(6)      |                   |

**Casos de Teste**

| Classes de Equivalência | Entradas                    | Resultado Esperado                                                                                |
| :---------------------- | :-------------------------- | :------------------------------------------------------------------------------------------------ |
| 1,3,5                   | todas entradas válidas      | opção de salvar é exibida, o nome é atribuído com sucesso e o contato aparece nos atalhos(válido) |
| 2,3,5                   | exibição da opção de salvar | chave pix ou os dados bancários já existem na lista e o app não exibe a opção de salvar(inválido) |
| 1,4,5                   | identificação do contato    | usuário tenta salvar sem preencher o nome ou apelido(inválido)                                    |
| 1,3,6                   | visualização de atalhos     | novos contatos cadastrados não são renderizados nos atalhos da tela inicial(inválido)             |

---

## Pesquisa de Recebedor por Barra de Pesquisa
US12 - Enquanto usuário idoso, desejo pesquisar um recebedor na minha lista usando apenas o nome, para localizar o contato rapidamente na hora da transferência.

**Classes de Equivalência**

| Condições de Entrada          | classes válidas                                                                                               | classes inválidas                                                                        | classes invalidas                                         |
| :---------------------------- | :------------------------------------------------------------------------------------------------------------ | :--------------------------------------------------------------------------------------- | --------------------------------------------------------- |
| campo de busca                | barra de pesquisa fixa presente no topo da lista com o placeholder "buscar por nome"(1)                       | barra de pesquisa ausente, oculta ou com placeholder incorreto(2)                        |                                                           |
| filtro de contatos            | digitação de letras filtra automaticamente a lista de contatos correspondentes(3)                             | sistema ou não atualiza a lista em tempo real(4)                                         | sistema exige clique em botão para buscar atualizações(5) |
| tratamento de acentos e caixa | busca ignora diferenças entre maiúsculas/minúsculas e acentos (como "Jose" localiza "José")(6)                | busca restrita que exige digitação exata com acentuação e caixa correta(7)               |                                                           |
| ordenação do resultado        | contatos localizados são exibidos priorizando a ordem alfabética(8)                                           | lista retorma de forma desordenada ou aleatória(9)                                       |                                                           |
| correspondência ausente       | nenhum contato corresponde ao termo digitado e exibe a mensagem: nenhum contato encontrado com este nome"(10) | nenhum contato localizado e a tela fica em branco sem feedback ou algum visual claro(11) |                                                           |

**Casos de Teste**

| classes de equivalência | Entradas                      | Resultado Esperado                                                                                    |
| :---------------------- | :---------------------------- | :---------------------------------------------------------------------------------------------------- |
| 1,3,6,8,10              | todas entradas válidas        | busca realizada com sucesso, lista filtrada em ordem alfabética desconsiderando acentos/caixa(válido) |
| 2,3,6,8,10              | campo de busca                | barra de pesquisa ausente, oculta ou com placeholder incorreto(inválido)                              |
| 1,4,6,8,10              | filtro de contatos            | sistema não atualiza a lista em tempo real ao digitar(Inválido)                                       |
| 1,5,6,8,10              | filtro de contatos            | ssitema exige clique em botão para buscar atualizações(Inválido)                                      |
| 1,3,7,8,10              | tratamento de acentos e caixa | busca restrita que exige digitação exata com acentuação e caixa correta(Inválido)                     |
| 1,3,6,9,10              | ordenação do resultado        | lista retorna de forma desordenada ou aleatória(Inválido)                                             |
| 1,3,6,8,11              | correspondência ausente       | nenhum contato localizado e a tela fica em branco sem feedback ou algum visual claro(Inválido)        |

---

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

**Casos de Teste**

| **Casos de Teste** | **Classes de Equivalência** | **Entradas**                                                                                                                                             | **Resultado Esperado** |
| ------------------ | --------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| **Caso 1**         | 1, 3, 5, 7, 9               | Tudo válido                                                                                                                                              | Sucesso                |
| **Caso 2**         | 2, 3, 5, 7, 9               | Na exibição do comprovante, o sistema renderiza as informações principais (Valor, Nome ou Data) com tamanho de fonte abaixo de 20px.                     | Falha                  |
| **Caso 3**         | 1, 4, 5, 7, 9               | O sistema renderiza o texto do comprovante com cores que deixam o contraste abaixo dos padrões de acessibilidade (tornando a leitura nítida impossível). | Falha                  |
| **Caso 4**         | 1, 3, 6, 7, 9               | O usuário aciona o botão "Salvar PDF", mas o arquivo de saída gerado quebra a formatação original ou ignora o tamanho da escala.                         | Falha                  |
| **Caso 5**         | 1, 3, 5, 8, 9               | O sistema ignora completamente a configuração de escala de fonte que está ativa no sistema operacional do dispositivo do usuário.                        | Falha                  |
| **Caso 6**         | 1, 3, 5, 7, 10              | O sistema tenta aplicar o redimensionamento proporcional, mas a disposição do layout quebra, sobrepõe linhas ou oculta partes dos textos do comprovante. | Falha                  |

---

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

**Casos de Teste**

| **Casos de Teste** | **Classes de Equivalência** | **Entradas**                                                                                                                                      | **Resultado Esperado** |
| ------------------ | --------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| **Caso 1**         | 1, 4, 6, 10                 | Tudo válido                                                                                                                                       | Sucesso                |
| **Caso 2**         | 1, 4, 6, 8                  | O usuário visualiza o alerta de conta suspeita dentro dos padrões visuais corretos e clica na ação recomendada de destaque "Quero Cancelar".      | Sucesso                |
| **Caso 3**         | 3, 12                       | O usuário tenta realizar uma transferência Pix para uma conta cujo nível de risco é crítico (Presente na lista negra).                            | Sucesso                |
| **Caso 4**         | 2, 4, 6, 10                 | O usuário envia um Pix para uma chave comum e segura (Risco Normal), mas o sistema aciona incorretamente a tela de interrupção de fraude.         | Falha                  |
| **Caso 5**         | 1, 5, 6, 10                 | Ao identificar a chave suspeita, o pop-up de alerta é gerado com o layout quebrado, sem o fundo amarelo-alerta ou com fontes menores que 20pt.    | Falha                  |
| **Caso 6**         | 1, 4, 7, 10                 | O pop-up é acionado para a chave suspeita, mas a mensagem falha no critério e exibe termos técnicos complexos como "Score de Risco de Transação". | Falha                  |
| **Caso 7**         | 1, 4, 6, 9                  | O usuário clica no botão "Quero Cancelar", mas o aplicativo ignora a ação e prossegue normalmente com o fluxo da transação de risco.              | Falha                  |
| **Caso 8**         | 1, 4, 6, 11                 | O usuário clica em "Continuar assim mesmo" e o sistema libera o campo de digitação de senha imediatamente, ignorando os 5 segundos de pausa.      | Falha                  |
| **Caso 9**         | 3, 13                       | A chave de destino possui nível de risco crítico (lista preta), mas o sistema falha no bloqueio sumário e permite que o idoso digite a senha.     | Falha                  |

---

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

**Casos de Teste**

| **Casos de Teste** | **Classes de Equivalência** | **Entradas**                                                                                                                                           | **Resultado Esperado** |
| ------------------ | --------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ | ---------------------- |
| **Caso 1**         | 1, 3, 5, 7, 9, 11           | Tudo válido                                                                                                                                            | Sucesso                |
| **Caso 2**         | 2, 3, 5, 7, 9, 11           | O sistema exibe o comprovante, mas o botão de compartilhar aparece oculto, sem o texto descritivo "Enviar Comprovante" ou com um ícone incorreto.      | Falha                  |
| **Caso 3**         | 1, 4, 5, 7, 9, 11           | O usuário toca no botão de compartilhamento correto, mas o aplicativo não executa nenhuma ação ou gera um erro de sistema interno.                     | Falha                  |
| **Caso 4**         | 1, 3, 6, 7, 9, 11           | O processo é iniciado, mas o arquivo gerado para o compartilhamento está corrompido, em baixa resolução ou em um formato totalmente ilegível.          | Falha                  |
| **Caso 5**         | 1, 3, 5, 8, 9, 11           | O usuário seleciona o aplicativo desejado na gaveta nativa do SO, mas o sistema falha ao transferir o arquivo do recibo para esse aplicativo.          | Falha                  |
| **Caso 6**         | 1, 3, 5, 7, 10, 11          | O sistema operacional está configurado com zoom de acessibilidade, mas o aplicativo simplesmente ignora a escala ativa no aparelho do idoso.           | Falha                  |
| **Caso 7**         | 1, 3, 5, 7, 9, 12           | O sistema tenta realizar o compartilhamento com a escala de fonte ativa, mas o layout quebra, sobrepõe as linhas ou oculta dados essenciais do recibo. | Falha                  |

---

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

**Casos de Teste**

| **Casos de Teste** | **Classes de Equivalência** | **Entradas**                                                                                                                                                        | **Resultado Esperado** |
| ------------------ | --------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| **Caso 1**         | 1, 3, 5, 7, 9               | Tudo válido (Contato Salvo)                                                                                                                                         | Sucesso                |
| **Caso 2**         | 1, 3, 5, 8, 9               | Tudo válido (Nome Fantasia): transação para local sem contato salvo cruza dados e prioriza o Nome Fantasia em vez de termos jurídicos complexos na lista principal. | Sucesso                |
| **Caso 3**         | 2, 3, 5, 7, 9               | A lista do extrato principal falha em aplicar a máscara amigável e exibe diretamente a Razão Social complexa ou códigos da empresa para o idoso.                    | Falha                  |
| **Caso 4**         | 1, 4, 5, 7, 9               | O usuário tenta tocar sobre uma movimentação para entender o gasto, mas a interface não responde ou quebra completamente a navegação.                               | Falha                  |
| **Caso 5**         | 1, 3, 6, 7, 9               | A tela secundária de detalhes da movimentação abre após o toque, mas oculta dados obrigatórios ou omite a Razão Social original da transação.                       | Falha                  |
| **Caso 6**         | 1, 3, 5, 7, 10              | Existe um apelido registrado para o CPF/CNPJ de destino, mas o sistema ignora a regra de prioridade e exibe a Razão Social jurídica na lista do extrato.            | Falha                  |

---

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

**Casos de Teste**

| **Casos de Teste** | **Classes de Equivalência** | **Entradas**                                                                                                                                             | **Resultado Esperado** |
| ------------------ | --------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| **Caso 1**         | 1, 3, 5, 7, 9, 11           | Tudo válido                                                                                                                                              | Sucesso                |
| **Caso 2**         | 2, 3, 5, 7, 9, 11           | O usuário toca no campo de inserção do valor, mas o aplicativo abre o teclado alfabético tradicional ou exibe uma fonte padrão pequena.                  | Falha                  |
| **Caso 3**         | 1, 4, 5, 7, 9, 11           | O sistema processa a cobrança, mas gera um QR Code do tipo estático ou completamente sem o valor especificado embutido no payload.                       | Falha                  |
| **Caso 4**         | 1, 3, 6, 7, 9, 11           | O código é gerado, mas aparece na tela em tamanho pequeno, descentralizado ou com cores de baixo contraste.                                              | Falha                  |
| **Caso 5**         | 1, 3, 5, 8, 9, 11           | O aplicativo cria o QR Code, mas falha ao vincular os dados da chave Pix configurada como principal ou gera com uma chave incorreta.                     | Falha                  |
| **Caso 6**         | 1, 3, 5, 7, 10, 11          | O usuário aciona a função de cópia, mas o botão não responde ou envia uma string do Pix Copia e Cola totalmente corrompida para a área de transferência. | Falha                  |
| **Caso 7**         | 1, 3, 5, 7, 9, 12           | O pagamento vinculado ao QR Code é detectado e o saldo é atualizado, mas o sistema não emite nenhum aviso visual ou sinal sonoro de confirmação.         | Falha                  |

---

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

**Casos de Teste**

| **Casos de Teste** | **Classes de Equivalência** | **Entradas**                                                                                                                                                                                       | **Resultado Esperado** |
| ------------------ | --------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| **Caso 1**         | 1, 3, 5, 7, 9               | Tudo válido (Atendimento Diurno)                                                                                                                                                                   | Sucesso                |
| **Caso 2**         | 1, 3, 5, 8, 11              | Tudo válido (Atendimento Noturno): usuário acessa o suporte de madrugada (às 23h30), o sistema identifica o horário inativo, bloqueia a chamada ativa e exibe a tela informativa de funcionamento. | Sucesso                |
| **Caso 3**         | 2, 3, 5, 7, 9               | O usuário precisa de ajuda, mas o botão de suporte aparece oculto nas telas principais, sem texto descritivo ou com um ícone confuso.                                                              | Falha                  |
| **Caso 4**         | 1, 4, 5, 7, 9               | O usuário aciona o botão de ajuda no horário comercial, mas a interface omite um dos canais de atendimento ou exibe opções não suportadas.                                                         | Falha                  |
| **Caso 5**         | 1, 3, 6, 7, 9               | O menu de suporte abre corretamente, mas o tempo de espera estimado está oculto, estático ou utilizando fontes ilegíveis para o idoso.                                                             | Falha                  |
| **Caso 6**         | 1, 3, 5, 7, 10              | O usuário tenta iniciar um atendimento às 10h00 da manhã, mas o sistema falha ao iniciar a conexão ou bloqueia a chamada em horário ativo.                                                         | Falha                  |
| **Caso 7**         | 1, 3, 5, 8, 12              | O usuário tenta acionar o suporte humano de madrugada (às 02h00), mas o sistema permite a tentativa de chamada, gerando erro de linha discada ou muda.                                             | Falha                  |

---

# Navegação Segura no Modo Conta Assistida
US21 - Enquanto tutor desejo um modo de conta assistida para observar as principais movimentações bancárias do idoso.

**Classes de Equivalência**

| **Condição de Entrada**      | **Classes Válidas**                                              | **Classes Inválidas**                                                       | **Classes Inválidas**                                                |
| ---------------------------- | ---------------------------------------------------------------- | --------------------------------------------------------------------------- | -------------------------------------------------------------------- |
| **Ações na conta do idoso**  | Enviar notificação de transação suspeita. (1)                    | Tentar alterar dados cadastrais ou realizar transações financeiras. (2)     | Tentar realizar exclusões ou ações administrativas complexas. (3)    |
| **Tempo de navegação**       | Tempo de navegação menor ou igual a 15 minutos (Ex: 15 min). (4) | Tempo de navegação maior que 15 minutos (Ex: 16 min). (5)                   | Tempo nulo, vazio ou negativo de sessão (Ex: -1 min). (6)            |
| **Confirmação do idoso**     | Confirmação realizada via Link, Código ou QR Code válido. (7)    | Ausência de resposta ou recusa do idoso (Timeout). (8)                      | Utilização de método de confirmação incorreto ou corrompido. (9)     |
| **Exibição de Dados / LGPD** | Dados de movimentação visíveis e dados pessoais censurados. (10) | Dados pessoais totalmente expostos sem censura. (11)                        | Falha na carga de dados (Tela de movimentações vazia/quebrada). (12) |
| **Status do Primeiro Login** | Modo assistido ativo automaticamente no primeiro login. (13)     | Modo assistido não ativa (Tutor ganha acesso total no primeiro login). (14) | Modo assistido perde o estado em logins subsequentes. (15)           |

**Casos de Teste**

| **CT**   | **Classes de Equivalência** | **Entradas**             | **Resultado Esperado**                                                                                                                                                  |
| -------- | --------------------------- | ------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **CT01** | 1, 4, 7, 10, 13             | Todas entradas válidas   | Modo assistido é ativado com sucesso.                                                                                                                                   |
| **CT02** | 2, 4, 7, 10, 13             | Ações na conta do idoso  | A operação financeira/cadastral é bloqueada. Exibição de mensagem de erro: _"Ação não permitida no modo de conta assistida"_.                                           |
| **CT03** | 3, 4, 7, 10, 13             | Ações na conta do idoso  | Ação administrativa crítica é abortada imediatamente. Sistema mantém a integridade da conta e exibe alerta de violação de privilégios de acesso.                        |
| **CT04** | 1, 5, 7, 10, 13             | Tempo de navegação       | Aos 15 minutos, a navegação do tutor é suspensa e a tela de bloqueio é exibida                                                                                          |
| **CT05** | 1, 6, 7, 10, 13             | Tempo de navegação       | O sistema de segurança detecta a inconsistência crítica no contador de sessão. O token de acesso é invalidado e o tutor é deslogado por segurança.                      |
| **CT06** | 1, 4, 8, 10, 13             | Confirmação do idoso     | É exibida mensagem informando que a sessão expirou por falta de confirmação do idoso.                                                                                   |
| **CT07** | 1, 4, 9, 10, 13             | Confirmação do idoso     | O sistema rejeita a entrada inválida. Exibe mensagem de erro _"Confirmação inválida"_ e mantém a tela do tutor travada até que uma credencial correta seja fornecida.   |
| **CT08** | 1, 4, 7, 11, 13             | Exibição de Dados / LGPD | O mecanismo de segurança intercepta a resposta e força a censura/máscara dos dados pessoais sensíveis na interface, em estrita conformidade com a LGPD.                 |
| **CT09** | 1, 4, 7, 12, 13             | Exibição de Dados / LGPD | O sistema trata a exceção e exibe uma mensagem amigável: _"Não foi possível carregar as movimentações no momento"_, sem expor dados internos ou quebrar o app.          |
| **CT10** | 1, 4, 7, 10, 14             | Status do Primeiro Login | As diretrizes corporativas de segurança no backend identificam o perfil "tutor" e injetam compulsoriamente as amarras do modo assistido, impedindo o acesso irrestrito. |
| **CT11** | 1, 4, 7, 10, 15             | Status do Primeiro Login | O sistema valida o vínculo de tutoria de forma persistente.                                                                                                             |

---

# Autenticação Multifator para Acesso Assistido
US22 - Enquanto tutor desejo receber uma validação através de link, código ou Qr Code para acessar o modo conta assistida. 

**Classes de Equivalência**

| **Condição de Entrada**               | **Classes Válidas**                                                            | **Classes Inválidas**                                                                  | **Classes Inválidas**                                                               |
| ------------------------------------- | ------------------------------------------------------------------------------ | -------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| **Tempo de recebimento da validação** | Recebimento do método em até 5 segundos. (1)                                   | Recebimento após 5 segundos (SLA estourado). (2)                                       | Validação não recebida / tempo de requisição esgotado. (3)                          |
| **Método de validação e formato**     | Link estruturado correto, código numérico/alfanumérico ou QR Code íntegro. (4) | Código contendo caracteres inválidos ou formato incompatível. (5)                      | Código com tempo expirado ou QR Code corrompido/ilegível. (6)                       |
| **Submissão da validação**            | Confirmação realizada com sucesso de um token/método ativo. (7)                | Envio do campo de validação totalmente vazio ou em branco. (8)                         | Tentativa de utilizar credencial gerada para outra conta (combinação inválida). (9) |
| **Vínculo de perfil**                 | Tutor devidamente associado e vinculado ao perfil do idoso. (10)               | Tutor sem qualquer registro de vínculo com idoso no sistema. (11)                      | Tutor com vínculo anteriormente revogado, bloqueado ou inativo. (12)                |
| **Redirecionamento e Permissões**     | Redirecionamento automático imediato com perfil assistido configurado. (13)    | Validação com sucesso, mas sistema falha e não redireciona (tutor preso na tela). (14) | Redirecionamento para rota inválida ou com permissões totais expostas. (15)         |

**Casos de Teste**

| **CT**   | **Classes de Equivalência** | **Entradas**                      | **Resultado Esperado**                                                                                                                               |
| -------- | --------------------------- | --------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| **CT01** | 1, 4, 7, 10, 13             | Todas entradas válidas            | Validação concluída, modo assistido é ativado com sucesso.                                                                                           |
| **CT02** | 2, 4, 7, 10, 13             | Tempo de recebimento da validação | O sistema rejeita a validação por estouro do tempo limite de entrega (SLA).                                                                          |
| **CT03** | 3, 4, 7, 10, 13             | Tempo de recebimento da validação | A operação é cancelada por tempo de requisição esgotado. O sistema exibe mensagem de erro de comunicação e libera o botão para tentar um novo envio. |
| **CT04** | 1, 5, 7, 10, 13             | Método de validação e formato     | O sistema identifica o formato incompatível antes do envio. Bloqueia a submissão e exibe o alerta: _"Formato de código inválido"_.                   |
| **CT05** | 1, 6, 7, 10, 13             | Método de validação e formato     | O sistema recusa o token durante a validação.                                                                                                        |
| **CT06** | 1, 4, 8, 10, 13             | Submissão da validação            | O sistema impede o envio do formulário.                                                                                                              |
| **CT07** | 1, 4, 9, 10, 13             | Submissão da validação            | O sistema recusa o acesso por incompatibilidade de sessão de segurança. Exibe mensagem de erro de autenticação.                                      |
| **CT08** | 1, 4, 7, 11, 13             | Vínculo de perfil                 | O sistema valida o token, mas bloqueia o acesso na sequência.                                                                                        |
| **CT09** | 1, 4, 7, 12, 13             | Vínculo de perfil                 | O acesso ao modo assistido é negado                                                                                                                  |
| **CT10** | 1, 4, 7, 10, 14             | Redirecionamento e Permissões     | O sistema mantém os dados protegidos de forma segura no backend (não renderiza a tela principal)                                                     |
| **CT11** | 1, 4, 7, 10, 15             | Redirecionamento e Permissões     | O barramento de segurança do backend intercepta a falha de autorização da rota.                                                                      |

---

# Consulta Segura de Dados do Destinatário
US23 - Enquanto tutor desejo visualizar dados da conta do destinatário que receberá o dinheiro, para checar a segurança da transação.

**Classes de Equivalência**

| **Condição de Entrada**                | **Classes Válidas**                                                                       | **Classes Inválidas**                                                                   | **Classes Inválidas**                                                                      |
| -------------------------------------- | ----------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------ |
| Exibição dos dados obrigatórios        | Nome, Valor, Data e Hora exibidos de forma completa e íntegra. (1)                        | Um ou mais campos obrigatórios ausentes ou vazios em tela. (2)                          | Campos carregados com formato corrompido ou ilegível. (3)                                  |
| Marcação de Prioridade                 | Transação de alto valor ou recorrente com marcação de prioridade visível. (4)             | Transação de alto valor ou recorrente sem a marcação visual devida. (5)                 | Transação comum/baixo valor exibindo marcação de prioridade indevida. (6)                  |
| Mascaramento de Documentos             | Documento (CPF/RG) exibido com os caracteres intermediários ocultados por asteriscos. (7) | Documento exposto integralmente na interface sem nenhuma máscara de proteção. (8)       | Campo de documento com máscara totalmente desconfigurada, vazia ou quebrando o layout. (9) |
| Permissões do Perfil - Somente Leitura | Interface sem elementos operacionais (edição/exclusão) ativos para o tutor. (10)          | Sistema processa e aceita comandos de modificação ou inserção enviados pelo tutor. (11) | Botões de modificação ou exclusão visíveis e clicáveis na tela do tutor. (12)              |

**Casos de Teste**

| **CT**   | **Classes de Equivalência** | **Entradas**                           | **Resultado Esperado**                                                                                                                                                             |
| -------- | --------------------------- | -------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **CT01** | 1, 4, 7, 10                 | Todas entradas válidas                 | Visualização de dados do destinatário concluída.                                                                                                                                   |
| **CT02** | 2, 4, 7, 10                 | Exibição dos dados obrigatórios        | O sistema intercepta o dado ausente e impede o carregamento da tela incompleta.                                                                                                    |
| **CT03** | 3, 4, 7, 10                 | Exibição dos dados obrigatórios        | O front-end bloqueia a renderização dos dados corrompidos para preservar a integridade visual.                                                                                     |
| **CT04** | 1, 5, 7, 10                 | Marcação de Prioridade                 | O sistema de auditoria de segurança identifica o erro de conformidade da regra de priorização. O teste falha ao apontar que uma transação de risco ficou sem o selo visual devido. |
| **CT05** | 1, 6, 7, 10                 | Marcação de Prioridade                 | Ocorre um falso positivo na interface.                                                                                                                                             |
| **CT06** | 1, 4, 8, 10                 | Mascaramento de Documentos             | Ocorre uma violação crítica de segurança (LGPD). O mecanismo de proteção secundário do front-end deve travar a tela ou o teste reportará a exposição indevida do dado bruto.       |
| **CT07** | 1, 4, 9, 10                 | Mascaramento de Documentos             | A interface quebra ou oculta o bloco de identificação de forma anômala.                                                                                                            |
| **CT08** | 1, 4, 7, 11                 | Permissões do Perfil - Somente Leitura | O backend barra a ação operando na regra de Somente Leitura. A requisição é rejeitada imediatamente com um erro HTTP 403 _(Forbidden / Acesso Negado)_.                            |
| **CT09** | 1, 4, 7, 12                 | Permissões do Perfil - Somente Leitura | Falha de privilégio na camada visual da aplicação.                                                                                                                                 |

---

# Monitoramento de Histórico com Alerta Antifraude
US24 - Enquanto tutor desejo navegar pela tela do idoso para verificar se há movimentações suspeitas no histórico.

**Classes de Equivalência**

| **Condição de Entrada** | **Classes Válidas**                                                             | **Classes Inválidas**                                                | **Classes Inválidas**                                                   |
| ----------------------- | ------------------------------------------------------------------------------- | -------------------------------------------------------------------- | ----------------------------------------------------------------------- |
| Vínculo Tutor e Idoso   | Vínculo formalizado e ativo no sistema. (1)                                     | Tutor tenta acessar idoso sem nenhum vínculo cadastrado. (2)         | Tutor tenta acessar idoso com vínculo inativo ou revogado. (3)          |
| Filtros de busca        | Filtros preenchidos em formato correto e períodos existentes. (4)               | Filtro contendo caracteres inválidos ou formato incorreto. (5)       | Filtros totalmente vazios ou com intervalos inexistentes. (6)           |
| Ordenação do histórico  | Histórico exibido completamente em estrita ordem cronológica. (7)               | Histórico exibido com quebra ou falha na ordenação cronológica. (8)  | Falha crítica no carregamento dos dados (histórico em branco). (9)      |
| Alerta de atividade     | Destaque visual e badge "Atividade Suspeita" aplicados a acessos atípicos. (10) | Movimentação atípica sem exibição de destaque visual (omissão). (11) | Movimentação comum exibindo o alerta de suspeita (falso positivo). (12) |

**Casos de Teste**

| **CT**   | **Classes de Equivalência** | **Entradas**           | **Resultado Esperado**                                                                                                                                |
| -------- | --------------------------- | ---------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| **CT01** | 1, 4, 7, 10                 | Todas entradas válidas | Verificação de movimentações suspeitas por meio da navegação na tela do idoso concluida                                                               |
| **CT02** | 2, 4, 7, 10                 | Vínculo Tutor e Idoso  | O sistema bloqueia a renderização da tela e impede a execução da consulta por quebra de segurança.                                                    |
| **CT03** | 3, 4, 7, 10                 | Vínculo Tutor e Idoso  | O sistema recusa o acesso e barra a consulta aos logs.                                                                                                |
| **CT04** | 1, 5, 7, 10                 | Filtros de busca       | O mecanismo de validação do front-end/API rejeita a busca antes de submeter ao banco de dados.                                                        |
| **CT05** | 1, 6, 7, 10                 | Filtros de busca       | O sistema invalida o intervalo inconsistente e exibe uma mensagem informativa na listagem: _"Nenhum registro encontrado para o período selecionado"_. |
| **CT06** | 1, 4, 8, 10                 | Ordenação do histórico | O caso de teste acusa uma falha de sistema, evidenciando que o requisito de ordenação estritamente cronológica foi violado.                           |
| **CT07** | 1, 4, 9, 10                 | Ordenação do histórico | O sistema trata a falha de infraestrutura de forma segura.                                                                                            |
| **CT08** | 1, 4, 7, 11                 | Alerta de atividade    | O caso de teste registra uma falha de omissão de negócio, apontando que o algoritmo de segurança falhou ao não destacar a atividade atípica.          |
| **CT09** | 1, 4, 7, 12                 | Alerta de atividade    | Ocorre um falso positivo na interface.                                                                                                                |

---

# Análise Consolidada de Gastos via Dashboard
US25 - Enquanto tutor desejo visualizar uma interface gráfica com dashboards para obter dados organizados que mostram o fluxo gastos determinados por periodos filtrados.

**Classes de Equivalência**

| **Condição de Entrada**           | **Classes Válidas**                                                      | **Classes Inválidas**                                                 | **Classes Inválidas**                                                    |
| --------------------------------- | ------------------------------------------------------------------------ | --------------------------------------------------------------------- | ------------------------------------------------------------------------ |
| Perfil do Usuário                 | Usuário autenticado com perfil de Tutor ativo. (1)                       | Usuário autenticado com perfil comum ou de idoso. (2)                 | Usuário não autenticado tentando acesso direto por rota. (3)             |
| Filtro de Período Selecionado     | Seleção dos períodos previstos (diário, semanal, mensal ou anual). (4)   | Parâmetro de período enviado vazio ou nulo na requisição. (5)         | Parâmetro preenchido com formato incorreto ou valor inexistente. (6)     |
| Escopo e Isolamento Financeiro    | Dados de gastos correspondentes apenas ao idoso vinculado ao tutor. (7)  | Injeção de ID para tentar visualizar dados de idoso de terceiros. (8) | Base de dados de transações indisponível, corrompida ou offline. (9)     |
| Renderização e Atualização Visual | Componentes visuais renderizados e atualizados de forma automática. (10) | Falha estrutural ou erro de renderização visual dos gráficos. (11)    | Alteração de filtro que falha em disparar a atualização automática. (12) |

**Casos de Teste**

| **CT**   | **Classes de Equivalência** | **Entradas**                      | **Resultado Esperado**                                                                                                                                          |
| -------- | --------------------------- | --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **CT01** | 1, 4, 7, 10                 | Todas entradas válidas            | Visualização de interface com dashboards concluída                                                                                                              |
| **CT02** | 2, 4, 7, 10                 | Perfil do Usuário                 | O sistema bloqueia o carregamento da tela e impede a renderização dos componentes gráficos.                                                                     |
| **CT03** | 3, 4, 7, 10                 | Perfil do Usuário                 | A requisição é interceptada pelo middleware de autenticação.                                                                                                    |
| **CT04** | 1, 5, 7, 10                 | Filtro de Período Selecionado     | O sistema adota uma configuração segura por padrão para evitar quebra de layout.                                                                                |
| **CT05** | 1, 6, 7, 10                 | Filtro de Período Selecionado     | O sistema rejeita o processamento do parâmetro inválido.                                                                                                        |
| **CT06** | 1, 4, 8, 10                 | Escopo e Isolamento Financeiro    | O back-end detecta a quebra de escopo/isolamento no barramento de segurança.                                                                                    |
| **CT07** | 1, 4, 9, 10                 | Escopo e Isolamento Financeiro    | O front-end trata o erro de infraestrutura.                                                                                                                     |
| **CT08** | 1, 4, 7, 11                 | Renderização e Atualização Visual | O sistema aciona um fallback de layout, sem travar a página.                                                                                                    |
| **CT09** | 1, 4, 7, 12                 | Renderização e Atualização Visual | O caso de teste documenta e acusa uma falha lógica de sincronismo na interface, visto que o gráfico permaneceu estático e não refletiu a nova busca do usuário. |

---

# Envio de Alerta Preventivo ao Idoso
US26 - Enquanto tutor desejo enviar aviso de transação suspeita para o idoso receber uma notificação.

**Classes de Equivalência**

| **Condição de Entrada**        | **Classes Válidas**                                                                 | **Classes Inválidas**                                                               | **Classes Inválidas**                                                                     |
| ------------------------------ | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| Vínculo Tutor e Idoso          | Vínculo devidamente formalizado e ativo no sistema. (1)                             | Tutor tenta enviar aviso para idoso sem nenhum vínculo cadastrado. (2)              | Tutor tenta enviar aviso para idoso com vínculo inativo ou revogado. (3)                  |
| Dados da Transação e Descrição | Informações da movimentação válidas e descrição preenchida corretamente. (4)        | Dados da movimentação ou campo de descrição enviado totalmente vazio. (5)           | Descrição contendo caracteres inválidos ou tentativa de injeção de scripts. (6)           |
| Controle de Duplicidade        | Envio único do aviso ou envio após o término do intervalo curto de segurança. (7)   | Envio duplicado para a mesma transação dentro do curto intervalo de tempo. (8)      | Múltiplos cliques rápidos/simultâneos no botão de envio (Tentativa de Flood). (9)         |
| Confirmação e Mensageria       | Mensagem de sucesso correta exibida e notificação push entregue em tempo real. (10) | Alerta salvo com sucesso, mas o disparo automático em tempo real falha (Rede). (11) | Envio concluído, mas o sistema exibe texto incorreto ou falha de layout na mensagem. (12) |
| Filtro de Histórico            | Idoso acessando e visualizando logs exclusivos de sua própria conta. (13)           | Idoso tenta alterar parâmetros de rota para ler o histórico de outros idosos. (14)  | Idoso impossibilitado de ler seu próprio log devido a uma falha de persistência. (15)     |

**Casos de Teste**

| **CT**   | **Classes de Equivalência** | **Entradas**                   | **Resultado Esperado**                                                                                                                                          |
| -------- | --------------------------- | ------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **CT01** | 1, 4, 7, 10, 13             | Todas entradas válidas         | Aviso de transação suspeita enviado com sucesso                                                                                                                 |
| **CT02** | 2, 4, 7, 10, 13             | Vínculo Tutor e Idoso          | O sistema rejeita o processamento na camada de negócios por quebra de segurança.                                                                                |
| **CT03** | 3, 4, 7, 10, 13             | Vínculo Tutor e Idoso          | O sistema impede a submissão do alerta.                                                                                                                         |
| **CT04** | 1, 5, 7, 10, 13             | Dados da Transação e Descrição | O front-end intercepta e bloqueia o envio do formulário.                                                                                                        |
| **CT05** | 1, 6, 7, 10, 13             | Dados da Transação e Descrição | O sistema sanitiza a entrada ou barra o envio por motivos de segurança, exibindo alerta de formato inválido.                                                    |
| **CT06** | 1, 4, 8, 10, 13             | Controle de Duplicidade        | O mecanismo antiduplicidade identifica o ID da transação repetida no log recente.                                                                               |
| **CT07** | 1, 4, 9, 10, 13             | Controle de Duplicidade        | O componente de botão é desabilitado imediatamente após o primeiro clique.                                                                                      |
| **CT08** | 1, 4, 7, 11, 13             | Confirmação e Mensageria       | O alerta é registrado e persistido com sucesso no histórico de auditoria.                                                                                       |
| **CT09** | 1, 4, 7, 12, 13             | Confirmação e Mensageria       | O caso de teste documenta uma falha de layout e interface, visto que a mensagem não foi apresentada de maneira limpa ou textual conforme exigido pelo critério. |
| **CT10** | 1, 4, 7, 10, 14             | Filtro de Histórico            | O back-end detecta a tentativa de violação de acesso horizontal.                                                                                                |
| **CT11** | 1, 4, 7, 10, 15             | Filtro de Histórico            | O front-end trata a exceção e exibe uma mensagem: _"Não foi possível carregar seu histórico de notificações no momento"_, sem quebrar a tela.                   |

---

# Autenticação do Tutor com Bloqueio de Segurança
US27 - Enquanto tutor, desejo realizar login e acessar o menu inicial, para acessar o sistema.

**Classes de Equivalência**

| **Condição de Entrada**         | **Classes Válidas**                                                       | **Classes Inválidas**                                                           | **Classes Inválidas**                                                                           |
| ------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- |
| Identificação do Usuário        | E-mail/usuário cadastrado e em formato correto. (1)                       | E-mail/usuário não cadastrado na base de dados. (2)                             | Campo de e-mail/usuário vazio ou com formato inválido. (3)                                      |
| Validação da Senha              | Senha correta correspondente ao usuário digitado. (4)                     | Senha incorreta/divergente da cadastrada. (5)                                   | Campo de senha enviado totalmente em branco/vazio. (6)                                          |
| Contador de Falhas Consecutivas | Número de tentativas incorretas menor ou igual a 4. (7)                   | Número de tentativas incorretas atinge exatamente o limite de 5 falhas. (8)     | Tentativa de submissão com a conta já suspensa (dentro dos 15 minutos). (9)                     |
| Destino do Redirecionamento     | Redirecionamento bem-sucedido para o menu inicial adaptado de tutor. (10) | Redirecionamento para tela inválida, genérica ou com privilégios expostos. (11) | Autenticação aprovada no backend, mas front-end falha e prende o usuário na tela de login. (12) |

**Casos de Teste**

| **CT**   | **Classes de Equivalência** | **Entradas**                    | **Resultado Esperado**                                                                                                                       |
| -------- | --------------------------- | ------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| **CT01** | 1, 4, 7, 10                 | Todas entradas válidas          | Login feito com sucesso                                                                                                                      |
| **CT02** | 2, 4, 7, 10                 | Identificação do Usuário        | Login rejeitado                                                                                                                              |
| **CT03** | 3, 4, 7, 10                 | Identificação do Usuário        | O sistema impede a submissão ou bloqueia a requisição.                                                                                       |
| **CT04** | 1, 5, 7, 10                 | Validação da Senha              | Login rejeitado                                                                                                                              |
| **CT05** | 1, 6, 7, 10                 | Validação da Senha              | A validação de campo obrigatório da interface é acionada.                                                                                    |
| **CT06** | 1, 4, 8, 10                 | Contador de Falhas Consecutivas | O login é recusado e o sistema ativa o bloqueio temporário da conta por 15 minutos ou dispara obrigatoriamente o desafio CAPTCHA.            |
| **CT07** | 1, 4, 9, 10                 | Contador de Falhas Consecutivas | O sistema recusa o processamento da autenticação e exibe o alerta informando que a conta está temporariamente suspensa por segurança.        |
| **CT08** | 1, 4, 7, 11                 | Destino do Redirecionamento     | O barramento de segurança da aplicação intercepta a quebra de privilégio, bloqueia a renderização da rota inválida e protege as informações. |
| **CT09** | 1, 4, 7, 12                 | Destino do Redirecionamento     | O sistema impede a criação de uma sessão ativa "fantasma" sem resposta visual, tratando a falha e exigindo a reinicialização segura do app.  |

---

# Molde
US - Descriçãp

**Classes de Equivalência**


**Casos de Teste**

---


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

---

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

---

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

---

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

---

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

---

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

---

# Exportação Massiva de Extratos para Auditoria
US - Enquanto especialista de suporte com privilégios administrativos, desejo exportar extratos financeiros de usuários em lote aplicando filtros dinâmicos, para analisar comportamentos sistêmicos falhos ou atender a demandas de auditoria em massa.

**Classes de Equivalência**

| **Condição de Entrada**      | **Classes Válidas**                                                                       | **Classes Inválidas**                                                                     | **Classes Inválidas**                                                              |
| ---------------------------- | ----------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| Autorização do Especialista  | PerfilAdmin autenticado e com a flag de exportação massiva ativa. (1)                     | PerfilAdmin autenticado, mas sem a flag de autorização ativada. (2)                       | Especialista com sessão expirada, token inválido ou não autenticado. (3)           |
| Filtro de Período            | Intervalo de datas preenchido corretamente no formato aceito (Ex: DD/MM/AAAA). (4)        | Intervalo de período invertido (Data início maior que data fim) ou inválido. (5)          | Parâmetro de período enviado totalmente vazio ou nulo na requisição. (6)           |
| Tipo de Transação e Status   | Parâmetros compatíveis com os enums mapeados no sistema. (7)                              | Valores externos aos enums cadastrados ou caracteres inválidos (Ex: SQL Injection). (8)   | Combinação inválida de parâmetros que corrompe a estrutura de filtros. (9)         |
| Processamento e Mascaramento | Documento local gerado com sucesso aplicando as máscaras de dados sensíveis da US08. (10) | Documento gerado com falha de conformidade (expondo dados sensíveis em texto claro). (11) | Falha de timeout no processamento em lote devido a volume excessivo de dados. (12) |

**Casos de Teste**

| **CT**   | **Classes de Equivalência** | **Entradas**                 | **Resultado Esperado**                                                                          |
| -------- | --------------------------- | ---------------------------- | ----------------------------------------------------------------------------------------------- |
| **CT01** | 1, 4, 7, 10                 | Todas entradas válidas       | Exportação de extratos financeiros em lote realizado com sucesso                                |
| **CT02** | 2, 4, 7, 10                 | Autorização do Especialista  | O sistema bloqueia a execução do método exportarExtratoLote                                     |
| **CT03** | 3, 4, 7, 10                 | Autorização do Especialista  | O backend rejeita a requisição imediatamente de forma preventiva.                               |
| **CT04** | 1, 5, 7, 10                 | Filtro de Período            | O front-end/API rejeita a busca antes de iniciar o processamento em lote.                       |
| **CT05** | 1, 6, 7, 10                 | Filtro de Período            | O sistema impede a exportação massiva sem delimitador temporal.                                 |
| **CT06** | 1, 4, 8, 10                 | Tipo de Transação e Status   | O sistema intercepta e sanitiza a entrada de dados.                                             |
| **CT07** | 1, 4, 9, 10                 | Tipo de Transação e Status   | O back-end recusa a estrutura do objeto recebido.                                               |
| **CT08** | 1, 4, 7, 11                 | Processamento e Mascaramento | O caso de teste aponta e documenta uma falha crítica de segurança e desconformidade regulatória |
| **CT09** | 1, 4, 7, 12                 | Processamento e Mascaramento | O back-end interrompe a conexão de forma segura devido ao estouro de tempo.                     |

---
