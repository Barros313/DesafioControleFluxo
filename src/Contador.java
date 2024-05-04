import java.util.InputMismatchException;
import java.util.Scanner;
import exception.ParametrosInvalidosException;

public class Contador {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstParameter = getInteger("Insira o primeiro parâmetro: ", scan);
        int secondParameter = getInteger("Insira o segundo parâmetro: ", scan);
        scan.close();

        try {
            countParameters(firstParameter, secondParameter);
        } catch (ParametrosInvalidosException e) {
            System.err.println("O segundo parâmetro deve ser maior que o primeiro");
        }
    }

    static void countParameters(int firstParameter, int secondParameter) throws ParametrosInvalidosException {
        if (firstParameter > secondParameter) throw new ParametrosInvalidosException();

        int count = secondParameter - firstParameter;

        for (int i = 1; i <= count; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }

    static int getInteger(String request, Scanner scan) {
        int output = 0;
        boolean stillException = false;

        System.out.print(request);

        do {
            try {
                stillException = false;
                output = scan.nextInt();
            } catch (InputMismatchException e) {
                stillException = true;
                System.err.println("Input precisa ser um número inteiro. Tente novamente:");
                scan.next();
            }
        } while (stillException);

        return output;
    }
}
