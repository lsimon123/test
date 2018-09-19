/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ls.mycompany.controles;

/**
 *
 * @author ls
 */
public class IBAN {
    
    private IBAN(){}

    /**
     * Filtre le numéro de compte IBAN pour retirer les caractères autres que les lettres de A-Z et les chiffres de 0-9
     * @param numero le numéro de compte IBAN
     * @return le numéro de compte IBAN appuré des caractères non autorisés
     * 
     * @throws IllegalArgumentException
     */
    public static String filtreChar(String numero) {
        if(numero==null){
            throw new IllegalArgumentException();
        }
        StringBuilder buf = new StringBuilder();
        for (char c : numero.toCharArray()) {
            if ((c >= 'a') && (c <= 'z')) {
                c = (char) (c - 'a' + 'A');
            }
            if ((c >= 'A') && (c <= 'Z')) {
                buf.append(c);
            }
            if ((c >= '0') && (c <= '9')) {
                buf.append(c);
            }
        }
        return buf.toString();
    }
    
    /***
     * Transforme les lettres composant le code IBAN en leur équivalent en nombre
     * @param nombre le compte IBAN
     * @return le compte IBAN où les lettres ont été remplacées par des chiffres
     * 
     * @throws IllegalArgumentException
     */
    public static String convertirLettreEnChiffre(String nombre){
        if(nombre==null){
            throw new IllegalArgumentException();
        }
        StringBuilder buf = new StringBuilder();
        for(char c : nombre.toCharArray()){
            if((c>='0')&&(c<='9')){
                buf.append(c);
            }
            else{
                int i = c - 'A' + 10;
                buf.append(Integer.toString(i));
            }
        }
        return buf.toString();
    }
    
    /***
     * Calcul le check digit d'un numéro IBAN
     * @param pays le code pays du numéro IBAN
     * @param numero le numéro de compte IBAN sans les 4 premiers caractères
     * @return le modulo en deux caractères
     * 
     * @throws IllegalArgumentException
     */
    public static String calculModulo(String pays, String numero){
        if(numero==null){
            throw new IllegalArgumentException();
        }
        if(pays==null){
            throw new IllegalArgumentException();
        }
       
        String s = numero + pays + "00";
        int res = Commun.modulo97(convertirLettreEnChiffre(s));
//        res = Commun.resteDivision(convertirLettreEnChiffre(s), 98);
        res = 98 - res;
        return String.format("%02d", res);
    }
    
    /***
     * Calcule le check digit d'un numéro de compte
     * @param numero le compte IBAN
     * @return le check digit calculé du numéro de compte
     * 
     * @throws IllegalArgumentException
     */
    public static String calculModulo(String numero){
        if(numero==null){
            throw new IllegalArgumentException();
        }
        return calculModulo(numero.substring(0, 2), numero.substring(4));
    }

    /***
     * Vérifie si un numéro de compte IBAN est valide.
     * Les controles sont :
     * - la longueur du numéro de compte, minimum 14, maximum 34
     * - le numéro a un check digit valide
     * 
     * @param nombre le numéro de compte
     * @return TRUE si le numéro est valide, FALSE sinon
     * 
     * @throws IllegalArgumentException
     */
    public static boolean check(String nombre) {
        if(nombre==null){
            throw new IllegalArgumentException();
        }
        boolean resultat = true;
        
        // retrait de caractères non conforme
        String s = filtreChar(nombre);

        // Vérification de la longueur minimale du nombre
        if (resultat) {
            resultat = s.length() >= 14;
        }
        
        // Vérification de la longueur maximale du nombre
        if (resultat) {
            resultat = s.length() <= 34;
        }

        if (resultat) {
            StringBuilder buf = new StringBuilder();
            buf.append(s.substring(4));
            buf.append(s.substring(0, 4));
            int r = Commun.modulo97(convertirLettreEnChiffre(buf.toString()));
            resultat = r ==1;
//            String r = s.substring(2, 4);
//            resultat = r.equals(calculModulo(s.substring(0,2), buf.toString()));
        }
        return resultat;
    }
    
    /***
     * Formatte un numéro de compte IBAN en séparant le numéro par bloc de 4 symboles
     * @param numero le compte IBAN
     * @return le compte formaté
     * 
     * @throws IllegalArgumentException
     */
    public static String format(String numero){
        if(numero==null){
            throw new IllegalArgumentException();
        }
        StringBuilder buf = new StringBuilder();
        int i = 0;
        String s = filtreChar(numero);
        int l = s.length();
        while(i<l){
            if(buf.length()>0){
                buf.append(" ");
            }
            buf.append(s.substring(i, Math.min(i+4,l)));
            i+=4;
        }
        return buf.toString();
    }
    
    /***
     * Converti un numéro IBAN en numéro BBAN
     * @param numero le compte IBAN
     * @return le numéro BBAN
     * 
     * @throws IllegalArgumentException
     */
    public static String toBban(String numero){
        if(numero==null){
            throw new IllegalArgumentException();
        }
        String s = filtreChar(numero);
        if("BE".equals(s.substring(0, 2))){
            if((s.length()==16)&&check(numero)){
                return s.substring(4);
            }
        }
        return s.substring(4);
    }
    

}
