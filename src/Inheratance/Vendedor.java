package Inheratance;

public class Vendedor extends Funcionario {
    private final double taxaComissao;
    private final double vendasBrutas;
    public Vendedor(String nome, String sobrenome, String cpf, double salarioBase, double planoSaude,
            double valeTransporte, double taxaComissao, double vendasBrutas) {
        super(nome, sobrenome, cpf, salarioBase, planoSaude, valeTransporte);

    if(taxaComissao < 0 || taxaComissao > 1){
        throw new IllegalArgumentException("Taxa de comisssão deve ser uma valor entre 0 e 1");
    }
    this.taxaComissao = taxaComissao;
            
    if(vendasBrutas < 0){
        throw new IllegalArgumentException("Vendas brutas não podem ser negativas");
    }
    this.vendasBrutas = vendasBrutas;
}
    public double getTaxaComissao() {
        return taxaComissao;
    }
    public double getVendasBrutas() {
        return vendasBrutas;
    }

    public double getComissao(){
        return getTaxaComissao() * getVendasBrutas();
    }

    @Override
    public double getSalarioBruto(){
        return getSalarioBase() + getComissao();
    }

    @Override
    public String geraContracheque(){
        return  "Cargo: Vendedor\n" + 
                String.format("Comissao: R$%.2f\n", getComissao()) + 
                String.format("Taxa de Comissao: %.2f%%\n", getTaxaComissao()*100) + 
                super.geraContracheque();
    }
    
}
