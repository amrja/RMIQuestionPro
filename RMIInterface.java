/*
 Amr jamal
 */
package rmiquestion;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
	public String newQuestion(String q,String answer) throws RemoteException;
	public String getRandomQuestion() throws RemoteException;
	public String answerQuestion(String q,String answer) throws RemoteException;
	public String removeQuestion(String r) throws RemoteException;
}