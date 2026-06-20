# O que é?

Os testes automatizados foram desenvolvidos com o objetivo de validar o comportamento esperado das funcionalidades do sistema SeuPix de forma rápida, padronizada e sem a necessidade de execução manual. Cada teste foi criado a partir das Classes de Equivalência e dos Casos de Teste definidos durante a etapa de planejamento dos testes.

Para cada História de Usuário (User Story), foi criada uma classe de serviço que simula as regras de negócio da funcionalidade e uma classe de teste utilizando o framework JUnit 5. Os testes verificam tanto cenários válidos quanto cenários inválidos, garantindo que o sistema responda corretamente às diferentes situações previstas nos requisitos.

A estrutura do projeto foi organizada em duas partes principais:

* **src/**: contém as classes de serviço que simulam o comportamento das funcionalidades do sistema.
* **tests/**: contém as classes de teste automatizado responsáveis por validar as regras implementadas nas classes de serviço.

Cada método de teste possui rastreabilidade com os Casos de Teste definidos na documentação, permitindo identificar facilmente quais requisitos estão sendo validados. Dessa forma, os testes automatizados complementam os testes manuais, aumentando a confiabilidade da solução e facilitando a verificação contínua das funcionalidades desenvolvidas.

# Testes Automatizados
## US1 - Privacidade de Saldo
**Arquivos Relacionados**

Arquivo Source - [PrivacidadedeSaldoService.java](https://github.com/Vicktor456/projeto-pratico-es/blob/main/casos-de-teste/src/PrivacidadeSaldoService.java)

Teste - [PrivacidadedeSaldoTest.java](https://github.com/Vicktor456/projeto-pratico-es/blob/main/casos-de-teste/tests/PrivacidadeSaldoServiceTest.java)

**Descrição**

Os testes automatizados desta funcionalidade validam se o saldo do usuário permanece oculto por padrão, se pode ser exibido mediante ação do usuário, se volta a ser ocultado ao navegar entre telas e se a preferência é corretamente persistida.

**Rastreabilidade**

| User Story | Caso de Teste | Método JUnit                                |
| ---------- | ------------- | ------------------------------------------- |
| US1        | Caso 1        | CT_US1_01_PrivacidadeSaldoComSucesso        |
| US1        | Caso 2        | CT_US1_02_SaldoIniciaVisivel                |
| US1        | Caso 3        | CT_US1_03_FalhaAoExibirSaldo                |
| US1        | Caso 4        | CT_US1_04_SaldoPermaneceExpostoAoTrocarTela |
| US1        | Caso 5        | CT_US1_05_PreferenciaNaoPersistida          |

---

## US14 - Exibição de Aviso de Risco de Fraude
**Arquivos Relacionados**

Arquivo Source - [AlertaFraudeService.java](https://github.com/Vicktor456/projeto-pratico-es/blob/main/casos-de-teste/src/AlertaFraudeService.java)

Teste - [AlertaFraudeTest.java](https://github.com/Vicktor456/projeto-pratico-es/blob/main/casos-de-teste/tests/AlertaFraudeTest.java)

**Descrição**

Os testes automatizados desta funcionalidade verificam a exibição de alertas de fraude para transações suspeitas ou críticas, validando aspectos visuais, clareza da mensagem, interrupção da operação, temporização de segurança e bloqueio de operações consideradas perigosas.

**Rastreabilidade**

| User Story | Caso de Teste | Método JUnit                            |
| ---------- | ------------- | --------------------------------------- |
| US14       | Caso 1        | CT_US14_01_ContinuarComCronometro       |
| US14       | Caso 2        | CT_US14_02_CancelamentoSeguro           |
| US14       | Caso 3        | CT_US14_03_BloqueioDeRiscoCritico       |
| US14       | Caso 4        | CT_US14_04_AlertaExibidoParaChaveSegura |
| US14       | Caso 5        | CT_US14_05_FalhaDeLayout                |
| US14       | Caso 6        | CT_US14_06_LinguagemInadequada          |
| US14       | Caso 7        | CT_US14_07_CancelamentoIgnorado         |
| US14       | Caso 8        | CT_US14_08_CronometroNaoExecutado       |
| US14       | Caso 9        | CT_US14_09_FalhaBloqueioCritico         |

---

## US17 - Geração de QR Code
**Arquivos Relacionados**

Arquivo Source - [GeracaoQRCodeService.java](https://github.com/Vicktor456/projeto-pratico-es/blob/main/casos-de-teste/src/GeracaoQRCodeService.java)

Teste - [GeracaoQRCodeTest.java](https://github.com/Vicktor456/projeto-pratico-es/blob/main/casos-de-teste/tests/GeracaoQRCodeServiceTest.java)

**Descrição**

Os testes automatizados desta funcionalidade validam a geração de QR Codes para cobrança, verificando a entrada do valor, o tipo de QR gerado, a exibição visual, o vínculo com a chave Pix correta, a funcionalidade Pix Copia e Cola e as notificações de recebimento.

**Rastreabilidade**

| User Story | Caso de Teste | Método JUnit                       |
| ---------- | ------------- | ---------------------------------- |
| US17       | Caso 1        | CT_US17_01_GeracaoQRCodeComSucesso |
| US17       | Caso 2        | CT_US17_02_TecladoIncorreto        |
| US17       | Caso 3        | CT_US17_03_QRCodeInvalido          |
| US17       | Caso 4        | CT_US17_04_ExibicaoIncorreta       |
| US17       | Caso 5        | CT_US17_05_ChavePixIncorreta       |
| US17       | Caso 6        | CT_US17_06_FalhaNoPixCopiaECola    |
| US17       | Caso 7        | CT_US17_07_NotificacaoAusente      |
