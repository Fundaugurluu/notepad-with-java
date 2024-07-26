import java.awt.*;

public class Function_format {
    GUI yeni;
    Font arial,comicSans,timesNewRoman;
    String selectedFont;
    public Function_format(GUI yeni){
        this.yeni=yeni;
    }

public void createFont(int fontSize)
{
arial =new Font("Arial",Font.PLAIN,fontSize);
    comicSans =new Font("Comic Sans MS",Font.PLAIN,fontSize);
    timesNewRoman =new Font("Times New Roman",Font.PLAIN,fontSize);
    setFont(selectedFont);
}

public void setFont(String font){
    selectedFont=font;
    switch (selectedFont){
        case "Arial":
            yeni.textArea.setFont(arial); break;
        case "Comic Sans MS":
            yeni.textArea.setFont(comicSans); break;
        case "Times New Roman":
            yeni.textArea.setFont(comicSans); break;
    }
}



}
