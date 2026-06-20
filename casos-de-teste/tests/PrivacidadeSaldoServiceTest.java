import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrivacidadeSaldoServiceTest {

    private final PrivacidadeSaldoService service =
            new PrivacidadeSaldoService();

    @Test
    void CT_US1_01_PrivacidadeSaldoComSucesso() {

        assertEquals(
                "SUCESSO",
                service.validarPrivacidadeSaldo(
                        true,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US1_02_SaldoIniciaVisivel() {

        assertEquals(
                "SALDO_VISIVEL",
                service.validarPrivacidadeSaldo(
                        false,
                        true,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US1_03_FalhaAoExibirSaldo() {

        assertEquals(
                "ERRO_EXIBICAO",
                service.validarPrivacidadeSaldo(
                        true,
                        false,
                        true,
                        true
                )
        );
    }

    @Test
    void CT_US1_04_SaldoPermaneceExpostoAoTrocarTela() {

        assertEquals(
                "SALDO_EXPOSTO",
                service.validarPrivacidadeSaldo(
                        true,
                        true,
                        false,
                        true
                )
        );
    }

    @Test
    void CT_US1_05_PreferenciaNaoPersistida() {

        assertEquals(
                "PREFERENCIA_PERDIDA",
                service.validarPrivacidadeSaldo(
                        true,
                        true,
                        true,
                        false
                )
        );
    }
}
