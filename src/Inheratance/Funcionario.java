package Inheratance;


public abstract class Funcionario {
    private final String nome;
    private final String sobrenome;
    private final String cpf;
    private final double salarioBase;
    private final double planoSaude;
    private final double valeTransporte;
    public Funcionario(String nome, String sobrenome, String cpf, double salarioBase,
    double planoSaude, double valeTransporte) {
                if(nome.trim().isEmpty()){
                    throw new IllegalArgumentException("Nome não pode ser vazio");
                }
                this.nome = nome;
                
                if(sobrenome.trim().isEmpty()){
                    throw new IllegalArgumentException("Sobrenome não pode ser vazio");
                }
                this.sobrenome = sobrenome;
                
                if(!cpf.trim().matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}")){
                    throw new IllegalArgumentException("CPF invalido");
                }
                this.cpf = cpf;
        
                if(salarioBase < 0){
                    throw new IllegalArgumentException("Salario base não pode ser negativo");
                }
                this.salarioBase = salarioBase;
                
                if(planoSaude < 0){
                    throw new IllegalArgumentException("Plano de saude não pode ser negativo");
                }
                this.planoSaude = planoSaude;
                
                if(valeTransporte < 0){
                    throw new IllegalArgumentException("Vale transporte não pode ser negativo");
                }
                this.valeTransporte = valeTransporte;
    }
    public final String getNome() {
        return nome;
    }
    public final String getSobrenome() {
        return sobrenome;
    }
    public final String getCpf() {
        return cpf;
    }
    public final double getSalarioBase() {
        return salarioBase;
    }
    public final double getPlanoSaude() {
        return planoSaude;
    }
    public final double getValeTransporte() {
        return valeTransporte;
    }

    public abstract double getSalarioBruto();
    
    public double getSalarioLiquido(){
        return getSalarioBruto() - getValeTransporte() - getPlanoSaude();
    }

    public String geraContracheque(){
        return String.format("Nome: %s %s\n", getNome(), getSobrenome()) + 
                "CPF: " + getCpf() + "\n" +  
                String.format("Salario-Base: R$%.2f\n", getSalarioBase()) +  
                String.format("Bruto: R$%.2f\n", getSalarioBruto()) + "Descontos:\n" + 
                String.format("   Vale Transporte:  -R$%.2f\n", getValeTransporte()) + 
                String.format("   Plano de saude:  -R$%.2f\n", getPlanoSaude()) + 
                String.format("Liquido: R$%.2f\n", getSalarioLiquido());
    }

    @Override
    public String toString(){
        return geraContracheque();
    }

}
