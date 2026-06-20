import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeracaoQRCodeServiceTest {

    private final GeracaoQRCodeService service =
            new GeracaoQRCodeService();

    @Test
    void CT_US17_01_GeracaoQRCodeComSucesso() {

        assertEquals(
                "SUCESSO",
                service.validarGeracaoQRCode(
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
    void CT_US17_02_TecladoIncorreto() {

        assertEquals(
                "ERRO_ENTRADA_VALOR",
                service.validarGeracaoQRCode(
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
    void CT_US17_03_QRCodeInvalido() {

        assertEquals(
                "QR_INVALIDO",
                service.validarGeracaoQRCode(
                        true,
                        false,
                        true,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US17_04_ExibicaoIncorreta() {

        assertEquals(
                "ERRO_EXIBICAO",
                service.validarGeracaoQRCode(
                        true,
                        true,
                        false,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US17_05_ChavePixIncorreta() {

        assertEquals(
                "CHAVE_PIX_INVALIDA",
                service.validarGeracaoQRCode(
                        true,
                        true,
                        true,
                        false,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US17_06_FalhaNoPixCopiaECola() {

        assertEquals(
                "ERRO_COPIA_COLA",
                service.validarGeracaoQRCode(
                        true,
                        true,
                        true,
                        true,
                        false,
                        true
                )
        );
    }

    @Test
    void CT_US17_07_NotificacaoAusente() {

        assertEquals(
                "NOTIFICACAO_AUSENTE",
                service.validarGeracaoQRCode(
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
