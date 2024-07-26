import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ActionListener kullanıcı etkileişimlerine izin verir
public class GUI implements ActionListener {
    JTextArea textArea;
    JFrame window;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile,menuEdit,menuColor,menuFormat;
    JMenuItem inew,iopen,isave,iexit;
    JMenu menuFont,menuFontSize;
    JMenuItem iFontArial,iFontCSMS,iFontTNR,iFontSize8,iFontSize12,iFontSize16;

    File file=new File(this); //Guı dan aldığı için this kullanmalıymışız?
    Function_format format =new Function_format(this);
    public static void main(String[] args)
    {
        new GUI();
    }

 public GUI()
 {
createWindow();
createTextArea();
     createMenuBar();
     createFileMenu();
     createFormatMenu();
     format.selectedFont="Arial";
     format.createFont(12);
window.setVisible(true);
 }

 public void createWindow()
 {
  window=new JFrame("Not Defteri");
  window.setSize(800,600);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 }

 public void createTextArea(){
 textArea=new JTextArea();
 scrollPane= new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); //dikey ve yatay kaydırma çubugu gerektiğinde
    scrollPane.setBorder(BorderFactory.createEmptyBorder()); //Kenar boşlğu için
 window.add(scrollPane);

 }

 public void createMenuBar(){
menuBar=new JMenuBar();
window.setJMenuBar(menuBar);
      //set kullanmamızın nedeni Jmenubar nesnesini pencereye atıyo.
     //neden add değil? add bir metodu Jframe gibi nesnelerin içine eklemek için kullanılır.
     // menü çubuğu pencerenin özel bir bileşeni gibi düşün.
menuFile=new JMenu("Dosya");
menuBar.add(menuFile);

menuFormat=new JMenu("Format");
menuBar.add(menuFormat);
 }

public void createFileMenu(){
        //Jmenuitem den yeni nesne oluşturma ve file menuye ekleme.
    inew= new JMenuItem("Yeni");
    inew.addActionListener(this);
    inew.setActionCommand("Yeni");  //hangi menü ogesine tıklandığını anlamak için
    menuFile.add(inew);

    iopen= new JMenuItem("Aç");
    iopen.addActionListener(this);
    iopen.setActionCommand("Aç");
    menuFile.add(iopen);

    isave= new JMenuItem("Kaydet");
    menuFile.add(isave);
    isave.addActionListener(this);
    isave.setActionCommand("Kaydet");

    iexit= new JMenuItem("Çıkış");
    menuFile.add(iexit);
    iexit.addActionListener(this);
    iexit.setActionCommand("Çıkış");
}

public void createFormatMenu() {
    menuFont = new JMenu("Yazı Tipi");
    menuFormat.add(menuFont);

    iFontArial = new JMenuItem("Arial");
    iFontArial.addActionListener(this);
    iFontArial.setActionCommand("Arial");
    menuFont.add(iFontArial);

    iFontCSMS = new JMenuItem("Comic Sans MS");
    iFontCSMS.addActionListener(this);
    iFontCSMS.setActionCommand("Comic Sans MS");
    menuFont.add(iFontCSMS);

    iFontTNR = new JMenuItem("Times New Roman");
    iFontTNR.addActionListener(this);
    iFontTNR.setActionCommand("Times New Roman");
    menuFont.add(iFontTNR);

    menuFontSize = new JMenu("Yazı Tipi Boyutu");
    menuFormat.add(menuFontSize);

    iFontSize8 = new JMenuItem("8");
    iFontSize8.addActionListener(this);
    iFontSize8.setActionCommand("8");
    menuFontSize.add(iFontSize8);

    iFontSize12 = new JMenuItem("12");
    iFontSize12.addActionListener(this);
    iFontSize12.setActionCommand("12");
    menuFontSize.add(iFontSize12);

    iFontSize16 = new JMenuItem("16");
    iFontSize16.addActionListener(this);
    iFontSize16.setActionCommand("16");
    menuFontSize.add(iFontSize16);

}

    @Override
    public void actionPerformed(ActionEvent e) {
    String command=e.getActionCommand();
    //e, tıklama olayıyla ilgili bilgileri içeren bir ActionEvent nesnesi.
        //Eğer yeniye tıklandıysa
switch (command)
{
    case "Yeni": file.newFile(); break;
    case "Aç":file.open(); break;
    case "Kaydet":file.save(); break;
    case "Çıkış":file.exit(); break;
    case "Arial":format.setFont(command);
    case "Comic Sans MS":format.setFont(command);
    case "Times New Roman":format.setFont(command);
    case "8":format.createFont(8); break;
    case "12":format.createFont(12); break;
    case "16":format.createFont(16); break;



}


    }
}
