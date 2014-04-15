package compilplic.lexique.expression;

import java.io.*;

public class TestExpression {

	public static void main(String[] args) {
		// e = ( 4 * 2 ) + ( 12 - 6 ) = 14
		Nombre n = new Nombre (4);
		Expression s = new Somme(new Multiplication(n, new Nombre(2)), new Soustraction(new Nombre(12), new Nombre(6)));
		System.out.println("Iteration type \"foreach\" des Nombres sur Expression s");
		for(Nombre nn : s) {
		}
		try {
			ObjectOutputStream flot = new ObjectOutputStream(new FileOutputStream(new File("serial_expression"))) ;
			flot.writeObject(s) ;
			flot.writeObject(n) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectInputStream flot = new ObjectInputStream(new FileInputStream(new File("serial_expression")));
			Expression s2 = (Expression)flot.readObject() ;
			Nombre n2 = (Nombre)flot.readObject() ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
