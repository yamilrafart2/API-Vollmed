package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.DatosActualizacionMedico;
import med.voll.api.domain.medico.DatosDetalleMedico;
import med.voll.api.domain.medico.DatosListaMedico;
import med.voll.api.domain.medico.DatosRegistroMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroMedico datos, UriComponentsBuilder uriBuilder) {

        System.out.println(datos);

        var medico = new Medico(datos);
        medicoRepository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleMedico(medico)); // 201 Created + nuevo médico + Location en Header

    }

    @GetMapping
    public ResponseEntity<Page<DatosListaMedico>> listar(@PageableDefault(size=10, sort={"nombre"}) Pageable paginacion) {

        var page = medicoRepository.findByActivoTrue(paginacion).map(DatosListaMedico::new);
        return ResponseEntity.ok(page); // 200 OK

    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionMedico datos) {

        var medico = medicoRepository.getReferenceById(datos.id());
        medico.actualizarInformacion(datos);
        return ResponseEntity.ok(new DatosDetalleMedico(medico)); // 200 OK + DTO del médico actualizado

    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {

        var medico = medicoRepository.getReferenceById(id);
        medico.eliminar();

        return ResponseEntity.noContent().build(); // 204 No Content

    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id) {

        var medico = medicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleMedico(medico)); // 200 OK + DTO del médico

    }

}
