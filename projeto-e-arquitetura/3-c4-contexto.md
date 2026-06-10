# Diagrama de Contexto

O Diagrama de Contexto é o primeiro nível (Nível 1) do Modelo C4 e funciona como uma visão macro e de alto nível do ecossistema de um software. Ele posiciona o sistema em desenvolvimento no centro do diagrama para estabelecer claramente suas fronteiras, ilustrando como ele se relaciona com seus usuários finais (personas) e com outros sistemas ou dependências externas. Por ser totalmente agnóstico em relação a tecnologias e focado no fluxo de valor de negócio, é uma ferramenta de comunicação ideal tanto para alinhar o escopo com stakeholders não técnicos quanto para dar um ponto de partida claro à equipe de engenharia.

## Visão Geral do Diagrama:

- Este diagrama de contexto mapeia o ecossistema completo da plataforma SeuPix. Ele define as fronteiras do sistema que será desenvolvido, identificando claramente quem são os usuários que interagem com o aplicativo e quais são as dependências de infraestrutura e serviços externos regulatórios.

<img width="4924" height="3436" alt="image" src="https://github.com/user-attachments/assets/c8327237-75a6-46c1-be76-5bdc90d04c1c" />

## Detalhamento por Partes:
#### Os Usuários (Personas): 
- O Usuário Idoso (titular focado em autonomia), o Contato de Apoio (tutor com visão consultiva) e o Especialista de Suporte (agente humano de triagem de falhas).

<img width="4284" height="1276" alt="image" src="https://github.com/user-attachments/assets/1f07dda1-b206-498c-bfb6-97b01678e58f" />

#### O Sistema Central no Diagrama de Contexto:
- A caixa central representa o Sistema SeuPix no Nível 1 do Modelo C4. Ela funciona como uma "caixa preta" que centraliza a inteligência do negócio e delimita a fronteira do sistema.

<img width="1192" height="688" alt="image" src="https://github.com/user-attachments/assets/4ddc6280-dd5d-446e-a09d-ec6a3bb4a1cd" />

#### Detalhamento dos Sistemas Externos e Integrações:
- Banco Central do Brasil & DICT: Explicação de como o sistema consome os scores de risco em tempo real para disparar as telas de aviso de golpe.
- Serviços de Notificações Push/SMS: Como o barramento envia os links temporários e tokens de segurança em até 5 segundos.
<img width="3248" height="608" alt="image" src="https://github.com/user-attachments/assets/1db4be87-2e9f-4cf5-9af1-943187391744" />



