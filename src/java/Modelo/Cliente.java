package Modelo;

public class Cliente {
    private int id;
    private String Dni,Nom,Direccion,Estado;

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
    
    
}
