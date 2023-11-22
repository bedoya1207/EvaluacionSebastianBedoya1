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
class Matriz {
    private int[][] matriz = new int[5][5];

    public void leerSecuencia(Scanner scanner) {
        try {
            System.out.println("Ingrese un número y su ubicación en la matriz (fila, columna): ");
            int numero = scanner.nextInt();
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            validarEntrada(fila, columna);

            this.matriz[fila][columna] = numero;
            generarSecuenciales(fila, columna);
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Formato de entrada incorrecto.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void mostrarMatriz() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    private void generarSecuenciales(int fila, int columna) {
        int valor = matriz[fila][columna];

        // Generar secuencia en la fila hacia la derecha
        for (int i = columna + 1; i < 5; i++) {
            matriz[fila][i] = ++valor;
        }

        valor = matriz[fila][columna];

        // Generar secuencia en la fila hacia la izquierda
        for (int i = columna - 1; i >= 0; i--) {
            matriz[fila][i] = ++valor;
        }

        valor = matriz[fila][columna];

        // Generar secuencia en la columna hacia abajo
        for (int i = fila + 1; i < 5; i++) {
            matriz[i][columna] = ++valor;
        }

        valor = matriz[fila][columna];

        // Generar secuencia en la columna hacia arriba
        for (int i = fila - 1; i >= 0; i--) {
            matriz[i][columna] = ++valor;
        }
    }
    private void validarEntrada(int fila, int columna) {
        if (fila < 0 || fila >= 5 || columna < 0 || columna >= 5) {
            throw new IllegalArgumentException("Ubicación fuera de los límites de la matriz.");
        }
    }
}


