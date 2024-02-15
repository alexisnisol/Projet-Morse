public class ExecutableMorse {
    public static void main(String[] args){

        Lettre lA = new Lettre('A');
        Lettre lB = new Lettre('B');
        Lettre lEspace = new Lettre(' ');
        assert lA.toNumero() == 0;
        assert lB.toNumero() == 1;
        assert lEspace.toNumero() == 26;

        Lettre n = new Lettre('N');
        assert n.toChar() == 'N';
        assert n.toMorse().equals("===_=");


        Lettre a = new Lettre("=_===");
        assert a.toMorse().equals("=_===");
        assert a.toChar() == 'A';

        Lettre morseEspace = new Lettre("_");
        assert morseEspace.toMorse().equals("_");
        assert morseEspace.toChar() == ' ';

        Texte texte = new Texte("BA BA");
        assert texte.toMorse().equals("===_=_=_=___=_===_______===_=_=_=___=_===");
        assert texte.contient(a);
        assert texte.contient(lB);
        assert texte.contient(lEspace);

        Texte sansEspace = new Texte("TOTO");
        assert sansEspace.toMorse().equals("===___===_===_===___===___===_===_===");
        assert !sansEspace.contient(n);
        assert !sansEspace.contient(a);
        assert !sansEspace.contient(lEspace);


        Texte phrase = new Texte("UNE PHRASE EN MORSE");
        phrase.toSon();

        System.out.println(texte.decode("===___===_===_===___===___===_===_==="));
    }
}
