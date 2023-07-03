import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static List<Funcionarios> listaFuncionarios = new ArrayList<>();

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de funcionários");
        int qtdeFuncionarios = scanner.nextInt();
        scanner.nextLine();

        cadastrarFuncionários(qtdeFuncionarios, scanner);

        efetuarAumento(scanner);

        imprimirListaFuncionarios();

    }

    public static void cadastrarFuncionários(int qtdeFuncionarios, Scanner scanner) {

        for (int idx = 0; idx < qtdeFuncionarios; idx++) {
            System.out.println("Informe agora o nome do funcionário(a): ");
            String nomeFunci = scanner.nextLine();

            System.out.printf("%s, Salário: %n", nomeFunci);
            double salarioFunci = scanner.nextDouble();

            System.out.printf("%s, Id: %n", nomeFunci);
            int idFunci = scanner.nextInt();
            scanner.nextLine();

            while (!checarID(idFunci)) {
                System.out.printf("Id %d já existe. Atribua outro: ", idFunci);
                idFunci = scanner.nextInt();
                scanner.nextLine();
            }

            listaFuncionarios.add(new Funcionarios(idFunci, nomeFunci, salarioFunci));
        }
    }
    public static boolean checarID(int id) {
        return listaFuncionarios.stream().noneMatch(x -> x.getId() == id);
    }

    public static void efetuarAumento(Scanner scanner) {
        System.out.println("Informe agora o id do funcionário ao qual deseja realizar o aumento de salário: ");
        int idAumentoSal = scanner.nextInt();
        scanner.nextLine();

        if (checarID(idAumentoSal)) {
            System.out.println("Id não existe");
        } else {
            System.out.println("Qual a porcentagem de aumento? ");
            double aumentoSal = scanner.nextDouble() / 100;

            for (Funcionarios funci : listaFuncionarios) {
                if (funci.getId() == idAumentoSal) {
                    funci.setSalario(funci.getSalario() * (aumentoSal + 1));
                }
            }
        }
    }

    public static void imprimirListaFuncionarios() {

        System.out.println("\nLista de Funcionários: ");
        for (Funcionarios funci : listaFuncionarios) {
            System.out.println(funci);
        }
    }

}