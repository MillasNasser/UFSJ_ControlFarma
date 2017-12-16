package model;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciarProdutoDAO {
     
    
    public void cadastrar(Produto produto) throws IOException{
        String arq = "/home/user/Projetos/MVC/database/produtos.txt";
        try (PrintWriter escritor = new PrintWriter(
                new BufferedWriter(new FileWriter(arq, true)))) {
            escritor.println(produto.getCodigo());
            escritor.println(produto.getNome());
            escritor.println(produto.getPreco());
            escritor.println(produto.getCategoria());
            escritor.println(produto.getPrincipioAtivo());
            escritor.println(produto.getLote());
            escritor.println(produto.getValidade());
            escritor.close();                        
        }
    }    
    
    public void excluir(int codigo) throws IOException{
        
        String path = "/home/user/Projetos/MVC/database/produtos.txt";
        try {
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);
            String texto = "", temp;
            while((temp = lerArq.readLine()) != null){ // enquanto não for o fim do arquivo.
                
                if(!temp.equals(Integer.toString(codigo))){
                    
                    texto += temp + "\n";
                    texto += lerArq.readLine() + "\n";
                    texto += lerArq.readLine() + "\n";
                    texto += lerArq.readLine() + "\n";
                    texto += lerArq.readLine() + "\n";
                    texto += lerArq.readLine() + "\n";
                    texto += lerArq.readLine() + "\n";
                }else{
                    
                    temp = lerArq.readLine() + "\n";
                    temp = lerArq.readLine() + "\n";
                    temp = lerArq.readLine() + "\n";
                    temp = lerArq.readLine() + "\n";
                    temp = lerArq.readLine() + "\n";
                    temp = lerArq.readLine() + "\n";
                }
            }
            try (PrintWriter escritor = new PrintWriter(
                new BufferedWriter(new FileWriter(path, true)))) {
                escritor.println(texto);                
                escritor.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DAOBdFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public List<Produto> listar() throws IOException, ParseException{
        
        String path = "/home/user/Projetos/MVC/database/produtos.txt";
        List<Produto> lista = new ArrayList<>();
        FileReader arq = new FileReader(path);
        BufferedReader lerArq = new BufferedReader(arq);
        String texto = "", temp;        
        while((temp = lerArq.readLine()) != null){ // enquanto não for o fim do arquivo.
            
            Produto p = new Produto();
            p.setCodigo(Integer.parseInt(temp));
            p.setNome(lerArq.readLine());
            p.setPreco(Float.parseFloat(lerArq.readLine()));
            p.setCategoria(lerArq.readLine());
            p.setPrincipioAtivo(lerArq.readLine());
            p.setLote(lerArq.readLine());
            p.setValidade(new SimpleDateFormat().parse(lerArq.readLine()));
        }
        return lista;
    }
    
    public void atualizar(Produto produto) throws IOException{
        
        new GerenciarProdutoDAO().excluir(produto.getCodigo());
        new GerenciarProdutoDAO().cadastrar(produto);
    }
}
