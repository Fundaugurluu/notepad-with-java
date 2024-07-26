import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class File {
    GUI yeni;
    String fileName;
    String fileAdress;
    public File(GUI yeni) {
        this.yeni = yeni;
    }

    public void newFile() {
        yeni.textArea.setText("");
        yeni.window.setTitle("Yeni");
        fileName=null;
        fileAdress=null;

        }
public void open(){
        FileDialog fd= new FileDialog(yeni.window,"Aç", FileDialog.LOAD);
        fd.setVisible(true);
        //FileDialog jaavda dosya seçmek için kullanılan diyolog penceresi,aç diyolog pencersi başlığı ,
    // FileDialog.LOAD dp dosya açma modunda oldugunu belirtir bu modda kullanıcı yalnızca dosya seçebilir
//fd.setVisible(true) dp görünür hale getirir.

    if(fd.getFile()!=null)
    {
            fileName=fd.getFile();
            fileAdress=fd.getDirectory();
            yeni.window.setTitle(fileName);
    }

    try{
        BufferedReader br =new BufferedReader(new FileReader(fileAdress+fileName));
        yeni.textArea.setText("");
        String line = null;
        while((line = br.readLine())!=null)
        {

            yeni.textArea.append(line+ "/n");
        }  br.close();
    }
    catch(Exception e){
            System.out.println("DOSYA AÇILAMADI");
    }


}

public void save(){
      FileDialog fd= new FileDialog(yeni.window,"Kaydet",FileDialog.SAVE);
        fd.setVisible(true);
    if(fd.getFile()!=null)
    {
        fileName=fd.getFile();
        fileAdress=fd.getDirectory();
        yeni.window.setTitle(fileName);
    }

    try{
        FileWriter fw = new FileWriter(fileAdress+fileName);
        fw.write(yeni.textArea.getText());
        fw.close();
    }
    catch(Exception e){
        System.out.println("BİR ŞEYLER TERS GİTTİ");
    }
}

public void exit()
{
    System.exit(0);
}
    }
