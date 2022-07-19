package base;
public class AssistenteAdministrativo {
    private final String nome;
    private final String sobrenome;
    private final String cpf;
    private final double salarioBase;
    private final double planoSaude;
    private final double valeTransporte;
    private final double horasExtras;
   
    public AssistenteAdministrativo(String nome, String sobrenome, String cpf, 
                                    double salarioBase, double planoSaude, 
                                    double valeTransporte, double horasExtras) {
        
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
        
        if(horasExtras < 0){
            throw new IllegalArgumentException("Horas extras não podem ser negativas");
        }
        this.horasExtras = horasExtras;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    public double getHorasExtras() {
        return horasExtras;
    }
    
    public double adicionalHorasExtras(){
        return getSalarioBase() / 220 * 1.5 * getHorasExtras();
    }

    public double getSalarioBruto(){
        return getSalarioBase() + adicionalHorasExtras();
    }

    public double getSalarioLiquido(){
        return getSalarioBruto() - getPlanoSaude() - getValeTransporte();
    }

    public String geraContracheque(){
        return String.format("Nome: %s %s\n", getNome(), getSobrenome()) + 
                "CPF: " + getCpf() + "\n" + 
                "Cargo: Assistente Administrativo\n" + 
                String.format("Salario-Base: R$%.2f\n", getSalarioBase()) + 
                String.format("Horas-extra: %.2f(R$%.2f)\n", getHorasExtras(), adicionalHorasExtras()) + 
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
