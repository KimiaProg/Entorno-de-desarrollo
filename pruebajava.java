import javax.swing.JOptionPane;

public class ElDiecisiete {

	public static void main(String[] args) {
		
		 int a= Integer.parseInt(JOptionPane.showInputDialog("Introduce el primer número"));
		 int b= Integer.parseInt(JOptionPane.showInputDialog("Introduce el segundo número"));
		 
		 if ( a>=0 && b>=0 || a>=0) {
			 
			 System.out.println("OK");
		 }else {
			 System.out.println("NO");
		 }
	}

}
