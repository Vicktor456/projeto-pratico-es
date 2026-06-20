import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertaFraudeServiceTest {

    private final AlertaFraudeService service =
            new AlertaFraudeService();

    @Test
    void CT_US14_01_ContinuarComCronometro() {

        assertEquals(
                "SUCESSO",
                service.validarAlertaFraude(
                        true,
                        false,
                        true,
                        true,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US14_02_CancelamentoSeguro() {

        assertEquals(
                "SUCESSO",
                service.validarAlertaFraude(
                        true,
                        false,
                        true,
                        true,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US14_03_BloqueioDeRiscoCritico() {

        assertEquals(
                "BLOQUEIO_REALIZADO",
                service.validarAlertaFraude(
                        false,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US14_04_AlertaExibidoParaChaveSegura() {

        assertEquals(
                "ALERTA_INDEVIDO",
                service.validarAlertaFraude(
                        false,
                        false,
                        true,
                        true,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US14_05_FalhaDeLayout() {

        assertEquals(
                "ERRO_LAYOUT",
                service.validarAlertaFraude(
                        true,
                        false,
                        false,
                        true,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US14_06_LinguagemInadequada() {

        assertEquals(
                "LINGUAGEM_INADEQUADA",
                service.validarAlertaFraude(
                        true,
                        false,
                        true,
                        false,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US14_07_CancelamentoIgnorado() {

        assertEquals(
                "CANCELAMENTO_IGNORADO",
                service.validarAlertaFraude(
                        true,
                        false,
                        true,
                        true,
                        false,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US14_08_CronometroNaoExecutado() {

        assertEquals(
                "CRONOMETRO_NAO_EXECUTADO",
                service.validarAlertaFraude(
                        true,
                        false,
                        true,
                        true,
                        true,
                        false,
                        true
                )
        );
    }

    @Test
    void CT_US14_09_FalhaBloqueioCritico() {

        assertEquals(
                "FALHA_BLOQUEIO_CRITICO",
                service.validarAlertaFraude(
                        false,
                        true,
                        true,
                        true,
                        true,
                        true,
                        false
                )
        );
    }
}
