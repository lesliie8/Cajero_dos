public class App {
    public static void main(String[] args) throws Exception {
        Cuenta cuenta = new Cuenta(1234, 50000);
        Cajero cajero = new Cajero(cuenta);
        cajero.iniciar();

    }
}
