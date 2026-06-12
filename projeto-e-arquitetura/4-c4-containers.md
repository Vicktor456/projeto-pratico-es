# Diagrama de Container
O Diagrama de Containers apresenta uma visão geral da arquitetura do SeuPix baseada em microserviços, demonstrando como os diferentes perfis de usuários interagem com o sistema por meio de aplicações específicas que se comunicam com o backend através de um API Gateway. A arquitetura é composta por serviços independentes responsáveis por funcionalidades como autenticação, gerenciamento de usuários, conta assistida, permissões, transações PIX, notificações e segurança antifraude, promovendo modularidade e escalabilidade. Além disso, o sistema integra-se a componentes de infraestrutura, como serviços de nuvem, mensageria e biometria, e a sistemas externos responsáveis pelo processamento de transações, autenticação, envio de notificações e análise antifraude. Essa organização permite que os serviços atuem de forma desacoplada, facilitando a manutenção, a evolução da aplicação e a implementação de uma solução segura e acessível para usuários idosos.


### Personas, Interface e API Gateway

<img width="2482" height="1704" alt="image" src="https://github.com/user-attachments/assets/e724d98c-b8bd-40e9-9510-59865e0e0091" />

A camada superior do diagrama representa os diferentes perfis de usuários do sistema SeuPix e suas respectivas interfaces de acesso. Embora cada perfil possua funcionalidades específicas de acordo com suas responsabilidades, todos utilizam aplicações dedicadas que foram projetadas para atender suas necessidades de interação com a plataforma.
As interfaces funcionam como a camada de apresentação do sistema, sendo responsáveis por receber as ações dos usuários e encaminhá-las para o backend. Essa separação permite que cada perfil tenha uma experiência adequada ao seu contexto de uso, sem alterar a lógica de negócio implementada nos serviços internos.
Todas as aplicações se comunicam com o sistema por meio do API Gateway & Core Backend, que atua como ponto central de entrada das requisições. Essa camada é responsável por receber, validar e direcionar as solicitações para os microserviços apropriados, além de consolidar as respostas retornadas ao usuário.
A utilização de um ponto único de comunicação reduz o acoplamento entre as interfaces e os serviços internos, facilitando a manutenção da arquitetura, a aplicação de mecanismos de segurança e a evolução independente dos microserviços sem impactar diretamente as aplicações utilizadas pelos diferentes perfis de usuários.

### Domínio de Microsserviços

<img width="9004" height="4772" alt="image" src="https://github.com/user-attachments/assets/410c6e6a-0001-4980-9832-b8d858187a61" />


O API Gateway & Core Backend atua como ponto central de comunicação entre as aplicações do SeuPix e o domínio de microserviços. Sua função é receber as requisições dos usuários, realizar validações iniciais e encaminhá-las para o serviço responsável por processar cada funcionalidade, simplificando a comunicação e reduzindo o acoplamento entre os componentes do sistema.
O domínio de microserviços reúne os principais serviços responsáveis pelas funcionalidades do SeuPix, cada um especializado em uma área específica do negócio. Entre eles estão os serviços de gerenciamento de usuários, autenticação, conta assistida, permissões, transações PIX, segurança antifraude e notificações. Essa divisão permite que os serviços sejam desenvolvidos e mantidos de forma independente, promovendo maior escalabilidade, organização e facilidade de evolução da aplicação.
Além disso, cada microserviço possui seu próprio banco de dados, garantindo autonomia no gerenciamento das informações e reduzindo dependências entre os componentes. Essa abordagem fortalece a arquitetura de microserviços e contribui para a construção de um sistema mais robusto, seguro e de fácil manutenção.

### API's
#### API Usuário

A **API Usuário** é responsável pelo gerenciamento dos dados cadastrais dos usuários do sistema, como informações pessoais, contato e configurações da conta. Sua importância está em centralizar todas as informações necessárias para identificação dos usuários e funcionamento das demais funcionalidades da plataforma.

---

#### API Autenticação

A **API Autenticação** gerencia os processos de login, validação de credenciais e controle de acesso ao sistema. Ela garante que apenas usuários autorizados possam acessar suas contas, contribuindo diretamente para a segurança da aplicação.

---

#### API Conta Assistida

A **API Conta Assistida** é responsável pelas funcionalidades que permitem vincular um responsável ao usuário idoso. Ela gerencia o relacionamento entre as contas, possibilitando recursos de supervisão, acompanhamento e auxílio financeiro de acordo com as permissões definidas pelo titular.

---

#### API Permissões

A **API Permissões** controla os níveis de acesso concedidos ao responsável vinculado à conta assistida. Sua função é aplicar e gerenciar as regras que determinam quais informações podem ser visualizadas e quais ações podem ser supervisionadas ou sugeridas, garantindo privacidade e segurança ao usuário idoso.

---

#### API PIX

A **API PIX** é responsável pelo processamento das transações financeiras realizadas no sistema. Ela gerencia operações como transferências, consultas e validações relacionadas ao ecossistema PIX, sendo um dos principais serviços da plataforma bancária.

---

#### API Antifraude

A **API Antifraude** monitora atividades suspeitas e realiza análises de segurança durante operações sensíveis, como logins e transações financeiras. Sua importância está na prevenção de golpes, fraudes e acessos indevidos, oferecendo maior proteção aos usuários.

---

#### API Notificação

A **API Notificação** centraliza o envio de comunicações do sistema, incluindo alertas, avisos de segurança, confirmações de operações e mensagens informativas. Ela garante que usuários e responsáveis sejam informados sobre eventos importantes relacionados às suas contas.


### Sistemas Externos
<img width="6684" height="804" alt="image" src="https://github.com/user-attachments/assets/40261512-41f6-4424-8edb-88bcc33996d4" />

Os sistemas externos representam serviços especializados que complementam as funcionalidades do SeuPix e fornecem recursos essenciais para sua operação. Em vez de desenvolver internamente mecanismos complexos de comunicação, autenticação, processamento financeiro e análise de risco, o sistema integra-se a plataformas já consolidadas no mercado, aumentando a confiabilidade, segurança e escalabilidade da solução. Essas integrações permitem que os microserviços do SeuPix consumam funcionalidades externas de forma transparente, garantindo uma experiência mais segura e eficiente para os usuários.

---

#### Sistema de Autenticação (Twilio)

O serviço de autenticação é responsável por validar a identidade dos usuários durante processos de login, recuperação de conta e confirmações de segurança. Sua utilização adiciona uma camada extra de proteção ao sistema, reduzindo riscos de acessos indevidos e fortalecendo os mecanismos de autenticação.

---

#### Sistema PIX (Banco Central / SPI)

O Sistema PIX é responsável pela liquidação e comunicação das transações financeiras realizadas pelos usuários. Por meio dessa integração, o SeuPix consegue efetuar transferências instantâneas e consultar informações relacionadas às operações financeiras, garantindo conformidade com a infraestrutura oficial do Banco Central.

---

#### Serviço de E-mail (Twilio)

O serviço de e-mail é utilizado para o envio de comunicações importantes aos usuários, como confirmações de cadastro, recuperação de senha, alertas de segurança e notificações operacionais. Essa integração garante um canal adicional de comunicação entre a plataforma e seus usuários.

---

#### Serviço de SMS (Twilio)

O serviço de SMS permite o envio de mensagens diretamente para o telefone dos usuários. Ele pode ser utilizado para autenticação em duas etapas, recuperação de conta e envio de alertas críticos, oferecendo uma alternativa de comunicação rápida e acessível.

---

#### Serviço de Notificações Push (Firebase Cloud Messaging)

O Firebase Cloud Messaging é responsável pelo envio de notificações push para os dispositivos móveis dos usuários. Essa integração permite que o SeuPix informe eventos importantes em tempo real, como alterações de permissões, movimentações suspeitas, solicitações de aprovação e outras ações relevantes para a segurança da conta.

---

#### Sistema Antifraude (ClearSale)

O sistema antifraude realiza análises de risco sobre operações e comportamentos dos usuários, auxiliando na identificação de possíveis tentativas de golpe ou atividades suspeitas. Sua integração é especialmente importante para o público idoso, contribuindo para a prevenção de fraudes financeiras e aumentando a segurança das transações realizadas na plataforma.


### Sistemas Externos PT2
<img width="1632" height="394" alt="image" src="https://github.com/user-attachments/assets/67ebbd9f-f956-4584-bbf7-772d479945d1" />

#### Cloud (AWS)

A AWS (Amazon Web Services) é a plataforma de computação em nuvem utilizada para hospedar e gerenciar a infraestrutura do SeuPix. Por meio dela, os microserviços, bancos de dados e demais componentes da aplicação podem ser executados de forma escalável, segura e com alta disponibilidade, garantindo que o sistema permaneça acessível aos usuários.

---

#### Mensagens e Eventos (Apache Kafka)

O Apache Kafka é a plataforma de mensageria responsável pela comunicação assíncrona entre os microserviços do sistema. Sua função é permitir que eventos gerados por um serviço possam ser consumidos por outros componentes sem a necessidade de comunicação direta, reduzindo o acoplamento da arquitetura e aumentando a escalabilidade e a eficiência da troca de informações.

---

#### Biometria (Android Biometric API e Apple Touch ID)

Os serviços de biometria disponibilizados pelos sistemas operacionais dos dispositivos móveis são utilizados para validar a identidade dos usuários durante processos de autenticação e confirmação de ações sensíveis. Essa integração permite que o SeuPix utilize recursos como impressão digital, reconhecimento facial e outras formas de autenticação biométrica, oferecendo uma experiência mais segura e acessível para os usuários.


### Relacionamentos
<img width="1488" height="1040" alt="image" src="https://github.com/user-attachments/assets/199641cd-f1b9-4a09-897b-619ec406a1fe" />

