/**
 *
 * @author Jv Loreti
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener{
    JButton btnEsquerda;
    JButton btnDireita;
    JButton btnAmbos;
    TextListener tl;
    
    public Menu(){
        //Define a posição dos botões no menu
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Define como os botões serão exibidos
        btnEsquerda = new JButton("Esquerda");
        btnAmbos = new JButton("Ambos");
        btnDireita = new JButton("Direita");
        
        //Implementa os botões à interface TextListener
        btnEsquerda.addActionListener(this);
        btnAmbos.addActionListener(this);
        btnDireita.addActionListener(this);
        
        //Adiciona os botões à UI
        add(btnEsquerda);
        add(btnAmbos);
        add(btnDireita);
    }
    
    //Implementa a interface TextListener
    public void setTextListener(TextListener t){
        this.tl = t;
    }
    
    //Define a mensagem mostrada quando algum dos botões for clicado
    @Override
    public void actionPerformed(ActionEvent e){
        if(tl != null){
            JButton btnClicado = (JButton) e.getSource();

            if(btnClicado == btnEsquerda){
                tl.enviarTexto("Botão da esquerda foi clicado");
            }else if(btnClicado == btnDireita){
                tl.enviarTexto("Botão da direita foi clicado");
            }else if(btnClicado == btnAmbos){
                tl.enviarTexto("Ambos botões foram clicados");
            }
        }
    }
}
