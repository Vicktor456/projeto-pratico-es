# Diagrama de Classe

O **Diagrama de Código** representa o quarto e último nível (Nível 4) do Modelo C4, entregando uma visão microscópica e de baixo nível sobre como um componente específico é estruturado internamente. Ele detalha os elementos reais de implementação — como classes, interfaces, objetos, funções e suas relações de dependência ou herança —, assemelhando-se diretamente a um clássico Diagrama de Classes da UML ou a um diagrama de entidades.

## Visão Geral do Diagrama

<img width="4608" height="2624" alt="image" src="https://github.com/user-attachments/assets/61df6899-990c-4ff6-aea0-5851e0d22204" />

O diagrama de classes do nível de código do ecossistema **SeuPix** apresenta de forma unificada a estrutura de objetos e as relações essenciais projetadas para viabilizar uma experiência bancária digital totalmente inclusiva, acessível e segura. A arquitetura conecta de maneira fluida a gestão de credenciais e diferentes perfis de usuários — como o idoso, seu contato de apoio (tutor) e a equipe de suporte — às engrenagens do núcleo financeiro e ao motor automatizado de análise de risco, garantindo que a flexibilidade operacional do monitoramento temporário caminhe lado a lado com mecanismos rígidos de auditoria, conformidade com a LGPD e regras regulamentares de controle de limites impostas pelo Banco Central.

## Detalhamento por partes

### Classe Usuário: 

<img width="1493" height="1041" alt="image" src="https://github.com/user-attachments/assets/3397885e-05a8-483b-8e49-c3b63ed9bb66" />

A classe Usuario, funciona como a estrutura base centralizadora de identidade e segurança do ecossistema SeuPix, mapeando os atributos cadastrais essenciais dos indivíduos através de propriedades privadas como id, nome, cpf, email e telefone. Além de gerenciar esses dados fundamentais, ela assume o papel crítico de blindar os acessos à plataforma por meio do atributo senhaHash, que evita o armazenamento de credenciais em texto puro, e dos controles de defesa contra força bruta, representados por tentativasIncorretas e isBloqueado. Esse mecanismo de segurança opera de forma totalmente integrada aos comportamentos da classe, onde as rotinas públicas + realizarLogin() e + realizarLogout() ditam o ciclo das sessões ativas no aplicativo, enquanto o método protegido # registrarTentativaFalha() atualiza o estado de restrição da conta de maneira automatizada em caso de sucessivas falhas de autenticação.

### Classe Idoso:

<img width="1577" height="801" alt="image" src="https://github.com/user-attachments/assets/9d489d7f-2d8e-42e2-b738-c3ad18fa15ab" />

A classe Idoso, atua como uma especialização fundamental do usuário final no ecossistema SeuPix, customizada especificamente para mediar a autonomia, acessibilidade e privacidade do público da terceira idade. A estrutura armazena preferências essenciais de interface por meio dos atributos privados - isSaldoOcultoPadrao, que define a ocultação automática do saldo em locais públicos para preservar a discrição visual, e - biometriaAtiva, que gerencia o uso de biometria nativa para simplificar o login e validar confirmações críticas de segurança. Seus comportamentos públicos estendem essas salvaguardas de forma direta: o método + alternarExibicaoSaldo() controla a revelação ou ocultação sob demanda dos valores em conta, enquanto as rotinas + gerenciarTutor() e + alterarNivelAcessoTutor() garantem a soberania total do idoso sobre seu vínculo assistencial, permitindo vincular, remover ou alterar o nível de privilégios de leitura do seu responsável de confiança a qualquer momento.

### Classe ContatoApoio:

<img width="1659" height="471" alt="image" src="https://github.com/user-attachments/assets/851dc0e6-7fe1-4b72-a1a0-4690f71528a1" />

A classe ContatoApoio representa o perfil do tutor de confiança dentro do ecossistema SeuPix, cuja função principal é auxiliar no monitoramento e na segurança preventiva da conta do idoso vinculado. Seu único atributo privado, - valorMinimoNotificacao, armazena o valor de corte financeiro configurado pelo responsável para estipular a partir de qual quantia o sistema deve disparar alertas automatizados de movimentações em seu dispositivo. No escopo de seus comportamentos, o método público + emitirAvisoSuspeito() viabiliza o envio manual de notificações de transações atípicas diretamente para o aplicativo do idoso, vinculando o alerta ao identificador da operação e a uma descrição do contexto, enquanto a rotina + obterDashboardGastos() recebe um filtro temporal específico para processar e retornar um objeto de dados estruturado (DashboardDTO), alimentando os gráficos informativos sobre o fluxo de despesas consultadas sem comprometer a titularidade ou a privacidade do usuário assistido.

### Classe EspecialistaSuporte:

<img width="1428" height="799" alt="image" src="https://github.com/user-attachments/assets/1059e490-e43a-447a-991f-86ac99691f49" />

A classe EspecialistaSuporte, encapsula as ferramentas operacionais e administrativas concedidas à equipe de atendimento interno do SeuPix para prover um suporte humanizado, guiado e seguro ao usuário final. Estruturada com os atributos privados - codigoSuporte e - perfilAcesso, ela garante a completa rastreabilidade de todas as consultas na plataforma para fins de auditoria e dita o nível de privilégio do funcionário na execução de tarefas do sistema. Seus comportamentos públicos respondem diretamente a requisitos rigorosos de segurança e acessibilidade: o método + autenticarMFA() estabelece uma barreira de login por múltiplos fatores antes de liberar o painel de atendimento; + iniciarVisualizacaoTela() viabiliza o espelhamento consentido e mascarado da tela do idoso para auxiliá-lo remotamente; + consultarLogsFalha() extrai diagnósticos precisos sobre erros operacionais recentes; e a rotina + exportarExtratoLote() concede a funcionários autorizados o poder de realizar a extração massiva de relatórios financeiros filtrados por meio do objeto FiltroExtrato, consolidando a proteção de dados e a eficiência regulatória do ecossistema.

### Classe LogAuditoria:

<img width="910" height="910" alt="image" src="https://github.com/user-attachments/assets/71bda428-968c-45e2-b366-451bb2cd8351" />

A classe LogAuditoria atua como um componente transversal de segurança e conformidade legal no ecossistema SeuPix, sendo responsável por registrar de forma imutável todas as operações críticas e eventos de autenticação realizados na plataforma. A estrutura armazena dados detalhados por meio de atributos privados, incluindo o identificador único da entrada (- id), o carimbo de tempo preciso da ocorrência (- dataHora), o identificador do autor da ação (- usuarioId), a descrição textual da operação executada (- acao), além do endereço de rede do dispositivo (- ipOrigem) e a assinatura digital de arquivos exportados (- hashArquivo), que assegura a integridade de relatórios e comprovantes locais contra adulterações externas. Toda essa massa de dados de auditoria é persistida fisicamente na base de segurança por meio do comportamento público + gravarLog(), um método invocado de maneira automatizada pelo sistema sempre que rotinas sensíveis de login, movimentações financeiras ou alterações de permissões são concluídas ou falham, garantindo a rastreabilidade completa e o não-repúdio das operações de acordo com as diretrizes da LGPD e normas regulatórias.

### Classe ContaBancaria:

<img width="1606" height="876" alt="image" src="https://github.com/user-attachments/assets/2cc7f665-33c0-4b5b-a612-cd3b97c34de6" />

A classe ContaBancaria, centraliza a gestão dos fundos financeiros e o cumprimento das diretivas regulatórias essenciais da conta digital do usuário idoso no ecossistema SeuPix. Estruturada com os atributos privados - numeroConta e - saldo, ela mantém o estado financeiro sob controle, enquanto as propriedades - limiteDiarioAtual, - limiteDiarioPendente e - dataHoraSolicitacaoLimite implementam de forma robusta as travas temporárias e regras antifraude do Banco Central para mitigar golpes de engenharia social através de uma janela de segurança (de 24h a 48h) para aumentos de limite. A integridade das movimentações é assegurada por seus comportamentos ativos, onde o método + verificarDisponibilidadeTransacao() valida em tempo real se o valor digitado respeita os tetos disponíveis e os fundos em conta antes de permitir a digitação da senha, e a rotina + atualizarLimite() processa reduções imediatas ou barra alterações operacionais por parte do tutor em modo de somente leitura, blindando por completo a autonomia financeira do titular.

### Classe TransaçãoPix:

<img width="1121" height="841" alt="image" src="https://github.com/user-attachments/assets/69903304-799e-476b-b3ef-64827d566e7e" />

A classe TransacaoPix, atua como o núcleo operacional e de segurança financeira do ecossistema SeuPix, sendo responsável por governar o ciclo de vida e a integridade de cada transferência realizada. Ela armazena informações essenciais por meio de atributos privados como o identificador único (- id), a quantia (- valor), o registro cronológico (- dataHora) e a - chavePixDestino do recebedor — fundamentais para a validação de limites diários, geração de comprovantes e aplicação de máscaras de privacidade em conformidade com a LGPD —, além de gerenciar seu estado de processamento e segurança através das propriedades associadas - status e - scoreRisco. O grande diferencial de seu comportamento reside no método público + executarAnaliseRisco(), uma rotina preventiva acionada em tempo real antes da digitação da senha que consulta os motores de segurança para classificar a movimentação, servindo como o gatilho automático que determina se o fluxo deve sofrer uma de pausa forçada de 5 segundos para leitura de alertas, ser abortado sumariamente por ameaça crítica de golpe ou ser confirmado com sucesso para o usuário.

### Classe StatusTransação:

<img width="1322" height="702" alt="image" src="https://github.com/user-attachments/assets/f6b352f2-dc30-4799-8f73-763d76bb02c6" />

A classe StatusTransacao é responsável por gerenciar os diferentes estágios operacionais e lógicos pelos quais uma movimentação financeira passa dentro do ecossistema SeuPix, mapeando se a transferência foi confirmada com sucesso, cancelada pelo usuário diante de avisos ou preventivamente bloqueada por estouro de limites ou risco de fraude. A estrutura armazena dados essenciais por meio de atributos privados como o - codigoStatus, o - nomeEstado — que reflete diretamente o fluxo das ações tomadas nas interfaces do idoso — e a flag booleana - permiteVisualizacaoContatoApoio, uma trava fundamental de governança e conformidade com a LGPD que restringe e isola a visibilidade de informações sensíveis para o tutor em modo de somente leitura. Seus comportamentos públicos consolidam essa inteligência de negócio de forma dinâmica: o método + determinarEstadoFinal() resolve o status terminal para exibição clara e legível em comprovantes adaptados ou históricos de alertas, enquanto a rotina + Filtravel() valida se o estado atual da transação é elegível para consultas parametrizadas, viabilizando que o tutor filtre movimentações no histórico de atividades ou que o especialista de suporte aplique filtros dinâmicos para auditorias de extrato em lote.

### Classe NivelRisco:

<img width="1171" height="783" alt="image" src="https://github.com/user-attachments/assets/50a35397-9c98-4efb-97bd-7d214cde09ee" />

A classe NivelRisco, compõe a inteligência preventiva do motor antifraude do ecossistema SeuPix, mapeando o score de risco das movimentações para fornecer uma camada extra de proteção adaptada à vulnerabilidade do usuário idoso. Sua estrutura é sustentada pelos atributos privados - classificacao, que categoriza a ameaça detectada pelas consultas em tempo real (como normal, suspeito ou crítico), - mensagemHumana, que traduz jargões técnicos em alertas acolhedores de fácil compreensão, e - tempoPausaForcada, responsável por parametrizar o cronômetro regulamentar de retenção da tela. Esses dados se integram de forma direta aos comportamentos da classe, nos quais o método + requerInterrupcaoVisual() dispara o pop-up de tela cheia com fundo amarelo ao identificar operações atípicas, a rotina + aplicarBloqueioDefinitivo() veda sumariamente o avanço de transferências para chaves com score crítico de fraude, e a função + obterTempoRegressivo() gerencia a contagem regressiva de cinco segundos obrigatória para leitura dos avisos, forçando um momento de reflexão preventiva antes de liberar a digitação da senha.

### Classe Contato:

<img width="1319" height="815" alt="image" src="https://github.com/user-attachments/assets/32c12561-afde-46a5-90e7-f109d8d7a0fa" />

A classe Contato gerencia a rede de recebedores frequentes do usuário idoso no ecossistema SeuPix, sendo projetada especificamente para reduzir o esforço cognitivo e evitar falhas operacionais durante as transferências. Ela armazena os dados essenciais do destinatário por meio de atributos privados como o - id, o - nomeCompleto, a - chavePix (usada para validar duplicidades antes do salvamento) e a flag - isFavorito, que dita o agrupamento visual prioritário do contato na tela inicial do aplicativo. Além disso, a classe incorpora o atributo - cpfParcial para mascarar o documento com asteriscos em conformidade com a LGPD e a propriedade - apelido para atribuir identificações familiares e amigáveis aos contatos. Esse ecossistema é suportado pelo comportamento público + atualizarApelido(), um método que confere total autonomia ao idoso para modificar ou ajustar o nome amigável do recebedor a qualquer momento, atualizando de forma dinâmica o histórico e as buscas do sistema.

### Classe VinculoModoAssistido:

<img width="1447" height="743" alt="image" src="https://github.com/user-attachments/assets/c01dc801-ace0-4648-adac-01a9909f88b7" />

A classe VinculoModoAssistido, gerencia formalmente a relação de monitoramento ativa entre o usuário idoso e seu tutor de confiança dentro do ecossistema SeuPix. Sua estrutura é composta pelos atributos privados - id, que atua como o identificador unívoco do vínculo ativo, - dataCriacao, que registra o momento exato em que a conexão foi estabelecida no aplicativo, - nivelAcessoAtual, que dita o escopo e os privilégios operacionais de leitura atribuídos ao responsável, e - inicioSessaoAtual, que carimba o horário de entrada do tutor no modo de conta assistida. Esse controle de governança e privacidade é diretamente assegurado por seus métodos públicos, nos quais a rotina + validarTempoSessao() computa o tempo de navegação contínua e interrompe o acesso caso ele ultrapasse o teto estrito de 15 minutos, funcionando em conjunto com o método + solicitarRevalidacaoIdoso() (grafado no diagrama como solicitarRevalidacaoldoso), que serve como o gatilho automático de segurança para exigir uma nova autenticação externa ou código temporário para revalidar a sessão do tutor.

### Classe NivelAcesso:

<img width="2098" height="849" alt="image" src="https://github.com/user-attachments/assets/702cf2ba-8c14-44b2-bf55-89439073c4f1" />

A classe NivelAcesso funciona como o núcleo de governança, privacidade e controle de privilégios do ecossistema SeuPix, sendo responsável por ditar com precisão o escopo visual e operacional que o tutor possui ao acessar a conta do usuário idoso. A estrutura mapeia o modelo de compartilhamento e suas restrições através de atributos privados como o - tipoNivelAtual (que assume categorias predefinidas como "Acesso Básico", "Supervisionado" ou "Dependente") e por chaves lógicas booleanas que habilitam ou barram o acesso a recursos específicos, como - permiteVisualizarDashboards, - permiteSinalizarSuspeita, - permiteVerDadosDestinatario e - permiteVisualizarHistorico, assegurando a conformidade com a LGPD e o isolamento de dados sensíveis. Essa inteligência de autorização é diretamente suportada por seus comportamentos públicos, onde o método + aplicarModoPredefinido() altera as chaves em bloco para simplificar a usabilidade, a rotina + configurarPermissaoManual() confere autonomia para o idoso customizar as flags individualmente no modo personalizado, e a função + verificarRestricoes() atua como uma barreira de segurança rígida que intercepta e rejeita de forma automatizada qualquer tentativa de conceder poderes críticos e administrativos ao responsável, como a alteração de senhas, exclusão de chaves Pix ou modificação de dados cadastrais do titular.
