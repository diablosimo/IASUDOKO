package sample;

import org.jpl7.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sodoku {
    private static final String FILE_NAME = "soduku.pl";

    public static List<String> sodoku(List<String> list) {
        ArrayList<String> resultat = new ArrayList<>();
        Query query = new Query("consult('" + FILE_NAME + "')");
        query.hasSolution();
        String matrice=format(list);

        //String matrice="[[3,_,_,_,_,_,_,_,5],[9,_,4,8,6,_,_,_,_],[_,_,_,_,_,_,4,8,_],[_,_,_,1,_,_,_,3,6],[_,_,8,_,_,_,_,_,4],[_,_,_,_,_,_,1,7,_],[4,_,_,_,9,_,5,_,3], [_,6,_,_,7,_,_,_,8],[_,_,9,_,_,3,_,_,_]]";



        query = new Query("sodoku(" + matrice + ",Solution).");
        Map<String, Term>[] solutions = query.allSolutions();
        if(solutions==null || solutions.length==0){
            return null;
        }

        for (int i = 0; i <solutions.length ; i++) {
            System.out.println(solutions[i]);
        }

        for (String caractere : solutions[0].toString().split("")) {
            if(caractere.equals("_")){
                return null;
            }
            if (Util.isValidNumber(caractere)) {
                resultat.add(caractere);
            }
        }
        System.out.println(matrice);
        System.out.println(" output:");
        printM(resultat);
        return resultat;
    }

    public static String format(List<String> list) {
        System.out.println(" linput:");
        printM(list);
        String resultat = "[";
        for (int i = 1; i <= list.size(); i++) {
            if ((i - 1) % 9 == 0) {
                resultat += "[";
            }
            resultat += list.get(i - 1);
            if (i % 9 == 0) {
                resultat += "]";
                if(i!=81){
                    resultat += ",";
                }
            } else {
                resultat += ", ";
            }
        }
        resultat += "]";

        return resultat;
    }

    public static void printM(List<String> list){
        for (int i = 1; i <=list.size() ; i++) {
            if(i%9!=0){
                System.out.print(list.get(i-1));
                System.out.print("  ");
            }else{
                System.out.println(list.get(i-1));
            }
        }
    }
}
