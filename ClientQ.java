/*
Amr Jamal
 */
package rmiquestion;


import java.rmi.RemoteException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Amr Jamal
 */
public class ClientQ extends Application {
    Scene scene1,scene2,scene3,scene4;
  private static RMIInterface newQuestion;
	private static RMIInterface getRandomQuestion;
	private static RMIInterface answerQuestion;
	private static RMIInterface removeQuestion;
    @Override
    public void start(Stage primaryStage) {
          
          try {
          Registry u =LocateRegistry.getRegistry("127.0.0.1",55882)   ;
            RMIInterface r =(RMIInterface)u.lookup("rmiquestion");
            
       
        primaryStage.setTitle("Amr Client");
      newQuestion = (RMIInterface) u.lookup("rmiquestion");
		getRandomQuestion = (RMIInterface) u.lookup("rmiquestion");
		answerQuestion = (RMIInterface) u.lookup("rmiquestion");
		removeQuestion = (RMIInterface) u.lookup("rmiquestion");  
                String response="";
    //Implementation Qu = new Implementation();           
//Scene 1

Button button1= new Button("Add New Question");
Button button2= new Button("Get Question");
Button button3= new Button("Remove Question");
Button clear= new Button("Clear");
button1.setOnAction(e -> primaryStage.setScene(scene2));
button2.setOnAction(e -> primaryStage.setScene(scene3));
button3.setOnAction(e -> primaryStage.setScene(scene4));
 

VBox layout1 = new VBox(20);     
layout1.getChildren().addAll(button1,button2,button3);
button1.setTranslateX(100);
button1.setTranslateY(50);
button2.setTranslateX(110);
button2.setTranslateY(60);
button3.setTranslateX(100);
button3.setTranslateY(70);
scene1= new Scene(layout1, 300, 230);

//Scene 2
Label label2= new Label("Add New Question");
Button button4= new Button("Go Back");
button4.setOnAction(e -> primaryStage.setScene(scene1));

 Button btn = new Button("Add");
            Label lab = new Label("Enter You'r Question");
             TextField Question = new TextField();
             Label lab2 = new Label("Answer");
              Label out = new Label();
             TextField answer = new TextField();    
        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {     
                try {
        String inputText = Question.getText();
        String inputText2 = answer.getText();
                    out.setText(r.newQuestion(inputText, inputText2));
                    
                } catch (Exception e) {
                }
 
            }
        });
 
VBox layout2= new VBox(20);
layout2.getChildren().addAll(label2,lab,Question,lab2,answer,out,btn,button4);
scene2= new Scene(layout2,350,420);
       
//Scene 3
Label label3= new Label("Get Question");
Button button5= new Button("Go Back");
button5.setOnAction(e -> primaryStage.setScene(scene1));
 
Button btn2 = new Button("Check Answer");
            response = r.getRandomQuestion();
            Label lab3 = new Label(response);
            Label lab4 = new Label("Answer ? ");
            Label out1 = new Label();
            TextField textField = new TextField();
           //String sss ;
		  //String a=response;
                  
                  

            btn2.setOnAction(new EventHandler<ActionEvent>() { // Answer Button
            @Override
            public void handle(ActionEvent event) {
                try {
                    String sss=textField.getText();
                    out1.setText(r.answerQuestion(lab3.getText(),sss));
                    
                } catch (Exception e) {
                }
            }
        });//Answer Button end
      Button swich = new Button("Another question");      
            swich.setOnAction(new EventHandler<ActionEvent>() { // Swich Button
            @Override
            public void handle(ActionEvent event) {
                try {
                    String q =r.getRandomQuestion();
                    lab3.setText(q);
                    
                    
                } catch (Exception e) {
                }
            }
        });//Swich Button end
            
VBox layout3= new VBox(20);
layout3.getChildren().addAll(label3,lab3,lab4,textField,out1,swich,btn2,button5);
swich.setTranslateX(200);
swich.setTranslateY(50);
scene3= new Scene(layout3,350,420);

//Scene 4
Label label4= new Label("Remove Question");
Button button6= new Button("Go Back");
button6.setOnAction(e -> primaryStage.setScene(scene1));

Button btn3 = new Button("Remove"); 
            Label lab5 = new Label("What is number of question for remove ?");
            Label lab6 = new Label("Answer");
            Label out3 = new Label();
            TextField answer3 = new TextField();
//            int j =1;
//           for(int i = 0; i < Qu.question.size(); i++) { 
//               
//                System.out.println(j+") "+Qu.question.get(i));
//                          j++;             } 
            btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                   
                   // System.out.println(answer3.getText());
                  out3.setText(r.removeQuestion(answer3.getText())); 
                    
                } catch (Exception e) {
                    
                }
            }
        });
            

VBox layout4= new VBox(20);
layout4.getChildren().addAll(label4,lab5,lab6,answer3,out3,btn3,button6);
scene4= new Scene(layout4,350,420);
 }
        catch (Exception e) {
            System.out.println("Helloclient exception: " + e); 
        } 
       
        
primaryStage.setScene(scene1);
primaryStage.show();
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
