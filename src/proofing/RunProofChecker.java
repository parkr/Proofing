/** Name: Parker Moore
  * Class: AP Computer Science
  * Teacher: Mr. Klus
  * Program: 
  * Description: 
  */

package proofing;

import proofing.exceptions.WrongFileTypeException;

public class RunProofChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProofChecker checker;
		try {
			checker = new ProofChecker("mabra.olivia.proofingset");
			System.out.println(checker.compare());
		} catch (WrongFileTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
