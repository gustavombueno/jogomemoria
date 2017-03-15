package code;

/**
 * @author Gustavo Moraes Bueno
 */
public class ResultadoJogo {
    
    public String vencedorJogo(int pontosJogador, int pontosComputador) {
        if (pontosJogador == pontosComputador) {
            return "Incrível, tivemos um empate!!!";

        } else if (pontosJogador > pontosComputador) {
            return "Parabéns, você venceu!!!";

        } else if (pontosJogador < pontosComputador) {
            return "Você perdeu! :( Tente novamente!!!";
        }
        return null;
    }
}
