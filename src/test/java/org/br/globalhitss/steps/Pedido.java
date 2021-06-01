package org.br.globalhitss.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.br.globalhitss.core.BaseTest;
import org.br.globalhitss.page.Carrinho;
import org.br.globalhitss.page.Home;
import org.br.globalhitss.page.LoginCliente;
import org.json.JSONException;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Pedido extends BaseTest {

    private Home homePage;
    private LoginCliente loginCliente;
    private Carrinho carrinho;
    private RemoteWebDriver driver;

    @Dado("que eu esteja na tela inicial do e-commerce")
    public void queEuEstejaNaTelaInicialDoECommerce() {
        driver = startTestCase();
        homePage = new Home(driver);
        loginCliente = new LoginCliente(driver);
        carrinho = new Carrinho(driver);
    }

    @Quando("eu efetuar a busca do produto {string}")
    public void euEfetuarABuscaDoProduto(String produto) {
        homePage.buscarProduto(produto);
        //valida retorno da busca
        if (homePage.validarItemRetornadoNaBusca(produto) == null) {
            Assert.fail("Produto não encontrado");
        }
    }

    @E("selecionar um dos itens retornados")
    public void selecionarUmDosItensRetornados() {
        homePage.clicarComprar();
    }

    @E("informar um cep válido para calculo do frete, rua {string}")
    public void informarUmCepVálidoParaCalculoDoFrete(String rua) throws JSONException {
        String cep = carrinho.buscarCep(rua);
        carrinho.preencherCep(cep);
    }

    @E("clicar no botão ok")
    public void clicarNoBotãoOk() {
        carrinho.clicarOk();
    }

    @E("clicar no botão continuar")
    public void clicarNoBotãoContinuar() {
        carrinho.clicarContinuar();
    }

    @Entao("o sistema deverá ir para a etapa de pagamento")
    public void oSistemaDeveráIrParaAEtapaDePagamento() {
        //não foi validado por causa do recaptcha
        finishTestCase();
    }

    @E("informar um cep inválido para calculo do frete")
    public void informarUmCepInválidoParaCalculoDoFrete() {
    }

    @Entao("o sistema deverá ir retorna a mensagem de erro {string}")
    public void oSistemaDeveráIrRetornaAMensagemDeErro(String msg) {
        Assert.assertTrue(carrinho.validarMensagemDeErroParaCepInvalido(msg));
        finishTestCase();
    }

    @E("validar o item adicionado no carrinho {string}")
    public void validarOItemAdicionadoNoCarrinho(String produto) {
        if (!carrinho.validarItemNoCarrinho(produto)) {
            Assert.fail("O produto não foi adicionado no carrinho");
        }
    }

    @E("validar o valor do frete {string}")
    public void validarOValorDoFrete(String valor) {
        if (!carrinho.validarValorDoFrete(valor)) {
            Assert.fail("Valor do frete está incorreto");
        }
    }

    @E("informar um cep inválido {string} para calculo do frete")
    public void informarUmCepInválidoParaCalculoDoFrete(String cep) {
        carrinho.preencherCep(cep);
    }
}
