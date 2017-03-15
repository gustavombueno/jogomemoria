package code;

import com.sun.org.apache.bcel.internal.util.SecuritySupport;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

/**
 *
 * @author Gustavo Moraes Bueno
 */
public class MemoriaGame extends JFrame implements ActionListener {

    Container JANELA;
    int totalPecas = 0;
    JButton[] pecas;
    JLabel lblAcertosJogador;
    JLabel lblErrosJogador;
    JLabel lblAcertosComputador;
    JLabel lblErrosComputador;

    String path1 = MemoriaGame.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    String path = new File(".").getAbsolutePath();
    String blankCard = "src\\imgs\\blank\\interrogacao.png";
    String diretorioCards = "src\\imgs\\cards\\";
    ArrayList<String> arrCard = new ArrayList<String>();
    ArrayList<String> arrCardGame = new ArrayList<String>();
    ArrayList<Integer> arrCardGameChance = new ArrayList<Integer>();
    ArrayList<String> arrMemoriaComputador = new ArrayList<String>();

    Timer timer;
    Timer timerShower;
    Timer timerComparador;

    boolean comparando = false;
    boolean opcaoEscolhaComputador = false;

    int statusMostrarOculta = 0;

    int primeiraEscolha = -1;
    int segundaEscolha = -1;

    int qtdJogadasJogador = 0;
    int qtdAcertosJogador = 0;

    int qtdJogadasComputador = 0;
    int qtdAcertosComputador = 0;

    int controlaMemoriaComputador = 0;
    int fimJogo = 0;
    int lvlMemoria = 0;

    //Objetos
    ListaArquivos objListaArquivos = new ListaArquivos();
    Audio objTocadorSom = new Audio();

    /**
     * Creates new form MemoriaJava
     */
    public MemoriaGame(int ptotalLacunaTabela, int pLevelMemoria, String level) {
        try {

            path = path.substring(0, path.length() - 1);

            objTocadorSom.emiteSom(path + "\\src\\audio\\newgame.wav");

            totalPecas = ptotalLacunaTabela;
            lvlMemoria = pLevelMemoria;

            JANELA = getContentPane();
            JANELA.setLayout(null);
            setSize(400, 300);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            lblAcertosJogador = new JLabel();
            lblErrosJogador = new JLabel();
            lblAcertosComputador = new JLabel();
            lblErrosComputador = new JLabel();

            lblAcertosJogador.setText("Jogador acertou: ");
            lblErrosJogador.setText("Jogador errou: ");
            lblAcertosComputador.setText("Computador acertou: ");
            lblErrosComputador.setText("Computador errou: ");

            JANELA.add(lblAcertosJogador);
            JANELA.add(lblErrosJogador);
            JANELA.add(lblAcertosComputador);
            JANELA.add(lblErrosComputador);

            lblAcertosJogador.setBounds(20, 5, 300, 20);
            lblErrosJogador.setBounds(20, 22, 300, 20);

            lblAcertosComputador.setBounds(200, 5, 300, 20);
            lblErrosComputador.setBounds(200, 22, 300, 20);

            this.setResizable(false);

            //Cria um array de botões
            pecas = new JButton[totalPecas];

            //Cria todas as peças na tela
            for (int i = 0; i < totalPecas; i++) {
                pecas[i] = new JButton();
                pecas[i].setIcon(new ImageIcon(path + blankCard));

                JANELA.add(pecas[i]);
                pecas[i].setVisible(true);
                pecas[i].setEnabled(true);
            }

            if (totalPecas == 12) {
                this.setSize(550, 450);
                pecas[0].setBounds(40, 50, 100, 100);
                pecas[1].setBounds(160, 50, 100, 100);
                pecas[2].setBounds(280, 50, 100, 100);
                pecas[3].setBounds(400, 50, 100, 100);
                pecas[4].setBounds(40, 160, 100, 100);
                pecas[5].setBounds(160, 160, 100, 100);
                pecas[6].setBounds(280, 160, 100, 100);
                pecas[7].setBounds(400, 160, 100, 100);
                pecas[8].setBounds(40, 280, 100, 100);
                pecas[9].setBounds(160, 280, 100, 100);
                pecas[10].setBounds(280, 280, 100, 100);
                pecas[11].setBounds(400, 280, 100, 100);

            } else if (totalPecas == 20) {
                this.setSize(650, 520);

                pecas[0].setBounds(30, 50, 100, 100);
                pecas[1].setBounds(150, 50, 100, 100);
                pecas[2].setBounds(270, 50, 100, 100);
                pecas[3].setBounds(390, 50, 100, 100);
                pecas[4].setBounds(510, 50, 100, 100);
                pecas[5].setBounds(30, 160, 100, 100);
                pecas[6].setBounds(150, 160, 100, 100);
                pecas[7].setBounds(270, 160, 100, 100);
                pecas[8].setBounds(390, 160, 100, 100);
                pecas[9].setBounds(510, 160, 100, 100);
                pecas[10].setBounds(30, 270, 100, 100);
                pecas[11].setBounds(150, 270, 100, 100);
                pecas[12].setBounds(270, 270, 100, 100);
                pecas[13].setBounds(390, 270, 100, 100);
                pecas[14].setBounds(510, 270, 100, 100);
                pecas[15].setBounds(30, 380, 100, 100);
                pecas[16].setBounds(150, 380, 100, 100);
                pecas[17].setBounds(270, 380, 100, 100);
                pecas[18].setBounds(390, 380, 100, 100);
                pecas[19].setBounds(510, 380, 100, 100);

            } else if (totalPecas == 24) {
                this.setSize(780, 600);

                pecas[0].setBounds(40, 50, 100, 100);
                pecas[1].setBounds(160, 50, 100, 100);
                pecas[2].setBounds(280, 50, 100, 100);
                pecas[3].setBounds(400, 50, 100, 100);
                pecas[4].setBounds(520, 50, 100, 100);
                pecas[5].setBounds(640, 50, 100, 100);
                pecas[6].setBounds(40, 160, 100, 100);
                pecas[7].setBounds(160, 160, 100, 100);
                pecas[8].setBounds(280, 160, 100, 100);
                pecas[9].setBounds(400, 160, 100, 100);
                pecas[10].setBounds(520, 160, 100, 100);
                pecas[11].setBounds(640, 160, 100, 100);
                pecas[12].setBounds(40, 280, 100, 100);
                pecas[13].setBounds(160, 280, 100, 100);
                pecas[14].setBounds(280, 280, 100, 100);
                pecas[15].setBounds(400, 280, 100, 100);
                pecas[16].setBounds(520, 280, 100, 100);
                pecas[17].setBounds(640, 280, 100, 100);
                pecas[18].setBounds(40, 400, 100, 100);
                pecas[19].setBounds(160, 400, 100, 100);
                pecas[20].setBounds(280, 400, 100, 100);
                pecas[21].setBounds(400, 400, 100, 100);
                pecas[22].setBounds(520, 400, 100, 100);
                pecas[23].setBounds(640, 400, 100, 100);

            } else if (totalPecas == 30) {
                this.setSize(780, 660);

                pecas[0].setBounds(30, 50, 100, 100);
                pecas[1].setBounds(150, 50, 100, 100);
                pecas[2].setBounds(270, 50, 100, 100);
                pecas[3].setBounds(390, 50, 100, 100);
                pecas[4].setBounds(510, 50, 100, 100);
                pecas[5].setBounds(630, 50, 100, 100);
                pecas[6].setBounds(30, 160, 100, 100);
                pecas[7].setBounds(150, 160, 100, 100);
                pecas[8].setBounds(270, 160, 100, 100);
                pecas[9].setBounds(390, 160, 100, 100);
                pecas[10].setBounds(510, 160, 100, 100);
                pecas[11].setBounds(630, 160, 100, 100);
                pecas[12].setBounds(30, 270, 100, 100);
                pecas[13].setBounds(150, 270, 100, 100);
                pecas[14].setBounds(270, 270, 100, 100);
                pecas[15].setBounds(390, 270, 100, 100);
                pecas[16].setBounds(510, 270, 100, 100);
                pecas[17].setBounds(630, 270, 100, 100);
                pecas[18].setBounds(30, 380, 100, 100);
                pecas[19].setBounds(150, 380, 100, 100);
                pecas[20].setBounds(270, 380, 100, 100);
                pecas[21].setBounds(390, 380, 100, 100);
                pecas[22].setBounds(510, 380, 100, 100);
                pecas[23].setBounds(630, 380, 100, 100);
                pecas[24].setBounds(30, 490, 100, 100);
                pecas[25].setBounds(150, 490, 100, 100);
                pecas[26].setBounds(270, 490, 100, 100);
                pecas[27].setBounds(390, 490, 100, 100);
                pecas[28].setBounds(510, 490, 100, 100);
                pecas[29].setBounds(630, 490, 100, 100);
            }

            this.setLocationRelativeTo(null);

            System.out.println(path);

            totalPecas = ptotalLacunaTabela;
            lvlMemoria = pLevelMemoria;

            lblErrosJogador.setText(lblErrosJogador.getText().substring(0, lblErrosJogador.getText().indexOf(":") + 1) + " " + qtdJogadasJogador);
            lblAcertosJogador.setText(lblAcertosJogador.getText().substring(0, lblAcertosJogador.getText().indexOf(":") + 1) + " " + qtdAcertosJogador);

            lblErrosComputador.setText(lblErrosComputador.getText().substring(0, lblErrosComputador.getText().indexOf(":") + 1) + " " + qtdJogadasComputador);
            lblAcertosComputador.setText(lblAcertosComputador.getText().substring(0, lblAcertosComputador.getText().indexOf(":") + 1) + " " + qtdAcertosComputador);

            //Carrega os arquivos no ArrayList
            arrCard = objListaArquivos.listarArquivos(path + diretorioCards);

            //Sorteia as imagens de maneira aleatória
            Collections.shuffle(arrCard);

            //Duplica as imagens 
            for (int i = 0; i < totalPecas / 2; i++) {
                arrCardGame.add(arrCard.get(i));
                arrCardGame.add(arrCard.get(i));
            }

            //Sorteia as imagens no game
            Collections.shuffle(arrCardGame);

            criaImagensPadrao();
            this.setTitle("Memória Ambiental - Dificuldade: " + level);
            //From nao Dimensionavel
            this.setResizable(false);

            memoriaComputador();

            timerComparador = new Timer(2300, new MemoriaGame.TemporizadorInicial());
        } catch (Exception ex) {
            //JOptionPane.showConfirmDialog(this, ex.toString(), null, WIDTH);
        }

    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < pecas.length; i++) {
            if (e.getSource() == pecas[i]) {
                if (comparando == false) {
                    exibeEscolhas(i);
                    comparaEscolhas();
                    timerComparador.restart();
                }
            }
        }
    }

    private void criaImagensPadrao() {
        timer = new javax.swing.Timer(1200, new MemoriaGame.TemporizadorInicial());

        //Inicia o timer
        timer.start();

        int controladorTempo = 400 * totalPecas;

        timerShower = new javax.swing.Timer(controladorTempo, new MemoriaGame.TemporizadorInicial());
        timerShower.start();
    }

    public class TemporizadorInicial implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                if (statusMostrarOculta == 0) {

                    mostraImagens();
                    statusMostrarOculta = 1;

                } else if (statusMostrarOculta == 1) {
                    retornaImagensBranco();
                    statusMostrarOculta = 2;
                }

                timer.stop();

                if (statusMostrarOculta == 2) {
                    timerShower.stop();

                }

                if (statusMostrarOculta == 2 || statusMostrarOculta == 5) {
                    controlaFimJogo();

                }

                if (statusMostrarOculta == 3) {
                    statusMostrarOculta = 4;
                    ocultaEscolhaErrada();
                }

                //Computador
                if (statusMostrarOculta == 5) {
                    verificaPossibilidadeJogadasComputador();

                    sorteiaPossibilidadeJogadasComputador();
                    escolhePossibilidadeJogadasComputador();
                }

                if (statusMostrarOculta == 6) {
                    exibeEscolhasComputador();
                    comparaEscolhasComputador();
                }

                if (statusMostrarOculta == 7) {
                    ocultaEscolhaErradaComputador();
                }

                if (statusMostrarOculta == 6) {
                    statusMostrarOculta = 7;
                }
            } catch (Exception ex) {
                System.out.println("Thread Error: " + ex.toString());
            }
        }
    }

    public void mostraImagens() {
        try {
            //Cria todos as peças na tela
            for (int i = 0; i < totalPecas; i++) {
                pecas[i].setIcon(new ImageIcon(arrCardGame.get(i)));
            }
        } catch (Exception ex) {
        }
    }

    public void retornaImagensBranco() {
        try {
            //Cria todos as peças na tela
            for (int i = 0; i < totalPecas; i++) {
                pecas[i].setIcon(new ImageIcon(path + blankCard));                

                //Configura a action para as peças
                pecas[i].addActionListener(this);
            }
        } catch (Exception ex) {
            System.out.println("Erro retornaImagensBranco(): " + ex.toString());
        }
    }

    public void exibeEscolhas(int i) {
        try {
            if (primeiraEscolha == -1) {
                primeiraEscolha = i;
                pecas[primeiraEscolha].setIcon(new ImageIcon(arrCardGame.get(primeiraEscolha)));
            } else if (primeiraEscolha != -1 && primeiraEscolha != i) {
                segundaEscolha = i;
                pecas[segundaEscolha].setIcon(new ImageIcon(arrCardGame.get(segundaEscolha)));
            }
        } catch (Exception ex) {
            System.out.println("Erro exibeEscolhas() " + ex.toString());
        }
    }

    public void comparaEscolhas() {
        try {
            if (primeiraEscolha != -1 && segundaEscolha != -1) {
                comparando = true;

                qtdJogadasJogador = qtdJogadasJogador + 1;
                lblErrosJogador.setText(lblErrosJogador.getText().substring(0, lblErrosJogador.getText().indexOf(":") + 1) + " " + qtdJogadasJogador);

                if (pecas[primeiraEscolha].getIcon().toString().equals(pecas[segundaEscolha].getIcon().toString()) && primeiraEscolha != segundaEscolha) {

                    pecas[primeiraEscolha].setEnabled(false);
                    pecas[segundaEscolha].setEnabled(false);

                    objTocadorSom.emiteSom(path + "src\\audio\\jogador-acertou.wav");

                    qtdAcertosJogador = qtdAcertosJogador + 1;
                    lblAcertosJogador.setText(lblAcertosJogador.getText().substring(0, lblAcertosJogador.getText().indexOf(":") + 1) + " " + qtdAcertosJogador);

                    primeiraEscolha = -1;
                    segundaEscolha = -1;
                    statusMostrarOculta = 2;

                    comparando = false;
                } else {
                    objTocadorSom.emiteSom(path + "src\\audio\\jogador-errou.wav");

                    statusMostrarOculta = 3;

                    timerComparador.restart();
                }
            }

        } catch (Exception ex) {
            System.out.println("Erro comparaEscolhas() " + ex.toString());
        }
    }

    public void ocultaEscolhaErrada() {
        try {
            adicionaOpcaoErradaMemoriaComputador();

            if (statusMostrarOculta == 4) {

                pecas[primeiraEscolha].setIcon(new ImageIcon(path + blankCard));
                pecas[segundaEscolha].setIcon(new ImageIcon(path + blankCard));

                primeiraEscolha = -1;
                segundaEscolha = -1;

                statusMostrarOculta = 5;
                comparando = false;
            }
        } catch (Exception ex) {
            System.out.println("Erro ocultaEscolhaErrada() " + ex.toString());
        }
    }

    //Computador     
    public void verificaPossibilidadeJogadasComputador() {
        try {
            comparando = true;
            arrCardGameChance.clear();

            for (int i = 0; i < arrCardGame.size(); i++) {
                if (!arrCardGame.get(i).toString().equals(pecas[i].getIcon().toString())
                        && (pecas[i].getIcon().toString().equals(path + blankCard))
                        && pecas[i].isEnabled()) {

                    arrCardGameChance.add(i);
                }
            }

        } catch (Exception ex) {
            System.out.println("Erro verificaPossibilidadeJogadasComputador() " + ex.toString());
        }
    }

    private void memoriaComputador() {
        int valor = 0;

        //Prepara o ArrayList para ser populado 
        for (int i = 0; i < totalPecas; i++) {
            arrMemoriaComputador.add("");
        }

        //Randomiza as posição onde o computador irá memorizar
        int index1 = 0;

        while (index1 < lvlMemoria) {
            valor = (int) (Math.random() * totalPecas);

            if (arrMemoriaComputador.get(valor).equals("")) {
                index1++;
            }
            arrMemoriaComputador.set(valor, arrCardGame.get(valor));
        }

        for (int i = 0; i < totalPecas; i++) {
            System.out.println(i + arrMemoriaComputador.get(i));
        }
    }

    public void sorteiaPossibilidadeJogadasComputador() {
        try {
            Collections.shuffle(arrCardGameChance);
        } catch (Exception ex) {
            System.out.println("Erro sorteiaPossibilidadeJogadasComputador() " + ex.toString());
        }
    }

    public void escolhePossibilidadeJogadasComputador() {
        try {
            opcaoEscolhaComputador = false;

            for (int index1 = 0; index1 < totalPecas; index1++) {
                for (int index2 = index1 + 1; index2 < totalPecas; index2++) {

                    //Verifica se a opção escolhida pelo computador é válida
                    for (int index3 = 0; index3 < arrCardGameChance.size(); index3++) {
                        for (int index4 = index3 + 1; index4 < arrCardGameChance.size(); index4++) {
                            if ((arrMemoriaComputador.get(index1).equals(arrMemoriaComputador.get(index2))
                                    && index1 != index2 && opcaoEscolhaComputador == false)
                                    && (!arrMemoriaComputador.get(index1).equals("") && !arrMemoriaComputador.get(index2).equals(""))
                                    && index1 == arrCardGameChance.get(index3) && index2 == arrCardGameChance.get(index4)) {

                                primeiraEscolha = index1;
                                segundaEscolha = index2;
                                opcaoEscolhaComputador = true;

                                System.out.println("passou");

                                System.out.println("C1 " + primeiraEscolha);
                                System.out.println("C2 " + segundaEscolha);

                                statusMostrarOculta = 6;

                                break;
                            }
                        }
                    }
                }
            }

            if (opcaoEscolhaComputador == false) {
                primeiraEscolha = arrCardGameChance.get(0);
                segundaEscolha = arrCardGameChance.get(1);
                System.out.println("Comp1 random " + primeiraEscolha);
                System.out.println("Comp2 random " + segundaEscolha);

                opcaoEscolhaComputador = true;
                statusMostrarOculta = 6;
            }
        } catch (Exception ex) {
            System.out.println("Erro escolhePossibilidadeComputador " + ex.toString());
        }
    }

    public void exibeEscolhasComputador() {
        try {
            pecas[primeiraEscolha].setIcon(new ImageIcon(arrCardGame.get(primeiraEscolha)));
            pecas[segundaEscolha].setIcon(new ImageIcon(arrCardGame.get(segundaEscolha)));
        } catch (Exception ex) {
            System.out.println("Erro exibeEscolhasComputador() " + ex.toString());
        }
    }

    public void comparaEscolhasComputador() {
        try {
            if (primeiraEscolha != -1 && segundaEscolha != -1) {

                qtdJogadasComputador = qtdJogadasComputador + 1;
                lblErrosComputador.setText(lblErrosComputador.getText().substring(0, lblErrosComputador.getText().indexOf(":") + 1) + " " + qtdJogadasComputador);

                if (pecas[primeiraEscolha].getIcon().toString().equals(pecas[segundaEscolha].getIcon().toString()) && primeiraEscolha != segundaEscolha) {

                    pecas[primeiraEscolha].setEnabled(false);
                    pecas[segundaEscolha].setEnabled(false);

                    objTocadorSom.emiteSom(path + "src\\audio\\computador-acertou.wav");

                    qtdAcertosComputador = qtdAcertosComputador + 1;
                    lblAcertosComputador.setText(lblAcertosComputador.getText().substring(0, lblAcertosComputador.getText().indexOf(":") + 1) + " " + qtdAcertosComputador);

                    primeiraEscolha = -1;
                    segundaEscolha = -1;
                    statusMostrarOculta = 5;
                } else {
                    objTocadorSom.emiteSom(path + "src\\audio\\computador-errou.wav");
                    statusMostrarOculta = 6;

                    timerComparador.restart();
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro comparaEscolhasComputador() " + ex.toString());
        }
    }

    public void ocultaEscolhaErradaComputador() {
        try {
            adicionaOpcaoErradaMemoriaComputador();

            if (statusMostrarOculta == 7) {

                pecas[primeiraEscolha].setIcon(new ImageIcon(path + blankCard));
                pecas[segundaEscolha].setIcon(new ImageIcon(path + blankCard));

                primeiraEscolha = -1;
                segundaEscolha = -1;
                comparando = false;

                statusMostrarOculta = 2;
            }
        } catch (Exception ex) {
            System.out.println("Erro ocultaEscolhaErradaComputador() " + ex.toString());
        }
    }

    public void adicionaOpcaoErradaMemoriaComputador() {
        arrMemoriaComputador.set(primeiraEscolha, arrCardGame.get(primeiraEscolha));
        arrMemoriaComputador.set(segundaEscolha, arrCardGame.get(segundaEscolha));
    }

    //------------------------------------------------------------------------------
    public void controlaFimJogo() {
        try {
            int contadorFinal = 0;
            String rendimento = null;

            for (int i = 0; i < totalPecas; i++) {
                if (!pecas[i].getIcon().toString().equals(path + blankCard)) {
                    contadorFinal = contadorFinal + 1;
                }

                if (totalPecas == contadorFinal) {
                    String vencedor = null;
                    System.out.println("Total Jogadas: " + qtdJogadasJogador + " Total Jogadas Acertadas: " + qtdAcertosJogador);
                    ResultadoJogo objRendimentoJogador = new ResultadoJogo();

                    vencedor = objRendimentoJogador.vencedorJogo(qtdAcertosJogador, qtdAcertosComputador);
                    if (qtdAcertosJogador > qtdAcertosComputador) {
                        objTocadorSom.emiteSom(path + "src\\audio\\vitoria.wav");
                    } else {
                        objTocadorSom.emiteSom(path + "src\\audio\\derrota.wav");
                    }
                    statusMostrarOculta = 8;

                    int resp = JOptionPane.showConfirmDialog(null, vencedor + "\nPontos do Jogador: " + qtdAcertosJogador + "\nPontos do Computador: " + qtdAcertosComputador + " \n", "Fim de Jogo! \nDeseja jogar novamente?", JOptionPane.INFORMATION_MESSAGE);

                    if (resp == JOptionPane.YES_OPTION) {
                        this.dispose();
                        new newMemoria().show();
                    } else {
                        this.dispose();
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println("Erro controlaFimJogo() " + ex.toString());
        }
    }
}
