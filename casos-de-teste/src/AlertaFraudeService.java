public class AlertaFraudeService {

    public String validarAlertaFraude(
            boolean chaveSuspeita,
            boolean chaveCritica,
            boolean layoutCorreto,
            boolean linguagemAdequada,
            boolean cancelamentoFunciona,
            boolean cronometroExecutado,
            boolean bloqueioCriticoFunciona
    ) {

        if (chaveCritica) {
            if (!bloqueioCriticoFunciona)
                return "FALHA_BLOQUEIO_CRITICO";

            return "BLOQUEIO_REALIZADO";
        }

        if (!chaveSuspeita)
            return "ALERTA_INDEVIDO";

        if (!layoutCorreto)
            return "ERRO_LAYOUT";

        if (!linguagemAdequada)
            return "LINGUAGEM_INADEQUADA";

        if (!cancelamentoFunciona)
            return "CANCELAMENTO_IGNORADO";

        if (!cronometroExecutado)
            return "CRONOMETRO_NAO_EXECUTADO";

        return "SUCESSO";
    }
}
