## Descrição do Padrão Arquitetural:
## Microsserviços
O padrão arquitetural de microsserviços é uma abordagem de design de software que decompõe um sistema em módulos menores que são executados como processos independentes e autônomos. Diferente de uma arquitetura monolítica, onde todos os módulos compartilham o mesmo espaço de endereçamento e memória em tempo de execução, os microsserviços funcionam sem compartilhamento de memória, garantindo o isolamento entre as partes do sistema.
Abaixo, os detalhes sobre como o padrão organiza o sistema e suas características fundamentais:
**Organização do Sistema**
- **Decomposição em tempo de execução:** O sistema é dividido em módulos não apenas durante o desenvolvimento, mas também em tempo de execução, operando em processos distintos.
- **Comunicação via Interfaces Públicas:** Como os processos são isolados pelo sistema operacional, a comunicação entre os módulos deve ocorrer obrigatoriamente através de interfaces públicas (como protocolos HTTP/REST).
- **Gerenciamento de Dados Autônomo:** Cada microsserviço deve gerenciar seus próprios dados. O ideal é que cada serviço possua seu próprio banco de dados independente para evitar que uma autoridade central de administração de dados se torne um gargalo à evolução do sistema.
- **Sistemas Distribuídos:** Por construção, essa arquitetura dá origem a sistemas distribuídos, exigindo o uso de protocolos de rede e lidando com desafios como a latência de comunicação.


**Principais Características**
- **Autonomia e Independência de Evolução:** Permite que diferentes times trabalhem em serviços específicos e lancem novas versões de forma independente, sem a necessidade de processos burocráticos exigidos por monolitos para evitar efeitos colaterais.
- **Escalabilidade Granular:** Oferece escalabilidade horizontal em um nível fino, permitindo replicar apenas os microsserviços que apresentam problemas de performance em vez de todo o sistema.
- **Heterogeneidade Tecnológica:** Cada serviço pode ser implementado com tecnologias distintas (linguagens de programação, bancos de dados e frameworks) conforme a necessidade do problema que resolve.
- **Resiliência a Falhas Parciais:** Em vez de uma falha total (comum em monolitos quando o banco de dados cai), os microsserviços permitem falhas parciais. Se um serviço de recomendação falhar, por exemplo, o cliente ainda pode pesquisar e comprar produtos, perdendo apenas a funcionalidade específica.
- **Times Pequenos e Ágeis:** O termo "micro" refere-se à simplicidade das funcionalidades, projetadas para serem desenvolvidas por times pequenos (cerca de cinco pessoas), o que facilita a agilidade e a inovação.
Viabilizado pela Nuvem: O padrão tornou-se popular com o surgimento da computação em nuvem, que facilita o aluguel e a escala rápida de máquinas virtuais para rodar os serviços.

## Justificativa da Escolha:

A arquitetura de microsserviços foi escolhida para o desenvolvimento do SeuPix por permitir a divisão do sistema em serviços independentes, cada um responsável por uma funcionalidade específica. Essa abordagem é adequada para o projeto, pois o aplicativo possui diferentes módulos, como autenticação, transferências PIX, gerenciamento de usuários, notificações e recursos de acessibilidade, que podem ser desenvolvidos e mantidos separadamente.

Além de facilitar a organização do sistema, os microsserviços ajudam a reduzir a complexidade do desenvolvimento, permitindo que os integrantes da equipe trabalhem de forma mais focada em funcionalidades específicas. Isso melhora a produtividade, diminui conflitos durante a implementação e facilita a manutenção do código.

Outro benefício importante é a escalabilidade, já que cada serviço pode ser atualizado ou expandido individualmente conforme a necessidade da aplicação. A arquitetura também contribui para a segurança e a confiabilidade do sistema, pois possíveis falhas em um serviço tendem a causar menor impacto nos demais componentes.

Dessa forma, a arquitetura de microsserviços torna o SeuPix mais modular, organizado, escalável e preparado para futuras evoluções, características essenciais para uma aplicação financeira moderna.

## Aplicação no Sistema:

No SeuPix, o padrão de arquitetura de microsserviços foi aplicado por meio da separação das funcionalidades do sistema em serviços independentes, cada um responsável por uma área específica do negócio. Em vez de concentrar toda a lógica da aplicação em um único sistema monolítico, as responsabilidades foram distribuídas em módulos especializados, permitindo maior organização e desacoplamento entre as funcionalidades.

As principais partes do sistema que seguem esse padrão são os serviços responsáveis pelo gerenciamento de usuários, autenticação, controle de permissões, acessibilidade e suporte ao idoso, processamento de transações PIX, notificações e mecanismos de segurança e antifraude. Cada um desses componentes possui responsabilidades bem definidas e pode evoluir de forma independente dos demais.

A comunicação entre esses serviços ocorre por meio de APIs e troca de eventos, permitindo que as funcionalidades trabalhem em conjunto sem criar dependências excessivas. Dessa forma, o sistema torna-se mais modular, facilitando a manutenção, a implementação de novas funcionalidades e a distribuição das atividades entre os membros da equipe.

A adoção desse padrão também contribui para a escalabilidade e confiabilidade da aplicação, uma vez que cada serviço pode ser atualizado, monitorado e expandido individualmente conforme as necessidades do sistema e dos usuários. Isso é especialmente importante para o SeuPix, que atua em um contexto financeiro e precisa garantir segurança, disponibilidade e facilidade de evolução ao longo do tempo.

## Figura do Sistema aplicada a Arquitetura:

<img width="1340" height="1392" alt="SeuPix MicroServices Architecture" src="https://github.com/user-attachments/assets/29c659fd-3034-4e78-9325-d5c8af7696d4" />
