package Modelo;

public class Venta {
    int id,item,idcliente,idempleado,idproducto,cantidad;
    String Numserie,DescripcionP,fecha,estado;
    double precio,subtotal,monto;

    public Venta() {
    }

    public Venta(int id, int item, int idcliente, int idempleado, int idproducto, int cantidad, String Numserie, String DescripcionP, String fecha, String estado, double precio, double subtotal, double monto) {
        this.id = id;
        this.item = item;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.Numserie = Numserie;
        this.DescripcionP = DescripcionP;
        this.fecha = fecha;
        this.estado = estado;
        this.precio = precio;
        this.subtotal = subtotal;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNumserie() {
        return Numserie;
    }

    public void setNumserie(String Numserie) {
        this.Numserie = Numserie;
    }

    public String getDescripcionP() {
        return DescripcionP;
    }

    public void setDescripcionP(String DescripcionP) {
        this.DescripcionP = DescripcionP;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
