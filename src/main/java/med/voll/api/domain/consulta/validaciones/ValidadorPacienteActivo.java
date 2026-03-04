package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteActivo {

    private PacienteRepository pacienteRepository;

    public void validar(DatosReservaConsulta datos) {

        var pacienteEstaActivo = pacienteRepository.findActivoById(datos.idPaciente());
        if (!pacienteEstaActivo) {
            throw new ValidacionException("CONSULTA NO PUEDE SER RESERVADA CON PACIENTES EXCLUIDO");
        }

    }

}
