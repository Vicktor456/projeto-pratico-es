# Rastreabilidade

A etapa de Rastreabilidade com Histórias do Usuário, tem como propósito demonstrar de forma clara e verificável como as decisões arquiteturais do projeto se conectam diretamente às histórias de usuário mapeadas. O procedimento exige correlacionar uma história de usuário específica com suas respectivas evidências nos diagramas do Modelo C4. Para isso, aplicamos um destaque visual dinâmico nos diagramas (utilizando cores, setas ou numeração de passos) e fornecemos um detalhamento textual descritivo que ilustra a jornada completa da requisição, partindo da interface do usuário (frontend) através da API até a persistência final no banco de dados e o retorno da confirmação.

# **Diagrama C4 Container**

## Container - API Usuário

**Responsabilidade:** Gerenciamento dos dados cadastrais do usuário idoso e responsável.

**Histórias Associadas:** H1 | H7 | H8

**Rastreabilidade:** Responsável pelo armazenamento e recuperação das informações dos usuários cadastrados no sistema. Participa da criação da conta durante o cadastro, da validação de dados utilizados no login e da identificação dos usuários envolvidos no vínculo entre idoso e responsável na funcionalidade de conta assistida.

---

## Container - API Autenticação

**Responsabilidade:** Autenticação e validação de identidade dos usuários.

**Histórias Associadas:** H1 | H4 | H8

**Rastreabilidade:** Responsável pela validação das credenciais de acesso, gerenciamento de sessões e confirmação de operações sensíveis. É utilizada durante o login e também para autenticar alterações relacionadas à conta assistida e às configurações de permissões do responsável.

---

## Container - API Conta Assistida

**Responsabilidade:** Gerenciamento do vínculo entre usuário idoso e responsável.

**Histórias Associadas:** H1 | H4

**Rastreabilidade:** Responsável pela ativação da conta assistida, geração de convites para vinculação de responsáveis, manutenção do relacionamento entre as contas e aplicação das regras relacionadas ao suporte e acompanhamento do usuário idoso.

---

## Container - API Permissões

**Responsabilidade:** Controle de níveis de acesso e permissões do responsável.

**Histórias Associadas:** H4

**Rastreabilidade:** Responsável pelo gerenciamento dos níveis de acesso Básico, Supervisionado, Dependente e Personalizado, garantindo que cada responsável possua apenas as permissões autorizadas pelo usuário idoso conforme as regras de negócio definidas.

---

## Container - API PIX

**Responsabilidade:** Processamento de transações financeiras.

**Histórias Associadas:** Nenhuma HU diretamente implementada até o momento.

**Rastreabilidade:** Embora ainda não possua uma história de usuário específica definida nesta etapa do projeto, o serviço é responsável pelo processamento das transações financeiras e servirá de base para futuras funcionalidades relacionadas a pagamentos, transferências, limites e monitoramento de operações.

---

## Container - API Antifraude

**Responsabilidade:** Análise de risco e prevenção de fraudes.

**Histórias Associadas:** H1 | H4

**Rastreabilidade:** Atua como camada adicional de segurança para usuários idosos, analisando comportamentos suspeitos, operações sensíveis e possíveis tentativas de fraude. Dá suporte às funcionalidades de conta assistida e supervisão financeira.

---

## Container - API Notificação

**Responsabilidade:** Gerenciamento das notificações do sistema.

**Histórias Associadas:** H1 | H4

**Rastreabilidade:** Responsável pelo envio de notificações relacionadas à vinculação de responsáveis, alteração de permissões, mudanças de níveis de acesso e demais eventos importantes para manter o usuário informado sobre ações realizadas em sua conta.

---

## Container - Aplicação Móvel (Usuário Idoso)

**Responsabilidade:** Interface principal de utilização do sistema.

**Histórias Associadas:** H1 | H4 | H7 | H8

**Rastreabilidade:** Permite que o usuário idoso realize cadastro, login, gerenciamento da conta assistida, configuração de permissões e utilização dos serviços financeiros disponibilizados pela plataforma.

---

## Container - Aplicação Móvel (Contato de Apoio)

**Responsabilidade:** Interface utilizada pelo responsável vinculado ao usuário idoso.

**Histórias Associadas:** H1 | H4

**Rastreabilidade:** Disponibiliza ao responsável as funcionalidades autorizadas pelo usuário idoso, permitindo acompanhamento financeiro, recebimento de alertas e atuação dentro dos limites definidos pelo nível de acesso configurado.

---

## Container - Aplicação Móvel (Especialista de Suporte)

**Responsabilidade:** Interface utilizada pela equipe de suporte da plataforma.

**Histórias Associadas:** Nenhuma HU diretamente associada.

**Rastreabilidade:** Fornece ferramentas administrativas para atendimento ao usuário, diagnóstico de problemas, auxílio operacional e suporte relacionado às funcionalidades da plataforma.

---

## Container - API Gateway & Core Backend

**Responsabilidade:** Orquestração e roteamento das requisições.

**Histórias Associadas:** H1 | H4 | H7 | H8

**Rastreabilidade:** Atua como ponto central de entrada para todas as requisições realizadas pelos aplicativos do sistema, encaminhando chamadas aos microserviços apropriados, aplicando regras de segurança, autenticação e controle de acesso.

---

## Sistema Externo - Autenticação

**Histórias Associadas:** H1 | H4 | H8

**Rastreabilidade:** Responsável pela validação externa de identidade, autenticação multifator e gerenciamento seguro das credenciais utilizadas pelos usuários da plataforma.

---

## Sistema Externo - Sistema PIX (SPI/Banco Central)

**Histórias Associadas:** Nenhuma HU diretamente associada.

**Rastreabilidade:** Responsável pela liquidação e comunicação das transações PIX realizadas pela plataforma, servindo como infraestrutura financeira externa obrigatória para operações bancárias.

---

## Sistema Externo - Email

**Histórias Associadas:** H1 | H7

**Rastreabilidade:** Utilizado para envio de mensagens de confirmação de cadastro, vinculação de responsáveis e demais comunicações importantes relacionadas à conta do usuário.

---

## Sistema Externo - SMS

**Histórias Associadas:** H1 | H7 | H8

**Rastreabilidade:** Utilizado para envio de códigos de verificação, autenticação adicional e notificações de segurança relacionadas ao acesso e gerenciamento da conta.

---

## Sistema Externo - Notificações Push

**Histórias Associadas:** H1 | H4

**Rastreabilidade:** Responsável pelo envio de notificações em tempo real para informar alterações de permissões, vinculação de responsáveis e demais eventos relevantes da conta assistida.

---

## Sistema Externo - Antifraude (ClearSale)

**Histórias Associadas:** H1 | H4

**Rastreabilidade:** Realiza análise de risco sobre operações e comportamentos suspeitos, auxiliando os mecanismos internos de segurança e proteção contra fraudes.

---

## Sistema Externo - Biometria

**Histórias Associadas:** H1 | H4 | H8

**Rastreabilidade:** Permite a utilização de biometria digital ou facial para autenticação de usuários e confirmação de operações críticas, aumentando a segurança e a acessibilidade da plataforma.

---

## Sistema Externo - Cloud (AWS)

**Histórias Associadas:** H1 | H4 | H7 | H8

**Rastreabilidade:** Fornece a infraestrutura necessária para hospedagem, processamento e armazenamento dos componentes da aplicação, garantindo disponibilidade e escalabilidade dos serviços.

---

## Sistema Externo - Mensageria e Eventos (Kafka)

**Histórias Associadas:** H1 | H4

**Rastreabilidade:** Responsável pela comunicação assíncrona entre os microserviços, permitindo a propagação de eventos relacionados à conta assistida, permissões, notificações e monitoramento de segurança sem aumentar o acoplamento entre os serviços.


# **Diagrama C4 Código - Classe**

## **Classe - Usuário**: 

### **Atributo - id: int**

Histórias Associadas - US19 | US32 | US33

**Rastreabilidade:** Identificador único interno gerado pelo sistema após a persistência bem-sucedida do cadastro na base de dados, garantindo a distinção de cada conta e a integridade referencial dos vínculos de auditoria.

### **Atributo - nome: String**

História Associada - US19 (RN01)

**Rastreabilidade:** Armazena o nome completo fornecido obrigatoriamente durante o registro no sistema para identificação do indivíduo.

### **Atributo - cpf: String**

Histórias Associadas - US19 | US32 (CA / RN01) | US33 (CA / RN01)

**Rastreabilidade:**
- Recebe a validação obrigatória de formato e dígitos verificadores.
- Garante a unicidade cadastral (Regra: apenas uma conta cadastrada por CPF).
- Serve como um dos métodos de credencial fixa e chave de busca única para o login.

### **Atributo - email: String**

Histórias Associadas - US19 (CA / RN01) | US27 (CA) | US32 (CA / RN02) | US33 (CA / RN01)

**Rastreabilidade:**
- Validado em tempo de inserção contra formatos inválidos.
- Utilizado diretamente como credencial de acesso na tela de login para Tutores e Idosos.
- Garante restrição de conta única por e-mail ativo.

### **Atributo - telefone: String**

Histórias Associadas - US19 (CA) | US32 (CA / RN02) | US33 (CA / RN01)

**Rastreabilidade:**
- Armazena o telefone com verificação obrigatória de DDD.
- Funciona como identificador único e opção alternativa para realização de login.

### **Atributo - senhaHash: String**

Histórias Associadas - US19 (RN01) | US32 (CA / RN03) | US33 (CA / RN03)

**Rastreabilidade:** Atende diretamente à regra de segurança de que **a senha não pode ser armazenada em texto puro**. Este atributo guarda a assinatura criptográfica (hash) gerada a partir dos critérios mínimos de senha (mínimo de 8 caracteres, maiúsculas, números e caracteres especiais).

### **Atributo - tentativasIncorretas: int**

Histórias Associadas - US27 (RN01) | US33 (RN04)

**Rastreabilidade:** Contador numérico incremental que monitora acessos falhos consecutivos para acionar barreiras de segurança contra ataques de força bruta.

### **Atributo - isBloqueado: boolean**

Histórias Associadas - US27 (RN01) | US33 (RN04)

**Rastreabilidade:** Flag lógica booleana alterada para `true` assim que o contador de `tentativasIncorretas` atinge o limite de 5 tentativas falhas, bloqueando a conta temporariamente por 15 minutos.

### **Método - realizarLogin(credencial: String, senha: String): boolean**

Histórias Associadas - US27 (CA) | US33 (CA / RN02 / RN05)

**Rastreabilidade:** Método responsável por autenticar a sessão do usuário. Ele aceita polimorfismo de credenciais (CPF, e-mail ou telefone), valida a correspondência contra a criptografia do `senhaHash`, inicializa a sessão ativa e redireciona o usuário para o menu correto de acordo com a sua especialização (Idoso, Tutor ou Suporte).

### **Método - realizarLogout(): void**

Histórias Associadas - US33 (CA / RN06)

**Rastreabilidade:** Termina explicitamente a sessão do usuário no aplicativo, invalidando os tokens de autenticação ativos de forma imediata para mitigar acessos não autorizados.

### **Método - registrarTentativaFalha(): void**

Histórias Associadas - US27 (RN01) | US33 (RN04 / RN08)

**Rastreabilidade:** Método protegido invocado internamente quando o `realizarLogin` falha. Ele incrementa o atributo `tentativasIncorretas`, avalia se o limite foi atingido para alternar o estado do `isBloqueado` e dispara a gravação do evento no histórico de auditoria (`LogAuditoria`).

## **Classe - EspecialistaSuporte**:

### **Atributo - codigoSuporte: String**

Histórias Associadas - US09

**Rastreabilidade:** Atende diretamente ao requisito de rastreabilidade e auditoria da **US09**. Este identificador único do especialista é vinculado pelo sistema a todas as consultas, visualizações de tela e exportações disparadas durante a sessão ativa, garantindo a responsabilização pelas ações realizadas.

### **Atributo - perfilAcesso: String**

Histórias Associadas - US09 | US34

**Rastreabilidade:**

 - Na US09, é utilizado para validar o nível de privilégios do funcionário e determinar quais abas e ferramentas avançadas estarão visíveis no painel.
 - Na **US34**, atua como a trava de segurança que verifica se o especialista logado possui os privilégios administrativos necessários ("flag de autorização") para realizar a exportação massiva de dados financeiros.

### **Método - iniciarVisualizacaoTela(usuarioId: int): boolean**

Histórias Associadas - US08

- **Rastreabilidade:** Executa o primeiro critério de aceitação da **US08**, permitindo que o especialista veja a tela do usuário em tempo real para identificar as dificuldades do idoso. O retorno `boolean` indica se o consentimento e a permissão prévia obrigatória foram concedidos pelo usuário antes de abrir a transmissão.

- **Regra de Negócio Vinculada:** O fluxo interno deste método deve acionar o mascaramento automático de campos sensíveis (como saldos e senhas), impedindo que esses dados cheguem ao especialista.

### **Método - exportarExtratoLote(filtros: FiltroExtrato)**

Histórias Associadas - US34

- **Rastreabilidade:** Implementa diretamente o núcleo da **US34**. O método recebe o objeto estruturado `FiltroExtrato` contendo os parâmetros preenchidos na interface (como período, tipo de transação ou status) e processa a geração do relatório em massa.

- **Regra de Negócio Vinculada:** Deve herdar as diretivas de segurança da **US08**, mascarando dados pessoais (como CPF/CNPJ) nos documentos gerados localmente para manter a conformidade com a LGPD.

### **Método - autenticarMFA(): boolean**

Histórias Associadas - US09

- **Rastreabilidade:** Responde ao primeiro critério de aceitação da **US09**, servindo como a barreira de segurança por múltiplos fatores de autenticação obrigatória antes de liberar o painel de suporte.

- **Regra de Negócio Vinculada:** Se o retorno for `false`, o sistema bloqueia a exibição de qualquer dado e registra a tentativa de acesso indevido no servidor de segurança.

### **Método - consultarLogsFalha(usuarioId: int): List**

Histórias Associadas - US08

**Rastreabilidade:** Atende ao critério de aceitação da **US08** que exige que o especialista tenha acesso a um painel mostrando o motivo do erro da última ação do usuário. O método recebe o identificador do idoso e retorna uma lista estruturada de falhas sistêmicas recentes para guiar o suporte humano.

## **Classe - Idoso**:

### **Atributo - isSaldoOcultoPadrao: boolean**

História Associada - US01

**Rastreabilidade:** Atende diretamente à Regra de Negócio da **US01**, que exige que a preferência de "ocultar saldo" seja salva de forma persistente nas configurações de perfil do usuário. Esse atributo armazena o estado booleano que define se o saldo deve ser substituído por asteriscos assim que o aplicativo for inicializado.

### **Atributo - biometriaAtiva: boolean**

Histórias Associadas - US02 | US28 | US30 | US31

**Rastreabilidade:**
- Na **US02**, reflete a Regra de Negócio de que a autenticação biométrica (digital ou facial) só pode ser habilitada se o hardware do dispositivo estiver ativo e configurado.
- Nas **US28**, **US30** e **US31**, funciona como a flag de controle que valida se o usuário possui biometria disponível para realizar as "confirmações de segurança" exigidas ao ativar o modo assistido, remover um tutor ou alterar níveis de privilégios.

### **Método - alternarExibicaoSaldo(): void**

História Associada - US01

**Rastreabilidade:** Executa o comportamento mapeado nos Critérios de Aceitação da **US01**. Este método é invocado ao tocar no botão "Ver Saldo" para revelar os valores e é chamado de forma automatizada pelo ciclo de vida das telas para ocultar o saldo novamente quando o idoso navega para outra seção do aplicativo.

### **Método - gerenciarTutor(acao: TipoAcao, tutorId: int): boolean**

**Histórias Associadas - US29 | US30**

**Rastreabilidade:** Centraliza o gerenciamento de vínculo do responsável de forma polimórfica:
- **US29 (Adicionar Responsável):** Quando o parâmetro `acao` recebe um tipo equivalente a "ADICIONAR", o método processa a validação do convite (via link, QR Code ou código de 6 dígitos) e registra o `tutorId` respeitando a regra de que cada conta só pode ter um responsável vinculado (RN1).
- **US30 (Remover Responsável):** Quando a `acao` recebe o tipo correspondente a "REMOVER", o método revoga imediatamente todas as permissões do tutor e limpa o vínculo do sistema. O retorno `boolean` indica o sucesso da operação após a validação da senha ou biometria do idoso.

### **Método - alterarNivelAcessoTutor(novoNivel: NivelAcesso): void**

**História Associada - US31**

**Rastreabilidade:** Implementa diretamente as regras de transição de permissões da **US31**. O método recebe o objeto configurado de `NivelAcesso` (seja uma predefinição como Acesso Básico ou uma configuração personalizada) e atualiza os privilégios atribuídos ao tutor no sistema, disparando as notificações push ou pop-ups de confirmação exigidas pelos critérios de aceitação.

## Classe - ContatoApoio:

### **Atributo - valorMinimoNotificacao: double**

História Associada - US20

- Rastreabilidade: Atende diretamente aos critérios e regras de negócio da **US20**. Este atributo armazena o valor de corte configurado pelo tutor (variando de R$ 0,00 a R$ 100.000,00) para determinar quais movimentações financeiras do idoso dispararão alertas automáticos para o seu dispositivo.
- Regras de Negócio Rastreadas: 
	- Se o valor contido nesta propriedade for igual a 0.00, a lógica do sistema interpreta as notificações como formalmente desativadas (RN01).
	- A camada de serviço valida se as tentativas de alteração deste atributo permanecem dentro do intervalo permitido pela RN02.
### **Método - emitirAvisoSuspeito(transacaoId: int, desc: String): boolean**

Histórias Associadas - US10 | US20 | US26

- Rastreabilidade: Implementa a funcionalidade central descrita na US26 (e prevista na US20), permitindo ao tutor enviar uma notificação preventiva em tempo real diretamente para o aplicativo do idoso ao notar uma movimentação atípica.
- Comportamento Técnico:
	- O parâmetro `transacaoId` vincula o alerta à transação específica guardada no sistema (atendendo à RN03).
    - O parâmetro `desc` recebe a descrição do motivo ou contexto da suspeita inserido pelo tutor.
    - O retorno `boolean` sinaliza o sucesso do envio e o armazenamento da notificação no histórico cronológico do sistema para que a mensagem de confirmação ("Aviso enviado com sucesso") seja exibida na tela.

### **Método - obterDashboardGastos(periodo: PeriodoFiltro): DashboardDTO**

História Associada - US25

- Rastreabilidade: Entrega as regras estipuladas na US25, que exige um painel gráfico consolidado para monitorar a saúde e o fluxo financeiro da conta supervisionada.
- Comportamento Técnico:
    - O parâmetro periodo (mapeado na classe como a estrutura `PeriodoFiltro`) recebe a seleção dinâmica do usuário (diário, semanal, mensal ou anual), cumprindo a RN02.
    - O método processa o agrupamento dos dados e encapsula o resultado em um Objeto de Transferência de Dados (`DashboardDTO`), garantindo o isolamento de privilégios (RN01) e atualizando os gráficos da tela automaticamente.

## Classe - LogAuditoria:

### **Atributo - id: int**

Histórias Associadas - US09 | US30 | US31 | US33

- Rastreabilidade: Identificador único, sequencial e imutável de cada entrada do log de auditoria, garantindo a integridade referencial dos registros históricos de segurança.

### **Atributo - dataHora: DateTime**

Histórias Associadas - US26 (RN03) | US30 (RN02) | US31 (RN02) | US33 (RN08)

Rastreabilidade: Grava o carimbo de tempo (timestamp) exato da ocorrência. Atende às exigências de armazenar a data e horário em que o tutor enviou um alerta (US26), o idoso removeu um responsável (US30), alterou permissões (US31) ou quando houve uma tentativa de login (US33).

### Atributo - usuarioId: int

Histórias Associadas - US09 | US26 (RN03) | US30 | US31 | US33 (RN08)

Rastreabilidade: Vincula o evento auditado ao seu respectivo autor. Identifica se a ação partiu do identificador do especialista de suporte (US09), do tutor responsável (US26) ou do próprio usuário idoso (US30, US31, US33).

### Atributo - acao: String

Histórias Associadas - US09 | US30 (RN02) | US31 (RN02) | US33 (RN08)

Rastreabilidade: Armazena a descrição textual/mnemônica da operação realizada no sistema. Exemplos práticos mapeados:

- `"LOGIN_FALHO"`, `"CONTA_BLOQUEADA_15MIN"` (**US33** / **US27**).
    - `"RECON_TUTOR_REMOVIDO"` (**US30**).
    - `"PERMISSAO_ALTERADA_MODO_PERSONALIZADO"` (**US31**).
    - `"EXTRATO_LOTE_EXPORTADO"` (**US09** / **US34**).

### Atributo - ipOrigem: String

Histórias Associadas - US09 | US33 (RN05 / RN08)

Rastreabilidade: Guarda o endereço IP do dispositivo que efetuou a requisição. Atende às diretivas de segurança contra acessos não autorizados e ataques maliciosos, permitindo o rastreamento em tentativas de login indevidas no servidor de segurança.

### Atributo - hashArquivo: String

Histórias Associadas - US15 | US34 (RN01)

Rastreabilidade: Atributo de segurança criptográfica (SHA-256 ou similar). Ele registra a assinatura digital dos arquivos gerados pelo sistema, como os PDFs de comprovantes compartilhados (US15) ou os arquivos de extrato gerados em massa pelo suporte (US34), garantindo que os relatórios baixados localmente não sofram adulterações externas.

### Método -  gravarLog(): void

Histórias Associadas - US09 | US27 (RN01) | US30 (RN02) | US31 (RN02) | US33 (RN08)

Rastreabilidade: Método responsável por persistir fisicamente o registro de auditoria no banco de dados ou em arquivos de log protegidos. É invocado de forma automática por interceptadores (triggers/middlewares) do sistema sempre que operações críticas de login, alteração de permissão e exportação financeira são concluídas ou falham.

## Classe - VinculoModoAssistido:

### Atributo - id: int

Histórias Associadas - US29 | US30 | US24

Rastreabilidade: Identificador único da relação de monitoramento ativa entre um idoso e um tutor específico. É o token que valida o "vínculo formalizado e ativo" exigido na RN01 da US24 para permitir a navegação no histórico e serve de referência para a revogação imediata de acesso na US30.

### Atributo - dataCriacao: DateTime

História Associada - US29

Rastreabilidade: Registra o momento exato em que o vínculo foi estabelecido (quando o responsável inseriu com sucesso o link, código ou QR Code gerado pelo idoso). Atende ao critério de inicialização do registro do tutor na aba de modo assistido.

### Atributo - nivelAcessoAtual: NivelAcesso

Histórias Associadas - US29 (RN04) | US31 (CA)

- Rastreabilidade: 
	- Na US29 (RN04), garante a regra de que todo responsável deve iniciar com permissões mínimas padrão (_"Acesso Básico"_) assim que o vínculo é instanciado.
    - Na US31, reflete o estado mutável do nível de privilégios configurado pelo idoso (Básico, Supervisionado, Dependente ou Personalizado), ditando o escopo operacional de leitura do tutor.

### Atributo - inicioSessaoAtual: DateTime

História Associada - US21

Rastreabilidade: Registra o carimbo de data/hora exato em que o tutor entrou no modo de monitoramento (Modo Conta Assistida). Esse atributo é o ponto de partida cronológico para calcular a janela de permanência permitida na interface.

### Método - validarTempoSessao(): boolean`

História Associada - US21

Rastreabilidade: Implementa diretamente o critério de aceitação de controle temporal da US21. O método calcula a diferença entre o horário atual e o `- inicioSessaoAtual`. Se o tempo de navegação contínua do tutor ultrapassar o teto estrito de 15 minutos, o método retorna `false`, sinalizando à interface que o acesso deve ser interrompido e bloqueado preventivamente.

### Método - solicitarRevalidacaoIdoso(): void`

Histórias Associadas - US21 | US22

- Rastreabilidade: Atua como o gatilho de segurança quando os 15 minutos expiram ou quando um novo login é detectado.
    - Na US21, dispara a requisição de novos métodos de autenticação externa para manter o tutor navegando.
    - Na US22, conecta-se à lógica de geração e entrega do link, código numérico ou QR Code que deve chegar ao dispositivo em até 5 segundos para revalidar a sessão.

## Classe - NivelAcesso:

### Atributo - tipoNivelAtual: String

Histórias Associadas - US29 (RN04) | US31 (Critérios de Aceitação)

- **Rastreabilidade:** 
	- Na **US31**, este atributo armazena qual é o modelo de compartilhamento ativo na relação. Os valores possíveis mapeados na história são: `"Acesso Básico"`, `"Acesso Supervisionado"`, `"Acesso Dependente"` e `"Personalizado"`.
    - Na **US29 (RN04)**, serve de salvaguarda para garantir que, assim que um responsável for adicionado pela primeira vez, o sistema grave compulsoriamente o valor `"Acesso Básico"`.

### Atributo - permiteVisualizarDashboards: boolean

História Associada - US25 (RN01) | US31

Rastreabilidade: Atua como a chave de segurança lógica (flag) para a US25. Quando o tutor tenta carregar os gráficos de fluxo de gastos, o sistema consulta essa flag. Ela é alterada dinamicamente pelo idoso através do painel de controle de privacidade da US31.

### Atributo - permiteSinalizarSuspeita: boolean

Histórias Associadas - US20 | US21 | US26 | US31

Rastreabilidade: Controla o privilégio operacional do tutor de emitir avisos. Se estiver ativada, permite a execução das ações descritas nas histórias US20 e US26 (enviar notificações em tempo real de transações fora do padrão para o aparelho do idoso).

### Atributo - permiteVerDadosDestinatario: boolean

História Associada - US23 (RN02) | US31

Rastreabilidade: Trava de segurança para a exibição de dados de terceiros. Valida se o tutor tem a permissão de leitura concedida para abrir a tela que detalha o nome do destinatário, valor, data e hora da transação financeira (US23).

### Atributo - permiteVisualizarHistorico: boolean

História Associada - US24 | US31

Rastreabilidade: 
- Nota: Embora no diagrama este item apareça visualmente na divisória inferior, o prefixo menos (`-`) e o tipo `boolean` o caracterizam como o atributo que guarda a permissão de acesso ao histórico. Ele habilita ou bloqueia o direito de o tutor navegar cronologicamente e aplicar filtros (por mês, dia ou data) no extrato do idoso (US24).

### Método - aplicarModoPredefinido(modo: String): void

Histórias Associadas - US29 (RN04) | US31 (Critérios de Aceitação)

Rastreabilidade:
- Facilita a usabilidade do idoso ao empacotar as permissões booleanas. Ao receber os textos `"Acesso Básico"`, `"Acesso Supervisionado"` ou `"Acesso Dependente"`, o método altera em bloco todas as chaves privadas anteriores para um estado padrão pré-definido.
- É o método invocado no primeiro vínculo da US29 para forçar o nível básico.

### Método - configurarPermissaoManual(permissao: String, valor: boolean): boolean

História Associada - US31 (Critérios de Aceitação)

Rastreabilidade: Atende diretamente ao requisito de customização da US31, permitindo que o idoso configure as permissões manualmente (ativando ou desativando flags de forma isolada) quando o `tipoNivelAtual` for definido como `"Personalizado"`. O método também garante que cada modificação exiba sua respectiva "descrição clara e objetiva".

### Método - verificarRestricoes(permissaoCritica: String): boolean

História Associada - US31 (RN1)

Rastreabilidade: Implementa de forma robusta a Regra de Negócio 1 da US31. Este método funciona como uma barreira rígida no código de segurança: se a interface ou um usuário malicioso tentar injetar uma permissão de alteração cadastral ou financeira para o tutor (como _"alterar CPF"_, _"alterar senha"_, _"excluir chaves PIX"_ ou _"encerrar conta"_), o método intercepta o pedido, recusa a alteração e retorna `false`.

## Classe - Contato:

### Atributo - id: int

Histórias Associadas - US11 | US12 | US16

Rastreabilidade: Identificador único do registro do contato na base de dados do usuário. É a chave primária que permite vincular o recebedor frequente à lista de contatos guardados e serve de referência para o cruzamento cronológico do extrato.

### Atributo - nomeCompleto: String

Histórias Associadas - US05 | US11 | US12 | US16 | US23

Rastreabilidade:
	- Na US05, alimenta a tela de confirmação de transferência com letras em destaque (negrito e fonte mínima de 20pt) para evitar erros operacionais.
    - Na US12, é o campo textual pesquisado e filtrado em tempo real quando o idoso utiliza a barra de busca ("Buscar por nome").
    - Na US23, permite ao tutor ler o nome do destinatário que receberá o dinheiro para checar a segurança da transação.

### Atributo - cpfParcial: String

Histórias Associadas - US05 | US16 | US23 (RN01)

Rastreabilidade: Atributo concebido especificamente para atender às regras de privacidade e conformidade com a LGPD. Em vez de armazenar ou expor o documento completo em interfaces comuns, ele guarda ou mascara o registro exibindo apenas "parte do CPF" para a conferência visual do idoso (US05) e do tutor (US23), ocultando caracteres intermediários com asteriscos.

### Atributo - apelido: String

Histórias Associadas - US11 | US12 | US16

Rastreabilidade:
- Na US11, cumpre o critério de aceitação de atribuir um nome simples e familiar ao recebedor para encurtar o esforço cognitivo do idoso.
- Na US16, funciona como o "nome amigável" exibido em total destaque na lista de últimas transações para que o usuário identifique imediatamente onde gastou o dinheiro, sem se confundir com razões sociais complexas.

### Atributo - chavePix: String

História Associada - US11 (Regra de Negócio)

- Rastreabilidade: Armazena o identificador financeiro do contato (como e-mail, telefone ou chave aleatória). A regra de negócio da US11 exige que o sistema consulte essa propriedade para verificar se a chave Pix já existe na lista de contatos antes de oferecer o botão de salvar o registro.

### Atributo - isFavorito: boolean

História Associada - US11

Rastreabilidade: Flag booleana que controla o agrupamento visual na interface. Quando definida como `true`, faz com que o contato seja exibido diretamente na seção de "Favoritos" ou "Recentes" na tela inicial de transferências, eliminando a necessidade de redigitação ou buscas profundas.

### Método - atualizarApelido(novoApelido: String): void`

História Associada - US11

Rastreabilidade: Método responsável por dar autonomia ao usuário idoso para modificar, ajustar ou corrigir o nome amigável associado àquele contato. Garante que a atribuição do apelido possa ser refinada a qualquer momento do ciclo de vida do aplicativo, atualizando as exibições dependentes no extrato e nas buscas.

## Classe - ContaBancaria:

### Atributo - numeroConta: String

Histórias Associadas - US32

Rastreabilidade: Identificador público da conta digital gerado automaticamente após a conclusão e validação do cadastro do usuário idoso (US32), formalizando a criação da sua conta bancária digital.

### Atributo - saldo: double

Histórias Associadas - US01 | US07 (RN01)

Rastreabilidade:
- Na US01, serve de modelo de dados para a interface que precisa mascarar este valor por padrão (substituindo por asteriscos) para preservar a privacidade do idoso em locais públicos.
- Na US07 (RN01), é o valor consultado em tempo real pelo sistema para validar se a quantia do Pix digitada é inferior ou igual aos fundos disponíveis em conta.

### Atributo - limiteDiarioAtual: double

Histórias Associadas - US03 | US07 (RN01)

Rastreabilidade:
- Na US03, armazena o valor do teto financeiro máximo que o idoso pode movimentar em um único dia para mitigar riscos de fraudes ou erros operacionais.
- Na US07 (RN01), atua como barreira lógica junto com o saldo: o botão de confirmar o Pix só é habilitado se o valor digitado for inferior ou igual ao menor dos dois valores (saldo ou limite diário disponível).

### Atributo - limiteDiarioPendente: double

História Associada - US03

Rastreabilidade: Atende diretamente ao critério de aprovação temporal da US03. Quando o idoso solicita um aumento de limite, o novo valor não entra em vigor imediatamente; ele fica retido nesta propriedade como um estado "pendente" enquanto a janela de segurança corre.

### Atributo - dataHoraSolicitacaoLimite: DateTime

História Associada - US03

Rastreabilidade: Registra o carimbo de data e hora exato em que o idoso solicitou a alteração do limite para cima. Esse atributo é indispensável para que o sistema calcule se o prazo regulamentar exigido de 24h a 48h (conforme normas antifraude do BACEN) já foi cumprido antes de migrar o valor do `limiteDiarioPendente` para o `limiteDiarioAtual`.

### Método - verificarDisponibilidadeTransacao(valor: double)

Histórias Associadas - US07 (RN01)

Rastreabilidade: Método responsável por executar a regra de validação pré-venda. Ele recebe a quantia do Pix digitada no teclado numérico ampliado e computa uma verificação lógica: o valor deve ser maior que R$ 0,00, menor ou igual ao `saldo` e menor ou igual ao `limiteDiarioAtual` disponível no dia. Se falhar, o sistema bloqueia o avanço e exibe a mensagem de erro em vermelho.

### Método - atualizarLimite(novoValor: double): void

Histórias Associadas: US03, US21 (CA), US31 (RN1)

Rastreabilidade:
- Na US03, implementa a inteligência de divisão de fluxos: se o `novoValor` for uma redução, a propriedade `limiteDiarioAtual` é atualizada instantaneamente. Se for um aumento, o método desvia o montante para o `limiteDiarioPendente` e carimba a `dataHoraSolicitacaoLimite`.
- Nas US21 e US31, o sistema garante que este método sofra restrição de escopo ("Acesso Somente Leitura" do Tutor), bloqueando qualquer tentativa de execução ou alteração de limites por parte do responsável cadastrado.

## Classe - TransacaoPix

### Atributo - id: int

Histórias Associadas - US16 | US24 | US26 | US34

Rastreabilidade: Identificador único da transação gerado após a persistência no banco de dados. É indispensável para indexar o histórico cronológico de movimentações (US16, US24), vincular alertas específicos de fraude enviados pelo tutor (US26) e permitir a identificação unívoca de registros em auditorias em lote (US34).

### Atributo - valor: double

Histórias Associadas - US07 (RN) | US13 | US15 | US20 | US23 | US25 | US34

Rastreabilidade:
- Na US07, passa pela validação que bloqueia o avanço caso ultrapasse o limite diário ou o saldo em conta.
- Nas US13 e US15, é exibido em destaque (mínimo 20px) no comprovante final e na exportação do PDF.
- Na US20, é comparado com o teto configurado pelo tutor para disparar notificações.
- Nas US23, US25 e US34, serve de base para detalhamento de transações, alimentação de dashboards de fluxo de gastos e filtros de extrato em lote.


### Atributo - dataHora: DateTime

Histórias Associadas - US13 | US15 | US16 | US23 | US24 | US25 | US26 | US34

Rastreabilidade: Carimbo de tempo que registra o momento exato da operação. Alimenta os dados de exibição do comprovante (US13, US15), a ordenação cronológica dos extratos de visualização do idoso (US16) e do tutor (US24), os agrupamentos temporais dos dashboards (US25), o log do histórico de avisos suspeitos (US26) e os filtros de período das auditorias em massa (US34).

### Atributo - chavePixDestino: String

Histórias Associadas - US05 | US11 (RN) | US16 (RN) | US20 (RN03) | US23 (RN01)

Rastreabilidade:
- Na US05, dispara a consulta em tempo real ao DICT (Diretório de Identificadores de Contas Transacionais).
- Na US11, é consultada para verificar duplicidade antes de salvar um contato favorito.
- Na US16, é cruzada com a lista de contatos para substituir a razão social pelo apelido amigável.
- Nas US20 e US23, sofre aplicação estrita de máscaras de privacidade (censura por asteriscos) antes de ser exibida na interface do tutor, atendendo às diretivas da LGPD.

### Atributo - status: StatusTransacao

Histórias Associadas - US15 | US16 | US26 | US34

Rastreabilidade: Atributo complexo que dita o ciclo de vida da operação (ex: _Confirmada_, _Cancelada_, _Bloqueada_). Garante que apenas transações com sucesso gerem comprovantes compartilháveis (US15), mapeia o status atual no histórico de alertas (US26) e serve como parâmetro dinâmico para filtragem de falhas sistêmicas por especialistas de suporte (US34).


### Atributo - scoreRisco: NivelRisco

Histórias Associadas - US14 | US20 | US24 | US26

Rastreabilidade: Armazena o resultado da avaliação de segurança. Se o valor apontar para um nível elevado ou _"Crítico"_, o sistema dispara as telas de interrupção visual (pop-up amarelo) ou o bloqueio definitivo do Pix (US14). Também é o gatilho que destaca a movimentação como "Atividade Suspeita" na tela do tutor (US24) e permite a sinalização preventiva de golpes (US20, US26).

### Método - executarAnaliseRisco(): NivelRisco

Histórias Associadas - US14 (CA / RN) | US20 | US24

Rastreabilidade: Método crítico invocado obrigatoriamente pela camada de negócio antes da solicitação da senha. Ele realiza chamadas assíncronas em tempo real ao motor antifraude corporativo e às APIs do Banco Central (US14). O objeto `NivelRisco` retornado por essa função dita de forma automatizada se o fluxo deve sofrer uma pausa forçada de 5 segundos, exibir um alerta humanizado ou ser abortado sumariamente por risco crítico de fraude.

## Classe - StatusTransacao

### Atributo - codigoStatus: int

Histórias Associadas - US15 | US26 | US34

Rastreabilidade: Identificador numérico interno correspondente a cada estado lógico no ciclo de vida da transação. Garante a indexação estável de transações bem-sucedidas prontas para compartilhamento, o rastreio de avisos disparados e o agrupamento em rotinas automáticas de auditoria.

### Atributo - nomeEstado: String

Histórias Associadas - US07 | US13 | US14 | US15 | US26

Rastreabilidade: Armazena a descrição textual legível do estado atual da transação. Esta propriedade assume os valores lógicos mapeados diretamente pelos fluxos das histórias de usuário:

- `"Confirmada"` / `"Sucesso"`: Acionada após o processamento correto, viabilizando a exibição e o envio do recibo final com fonte ampliada.
- `"Cancelada"`: Definida caso o usuário clique na opção segura "Quero Cancelar" no pop-up de alerta de golpe.
- `"Bloqueada"`: Configurada preventivamente se o valor digitado exceder os limites permitidos no dia ou se o motor de segurança retornar um score de risco fraudulento classificado como "Crítico".

### Atributo - permiteVisualizacaoContatoApoio: boolean

Histórias Associadas - US21 (RN01) | US23 (RN02) | US24

Rastreabilidade: Atua como a flag de conformidade e governança de privacidade de dados exigida no aplicativo.

- Na US21 (RN01), ela assegura que informações ou dados sensíveis fiquem protegidos de acordo com as diretrizes da LGPD.
- Na US23 (RN02), restringe o escopo de monitoramento do tutor estritamente ao acesso de "Somente Leitura" de transações.
- Na US24, concede ou nega permissão para que o tutor possa navegar e inspecionar cronologicamente os estados das transações efetuadas pelo idoso.

### Método - determinarEstadoFinal(): String`

Histórias Associadas - US13 | US15 | US26

Rastreabilidade: Resolve e retorna o status terminal consolidado da transferência para exibição em interfaces adaptadas. Esse método garante que o texto final formatado seja incorporado no arquivo de comprovante em alta resolução para compartilhamento e alimente corretamente o histórico de status de alertas visível tanto para o idoso quanto para o tutor.

### Método - Filtravel(): boolean`

Histórias Associadas - US24 | US34

Rastreabilidade: Retorna uma flag booleana indicando se o status em questão é elegível para participar de consultas parametrizadas.

- Apoia diretamente a US34 ao permitir que a interface de suporte administrativo inclua ou exclua determinados estados (como transações falhas ou bem-sucedidas) na montagem do objeto de parâmetros `FiltroExtrato`.
- Atende à US24, viabilizando que o tutor isole movimentações específicas ao filtrar o histórico de atividades do idoso.

## Classe - NivelRisco:

### Atributo - classificacao: String

Histórias Associadas - US14 | US20 | US24 | US26

Rastreabilidade:
- Armazena o nível final do score de risco obtido em tempo real através da API do Banco Central ou do motor antifraude (ex: `"Normal"`, `"Suspeito"` ou `"Crítico"`).
- Vínculo com o Requisito: Na US14, define se a transação sofrerá uma interrupção visual ou um bloqueio sumário. Nas histórias do ecossistema do tutor (US20, US24, US26), funciona como a flag que identifica uma "atividade fora do padrão" para gerar alertas ou destaques visíveis no histórico de monitoramento.

### Atributo - mensagemHumana: String

História Associada - US14

Rastreabilidade: Atende diretamente à regra de negócio de "Linguagem Acessível" da US14. Esta propriedade armazena textos preventivos limpos de jargões técnicos (ex: _"Atenção: Esta conta recebeu avisos de outros usuários recentemente. Tem certeza que conhece essa pessoa?"_), garantindo uma comunicação acolhedora para o usuário idoso.

### Atributo - tempoPausaForcada: int

História Associada - US14

Rastreabilidade: Alimenta o "Mecanismo de Pausa Forçada" descrito na US14. Guarda o valor inteiro estrito de `5` segundos necessário para reter o avanço do usuário na tela de alerta, forçando um momento de leitura preventiva antes de liberar os campos de autenticação.

### Método - requerInterrupcaoVisual(): boolean

História Associada - US14

Rastreabilidade: Avalia o estado do atributo `classificacao`. Se o risco for categorizado como "Suspeito", o método retorna `true`, servindo de gatilho para a interface abrir o pop-up de tela cheia com fundo amarelo-alerta e destacar os botões de ação recomendada ("Quero Cancelar").

### Método - aplicarBloqueioDefinitivo(): boolean

História Associada - US14

Rastreabilidade: Executa a regra de segurança máxima da US14. Caso a transação possua uma `classificacao` de risco classificada como "Crítico" (inserida em listas pretas oficiais), o método retorna `true` para abortar a transferência imediatamente, suprimindo qualquer opção de continuidade e instruindo o idoso a recorrer ao suporte.

### Método - obterTempoRegressivo(): int

História Associada - US14

Rastreabilidade: Controla e decrementa o cronômetro regressivo baseado na propriedade `tempoPausaForcada`. Ele retorna o tempo restante em tempo real para atualizar o contador visual da interface e, ao zerar, concede a liberação do campo de digitação de senha.
