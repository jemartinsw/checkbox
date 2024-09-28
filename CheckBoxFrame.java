import java.awt.FlowLayout;//importa componente do tipo setlayout
import java.awt.Font;//importa tipo de fonte
import java.awt.event.ItemListener;//importa 
import java.awt.event.ItemEvent;//importa
import javax.swing.JFrame;//importa quadro
import javax.swing.JTextField;//importa input para digitar coisas
import javax.swing.JCheckBox;//Importa caixa de seleção
import java.awt.font.*;
import java.util.*;

public class CheckBoxFrame extends JFrame // herda jframe
{//inicio da classe checkboxframe
   private final JTextField textField;//uso exclusivo da classe somente leitura primeira variável jtextfield
   private final JCheckBox boldJCheckBox;//uso exclusivo da classe somente leitura primeira variável boldcheckbox
   private final JCheckBox italicJCheckBox;//uso exclusivo da classe somente leitura primeira variável italicjcheckbox
   private final JCheckBox underlineJCheckBox;
   
      public CheckBoxFrame()//exporta construtor que possui mesmo nome da classe e do arquivo
   {//
      super("JCheckBox Test");//define titulo superior jcheckboxtext
      setLayout(new FlowLayout());//modo fluido renderizacao

       textField = new JTextField("Watch the font style change", 20);//inserre texto no textfield e define o tamanho
      textField.setFont(new Font("Serif", Font.PLAIN, 14));//define fonte do texto,formatação e tamanho
      add(textField);//adiciona input para colocar o texto (linha 20) e formataçã e demais(linha22) dentro do quadro

      boldJCheckBox = new JCheckBox("Bold"); //insere texto na caixa bold
      italicJCheckBox = new JCheckBox("Italic"); //insere italico na caixa italic
      underlineJCheckBox = new JCheckBox("Underline");
      add(boldJCheckBox);//adiciona ot exto na tela
      add(italicJCheckBox);//adiocona o texto na tela
      add(underlineJCheckBox);

      CheckBoxHandler handler = new CheckBoxHandler();//
      boldJCheckBox.addItemListener(handler);//escutador da caixa bold
      italicJCheckBox.addItemListener(handler);//escutador da caixa italico
      underlineJCheckBox.addItemListener(handler);
   } //

   private class CheckBoxHandler implements ItemListener //injeta objeto itemlistener que recebe outra forma (tem forma poliformica)
   {//
//new itemlistener (){
//public checkboxhandler(){
//public item listener{
      @Override//sobrescreve
      public void itemStateChanged(ItemEvent event)//verifica se a informação trocou depoisdo usuario trocou a descelção do checkbox para selecionado. envia pro evento a situação do evento (se selecionado ou descelecionado)
      {//
         Font font = null;//declara variavel font ed valor nulo

         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && underlineJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);//verifica se os dois checkbox estoa seleiconado. bold e italico devem estar selecionados para executar a linha 45 (texto fica negrito e italico ao mesmo tempo)
         else if (boldJCheckBox.isSelected())
            font = new Font("Serif", Font.BOLD, 14);//se só a seleção do bold estiver feita, a linha 47 será executada
         else if (italicJCheckBox.isSelected())
            font = new Font("Serif", Font.ITALIC, 14);//só a seleção do bold estiver feita, a linha 48 será executada
         else
            font = new Font("Serif", Font.PLAIN, 14);// se não tiver nunhuma seleção, volta a configuração padrão inicial do texto

         textField.setFont(font); //define textfield font que foi declarada nos if acima

         if (underlineJCheckBox.isSelected()) {
            font = textField.getFont();
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute. UNDERLINE_ON);
            textField.setFont(font.deriveFont(attributes));
            font = new Font(attributes);
         }
      } //fecha 
   }//fecha classe polimorfica checkbox handler
}//fim da classe checkboxframe
