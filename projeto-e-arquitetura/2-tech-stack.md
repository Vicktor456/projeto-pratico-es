## Tecnoligas e Ferramentas Utilizadas (Tech Stack Map)

O Tech Stack Map é uma representação visual das tecnologias e ferramentas utilizadas no desenvolvimento do sistema. Ele permite identificar os principais componentes que compõem a aplicação, desde o desenvolvimento e armazenamento de dados até segurança, comunicação entre serviços, infraestrutura e implantação.

No SeuPix, o Tech Stack Map demonstra como as tecnologias escolhidas trabalham em conjunto para garantir uma aplicação segura, escalável e acessível, alinhada às necessidades de uma fintech voltada à inclusão digital de idosos no ambiente bancário virtual.

<img width="4604" height="4144" alt="Group 2 (2)" src="https://github.com/user-attachments/assets/c71f9709-ea71-48a7-96fa-86f4c465ad51" />

## Tabela de Explicações das Tecnologias:
## IDE
### VISUAL STUDIO CODE
<img width="1648" height="833" alt="vscode" src="https://github.com/user-attachments/assets/c16d40f4-d01b-427c-a0ce-8cf5a7148c85" />

### WebStorm
<img width="1648" height="833" alt="Group 1" src="https://github.com/user-attachments/assets/eae8712e-28cd-451a-8fdd-7b0de006016e" />

### Intellij IDEA
<img width="1648" height="833" alt="inteliji idea" src="https://github.com/user-attachments/assets/05461953-af47-45e4-a1cd-55cb52f8684c" />

### PyCharm
<img width="1648" height="833" alt="pycharm" src="https://github.com/user-attachments/assets/a8f525ab-39bf-4e7c-ab89-ea9bb5893ffe" />

## Versionamento
### GIT
<img width="1648" height="833" alt="GIT" src="https://github.com/user-attachments/assets/d1c0b24c-e90e-4ab7-891c-49e18b9cbebc" />

### GitHub
<img width="1648" height="833" alt="GITHUB" src="https://github.com/user-attachments/assets/73a6df79-c2eb-45c2-8717-c3756e936227" />

## Cloud
### Amazon Web Services (AWS)
<img width="1648" height="833" alt="AWS" src="https://github.com/user-attachments/assets/6fdfc58a-2406-411c-87f8-d6802b3529d6" />

## Notificação
### RabbitMQ
<img width="1648" height="833" alt="NOTF RABBBITMQ" src="https://github.com/user-attachments/assets/a0c737dd-41bd-48ca-a6d4-669cdfb60aad" />

## Segurança
### KeyCloak
<img width="1648" height="833" alt="SEG KEYCLOAK" src="https://github.com/user-attachments/assets/8d9a76c9-951e-429a-9ddf-103101350ed5" />

## Deploy
### GitHub Actions
<img width="1648" height="833" alt="GITHUB AC" src="https://github.com/user-attachments/assets/ad3ad171-83b0-42a0-91b7-476394ad9549" />

## Banco de Dados
### PostgreSQL
<img width="1648" height="833" alt="Postgre" src="https://github.com/user-attachments/assets/c26b0ea9-dadc-4360-a601-996633155a21" />

## API Gateway
### Kong
<img width="1648" height="833" alt="apigat" src="https://github.com/user-attachments/assets/0482528c-fa81-4b9d-8eb7-316c072f899b" />

| Tecnologias            | Camada                   | Justificativa                                                                                                                                          |
| ---------------------- | ------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Spring Boot (Java)** | Back End                 | Framework utilizado para o desenvolvimento dos microsserviços do sistema, oferecendo rapidez, escalabilidade e integração com aplicações corporativas. |
| **Python**             | Back End / Antifraude    | Utilizado para automações, processamento de dados e futuras implementações de análise comportamental e detecção de fraudes.                            |
| **React Native**       | Front End Mobile         | Framework utilizado para o desenvolvimento do aplicativo móvel, permitindo a criação de uma única aplicação para Android e iOS.                        |
| **CodePush**           | Front End Mobile         | Permite realizar atualizações da interface e correções sem a necessidade de publicar uma nova versão do aplicativo nas lojas.                          |
| **Kong**               | API Gateway              | Responsável por centralizar, proteger e rotear as requisições entre o aplicativo e os microsserviços do sistema.                                       |
| **Figma**              | Design e Prototipação    | Utilizado para criação de protótipos, wireframes e interfaces, auxiliando no planejamento da experiência do usuário.                                   |
| **Keycloak**           | Segurança                | Plataforma de gerenciamento de identidade e acesso utilizada para autenticação, autorização e controle seguro dos usuários.                            |
| **AWS**                | Cloud                    | Plataforma de computação em nuvem utilizada para hospedar e escalar os serviços da aplicação com alta disponibilidade e segurança.                     |
| **RabbitMQ**           | Mensageria e Notificação | Responsável pela comunicação assíncrona entre os microsserviços e pelo processamento de eventos e notificações.                                        |
| **PostgreSQL**         | Banco de Dados           | Sistema gerenciador de banco de dados relacional utilizado para armazenar os dados da aplicação com segurança e consistência.                          |
| **GitHub Actions**     | CI/CD e Deploy           | Ferramenta utilizada para automatizar processos de integração contínua, testes e implantação do sistema.                                               |
| **Git + GitHub**       | Versionamento            | Utilizados para controle de versão do código-fonte, colaboração da equipe e rastreabilidade das alterações do projeto.                                 |
| **GitHub Projects**    | Gerenciamento de Tarefas | Utilizado para organização do backlog, acompanhamento de atividades e gerenciamento do desenvolvimento do projeto.                                     |
| **JavaScript**         | Linguagem Front End      | Linguagem utilizada no desenvolvimento da interface e de componentes do aplicativo.                                                                    |
| **Visual Studio Code** | IDE                      | Editor de código leve e versátil utilizado no desenvolvimento geral do projeto.                                                                        |
| **PyCharm**            | IDE Python               | Ambiente de desenvolvimento especializado para criação e manutenção de aplicações Python.                                                              |
| **WebStorm**           | IDE Front End            | IDE especializada em JavaScript e TypeScript, utilizada no desenvolvimento de interfaces modernas.                                                     |
| **IntelliJ IDEA**      | IDE Back End             | Ambiente de desenvolvimento utilizado para criação e manutenção dos microsserviços desenvolvidos com Java e Spring Boot.                               |


# API's
| API | Tecnologia / Serviço | Responsabilidade |
|------|---------------------|------------------|
| API de Autenticação | oAuth2 | Gerenciamento de login, tempo de sessão, biometria, recuperação de conta e permissões do usuário. |
| API Pix | BaaS | Responsável pela integração com PIX, chaves, transferências, consultas e confirmar pagamentos. |
| API Antifraude | IA Própria | Responsável pela detecção de contas suspeitas e ligadas a golpes golpes, assim como transferências anormais de acessos comuns. |
| API Notificação | OneSignal | Responsável por enviar notificação push, email, SMS. |
| API de Usuários | Controle de Dados de Usuário | Gerencia os dados do idoso, contatos de apoio, preferências de acessibilidade. |
| API de Permissões | Controle de Permissões do Contato de Apoio | Responsável por gerenciar as permissões do contato de apoio e os níveis de acesso. |





