package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;

public class ValidadorMedicoConOtraConsultaEnElMismoHorario {

    private ConsultaRepository consultaRepository;

    public void validar(DatosReservaConsulta datos) {

        var medicoTieneOtraConsultaEnElMismoHorario = consultaRepository.existsByMedicoIdAndFecha(datos.idMedico(), datos.fecha());
        if (medicoTieneOtraConsultaEnElMismoHorario) {
            throw new ValidacionException("MEDICO YA TIENE OTRA CONSULTA EN ESA MISMA FECHA Y HORA");
        }

    }

}
