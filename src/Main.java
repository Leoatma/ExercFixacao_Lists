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

        efetuarAumentoSalario(scanner);

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

            while (!checarExistenciaID(idFunci)) {
                System.out.printf("Id %d já existe. Atribua outro: ", idFunci);
                idFunci = scanner.nextInt();
                scanner.nextLine();
            }

            listaFuncionarios.add(new Funcionarios(idFunci, nomeFunci, salarioFunci));
        }
    }
    public static boolean checarExistenciaID(int id) {
        return listaFuncionarios.stream().noneMatch(x -> x.getId() == id); // se houver ocorrencia do id > false,  se não houver > true
    }

    public static void efetuarAumentoSalario(Scanner scanner) {
        System.out.println("Informe o id do funcionário ao qual deseja realizar o aumento de salário: ");
        int idAumentoSal = scanner.nextInt();
        scanner.nextLine();

        Funcionarios funcionario = listaFuncionarios.stream().filter(x -> x.getId() == idAumentoSal).findFirst().orElse(null);
        if (funcionario != null) {
            System.out.println("Qual a porcentagem de aumento? ");
            double aumentoSal = scanner.nextDouble() / 100;
            funcionario.setSalario(funcionario.getSalario() * (aumentoSal + 1));
        } else {
            System.out.println("Este id não existe.");
        }

    }

    public static void imprimirListaFuncionarios() {

        System.out.println("\nLista de Funcionários: ");
        for (Funcionarios funci : listaFuncionarios) {
            System.out.println(funci);
        }
    }

}