
### Defeitos encontrados pela outra equipe:

Não estão especificados quais canais devem ser suportados, qual formato o comprovante assume ao ser compartilhado (imagem, PDF, texto), nem o comportamento do sistema em caso de falha no compartilhamento.

**Trecho do Requisito**: _"Enquanto usuário idoso, desejo compartilhar o comprovante de transferência através das opções do meu aparelho, para enviar o recibo pelo canal de comunicação que eu preferir."_

**Tipo de Defeito**: Omissão

### Historia de usuário corrigida:
### 📝 Descrição

Enquanto usuário idoso, desejo compartilhar o comprovante de transferência através das opções do meu aparelho, para enviar o recibo pelo canal de comunicação que eu preferir.

### ✅ Critérios de Aceitação

1. Deve existir um botão com o ícone padrão de compartilhamento e a etiqueta de texto clara "Enviar Comprovante".
2. Ao clicar no botão, deve ser aberta a gaveta nativa de compartilhamento do sistema operacional (Android/iOS).
3. O comprovante deve ser enviado em formato de imagem ou PDF de alta resolução e fácil leitura.
4. O sistema deve permitir o compartilhamento direto para aplicativos de mensagens e redes sociais instalados no aparelho.

### 📏 Regra de Negócios

O arquivo gerado para compartilhamento deve manter os mesmos padrões de fonte ampliada e alto contraste definidos para a visualização em tela.

### Quais problemas foram corrigidos:

Quais canais devem ser suportados:
No relatório da equipe apontava que os canais não estavam especificados.  Na nova especificação, o critério de aceitação 2 define que deve ser aberta a "gaveta nativa de compartilhamento do sistema operacional (Android/iOS)" e o critério de aceitação 4 complementa permitindo o "compartilhamento direto para aplicativos de mensagens e redes sociais instalados no aparelho". Isso resolve o problema ao delegar os canais suportados ao próprio sistema operacional e apps instalados do usuário.

Qual formato o comprovante assume ao ser compartilhado:
O defeito apontava que a omissão do formato (imagem, PDF, texto).Na atualização que foi feito, o critério de aceitação 3 determina explicitamente que o comprovante deve ser enviado em "formato de imagem ou PDF de alta resolução e fácil leitura".

///////////////////////////////////////////////////////////////////////////////////////////////////////
### Defeitos encontrados pela outra equipe:
Trecho do Requisito: "US07: O teclado numérico deve ocupar pelo menos 40% da tela."  
Categoria: Ambiguidade  
Ocorre quando o requisito utiliza métricas que não possuem um ponto de referência fixo, gerando interpretações diferentes dependendo do hardware.

Descrição do Problema: O uso de percentual absoluto ("40% da tela") é ambíguo em um ecossistema de dispositivos com diferentes aspect ratios (proporções de tela) e densidades de pixels. Não está claro se os 40% referem-se à área total da tela, à altura útil (viewport) ou se deve considerar a área ocupada por barras de navegação do sistema operacional. Isso impossibilita a criação de um layout responsivo padronizado e dificulta a validação em testes de UI (User Interface).

### Historia de usuário corrigido:
### 📝 Descrição

Enquanto usuário idoso, desejo preencher a quantia do Pix em um teclado com números grandes e espaçados, para ter mais facilidade e não cometer erros de digitação.

### ✅ Critérios de Aceitação

1. O teclado numérico deve ocupar, no mínimo, 40% da altura útil da tela (Viewport Height), descontando-se as áreas ocupadas pelas barras de sistema (status e navegação do SO).
2. O valor digitado deve ser exibido em destaque no topo da área útil. A fonte deve utilizar Auto-scaling, iniciando em 32pt e reduzindo o tamanho apenas se o valor exceder a largura da tela, mantendo sempre o contraste WCAG AA.
3. O sistema deve aplicar a máscara de moeda (R$) em tempo real, com inserção automática de ponto e vírgula decimal a partir do terceiro dígito inserido (ex: ao digitar 1-0-0, o sistema exibe R$ 1,00).
4. Ao tocar em uma tecla, deve haver um feedback visual imediato (mudança de cor ou elevação do botão).

### 📏 Regra de Negócios

1. O botão de "Confirmar" só deve ser habilitado se o valor for superior a R$ 0,00 e inferior ou igual ao menor dos seguintes valores: saldo em conta ou limite diário disponível.
2. Caso o usuário digite um valor acima do limite, o sistema deve exibir uma mensagem de erro abaixo do valor, em cor vermelha e fonte legível, impedindo o avanço.
3. O teclado deve ser exclusivamente numérico, bloqueando qualquer entrada de caracteres especiais ou alfabéticos.

### Quais problemas foram corrigidos:

Referência do percentual absoluto ("40% da tela"):
A ambiguidade sobre o que representa os "40%" foi totalmente eliminada. O critério de aceitação 1 agora especifica formalmente que o teclado deve ocupar, no mínimo, 40% da altura útil da tela (Viewport Height), e não da área total ou largura.

Impacto das barras de navegação SO sistema operacional:
O problema apontava que não estava claro se as barras do SO deveriam ser contabilizadas. O critério de aceitação 1 corrigiu isso ao determinar explicitamente que o cálculo deve ser feito "descontando-se as áreas ocupadas pelas barras de sistema (status e navegação do SO)".
///////////////////////////////////////////////////////////////////////////////////////////////////////


### Defeitos encontrados pela outra equipe:
Embora a história especifique a comunicação com um "atendente humano" (descartando bots) , há uma ambiguidade crítica no método de comunicação. O termo "falar" não define a arquitetura tecnológica do sistema. Não fica claro se a funcionalidade exigirá a construção de um sistema de chamada interno no aplicativo , um redirecionamento para um aplicativo externo como o WhatsApp , ou o uso do discador nativo para uma ligação telefônica comum. Sem essa definição, a equipe de desenvolvimento fica impossibilitada de estimar o esforço, os custos e as permissões de hardware necessárias (como acesso ao microfone).

Trecho do Requisito:  
US18: “Enquanto usuário idoso, desejo visualizar um botão de ajuda em destaque na tela, para conseguir falar com um atendente humano sempre que eu tiver alguma dificuldade no aplicativo.”

Tipo do defeito:  
Ambiguidade

### Historia de usuário corrigido:
### 📝 Descrição

Enquanto usuário idoso, desejo ter um botão de "Ajuda" fácil de encontrar, para falar com um atendente humano caso eu fique confuso.

### ✅ Critérios de Aceitação

1. O botão de ajuda deve estar visível em todas as telas principais, posicionado em um local de fácil alcance.
    
2. O botão deve utilizar um ícone de "fone de ouvido" ou "balão de conversa" acompanhado do texto "Falar com Atendente" em fonte ampliada.
    
3. Ao acionar o botão, o usuário deve ter a opção de escolher entre "Chamada de Voz" ou "Chat por Mensagem".
    
4. O tempo de espera estimado deve ser exibido na tela de forma clara e legível.
    

### 📏 Regra de Negócios

O suporte deve estar disponível em horário comercial estendido (7h às 22h).

### Quais problemas foram corrigidos:

Definição das modalidades de comunicação ("Falar):
O termo genérico "falar" foi refinado. O critério de aceitação 3 agora estabelece que o usuário terá uma tela intermediária para escolher entre duas modalidades de atendimento: "Chamada de voz" ou "chat por mensagem". A inclusão do chat demonstra uma reavaliação do escopo pela nossa equipe para dar mais alternativas de acessibilidade.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


---

## Defeito 06 - US10

**Descrição do Problema**  
A US10 é descrita do ponto de vista de uma “tutora de idosos”, diferente do padrão “usuário idoso” adotado nas demais histórias.  
Além disso, a história menciona “fontes legíveis” sem quantificar tamanho mínimo, enquanto a US05 já especifica “no mínimo 20pt”, criando divergência entre histórias sobre o mesmo tema de acessibilidade visual.

**Trecho do Requisito**

- US10: “Enquanto tutora de idosos, desejo uma interface com fontes legíveis para garantir a acessibilidade de usuários com baixa visão.”
- US05 CA1: “O nome do recebedor deve estar em negrito e com fonte de no mínimo 20pt.”

**Tipo de Defeito:** Inconsistência

## User Story
### 📝 Descrição
Enquanto contato de apoio, desejo uma interface com fontes legíveis para garantir a acessibilidade de usuários com baixa visão.

#### Quais Problemas foram corrigidos?
- O defeito n° 06 apontado na inspeção realizada por outra equipe não descreve de fato nenhuma inconsistência na referida user story 10 do trabalho prático. O defeito encontrado descreve que não há padronização ao referir-se a persona “tutora de idosos”, já que em outras user story’s é usado de modo padronizado o termo “usuário idoso”, entretanto esta user story não está se referindo ao “usuário idoso”, já que esta é uma persona diferente e que não se enquadra no contexto descrito da user story atual. Dessa forma, não existe nenhum erro principal que possa ser corrigido ou reavaliado.
    
- Outro defeito inspecionado pela equipe foi a existência de duas user storys que mencionam o mesmo tema, acessibilidade na leitura do usuário, referindo-se especificamente ao tamanho da fonte. A convergência encontra-se no fato de uma user story(US05) especificar “No mínimo 20pt” ao  abordar o tamanho da fonte, enquanto a outra (US10)cita “fontes legíveis”, mas não diz de que forma a legibilidade vai ser oferecida ao usuário. Tendo em vista essa convergência entre histórias de usuários, a equipe padronizou as user storys de modo que todas tenham detalhamento de “20pt” para os tamanhos de fontes, criando um modelo/padronização para todas as user storys que tratam sobre legibilidade.
    
## DEFEITO 2 - US14
**Trecho do Requisito**  
“...caso a transação apresente algum risco de fraude...”

**Relatório de Inspeção de Requisitos (Segurança e Validação)**

- **Categoria:** Ambiguidade / Falta de Regras de Negócio  
    Ocorre quando o requisito depende de uma inteligência ou lógica que não foi descrita, deixando a funcionalidade “vazia” de sentido técnico.

#### Descrição do Problema
O requisito apresenta uma ambiguidade semântica e lógica. O termo “risco de fraude” é subjetivo e não vem acompanhado das regras de negócio ou parâmetros que o definem (ex.: limites de valor, divergência de geolocalização ou contas suspeitas em listas externas).  
Sem esses critérios, é impossível implementar a lógica de backend que dispara o alerta e, consequentemente, é impossível validar se o sistema está identificando corretamente o risco durante os testes.

---

## User storys
### 📝 Descrição
Enquanto usuário idoso, desejo visualizar um aviso de risco claro e em destaque antes de confirmar um Pix suspeito, para que eu possa interromper a operação a tempo e evitar cair em um golpe.

#### Quais Problemas foram corrigidos?
- O trecho que foi informado como um erro de ambiguidade na user story é inexistente na user story 14, não existe nenhuma parte do texto que cite “caso a transação apresente algum risco de fraude”, dessa forma, foi impossível corrigir o erro, a frase “risco de fraude” não é mencionada nenhuma vez.
    

## DFEITO US16

**Trecho do Requisito** “...exibindo nomes conhecidos no lugar de razões sociais...” (US16)

**Categoria:** Ambiguidade / Falta de Especificação Técnica Ocorre quando o requisito exige uma transformação de dados sem definir a regra ou a fonte de referência para tal conversão, impactando diretamente a cognição do usuário.

**ID:** DEF-11

**Descrição do Problema** O termo “nomes conhecidos” é subjetivo e carece de fundamentação técnica no contexto do aplicativo. Não está definido se o sistema realizará o de-para (mapeamento) via consulta ao Nome Fantasia do CNPJ, se utilizará uma base de dados interna de marcas populares ou se o próprio usuário deverá apelidar os contatos. Para o idoso, a substituição automática sem critérios claros pode gerar insegurança quanto à veracidade da transação.

## User storys
### 📝 Descrição
Enquanto contato de apoio, desejo uma interface com fontes legíveis para garantir a acessibilidade de usuários com baixa visão.

#### Quais Problemas foram corrigidos?
O erro apontado pela equipe não coincide com a especificação atual da US16 apresentada já reclamação do defeito baseia-se em um trecho inexistente ("...exibindo nomes conhecidos no lugar de razões sociais...") e argumenta que o termo "nomes conhecidos" é ambíguo e carece de fundamentação técnica sobre a origem dos dados (se vem do Nome Fantasia do CNPJ, de uma base de dados interna ou de apelidos salvos pelo usuário).

ao analisar o texto atual da US16 podemos ver que a ambiguidade já foi resolvida:
- A Descrição deixa claro o objetivo: "desejo ver uma lista das minhas ultimas transações com nomes amigáveis (apelidos)".
- O Critério de Aceitação 1 define exatamente o que exibir: "o nome fantasia ou o nome do contato salvo (apelido) em destaque".
- A seção Regra de Negócios resolve explicitamente a dúvida técnica levantada pelo erro, determinando a lógica de mapeamento: "O sistema deve cruzar os dados do CNPJ/CPF do recebedor com a lista de contatos salvos do usuário para priorizar a exibição do apelido definido."
    

Portanto, a especificação técnica atual da User Story já contém os critérios e fontes de referência cobrados pelo relatório de erros







