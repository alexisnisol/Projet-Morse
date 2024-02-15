import java.util.ArrayList;
import java.util.List;

public class Texte {
    private List<Lettre> texte;

    public Texte(String chaine){
        this.texte = new ArrayList<>();
        for (int i = 0; i < chaine.length(); i++) {
            texte.add(new Lettre(chaine.charAt(i)));
        }
    }

    public String toMorse(){
        String txt = "";
        for (Lettre lettre : texte) {
            if(lettre.toChar() == ' '){
                txt += "____"; //4 symboles '_' et non 7, car on rajoute les 3 autres provenant du caractère suivant.
            }else{
                txt += (txt.isEmpty() ? "" : "___") + lettre.toMorse();
            }
        }
        return txt;
    }

    public boolean contient(Lettre lettre){
        return this.texte.contains(lettre);
    }

    public String decode(String texteEnMorse){
        String txtDecode = "";
        String[] phraseSplit = texteEnMorse.split("_______");
        for (String mot : phraseSplit) {
            txtDecode += (txtDecode.isEmpty() ? "" : " ");
            String[] motSplit = mot.split("___");
            for (String lettre : motSplit) {
                Lettre lettreMorse = new Lettre(lettre);
                txtDecode += lettreMorse.toChar();
                
            }
        }
        return txtDecode;
    }


    public void toSon(){
        Son r = new Son();
        

        String[] phraseSplit = toMorse().split("_______");
        for (String mot : phraseSplit) {
            String[] motSplit = mot.split("___");
            for (String lettre : motSplit) {
                String[] caracSplit = lettre.split("_");
                for(String carac : caracSplit){
                    System.out.println(carac);
                    if(carac.equals("=")){
                        r.tone(100);
                    }else{
                        r.tone(200);
                        r.pause();
                    }
                    r.pause();
                }
                r.pause();
                r.pause();
                r.pause();
            }
            r.pause();
            r.pause();
            r.pause();
            r.pause();
            r.pause();
            r.pause();
            r.pause();
            System.out.println(" ");
        }
    }

    @Override
    public String toString(){
        String txt = "";
        for (Lettre lettre : this.texte) {
            txt += lettre.toChar();
        }
        return "Texte : " + txt;
    }
}
