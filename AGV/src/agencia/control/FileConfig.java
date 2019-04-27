/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agencia.control;

 //* @author PauloMatheus 


 
public class FileConfig 
{
   
    public static final String SEPARATOR = System.getProperty("file.separator");
    public static final String diretorioUsuario = "usuarios.txt";
    public static final String diretorioViagens = SEPARATOR+"NetBeansProjects"+SEPARATOR+"ProjetoLab"+SEPARATOR+"viagens.txt";
    public static final String USER_PATH = "files" + SEPARATOR + "user.txt";
    public static void main (String[] args){
        System.out.println(USER_PATH); 
        System.out.println(diretorioUsuario);
    }
    
} 