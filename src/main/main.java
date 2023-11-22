package main;
import java.util.InputMismatchException;
import java.util.Scanner;



public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matriz matriz = new Matriz();

        try {
            matriz.leerSecuencia(scanner);
            matriz.mostrarMatriz();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
