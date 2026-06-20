public class GeracaoQRCodeService {

    public String validarGeracaoQRCode(
            boolean tecladoNumerico,
            boolean qrDinamico,
            boolean exibicaoCorreta,
            boolean chavePixCorreta,
            boolean copiaColaFunciona,
            boolean notificacaoRecebimento
    ) {

        if (!tecladoNumerico)
            return "ERRO_ENTRADA_VALOR";

        if (!qrDinamico)
            return "QR_INVALIDO";

        if (!exibicaoCorreta)
            return "ERRO_EXIBICAO";

        if (!chavePixCorreta)
            return "CHAVE_PIX_INVALIDA";

        if (!copiaColaFunciona)
            return "ERRO_COPIA_COLA";

        if (!notificacaoRecebimento)
            return "NOTIFICACAO_AUSENTE";

        return "SUCESSO";
    }
}
