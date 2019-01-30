/*
Amr Jamal
 */
package rmiquestion;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


/**
 *
 * @author Amr Jamal
 */



public class Implementation extends UnicastRemoteObject implements RMIInterface { 
    
      ArrayList<String> question = new ArrayList<String>();
protected Implementation() throws RemoteException {
   super();
   
		  question.add("My Name ;;;Amr");
	  question.add("Best Doctor ;;;Fadi");
	  
	}

    @Override
    public String newQuestion(String q, String answer) throws RemoteException {
       question.add(""+q+";;;"+answer);
        int j =1;
         String queue="";
        for(int i = 0; i < question.size(); i++) { 
               
                System.out.println(i+") "+question.get(i));
                queue+=""+j+" : "+question.get(i)+"\n";
                      j++;               }
		return "Done Add \n All Question \n"+queue;
    }

    @Override
    public String getRandomQuestion() throws RemoteException {
       int random = (int)(Math.random() * question.size()  );
		 String h=(String) question.get(random);
   String[] parts = h.split(";;;");
         	return  parts[0];

    }

    @Override
    public String answerQuestion(String q, String answer) throws RemoteException {
        return "tested is : " +question.contains(q+";;;"+answer);
    }

    @Override
    public String removeQuestion(String r) throws RemoteException {
       	question.remove(Integer.parseInt(r)-1);
        String queue="";
        int j =1;
        for(int i = 0; i < question.size(); i++) { 
               
                System.out.println(i+") "+question.get(i));
                queue+=""+j+" : "+question.get(i)+"\n";
                      j++;               }
		return "Done->Removed "+"\n avilable : \n"+queue ;
    }
  

} 


