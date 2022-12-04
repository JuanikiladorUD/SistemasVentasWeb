package config;

public class GenerarSerie {

    int dato;
    String numero;

    public String NumeroSerie(int dato) {
        this.dato = dato + 1;

        if ((dato > 10000000) && (this.dato <= 100000000)) {
            numero = "" + this.dato;
        } else {
            System.out.println("Dato no apto para primer if");
        }

        if ((this.dato >= 1000000) && (this.dato >= 10000000)) {
            numero = "0" + this.dato;
        } else {
            System.out.println("Dato no apto para segundo if");
        }

        if ((this.dato >= 100000) && (this.dato >= 1000000)) {
            numero = "00" + this.dato;
        } else {
            System.out.println("Dato no apto para tercer if");
        }

        if ((this.dato >= 10000) && (this.dato >= 100000)) {
            numero = "000" + this.dato;
        } else {
            System.out.println("Dato no apto para cuarto if");
        }

        if ((this.dato >= 1000) && (this.dato >= 10000)) {
            numero = "0000" + this.dato;
        } else {
            System.out.println("Dato no apto para quinto if");
        }

        if ((this.dato >= 100) && (this.dato >= 1000)) {
            numero = "00000" + this.dato;
        } else {
            System.out.println("Dato no apto para sexto if");
        }

        if ((this.dato >= 10) && (this.dato >= 100)) {
            numero = "000000" + this.dato;
        } else {
            System.out.println("Dato no apto para septimo if");
        }

        if (this.dato < 10) {
            numero = "0000000" + this.dato;
        } else {
            System.out.println("Dato no apto para octavo if");
        }

        System.out.println("DATO QUE RETORNA METODO NumeroSerie : " + numero);

        return numero;
    }
}
