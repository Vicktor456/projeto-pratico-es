
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

### 🎯 Story Points

3

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

### 🎯 Story Points

3

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

### 🎯 Story Points

5
### Quais problemas foram corrigidos:

Definição das modalidades de comunicação ("Falar):
O termo genérico "falar" foi refinado. O critério de aceitação 3 agora estabelece que o usuário terá uma tela intermediária para escolher entre duas modalidades de atendimento: "Chamada de voz" ou "chat por mensagem". A inclusão do chat demonstra uma reavaliação do escopo pela nossa equipe para dar mais alternativas de acessibilidade.


