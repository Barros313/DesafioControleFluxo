import java.util.Scanner;
import exception.InvalidCountParameterException;

public class Contador {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.print("Insira o primeiro parâmetro: ");
        int firstParameter = scan.nextInt();

        System.out.print("Insira o segundo parâmetro: ");
        int secondParameter = scan.nextInt();

        try {
            countParameters(firstParameter, secondParameter);
        } catch (InvalidCountParameterException e) {
            System.err.println("O segundo parâmetro deve ser maior que o primeiro");
        }
    }

    static void countParameters(int firstParameter, int secondParameter) throws InvalidCountParameterException {
        if (firstParameter > secondParameter) throw new InvalidCountParameterException();

        int count = secondParameter - firstParameter;

        for (int i = 0; i <= count; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
