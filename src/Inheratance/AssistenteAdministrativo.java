package Inheratance;

public class AssistenteAdministrativo extends Funcionario{
    private final double horasExtras;

    public AssistenteAdministrativo(String nome, String sobrenome, String cpf, double salarioBase, double planoSaude,
            double valeTransporte, double horasExtras) {
        super(nome, sobrenome, cpf, salarioBase, planoSaude, valeTransporte);
        if(horasExtras < 0){
            throw new IllegalArgumentException("Horas extras não podem ser negativas");
        }
        this.horasExtras = horasExtras;
    }

    public double getHorasExtras() {
        return horasExtras;
    }
    
    public double adicionalHorasExtras(){
        return getSalarioBase() / 220 * 1.5 * getHorasExtras();
    }
    
    @Override
    public double getSalarioBruto(){
        return getSalarioBase() + adicionalHorasExtras();
    }

    @Override
    public String geraContracheque(){
        return "Cargo: Assistente Administrativo\n" +
        String.format("Horas-extra: %.2f(R$%.2f)\n", getHorasExtras(), adicionalHorasExtras()) +
         super.geraContracheque();
        
    }
}
