/**
 *
 * @author Jv Loreti
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame{
    Menu menu;
    TextArea textArea1;
    TextArea textArea2;
    
    public Frame(){
        //Define o título
        super("sU casa mi casa");
        //Define as dimensões
        super.setSize(1000, 700);
        
        //Define o layout
        super.setLayout(new BorderLayout());
        
        //Inicializa o menu
        menu = new Menu();
        //Define a posição do menu
        super.add(menu, BorderLayout.PAGE_START);
        
        //Inicializa a área de texto 1
        textArea1 = new TextArea();
        //Define a posição da área de texto 1
        super.add(textArea1, BorderLayout.LINE_START);
        
        //Inicializa a área de texto 2
        textArea2 = new TextArea();
        //Define a posição da área de texto 2
        super.add(textArea2, BorderLayout.LINE_END);
        
        //Comunicação entre a janela e o método "enviarTexto", por meio de uma classe anônima (Menu -> Frame -> TextArea)
        menu.setTextListener(new TextListener(){
            @Override
            public void enviarTexto(String txt){
                if(txt == "Botão da esquerda foi clicado"){ //Esquerda
                    textArea1.escreverTexto(txt + "\n");
                }else if(txt == "Botão da direita foi clicado"){ //Direita
                    textArea2.escreverTexto(txt + "\n");
                }else{ //Ambos
                    textArea1.escreverTexto(txt + "\n");
                    textArea2.escreverTexto(txt + "\n");
                }
            }
        });
        
        //Exibe o JFrame
        super.setVisible(true);
        //Encerra a operação ao fechar o JFrame
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
