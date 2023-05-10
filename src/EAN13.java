/**
 * @author Gabriele Di Santo
 * @version 1.0
 * @since 10/05/2023
 */

 public class EAN13 {
    
    private String codice;

   /**
    * Funzione che inizializza il codice EAN13
    * @param c valore del codice EAN13
    */
    public void setCodice(String c){
        codice = c;
    }

    public String getCodice(){
        return codice;
    }

    /**
     * Metodo per la verifica della correttezza del codice
     * @return True se il codice è valido, False se il codice non è valido
     * @throws NullPointerException se il codice è vuoto o nullo
     */
    public boolean verificaCodice(){

        // Verifica se l'attributo codice è vuoto o nullo
        if (codice.equals(null) || codice == ""){
            throw new NullPointerException("Il codice EAN-13 risulta vuoto o nullo");
        }

        // Verifica se la lunghezza dell'attributo codice è di 13
        if(codice.length() != 13) {
            return false;
        }
        
        // Implementazione dell'algoritmo di calcolo della cifra di controllo
        int somma = 0;
        int cifra;
        
        for(int i = 0; i < codice.length() - 1; i++) {   
            cifra = Character.getNumericValue(codice.charAt(i));
            
            if(i % 2 == 0) {
                somma += cifra * 1;  
            } else {
                somma += cifra * 3; 
            }
        }
        
        // Calcola la cifra di controllo
        int cifraDiControllo = (10 - (somma % 10));

        // Confronta la cifra di controllo con quella contenuta nel codice EAN13 (ultima cifra)
        return cifraDiControllo == Character.getNumericValue(codice.charAt(12)); 
    }


}