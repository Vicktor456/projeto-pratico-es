# Rastreabilidade das Telas
loren inpsum

## US01 - Privacidade do Saldo

**Descrição:** Enquanto usuário Idoso, desejo que o meu saldo apareça oculto po6r padrão, para que eu possa abrir o aplicativo em locais públicos com privacidade.

---

<img width="253" height="552" alt="image" src="https://github.com/user-attachments/assets/91132e8c-6227-401d-b7e4-86870c0181ed" />


---

**Implementação no MVP** - A funcionalidade foi implementada de modo que após realizar o desbloqueio biométrico, facial ou por PIN, o usuário tem acesso a tela inicial, onde o seu saldo está oculto de forma automática.

---

## US02 - Acesso Biométrico

**Descrição:** Enquanto usuário idoso, desejo autenticar meu acesso por meio de biometria (digital ou reconhecimento facial), a fim de simplificar o processo de login e eliminar a necessidade de memorização de credenciais complexas.

---

<img width="240" height="495" alt="image" src="https://github.com/user-attachments/assets/0d197c79-c930-4a57-b8bc-a7c90ce78764" />


---

**Implementação no MVP:** A funcionalidade foi implementada através de uma tela dedicada de ativação de biometria, projetada com elementos visuais simplificados e de fácil compreensão para o usuário idoso. No topo da interface, uma ilustração centralizada em formato de impressão digital reforça a utilidade da tela. Logo abaixo, o título em negrito "Ativar biometria" é acompanhado de uma instrução em texto claro: "Use sua digital ou reconhecimento facial para entrar com mais facilidade e segurança". Para a escolha do método, foram disponibilizados dois botões amplos e lado a lado, identificados com ícones explícitos para "Digital" e "Face ID". A ação principal é comandada por um botão de destaque contrastante com o texto "Ativar agora", posicionado estrategicamente acima da opção secundária "Fazer depois", garantindo uma navegação intuitiva e eliminando a dependência de senhas complexas.

---

## US03 - Limite de Transferência Diária

**Descrição:** Enquanto usuário idoso, desejo estabelecer um limite diário transacional, a fim de mitigar riscos de fraudes financeiras e prevenir a execução de operações com valores equivocados por erro operacional.

---

<img width="251" height="506" alt="image" src="https://github.com/user-attachments/assets/0c89cec8-8b0a-490c-aed5-69ca2b0a5ca7" />


---

**Implementação no MVP:** A funcionalidade foi implementada através de uma interface dedicada ao gerenciamento do "Limite Pix", estruturada de forma clara para combater riscos de fraudes e erros operacionais por usuários idosos. Em um card centralizado de alta visibilidade, o "Limite diário atual" é exibido em fonte ampliada e negrito ("R$ 5.000,00"). O ajuste do valor é facilitado pelo uso de um controle deslizante (slider) com marcadores visuais nítidos para os limites mínimo (R$ 100) e máximo (R$ 10.000), eliminando a necessidade de digitação complexa e prevenindo equívocos. A tela conta ainda com um banner informativo de alerta na cor amarela que detalha as regras de segurança regulamentadas e o prazo de até 24 horas para ativação, finalizando com um botão de ação proeminente no rodapé com o texto 'Salvar novo limite'.

---

## US04 - Utilização de Chaves Pix

**Descrição:** Enquanto usuário idoso, desejo inserir chaves PIX manualmente através de um campo de digitação direto, para realizar transferências a novos recebedores de forma independente, sem depender de contatos previamente salvos.

---
<img width="296" height="161" alt="image" src="https://github.com/user-attachments/assets/938e0444-42ce-45ce-992b-4884ef28f9d9" />

---

**Implementação no MVP:**  A funcionalidade foi implementada através de uma barra de digitação na área "enviar pix", onde o usuário pode selecionar tipo de chave pix que irá ser inserida de forma manual, como, e-mail, CPF, celular ou chave aleatória.

---

## US05 - Confirmação de Dados do Recebedor

**Descrição:** Enquanto usuário idoso, desejo conferir o nome completo e parte do CPF do destinatário com letras em destaque na tela de confirmação, para ter certeza de que o dinheiro está indo para a pessoa certa.

---

<img width="218" height="494" alt="image" src="https://github.com/user-attachments/assets/d2c38e31-eaba-4fef-8b77-55654d949cdc" />


---

**Implementação no MVP:** A funcionalidade foi implementada através de uma tela de confirmação de envio estruturada para garantir a segurança e a conferência dos dados por usuários idosos. No card centralizado intitulado "DESTINATÁRIO", o nome completo da recebedora ("Maria da Silva") é exibido com letras em destaque, utilizando uma fonte de tamanho ampliado e peso negrito para facilitar a leitura. Logo abaixo do nome, parte do CPF do destinatário é apresentada de forma mascarada, mantendo visível e em destaque apenas os dígitos centrais válidos ("***.123.456-**"),  e prevenção de erros antes da conclusão da transferência.

---

## US06 - Leitura de QR Code

**Descrição:** Enquanto usuário idoso, desejo escanear o QR Code usando a câmera dentro do aplicativo ou ter a opção de inserir o código manualmente, para realizar pagamentos de forma mais prática e ágil.

---

<img width="255" height="244" alt="image" src="https://github.com/user-attachments/assets/1dbda3cf-ecc8-4bff-b2cd-53e50d2381ab" />

<img width="251" height="406" alt="image" src="https://github.com/user-attachments/assets/70f5ef74-1180-4a20-881e-876c3b7604ea" />

---

**Implementação no MVP:**  A funcionalidade foi implementada através das telas que se refere ao menu pix, onde o usuário tem a opção "QR Code",  que pode ser utilizada tanto para realizar cobranças gerando QR um Code, quanto para escanear e realizar um pagamento. A chave também pode ser inserida manualmente através de uma barra de digitação de chave Pix.

---

## US07 - Inserção do Valor com Teclado Adaptado

**Descrição:** Enquanto usuário idoso, desejo preencher a quantia do Pix em um teclado com números grandes e espaçados, para ter mais facilidade e não cometer erros de digitação.

---

<img width="248" height="511" alt="image" src="https://github.com/user-attachments/assets/0f407883-fb78-40a6-9510-850a8183b16d" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através de uma interface de pagamento mobile com um teclado numérico de tamanho ampliado e um amplo espaçamento entre as teclas para facilitar o toque e evitar erros de digitação. O campo de inserção do valor exibe a quantia em uma fonte de tamanho grande e negrito para máxima visibilidade, posicionado centralmente acima do teclado.

---

## US08 - Canais de Comunicação Claros
**Descrição:** Enquanto especialista de suporte, desejo canais de comunicação estáveis e interfaces simplificadas para guiar usuários com necessidades de acessibilidade com clareza

---

<img width="246" height="490" alt="image" src="https://github.com/user-attachments/assets/f7862546-6825-434f-8392-294037c3be4b" />


---

**Implementação no MVP:** A funcionalidade foi implementada através de uma interface de tela inicial simplificada que organiza os canais de suporte e navegação em um layout de grade com blocos amplos e de fácil identificação, visando guiar usuários com necessidades de acessibilidade com clareza. Sob o título delimitador "O que você quer fazer?", foram disponibilizados botões com ícones minimalistas e rótulos explícitos de texto em alta visibilidade. Entre as ações de suporte, destacam-se os botões dedicados de "Ajuda" (com ícone de interrogação) e "Assistida" (com ícone de usuário e engrenagem), que servem como canais diretos e estáveis para acionar o suporte especializado e facilitar a orientação remota, reduzindo a complexidade cognitiva do fluxo para o usuário.

---

# Histórias de Usuário - SeuPix MVP

---

## US09 - Controle de Operações Essenciais

**Descrição:** Enquanto suporte, desejo um sistema com menus enxutos e funções essenciais para realização de ações fundamentais como geração de extratos.

---

<img width="240" height="502" alt="image" src="https://github.com/user-attachments/assets/44adbc73-6641-4623-9f85-e46be2ee666e" />
<img width="220" height="240" alt="image" src="https://github.com/user-attachments/assets/e264d86d-2072-47f5-ad22-6b79a9233acf" />


---

**Implementação no MVP** -  A funcionalidade foi implementada através de um fluxo simples que contém menus e funções essenciais na tela inicial, onde o botão dedicado "Extrato" integra uma grade de ações rápidas e de fácil identificação visual. Ao acessar essa função, o usuário é direcionado para uma tela de extrato limpa e organizada, que exibe de forma direta os cards que mostram o fluxo de movimentações bancárias "ENTRADAS" e "SAÍDAS"), além de botões de filtro rápido ("Todos", "Enviados", "Recebidos") localizados no topo. Todas as implementações seguem a ordem cronológica das transações, para manter a organização e facilitar a usabilidade do usuário.

---

## US10 - Acessibilidade Visual na Interface

**Descrição:** Enquanto contato de apoio, desejo uma interface com fontes legíveis para garantir a acessibilidade de usuários com baixa visão.

---

<img width="270" height="528" alt="image" src="https://github.com/user-attachments/assets/bb15345e-f259-48a1-84e2-90cc38d0e4c5" />


---

**Implementação no MVP:**  A funcionalidade foi implementada por meio da tela inicial do aplicativo (que o usuário a acessa após cadastro ou desbloqueio) utilizando uma fonte sem serifa (sans-serif) moderna e otimizada para interfaces digitais, sempre destacando as informações principais com tamanhos de 32px a 36px, criando hierarquia visual em relação ao tamanho das fontes e as informações mais importantes a serem exibidas.

---

## US11 - Memorização de Contrato Para Futuras Transações
Enquanto usuário idoso, desejo gravar o contato da pessoa que acabou de receber meu dinheiro, para ter um atalho rápido nas minhas próximas operações.

**Implementação no MVP:** Não foi gerada nenhuma tela para implementação dessa User Story, portanto, esta ficou fora do escopo do MVP

---

## US12 - Pesquisa de Recebedor por Barra de Pesquisa

**Descrição:** Enquanto usuário idoso, desejo pesquisar um recebedor na minha lista usando apenas o nome, para localizar o contato rapidamente na hora da transferência.

---

<img width="266" height="283" alt="image" src="https://github.com/user-attachments/assets/4c2aa0b2-ce5c-408c-9ba2-027c37e8064a" />


---

**Implementação no MVP:** A implementação foi feita através da barra de digitação na Área Pix, onde o usuário pode inserir o nome do destinatário ao qual deseja realizar uma transação, se o contato estiver salvo como favorito a busca retornará o nome e dados do suposto destinatário, e, ao selecionar o contato, o usuário será direcionado de forma imediata para a tela de transferência.

---

## US13 - Visualização de Comprovante Ampliado

**Descrição:** Enquanto usuário idoso, desejo visualizar o comprovante final com uma fonte ampliada e nítida, para conseguir conferir as informações da transferência sem forçar a vista.

---

<img width="277" height="558" alt="image" src="https://github.com/user-attachments/assets/1e728ead-4219-4831-aef1-05e47ebf6e78" />


---

**Implementação no MVP:** A implementação da funcionalidade foi realizada através de uma tela de comprovante final estruturada com foco em acessibilidade e legibilidade para o público idoso. No topo da interface, a mensagem de sucesso "Pix enviado! com sucesso" e o valor da transferência ("R$ 150,00") são exibidos com fontes amplas, nítidas e em negrito, garantindo identificação imediata. Logo abaixo, o card do comprovante organiza os detalhes da transação (como nome do destinatário, CPF mascarado, banco, data, horário e ID da transação) em linhas bem espaçadas e com alto contraste, permitindo que o usuário confira todas as informações com clareza e sem forçar a vista.

---

## US14 - Exibição de Aviso de Risco de Fraude

**Descrição:** Enquanto usuário idoso, desejo visualizar um aviso de risco claro e em destaque antes de confirmar um Pix suspeito, para que eu possa interromper a operação a tempo e evitar cair em um golpe.

---

<img width="270" height="544" alt="image" src="https://github.com/user-attachments/assets/6b680be1-1be3-4353-b3ae-b2c67843e684" />


---

**Implementação no MVP:** A implementação da funcionalidade ocorre quando o usuário confirma que deseja prosseguir para a próxima etapa da Transferência Pix, o sistema exibe um alerta que informa sobre o modus operandi de golpistas. A implementação desse alerta foi feita com cores que destoam da paleta do SeuPix, usando tons que variam entre laranja e o vermelho, já que, segundo a psicologia das cores, essas cores podem melhorar foco e aumentar atenção aos detalhes.

---

## US15 - Compartilhar Comprovantes por Canais de Comunicação

**Descrição:** Enquanto usuário idoso, desejo compartilhar o comprovante de transferência através das opções do meu aparelho, para enviar o recibo pelo canal de comunicação que eu preferir.

---

<img width="255" height="200" alt="image" src="https://github.com/user-attachments/assets/e13328c9-ff90-4842-9f4c-c6f7b2def02b" />


---

**Implementação no MVP:**  A implementação da funcionalidade está inserida num ícone disponível logo abaixo do comprovante, sinalizado com um pequeno símbolo de compartilhamento e a descrição "compartilhar". Ao selecionar essa opção, é ofertado para o usuário diferentes meios de compartilhamento de comprovante da transferência realizada, como: Whatsapp, Bluetooth, X, SMS etc.

---

## US16 - Extrato Simplificado

**Descrição:** Enquanto usuário idoso, desejo ver uma lista das minhas ultimas transações com nomes amigáveis (apelidos), para entender facilmente onde gastei meu dinheiro.

---

<img width="270" height="535" alt="image" src="https://github.com/user-attachments/assets/aa020708-62d2-4974-81ed-957d6f185afa" />


---

**Implementação no MVP:** A funcionalidade foi implementada através de uma tela de extrato simplificado que apresenta uma lista cronológica das últimas transações utilizando nomes amigáveis e reconhecíveis (como "Farmácia", "Supermercado", e "Padaria"). O layout organiza os gastos de forma limpa e legível, além de exibir a data e os valores correspondentes com clareza. Essa estrutura permite que o usuário idoso identifique e entenda facilmente onde gastou seu dinheiro, sem a necessidade de decifrar códigos ou razões sociais complexas.

---

## US17 - Geração de QR Code

**Descrição:** Enquanto usuário idoso, desejo gerar um QR Code com o valor da venda ou cobrança, para que outra pessoa possa me pagar sem eu precisar falar minha chave.

---

<img width="246" height="453" alt="image" src="https://github.com/user-attachments/assets/03f0f842-dfff-4e47-8cad-5e11db10d5f8" />


---

**Implementação no MVP:** A funcionalidade foi implementada através de uma tela dedicada a "Receber Pix", projetada para simplificar cobranças e vendas para o usuário idoso. A interface exibe no topo um QR Code centralizado e de tamanho ampliado, acompanhado de uma instrução curta e direta: "Mostre este QR Code para quem vai te pagar". Logo abaixo, há um campo de inserção simplificado para definir o valor da cobrança ("R$ 500"), além de um bloco na parte inferior que exibe a chave Pix (CPF mascarado) com um botão de cópia rápida. Essa estrutura elimina a necessidade de o usuário memorizar ou ditar sua chave, permitindo que o pagamento seja recebido de forma visual, segura e sem esforço cognitivo.

---

## US18 - Botão de Ajuda por Voz/Vídeo

**Descrição:** Enquanto usuário idoso, desejo ter um botão de "Ajuda" fácil de encontrar, para falar com um atendente humano caso eu fique confuso.

---

<img width="265" height="335" alt="image" src="https://github.com/user-attachments/assets/567d92e8-93be-48dc-b101-3eb041279877" />
<img width="271" height="531" alt="image" src="https://github.com/user-attachments/assets/2d56952b-0377-47e5-b4ba-ff632e85ad00" />


---

**Implementação no MVP:** A funcionalidade foi implementada na tela inicial com o ícone de "ajuda, que está localizado numa parte central da tela inicial, para que seja mais fácil de o usuário visualizar. Além disso, a ajuda também pode ser solicitada no menu de configurações. Em ambas as telas o usuário tem as mesmas opções de solicitar chamada com atendente, por voz/vídeo, também é exibido o horário de funcionamento do suporte do SeuPix.

---

## US19 - Login Tutor/Contato de Apoio

**Descrição:** Enquanto tutor, desejo realizar cadastro no seupix para logar em minha conta.

---

<img width="259" height="535" alt="image" src="https://github.com/user-attachments/assets/12b626d5-419c-4bae-be13-1b41deb141f0" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através de uma tela de login dedicada intitulada "Acesso Tutor - Portal do Contato de Apoio", voltada para o cadastro e autenticação de tutores no sistema SeuPix. A interface apresenta no topo uma mensagem informativa que contextualiza o objetivo do canal: "Acesse para acompanhar as transações e proteger seu familiar". Para a realização do acesso, foram disponibilizados dois campos de entrada: um para o preenchimento do "CPF" (com máscara de formatação visível) e outro para a "Senha" protegida. O fluxo é concluído de forma direta através de um botão de ação com o texto "Entrar" posicionado na base do formulário, garantindo um processo de autenticação objetivo e seguro.

---

## US20 - Configuração de Limite de Alerta contra Fraudes

**Descrição:** Enquanto tutor, desejo configurar um valor mínimo para recebimento de notificações de transações suspeitas no SeuPix, para controlar quando devo ser alertado sobre movimentações financeiras potencialmente suspeitas.

---

<img width="258" height="469" alt="image" src="https://github.com/user-attachments/assets/8e721671-78e4-49b9-8592-fcb3d8518714" />


---

**Implementação no MVP:**  A funcionalidade foi implementada por meio de uma tela de gerenciamento de limites com foco no controle do tutor. A interface apresenta um card com o valor do limite em fonte ampla e negrito ("R$ 5.000,00"), cujo ajuste é realizadoatravés de um controle deslizante (slider) entre os valores mínimos e máximos. Abaixo, um banner de aviso amarelo detalha o prazo de regulamentação, e o fluxo é concluído com um botão de ação destacado contendo o texto "Salvar novo limite", permitindo gerenciar com facilidade os alertas contra fraudes.

---

## US21 - Navegação Segura no Modo Conta Assistida

**Descrição:** Enquanto tutor desejo um modo de conta assistida para observar as principais movimentações bancárias do idoso.

---

<img width="221" height="489" alt="image" src="https://github.com/user-attachments/assets/e55b6320-f7c5-489d-8dd5-c02486cf5bcd" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através da tela de "Conta Assistida", focada em oferecer uma navegação segura sob a observação do tutor. A interface exibe no topo um ícone de escudo protetor com a mensagem centralizada "Seu familiar acompanha você". Logo abaixo, as principais diretrizes do modo assistido são organizadas em cards verticais bem espaçados e sinalizados por ícones claros: "Alertas automáticos" para notificações de transações, "Proteção extra" para detalhar a necessidade de aprovação de movimentações suspeitas pelo tutor, e "Você controla tudo" para indicar a flexibilidade de gerenciamento de permissões. Essa estrutura garante transparência e monitoramento simplificado sem comprometer a autonomia do usuário.

---

## US22 - Autenticação Multifator para Acesso Assistido

**Descrição:** Enquanto tutor desejo receber uma validação através de link, código ou QR Code para acessar o modo conta assistida.

---

<img width="221" height="489" alt="image" src="https://github.com/user-attachments/assets/9affc7e1-ea95-4d77-afd5-852678136555" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através da tela de "Conta Assistida", focada em oferecer uma navegação segura sob a observação do tutor. A interface exibe no topo um ícone de escudo protetor com a mensagem centralizada "Seu familiar acompanha você". Logo abaixo, as principais diretrizes do modo assistido são organizadas em cards verticais bem espaçados e sinalizados por ícones claros: "Alertas automáticos" para notificações de transações, "Proteção extra" para detalhar a necessidade de aprovação de movimentações suspeitas pelo tutor, e "Você controla tudo" para indicar a flexibilidade de gerenciamento de permissões. Essa estrutura garante transparência e monitoramento simplificado sem comprometer a autonomia do usuário.

---

## US23 - Consulta Segura de Dados do Destinatário

**Descrição:** Enquanto tutor desejo visualizar dados da conta do destinatário que receberá o dinheiro, para checar a segurança da transação.

---

<img width="266" height="534" alt="image" src="https://github.com/user-attachments/assets/98a09b5f-7aa4-442c-a7bd-03387dd7d0aa" />


---

**Implementação no MVP:**  A funcionalidade foi implementada na tela de confirmação de envio, onde o usuário pode verificar todos os dados não sigilosos do destinatário, definindo se a transação é para a pessoa correta e se os dados são legítimos, após essa verificação ser concluída o usuário pode prosseguir com a transação.

---

## US24 - Monitoramento de histórico com alerta anti fraude

**Descrição:** Enquanto tutor desejo navegar pela tela do idoso para verificar se há movimentações suspeitas no histórico.

---

<img width="275" height="564" alt="image" src="https://github.com/user-attachments/assets/f8313fbe-7691-4556-aaec-81075782b878" />


---

**Implementação no MVP:**  A implementação acontece através de ícones de notificações que são exibidos na tela do tutor caso haja alguma movimentação financeira alta ou incomum para o padrão do usuário idoso.

---

## US25 - Análise de Dados Consolidada Via DashBoard

**Descrição:** Enquanto tutor desejo visualizar uma interface gráfica com dashboards para obter dados organizados que mostram o fluxo gastos determinados por períodos filtrados.

---

<img width="259" height="556" alt="image" src="https://github.com/user-attachments/assets/94f08566-b92d-45f7-8552-bc8f0415379f" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através de uma interface de análise de dados consolidada via dashboard, focada em fornecer dados organizados sobre as movimentações do idoso ao tutor. A tela apresenta no topo a identificação do contato de apoio ("Olá, Maria!") e do familiar acompanhado. Logo abaixo, os fluxos de despesas são sumarizados graficamente: primeiro, por meio de um gráfico de rosca intitulado "Gastos por categoria" que distribui os percentuais de consumo de forma visual (como Saúde, Alimentação, Transporte e Outros); segundo, na seção "Gastos mensais", que utiliza um gráfico de barras verticais integrado a botões de filtros de período rápidos (como "6M" e "Anual"). Essa estrutura permite ao tutor monitorar o comportamento financeiro e obter um panorama claro da evolução dos gastos de maneira simples e intuitiva.

---

## US27 - Autenticação do Tutor com Bloqueio de Segurança

**Descrição:** Enquanto tutor, desejo realizar login e acessar o menu inicial, para acessar o sistema.

---

<img width="211" height="480" alt="image" src="https://github.com/user-attachments/assets/5055fadb-39fe-4547-b02e-04aabe1a0874" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através de uma tela de login segura intitulada "Acesso Tutor - Portal do Contato de Apoio", projetada para autenticação do tutor no sistema. A interface conta com um banner informativo inicial que reforça a segurança ("Acesse para acompanhar as transações e proteger seu familiar"). O formulário de autenticação dispõe de dois campos de entrada claros e com ícones identificadores: o primeiro para inserção do "CPF" (com máscara de digitação visível) e o segundo para a "Senha". O fluxo é finalizado por meio de um botão de ação proeminente com o texto "Entrar" posicionado na base da tela, garantindo uma validação direta antes de liberar o acesso ao menu inicial do sistema.

---

## US28 - Ativação Biométrica do Modo Assistido

**Descrição:** Enquanto idoso, desejo ativar o modo de conta assistida para receber auxílio no gerenciamento da segurança e do controle financeiro da minha conta.

---

<img width="237" height="489" alt="image" src="https://github.com/user-attachments/assets/6ede034b-8462-4c51-8d48-d1108828abd6" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através de uma tela informativa de "Conta Assistida", projetada para o usuário idoso ativar e receber auxílio no gerenciamento da segurança e do controle financeiro de sua conta. A interface destaca no topo um ícone de escudo protetor com a mensagem centralizada "Seu familiar acompanha você". Logo abaixo, as diretrizes de funcionamento do modo são organizadas em blocos verticais claros e bem espaçados: "Alertas automáticos" (notificações enviadas ao tutor), "Proteção extra" (aprovação de movimentações suspeitas) e "Você controla tudo" (gerenciamento e ajuste de permissões). Essa estrutura garante transparência e clareza cognitiva sobre o funcionamento do suporte familiar.

---

## US29 - Vinculação Segura de Tutor Responsável

**Descrição:** Enquanto idoso, desejo adicionar um responsável à minha conta assistida para receber suporte no gerenciamento da segurança e das atividades financeiras da minha conta.

---

<img width="233" height="497" alt="image" src="https://github.com/user-attachments/assets/afbf8f38-4f81-4a95-a184-93a18d5d9640" />
 <img width="220" height="482" alt="image" src="https://github.com/user-attachments/assets/303089f8-fda5-42aa-8d6d-f112faacfb04" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através do menu inicial, na opção "conta assistida". Ao escolher essa opção o usuário idoso é direcionado para uma tela com informações do modo conta assistida e, abaixo, um botão centralizado para adicionar tutor. Ao clicar, o usuário é direcionado para seleção de método de validação (QR Code, link por WhatsApp ou código manual), sendo necessária a autorização do idoso conforme regras de consentimento (LGPD).

---

## US30 - Revogação Imediata de Acesso do Responsável

**Descrição:** Enquanto idoso, desejo remover um responsável vinculado à minha conta para manter controle sobre quem possui acesso assistido à minha conta.

---

<img width="222" height="196" alt="image" src="https://github.com/user-attachments/assets/1326e3be-96b7-4e51-9aba-bd0873e3cc53" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através de um botão com um ícone de X vermelho, responsável por remover o tutor vinculado ao modo conta assistida. Ao acionar o botão, o usuário recebe uma confirmação antes da exclusão definitiva do acesso.

---

## US31 - Gestão de Níveis de Permissão e Privacidade
Enquanto idoso, desejo configurar diferentes níveis de acesso para meu responsável através de modos pré-definidos ou personalizados para equilibrar minha privacidade, autonomia e segurança financeira.
**Implementação do MVP:** Não foi gerada nenhuma tela para implementação dessa User Story, portanto, esta ficou fora do escopo do MVP.

---

## US32 - Cadastro Simplificado de Conta Digital

**Descrição:** Enquanto idoso, desejo realizar meu cadastro no aplicativo SeuPix utilizando CPF, e-mail e número de telefone e definindo minha senha para criar minha conta digital.

---

<img width="250" height="504" alt="image" src="https://github.com/user-attachments/assets/2dfa0214-db54-4ef8-915b-b2685e69b04b" />


---

**Implementação no MVP:**  A funcionalidade foi implementada por meio da tela de cadastro "Criar conta", onde o usuário idoso insere nome completo, e-mail, telefone e senha para criação da conta.

---

## US33 - Acesso Facilitado e Seguro à Conta

**Descrição:** Enquanto idoso, desejo realizar login no aplicativo SeuPix utilizando meu método de acesso preferido (CPF, e-mail ou telefone) e senha.

---

<img width="247" height="364" alt="image" src="https://github.com/user-attachments/assets/b2317bf1-48eb-47c0-8c26-15e46078c819" />


---

**Implementação no MVP:**  A tela de login permite acesso via CPF e senha, com indicação de alternativas como e-mail ou telefone.

---

## US34 - Exportação massiva de Extratos Para Auditoria

**Descrição:** Enquanto especialista de suporte com privilégios administrativos, desejo exportar extratos financeiros de usuários em lote aplicando filtros dinâmicos para auditoria.

---

<img width="213" height="303" alt="image" src="https://github.com/user-attachments/assets/cfae78cf-f384-4015-9bb2-b59c64c5cf46" />


---

**Implementação no MVP:**  A funcionalidade foi implementada através de um painel administrativo "Últimos eventos", que permite visualização de logs e exportação de dados com filtros dinâmicos para auditoria.
