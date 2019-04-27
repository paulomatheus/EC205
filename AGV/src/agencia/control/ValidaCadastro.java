package agencia.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class ValidaCadastro {

    public boolean validaCampos(String campo1, String campo2, String campo3) {
        boolean retorno = true;
        if (campo1.equals("") || campo2.equals("") || campo3.equals("")) {
            retorno = false;
        }
        return retorno;
    }

    public boolean validaCampoViagem(String campo1, String campo2, String campo3, String campo4, String campo5) {
        boolean retorno = true;
        if (campo1.equals("") || campo2.equals("") || campo3.equals("") || campo4.equals("") || campo5.equals("")) {
            retorno = false;
        }

        return retorno;
    }

    public boolean validaSenhas(String senha1, String senha2) {
        boolean retorno = true;
        if (!senha1.equals(senha2)) {
            retorno = false;
        }

        return retorno;
    }

    public boolean validacao(String loginSistema) {

        boolean retorno = true;
        String nome = "", texto = "",/*DIRETÓRIO*/ diretorio = "usuarios.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                if (texto.contains("Coordenador") || texto.contains(("Assessor"))) {
                    for (int i = 0; i < texto.length(); i++) {
                        //Verifica se já não existe o login
                        if (texto.charAt(i) == ':') {
                            break;
                        } else {
                            nome += texto.charAt(i);
                        }
                    }
                    if (nome.equals(loginSistema)) {
                        retorno = false;
                    }
                } else if (texto.startsWith("**")) {
                    nome = "";
                    continue;
                }
            }
            buffR.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
        }
        return retorno;
    }
}
