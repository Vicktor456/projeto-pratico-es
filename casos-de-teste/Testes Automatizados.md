# O que é?

Os testes automatizados foram desenvolvidos com o objetivo de validar o comportamento esperado das funcionalidades do sistema SeuPix de forma rápida, padronizada e sem a necessidade de execução manual. Cada teste foi criado a partir das Classes de Equivalência e dos Casos de Teste definidos durante a etapa de planejamento dos testes.

Para cada História de Usuário (User Story), foi criada uma classe de serviço que simula as regras de negócio da funcionalidade e uma classe de teste utilizando o framework JUnit 5. Os testes verificam tanto cenários válidos quanto cenários inválidos, garantindo que o sistema responda corretamente às diferentes situações previstas nos requisitos.

A estrutura do projeto foi organizada em duas partes principais:

* **src/**: contém as classes de serviço que simulam o comportamento das funcionalidades do sistema.
* **tests/**: contém as classes de teste automatizado responsáveis por validar as regras implementadas nas classes de serviço.

Cada método de teste possui rastreabilidade com os Casos de Teste definidos na documentação, permitindo identificar facilmente quais requisitos estão sendo validados. Dessa forma, os testes automatizados complementam os testes manuais, aumentando a confiabilidade da solução e facilitando a verificação contínua das funcionalidades desenvolvidas.

# Testes Automatizados
## US1 - Privacidade de Saldo
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
