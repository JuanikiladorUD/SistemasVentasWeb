package Modelo;

import java.util.Objects;

/**
 * @author Aylin Camila Orjuela Leiva & Juan Pablo Cuellar Florez
 */

public class Cliente {

    private int id;
    private String Dni, Nom, Direccion, Estado;

    public Cliente() {
    }

    public Cliente(int id, String Dni, String Nom, String Direccion, String Estado) {
        this.id = id;
        this.Dni = Dni;
        this.Nom = Nom;
        this.Direccion = Direccion;
        this.Estado = Estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.Dni);
        hash = 23 * hash + Objects.hashCode(this.Nom);
        hash = 23 * hash + Objects.hashCode(this.Direccion);
        hash = 23 * hash + Objects.hashCode(this.Estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Dni, other.Dni)) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.Direccion, other.Direccion)) {
            return false;
        }
        return Objects.equals(this.Estado, other.Estado);
    }
    
}
