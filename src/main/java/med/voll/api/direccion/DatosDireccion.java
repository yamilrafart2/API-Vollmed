package med.voll.api.direccion;

public record DatosDireccion(
        String calle,
        String numero,
        String complemento,
        String barrio,
        String codigoPostal,
        String ciudad,
        String estado
) {
}
