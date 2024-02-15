import java.util.Arrays;
import java.util.List;

public class Lettre{
    
    private char lettre;
    private static List<String> alphabetMorse = Arrays.asList("=_===", 
            "===_=_=_=", "===_===_=", "===_=_=", "=", "=_=_===_=",
            "===_===_=", "=_=_=_=", "=_=", "=_===_===_===", "===_=_===",
            "=_===_=_=", "===_===", "===_=", "===_===_===", "=_===_===_=",
            "===_===_=_===", "=_===_=", "=_=_=", "===", "=_=_===",
            "=_=_=_===", "=_===_===", "===_=_=_===", "===_=_===_===",
            "===_===_=_=", "_");


    public Lettre(char lettre){
        this.lettre = lettre;
    }

    public Lettre(String morse){

        int a = 0;
        for (String alphabet : alphabetMorse) {
            if(alphabet.equals(morse)){
                if(a == 26) this.lettre = ' ';
                else this.lettre = (char)(a + 'A');
                
            }
            ++a;
        }
    }

    public int toNumero(){
        if(this.lettre == ' '){
            return 26;
        }
        return this.lettre - 'A';
    }

    public char toChar(){
        return this.lettre;
    }

    public String toMorse(){
        return alphabetMorse.get(toNumero());
    }

    @Override
    public String toString(){
        return "Lettre : " + this.lettre + " En morse : " + toMorse();
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(!(o instanceof Lettre)) return false;

        Lettre lettreObj = (Lettre) o;
        return lettreObj.lettre == this.lettre;
    }

}
