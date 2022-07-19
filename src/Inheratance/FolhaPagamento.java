package Inheratance;
import java.util.List;


import java.util.ArrayList;


public class FolhaPagamento {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        AssistenteAdministrativo a1 = new AssistenteAdministrativo(
        "Joao", 
        "Silva",
        "12345678900",
        2500, 
        330, 
        300, 
        2);

        AssistenteAdministrativo a2 = new AssistenteAdministrativo(
        "Maria", 
        "costa",
        "12345678910",
        3300, 
        700, 
        200, 
        10);

        Vendedor v0 = new Vendedor(
        "Carla", 
        "Sousa",
        "12345678908",
        2300, 
        300, 
        150, 
        0.3,
        5000);
        
        Vendedor v1 = new Vendedor(
        "Tiago", 
        "Kupper",
        "12345678907",
        3000, 
        500, 
        0, 
        0.4,
        7500);

        funcionarios.add(a1);
        funcionarios.add(a2);
        funcionarios.add(v0);
        funcionarios.add(v1);

        for(Funcionario funcionario : funcionarios){
            System.out.println(funcionario.geraContracheque());
        }
    }
}
