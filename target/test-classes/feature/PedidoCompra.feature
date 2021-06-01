# language: pt
Funcionalidade: Gerar pedido de compra
  eu como usuário do e-commerce
  desejo monstar um pedido
  para poder efetuar uma compra

  Cenario: gerar um pedido de compra com sucesso
    Dado que eu esteja na tela inicial do e-commerce
    Quando eu efetuar a busca do produto "Oculos Oakley Juliet Squared xmetal azul doble x"
    E selecionar um dos itens retornados
    E validar o item adicionado no carrinho "Oculos Oakley Juliet Squared xmetal azul doble x"
    E informar um cep válido para calculo do frete, rua "Henri Dunant"
    E clicar no botão ok
    E validar o valor do frete "R$ 20,63"
    E clicar no botão continuar
    Entao o sistema deverá ir para a etapa de pagamento

  Cenario: retornar mensagem de cep inválido na geração do pedido
    Dado que eu esteja na tela inicial do e-commerce
    Quando eu efetuar a busca do produto "Oculos Oakley Juliet Squared xmetal azul doble x"
    E selecionar um dos itens retornados
    E validar o item adicionado no carrinho "Oculos Oakley Juliet Squared xmetal azul doble x"
    E informar um cep inválido "00000-000" para calculo do frete
    E clicar no botão ok
    Entao o sistema deverá ir retorna a mensagem de erro "Ops, ocorreu um erro inesperado. Tente novamente ou calcule o frete na próxima etapa."