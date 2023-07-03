public class Funcionarios {

    private final int id;
    private String nome;
    private double salario;

    public Funcionarios(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return String.format("Funcionário: %s, Id: #%d, Salário: %.2f", getNome(), getId(), getSalario());
    }
}
