# Testes Automatizados

Os testes automatizados foram desenvolvidos com o objetivo de validar o comportamento esperado das funcionalidades do sistema SeuPix de forma rápida, padronizada e sem a necessidade de execução manual. Cada teste foi criado a partir das Classes de Equivalência e dos Casos de Teste definidos durante a etapa de planejamento dos testes.

Para cada História de Usuário (User Story), foi criada uma classe de serviço que simula as regras de negócio da funcionalidade e uma classe de teste utilizando o framework JUnit 5. Os testes verificam tanto cenários válidos quanto cenários inválidos, garantindo que o sistema responda corretamente às diferentes situações previstas nos requisitos.

A estrutura do projeto foi organizada em duas partes principais:

* **src/**: contém as classes de serviço que simulam o comportamento das funcionalidades do sistema.
* **tests/**: contém as classes de teste automatizado responsáveis por validar as regras implementadas nas classes de serviço.

Cada método de teste possui rastreabilidade com os Casos de Teste definidos na documentação, permitindo identificar facilmente quais requisitos estão sendo validados. Dessa forma, os testes automatizados complementam os testes manuais, aumentando a confiabilidade da solução e facilitando a verificação contínua das funcionalidades desenvolvidas.
