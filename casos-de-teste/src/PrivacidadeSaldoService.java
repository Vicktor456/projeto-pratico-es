public class PrivacidadeSaldoService {

    public String validarPrivacidadeSaldo(
            boolean saldoOcultoInicialmente,
            boolean cliqueExibeSaldo,
            boolean ocultaAoTrocarTela,
            boolean preferenciaPersistida
    ) {

        if (!saldoOcultoInicialmente)
            return "SALDO_VISIVEL";

        if (!cliqueExibeSaldo)
            return "ERRO_EXIBICAO";

        if (!ocultaAoTrocarTela)
            return "SALDO_EXPOSTO";

        if (!preferenciaPersistida)
            return "PREFERENCIA_PERDIDA";

        return "SUCESSO";
    }
}
