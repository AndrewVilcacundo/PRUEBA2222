import java.io.Serializable;
public class Datos implements Serializable {
    String nombre;
    Double codigo;
    int cedula;
    String apellido;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Datos(String nombre, Double codigo, int cedula, String apellido) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cedula = cedula;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", cedula=" + cedula +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}

