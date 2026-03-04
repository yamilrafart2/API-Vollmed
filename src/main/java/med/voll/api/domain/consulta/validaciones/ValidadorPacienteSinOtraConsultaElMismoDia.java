package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosDetalleConsulta;

public class ValidadorPacienteSinOtraConsultaElMismoDia {

    private ConsultaRepository consultaRepository;

    public void validar(DatosDetalleConsulta datos) {

        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);
        var pacienteTieneOtraConsultaEnElDia = consultaRepository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);
        if (pacienteTieneOtraConsultaEnElDia) {
            throw new ValidacionException("PACIENTE YA TIENE UNA CONSULTA RESERVADA PARA ESE DIA");
        }

    }

}
