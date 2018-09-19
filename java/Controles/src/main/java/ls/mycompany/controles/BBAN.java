/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ls.mycompany.controles;

/**
 *
 * @author ls
 * 
 * @version 1.1.0
 */
public class BBAN {

    private BBAN() {
    }
    
    /***
     * Vérifie que le compte BBAN est valide
     * 
     * @param nombre
     *      Le numéro de compte bancaire
     * @return 
     *      TRUE si le numéro de compte est valide, FALSE sinon
     * 
     * @version 1.0.0
     * 
     * @throws IllegalArgumentException
     */
    public static boolean check(String nombre){
        if(nombre==null){
            throw new IllegalArgumentException();
        }
        String s = filtreChar(nombre);
        if(s.length()!=12){
            return false;
        }
        int r = Integer.valueOf(s.substring(10));
        int res = Commun.modulo97(s.substring(0, 10));
        if(res==0){
            res = 97;
        }
        return res == r;
    }
    
    /***
     * Filtre le numéro de compte pour ne garder que les caractères autorisés
     * @param numero
     *  Le numéro de compte BBAN
     * @return 
     *  Le numéro de compte sans les caractères non autorisés
     * 
     * @throws IllegalArgumentException
     */
    public static String filtreChar(String numero){
        if(numero==null){
            throw new IllegalArgumentException();
        }
        StringBuilder buf = new StringBuilder();
        for(char c : numero.toCharArray()){
            if((c>='0')&&(c<='9')){
                buf.append(c);
            }
        }
        return buf.toString();
    }
    
    /**
     * Transforme un numéro BBAN belge en Iban
     * @param numero
     *  le numéro BBAN belge
     * @return 
     * le numéro IBAN généré
     * 
     * @throws IllegalArgumentException
     */
    public static String toIban(String numero){
        if(numero==null){
            throw new IllegalArgumentException();
        }
        if(!check(numero)){
            throw new IllegalArgumentException("Le numéro de compte BBAN n'est pas valide ("+numero+")");
        }
        String s = filtreChar(numero);
        String cc = IBAN.calculModulo("BE", s);
        return "BE" + cc + s;
    }
}
