/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */

public class DAOBdFuncionarios {
        
    public void salvar(Funcionario f) throws IOException{
        String arq = "/home/user/Projetos/MVC/database/base.txt";
        try (PrintWriter escritor = new PrintWriter(
                new BufferedWriter(new FileWriter(arq, true)))) {
            escritor.println(f.getNome());
            escritor.println(f.getCpf());
            escritor.close();
        }
    }
    
    public void listar(){
        
        String path = "/home/user/Projetos/MVC/database/base.txt";
        try {
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);
            
            String nome = lerArq.readLine();
            String cpf = lerArq.readLine();
            //TO-DO
            while(cpf != null){
                
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOBdFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
