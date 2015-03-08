package hnt.hematies;

/**
 * Created by Radnouman on 08/03/2015.
 */
public class hematies {

    public static String Resultat_hematies(float hematiesmm,double min,double max){
        String texte="";
        if(hematiesmm>min && hematiesmm<max){
            texte="pas danomalie détectée";
        }else{
            if(hematiesmm<min){
                texte="Le patient souffre  d'anémie.";
            }
            if(hematiesmm>max){
                texte="Le patient souffre de polyglobulie.";
            }
        }

      return texte;
    }

}
