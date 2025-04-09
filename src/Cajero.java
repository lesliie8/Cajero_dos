import java.util.Scanner;

public class Cajero {

    private Cuenta cuenta;
    private Scanner scanner;

    public Cajero(Cuenta cuenta) {
        this.cuenta = cuenta;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Cuenta cuentaUsuario = new Cuenta(1234, 50000);
        Cajero cajero = new Cajero(cuentaUsuario);
        cajero.iniciar();
    }

    public void iniciar() {
        int intentos = 0;
        while (intentos < 3) {
            System.out.print("Ingrese su PIN: ");
            int pinIngre = scanner.nextInt();
            if (cuenta.verificarPin(pinIngre)) {
                System.out.println("Bienvenido Pichurria");
                mostrarMenu();
                return;
            } else {
                intentos++;
                System.out.println("PIN Incorrecto. Mosca Pues " + intentos);
            }
        }
        System.out.println("Mera Gueva, cuenta bloqueada");
    }

    private void mostrarMenu() {
        Opciones opcion = null;
        do {
            System.out.println("\nBienvenido a su cajero Groserón");
            System.out.println("1. Consultar Chichigua");
            System.out.println("2. Retirar Menuda");
            System.out.println("3. Depositar Money");
            System.out.println("4. cambiar el pin");
            System.out.println("5. Abrirse del Parche");
            System.out.print("Seleccione pues una opción: ");
            int eleccion = scanner.nextInt();

            if (eleccion < 1 || eleccion > 5) {
                System.out.println("Bájese de esa nube ome gueva");
                continue;
            }

            opcion = Opciones.values()[eleccion - 1];
            procesar(opcion);

        } while (opcion != Opciones.SALIR);
    }

    private void procesar(Opciones opcion) {
        switch (opcion) {

            case CONSULTAR_DINERO:
                System.out.println("Ay marica, tenés apenas $$ " + cuenta.getSaldo());
                break;

            case RETIRAR_DINERO:
                System.out.print("¿Cuánta chichigua vas a sacar? ");
                double retiro = scanner.nextDouble();

                if (cuenta.retirar(retiro)) {
                    System.out.println("Su nueva chichigua es de: " + cuenta.getSaldo());
                } else {
                    System.out.println("Oigan a esta gueva, si solo tenés " + cuenta.getSaldo());
                }
                break;

            case DEPOSITAR_DINERO:

                System.out.print("Empiece a cantar, ¿cuánta plata va a consignar? ");
                double deposito = scanner.nextDouble();

                if (cuenta.depositar(deposito)) {
                    System.out.println("Mano, su consignación fue exitosa. Su saldo es: " + cuenta.getSaldo());
                } else {
                    System.out.println("Despierte pues mijo, ¡ese valor no se puede!");
                }
                break;
                
            case CAMBIAR_PIN:
                System.out.print("Ingrese su PIN actual: ");
                int actual = scanner.nextInt();
            
                if (!cuenta.verificarPin(actual)) {
                    System.out.println("Ese no es el PIN correcto, bobo.");
                    break;
                }
            
                System.out.print("Ingrese su nuevo PIN de 4 dígitos: ");
                int nuevo = scanner.nextInt();
            
                if (cuenta.cambiarPin(actual, nuevo)) {
                    System.out.println("¡PIN cambiado con éxito!");
                } else {
                    System.out.println("El nuevo PIN es inválido, parcero.");
                }
                break;
            
            case SALIR:
                System.out.println("Suerte pues mi amor, ¡perdete!");
                break;
        }
    }
}

