import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;


public class Ex1_Dictionary {

	
	public static void main(String[] args) {
		Hashtable<String, Integer> alumNotas= new Hashtable<String, Integer>();
		boolean noStuden=false;
		
		while(!noStuden)
		{
			String nameStud=JOptionPane.showInputDialog("Introduzca el nombre del alumno que desea calificar, si ya no quedan mas alumnos escriba NO");
			switch(nameStud)
			{
				case "NO":
					noStuden=true;
					break;
					
				default:
					int notaStudenMed=notaStude();
					alumNotas.put(nameStud,notaStudenMed);
				break;		
			}
		
		}
		readNotas(alumNotas);
	}
	public static int notaStude()
	{
		String numOf=JOptionPane.showInputDialog("Introduzca la nota media");
		int notaMedi= Integer.parseInt(numOf);
		return notaMedi;
	}
	public static void readNotas(Hashtable<String,Integer> hitNotas)
	{
		Enumeration<String> keys= hitNotas.keys();
		while(keys.hasMoreElements())
		{
			String name=keys.nextElement();
			System.out.println("El alumno con nombre "+name+" con nota "+hitNotas.get(name));
		}
	}

}
