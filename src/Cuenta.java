public class Cuenta {

    private int pin;
    private double saldo;

    public Cuenta(int pinIni, double saldoIni) {
        this.pin = pinIni;
        this.saldo = saldoIni;
    }

    public boolean verificarPin(int pinIntentos) {
        return this.pin == pinIntentos;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean retirar(double saldoReti) {
        if (saldoReti > 0 && saldoReti <= saldo) {
            saldo -= saldoReti;
            return true;
        }
        return false;
    }

    public boolean cambiarPin(int pinActual, int nuevoPin) {
        if (this.pin == pinActual && String.valueOf(nuevoPin).length() == 4) {
            this.pin = nuevoPin;
            return true;
        }
        return false;
    }

    public boolean depositar(double nuevoDeposito) {
        if (nuevoDeposito > 0) {
            saldo += nuevoDeposito;
            return true;
        }
        return false;
    }
}



