package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jpl7.*;

import java.io.IOException;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main extends Application {
    List<String> validNumbers=new ArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sodoku.fxml"));
        primaryStage.setTitle("Sodoku solver");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image("/sample/resources/ai.png"));
        primaryStage.show();
    }

    public static void forward(ActionEvent actionEvent, String pageName, Class myClass) throws IOException {
        Parent parent = FXMLLoader.load(myClass.getResource(pageName));
        Scene scene = new Scene(parent);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

public void sodoku(){
    Query query=new Query("consult('soduku.pl')");
    query.hasSolution();
    ArrayList<String> s = new ArrayList<>();


    query=new Query("sodoku([[_,_,_,_,_,_,_,1,_],\n" +
            "[_,_,_,_,_,2,_,_,3],\n" +
            "[_,_,_,4,_,_,_,_,_],\n" +
            "[_,_,_,_,_,_,5,_,_],\n" +
            "[4,_,1,6,_,_,_,_,_],\n" +
            "[_,_,7,1,_,_,_,_,_],\n" +
            "[_,5,_,_,_,_,2,_,_],\n" +
            "[_,_,_,_,8,_,_,4,_],\n" +
            "[_,3,_,9,1,_,_,_,_]],Solution).");
    Map<String, Term>[] solutions = query.allSolutions();
    for(int i=0;i<solutions.length;i++){
        System.out.println(solutions[i]);
        for (String cs:solutions[i].toString().split("")) {
            if(validNumbers.contains(cs)){
                s.add(cs);
            }
        }
        for (String t:s) {
            System.out.println(t);
        }
    }

//    for (int i=0 ; i<solutions.length ; i++ )
//    {
//        System.out.println("X = " + solutions[i].get("Solution"));
//
//        //ADD THIS PART
//        Term term = solutions[i].get("Solution");
//
//        int u=0;
//        for (Term oneTerm : term.toTermArray())
//        {
//            System.out.println("term["+i+"]["+u+"] = " + oneTerm);
//            u++;
//        }
//    }
}
    public static void main(String[] args) {
        launch(args);
    }

    public void init(){
        validNumbers.add("1");
        validNumbers.add("2");
        validNumbers.add("3");
        validNumbers.add("4");
        validNumbers.add("5");
        validNumbers.add("6");
        validNumbers.add("7");
        validNumbers.add("8");
        validNumbers.add("9");
    }
}
