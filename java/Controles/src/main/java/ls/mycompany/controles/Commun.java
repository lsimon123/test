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
public class Commun {
    
    private Commun(){}

    /***
     * 
     * @param nombre
     * @param diviseur
     * @return 
     * 
     * @throws IllegalArgumentException
     */
    public static int resteDivision(String nombre, int diviseur) {
        if(nombre==null){
            throw new IllegalArgumentException();
        }
        if(diviseur==0){
            throw new IllegalArgumentException("Division par zéro");
        }
        int res = 0;
        for (byte b : nombre.getBytes()) {
            int i = b - '0';
            res = res * 10 + i;
            res = res % diviseur;
        }
        return res;
    }
    
    /***
     * 
     * @param nombre
     * @param diviseur
     * @return 
     * 
     * @throws IllegalArgumentException
     */
    public static int resteDivision(int nombre, int diviseur){
        if(diviseur==0){
            throw new IllegalArgumentException("Division par zéro");
        }
        return Commun.resteDivision(Integer.toString(nombre), diviseur);
    }
    
    /***
     * 
     * @param nombre
     * @return 
     * 
     * @throws IllegalArgumentException
     */
    public static int modulo97( String nombre ){
        if(nombre==null){
            throw new IllegalArgumentException();
        }
        return Commun.resteDivision(nombre, 97);
    }
    
    /***
     * 
     * @param nombre
     * @return 
     * 
     * @throws IllegalArgumentException
     */
    public static int modulo97( int nombre ){
        return resteDivision(nombre, 97);
    }
    
    /***
     * 
     * @param nombre
     * @return 
     * 
     * @throws IllegalArgumentException
     */
    public static int moduloComplement97( String nombre ){
        if(nombre==null){
            throw new IllegalArgumentException();
        }
        return 97 - Commun.resteDivision(nombre, 97);
    }
    
    /***
     * 
     * @param nombre
     * @return 
     * 
     * @throws IllegalArgumentException
     */
    public static int moduloComplement97( int nombre ){
        return 97 - resteDivision(nombre, 97);
    }
    
//    public static void main(String... args){
//        System.out.println(Commun.resteDivision("1996230911", 97));
//        System.out.println(Commun.resteDivision("3770458357", 97));
//        System.out.println(Commun.modulo97("1996230911"));
//        System.out.println(Commun.modulo97("3770458357"));
//        System.out.println(Commun.moduloComplement97("660401123"));
//        System.out.println(Commun.moduloComplement97("660401124"));
//        System.out.println(Commun.moduloComplement97("660401122"));
//        
//    }
}
