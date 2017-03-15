package code;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Gustavo Moraes Bueno
 */
public class ListaArquivos {

    public ArrayList<String> listarArquivos(String caminho) {

        try {
            File diretorio = new File(caminho);
            File fileList[] = diretorio.listFiles();

            ArrayList<String> arquivosListado = new ArrayList<String>();

            for (int i = 0; i < fileList.length; i++) {
                arquivosListado.add(fileList[i].getAbsolutePath());
            }

            return arquivosListado;

        } catch (Exception ex) {
            return null;
        }
    }
}
