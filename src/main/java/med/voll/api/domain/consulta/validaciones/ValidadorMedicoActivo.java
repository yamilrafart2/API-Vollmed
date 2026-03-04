package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import med.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoActivo {

    private MedicoRepository medicoRepository;

    public void validar(DatosReservaConsulta datos) {

        // ELECCIÓN DEL MEDICO OPCIONAL
        if (datos.idMedico() == null) {
            return;
        }
        var medicoEstaActivo = medicoRepository.findActivoById(datos.idMedico());
        if (!medicoEstaActivo) {
            throw new ValidacionException("CONSULTA NO PUEDE SER RESERVADA CON MEDICO EXCLUIDO");
        }

    }

}
