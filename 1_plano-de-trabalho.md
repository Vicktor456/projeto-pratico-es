# Plano de Trabalho

| Nome do Projeto:           | SeuPix                                                                                 |
| -------------------------- | -------------------------------------------------------------------------------------- |
| CODINOME:                  | *SeuPix*                                                                               |
| Versão:                    | 1.0                                                                                    |
| Status:                    | *Em desenvolvimento.*                                                                  |
| Número de Controle SRBR-M: | *SBID-DOC-ALPHA-0.1*  (Sistema Bancário para Idosos - Documentação - Versão alpha 0.1) |
| Executor Principal:        | Isabely Barbosa                                                                        |
| Coordenador do Projeto:    | Prof:Andrey Rodrigues                                                                  |

## Sumário
#### 1. Introdução
#### 1.1 Objeto
#### 1.2 Motivação, Justificativa e Oportunidade	
#### 1.3 Caracterização do Projeto	
#### 1.3.1 Classe
#### 1.3.2 Enquadrabilidade	
#### 2. INFORMAÇÕES GERAIS
#### 2.1 Escopo Geral	
#### 2.1.1 Escopo Específico
#### 2.1.2 Escopo Negativo	
#### 2.2 Ambiente de Desenvolvimento
#### 2.3 Características Inovadoras do Projeto
#### 2.4 Resultados Esperado
#### 3. METODOLOGIA DE PROJETO
#### 3.1 Estrutura do Projeto	
#### 3.2 Equipe de Projeto: Papéis e Responsabilidades dos integrantes	
#### 4. DESPESAS	
#### 4.1 Dispêndios	
#### 4.1.1 Equipamentos e Programa de Computador
#### 4.1.2 Materiais de Consumo	
#### 4.1.3 Serviço Técnico de Terceiros	
#### 4.2 Resumo Financeiro e Valor Total

# 

## 1. INTRODUÇÃO
O projeto SeuPix tem como principal objetivo a realização de transferências Pix de maneira prática, segura e sem complicações, foi desenvolvido com o objetivo de ser intuitivo e fácil de utilizar. Esse propósito foi priorizado após a equipe identificar a dificuldade de um determinado público ao lidar com bancos digitais, o público idoso. Uma das propriedades que a equipe priorizou ao desenvolver esse sistema de transferências foi o layout simplificado, com letras grandes e botões fáceis de visualizar. Além disso, fomos cuidadosos ao demonstrar para o usuário que o SeuPix é um sistema confiável e seguro de utilizar, implementando confirmações duplas antes de cada transação e um histórico visual para facilitar o acompanhamento do usuário ao navegar.

### 1.1 Objeto
O projeto consiste no desenvolvimento de um sistema de banco que tem como foco transferências pix, especialmente adaptado para pessoas idosas (mas não limitando-se apenas a esse público), contendo elementos no layout que facilitam a navegação do usuário através do sistema.
### 1.2 Motivação, Justificativa e Oportunidade 
Atualmente, observa-se uma baixa adesão do público idoso aos bancos digitais, principalmente devido à complexidade das interfaces, excesso de informações e falta de adaptação às suas necessidades. Essas dificuldades tornam tarefas simples, como transferências, confusas e inseguras.
	Diante disso, o projeto SeuPix foi desenvolvido com o objetivo de simplificar o uso de serviços bancários, com foco em transferências via Pix. A aplicação prioriza usabilidade e acessibilidade, oferecendo um layout intuitivo, com letras ampliadas, botões visíveis e um fluxo simplificado, além de mecanismos de segurança como confirmações duplas.
 O projeto representa uma oportunidade de promover inclusão digital e financeira, atendendo um público frequentemente negligenciado e ampliando seu acesso aos serviços bancários digitais. 

### 1.3 Caracterização do Projeto

#### 1.3.1 Classe

| Classe                | Detalhamento                                            |
| --------------------- | ------------------------------------------------------- |
| Aplicativo Móvel      | Um app de transferências pix com foco no público idoso. |

#### 1.3.2 Enquadrabilidade 

| Enquadrabilidade | Detalhamento                                                                                                                                                       |
| ---------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| FinTech          | Aplicativo móvel dedicado exclusivamente à gestão e execução de transações Pix, com arquitetura otimizada para acessibilidade e inclusão digital do público idoso. |

### 4.1 Dispêndios 
#### 4.1.1 Equipamentos e Programa de Computador 
Equipamentos que serão utilizados no projeto:
- Estações de Trabalho (Notebook/Desktop): Computadores de alto desempenho (mínimo 16GB RAM) para que os desenvolvedores consigam rodar os simuladores do aplicativo e os códigos de segurança simultaneamente.

- Dispositivos de Teste (Mobile): Uma variedade de smartphones (Android e iOS), incluindo modelos mais antigos e básicos. Isso é crucial para garantir que o SeuPix seja leve e funcional mesmo em celulares com telas menores ou processadores mais lentos, comuns entre o público idoso.

- Servidores Locais de Backup: Equipamentos de armazenamento físico (NAS) para garantir que o código-fonte e os dados do projeto não sejam perdidos em caso de falha na nuvem.

- Roteadores de Alta Performance: Para garantir uma conexão estável e segura durante o envio de dados sensíveis e testes de transações em tempo real.

- Programas que serão utilizados no projeto:
Ambiente de Desenvolvimento (IDE): Softwares como VS Code ou Android Studio, onde o código do aplicativo é escrito e compilado.

- Linguagens de Programação: Uso de tecnologias modernas e seguras (como React Native ou Flutter) que permitem criar um layout fluido e botões grandes com facilidade para ambas as plataformas (Android e iPhone).

- Sistema de Gestão de Banco de Dados: Programas como PostgreSQL ou Firebase para armazenar de forma criptografada o histórico de transações e as chaves Pix dos usuários.

- Ferramentas de Prototipagem (UX/UI): Softwares como o Figma, essenciais para desenhar a interface antes de programar, garantindo que o contraste de cores e o tamanho das letras atendam às normas de acessibilidade para idosos.

- Sistemas de Segurança e Criptografia: Programas específicos para mascarar os dados bancários e garantir que a "confirmação dupla" (mencionada no seu objetivo) seja inviolável. 

#### 4.1.2 Materiais de Consumo 
Os materiais de consumo previstos para o desenvolvimento do projeto estão detalhados na tabela abaixo:

| Item | Descrição dos Equipamentos | Quantidade | Valor Unitário (R$) | Valor Total (R$) |
| :---: | :--- | :---: | :---: | :---: |
| 1 | **Hospedagem em Nuvem** (AWS/Azure) | 12 meses | 150,00 | 1.800,00 |
| 2 | **Certificado de Segurança** SSL/TLS | 1 un. | 250,00 | 250,00 |
| 3 | **Serviço de SMS** (Token de Confirmação) | 2000 envios | 0,15 | 300,00 |
| 4 | **Licença de Software de Design** (Figma) | 1 un. | 90,00 | 90,00 |
| 5 | **Ferramenta de Monitoramento de Fraudes** | 12 meses | 100,00 | 1.200,00 |
| | **TOTAL DO INVESTIMENTO** | | | **R$ 3.640,00** |

### 4.1.3 Serviço Técnico de Terceiros

Os serviços técnicos de terceiros necessários para o desenvolvimento do projeto são:

| Item | Especificação | Custo(R$) |
| ---- | ------------- | --------- |
| 1 | Desenvolvimento de Software (Front-end e Back-end) | 8.000,00 |
| 2 | Serviço de UX/UI Design (Foco em Acessibilidade para Idosos) | 4.000,00 |
| 3 | Consultoria em Segurança Cibernética e LGPD | 3.500,00 |
| 4 | Teste de Usabilidade com Público-Alvo (Idosos) | 2.000,00 |
| 5 | Assessoria Jurídica (Contratos e Termos de Uso) | 1.500,00 |
| 6 | Marketing Digital e Gestão de Redes Sociais | 2.500,00 |
| 7 | Serviço técnico especializado em teste de usabilidade | 2.000,00 |
| 8 | Suporte Técnico e Manutenção Mensal | 2.500,00 |
| | **Total** | **26.000,00** |
