/** Name: Parker Moore
  * Class: AP Computer Science
  * Teacher: Mr. Klus
  * Program: 
  * Description: 
  */

package proofing;
import java.util.*;
import java.io.*;

import proofing.exceptions.WrongFileTypeException;

public class ProofChecker {
	
	private TreeSet<Integer> one = new TreeSet<Integer>();
	private String one_name;
	private TreeSet<Integer> two;
	private String two_name;

	public ProofChecker(String filename) throws WrongFileTypeException{
		if(filename.endsWith(".proofingset")){
			try {
				Scanner sc = new Scanner(new File(filename));
				
				//List One
				one_name = sc.next();
				one = new TreeSet<Integer>();
				while(sc.hasNextInt())
					one.add(sc.nextInt());
				
				//List Two
				two_name = sc.next();
				two = new TreeSet<Integer>();
				while(sc.hasNextInt())
					two.add(sc.nextInt());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}else{
			throw new WrongFileTypeException();
		}
	}
	
	public ProofChecker(int[] one, int[] two){
		this.one = convertArrayToTreeSet(one);
		this.two = convertArrayToTreeSet(two);
		this.one_name = "Person 1";
		this.two_name = "Person 2";
	}
	
	private TreeSet<Integer> convertArrayToTreeSet(int[] a) {
		TreeSet<Integer> temp = new TreeSet<Integer>();
		for(int t: a)
			temp.add(t);
		return temp;
	}

	public void print(){
		System.out.println(one_name+": "+one);
		System.out.println(two_name+": "+two);
	}
	
	public String compare(){
		String output = "";
		TreeSet<Integer> similar = new TreeSet<Integer>();
		TreeSet<Integer> person1 = clone(one);
		TreeSet<Integer> person2 = clone(two);
		//Get those that are similar! :)
		for(int eins: one){
			for(int zwei: two){
				if(eins == zwei)
					similar.add(eins);
			}	
		}
		//Get those that are dissimilar!
		Iterator<Integer> itr = person1.iterator();
		while(itr.hasNext()){
			int compare = itr.next();
			for(int eins: similar)
				if(compare == eins)
					itr.remove();
		}
		//Get those that are dissimilar!
		itr = person2.iterator();
		while(itr.hasNext()){
			int compare = itr.next();
			for(int eins: similar)
				if(compare == eins)
					itr.remove();
		}
		output += "Same numbers: [";
		for(int same: similar)
			output += (same+", ");
		output += "]\n"+one_name+" only: [";
		for(int eins: person1)
			output += (eins+", ");
		output += "]\n"+two_name+" only: [";
		for(int zwei: person2)
			output += (zwei+", ");
		output += "]";
		return output;
	}

	private TreeSet<Integer> clone(TreeSet<Integer> input) {
		TreeSet<Integer> temp = new TreeSet<Integer>();
		for(int i: input)
			temp.add(i);
		return temp;
	}
	
	
}
