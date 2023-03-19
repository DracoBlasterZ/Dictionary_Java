import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ex4_Dictionary {

	public static void main(String[] args) {
		String numOf=JOptionPane.showInputDialog("Introduzca la cantidad de carritos que hay");
		int numCarrito= Integer.parseInt(numOf);
		Hashtable<Integer, ArrayList<Hashtable<String, ArrayList<Double>>>> carroInfo= new Hashtable<Integer,  ArrayList<Hashtable<String, ArrayList<Double>>>>();
		
		for(int i=0;i<numCarrito;i++)
		{
			JOptionPane.showMessageDialog(null,"Bienvenido cliente numero "+(i+1));
			carroInfo.put(i, fillArrHash());
		}
		
		boolean finishNow=false;
		while(!finishNow)
		{
			String consultOf=JOptionPane.showInputDialog("Que operacion quieres realizar: Consultar producto(Product); Producto nuevo(New); Mostrar todo(Full); Finalizar(End)");
			switch(consultOf)
			{
				case "Product":
					String checkName=JOptionPane.showInputDialog("Porfavor introduzca el nombre del producto");
					JOptionPane.showMessageDialog(null,"Los datos del producto "+checkName+" son "+ (carroInfo.get(checkName)));
					
					break;
				case "New":
					String productName=JOptionPane.showInputDialog("Porfavor introduzca el nombre del producto");
					String productPrice=JOptionPane.showInputDialog("Introduzca el precio asignado al nuevo producto");
					int productPri= Integer.parseInt(productPrice);
					String productNum=JOptionPane.showInputDialog("Introduzca la cantidad del nuevo producto");
					int quantProdu= Integer.parseInt(productNum);
					//carroInfo.put(productName, priPri(productPri,quantProdu));
					
					break;
				case "Full":
					Enumeration<Integer> enumEle=carroInfo.keys();
					while(enumEle.hasMoreElements())
					{
						Integer namePro= enumEle.nextElement();
						System.out.println("El alumno con nombre "+namePro+" con nota "+carroInfo.get(namePro));
					}
					
					break;
				case "End":
					finishNow=true;
					JOptionPane.showMessageDialog(null,"Programa finalizado con exito, muchas gracias");
					break;
				default:
					JOptionPane.showMessageDialog(null,"No se ha introducido correctamente, vuelva a ponerlo");
					break;
				
			}
		}
		
		
		Enumeration<ArrayList<Hashtable<String, ArrayList<Double>>>> enumEle= carroInfo.elements();
		for(int i=0;i<numCarrito;i++)
		{
			System.out.println("El carro "+i+" tiene las caracteristicas de "+enumEle.nextElement());
		}

	}
	
	public static ArrayList<Hashtable<String, ArrayList<Double>>> fillArrHash()
	{
		String checkName=JOptionPane.showInputDialog("Porfavor introduzca el nombre del producto");
		ArrayList<Hashtable<String,ArrayList<Double>>> antList= new ArrayList<Hashtable<String,ArrayList<Double>>>();
		Hashtable<String,ArrayList<Double>> arkHash= new Hashtable<String,ArrayList<Double>>();
		arkHash.put(checkName,fillArray());
		antList.add(arkHash);
		return antList;
		
	}
	public static ArrayList<Double> fillArray()
	{
		ArrayList<Double> listData =new ArrayList<>();
		double ivaOn=ivaSelected();
		double priceNoIva= priceNotIva();
		double priceIva=priceWithIva(priceNoIva,ivaOn);
		double pagamentDone= pagamentDone(priceIva);
		listData.add(ivaOn);
		listData.add(priceNoIva);
		listData.add(priceIva);
		listData.add(productQuant());
		listData.add(pagamentDone);
		listData.add(changePagament(priceIva,pagamentDone));
		
		return listData;
	}
	
	public static double ivaSelected()
	{
		double numIva=0;
		boolean CorrectIva=false;
		while(!CorrectIva)
		{
			String numOf=JOptionPane.showInputDialog("Escoja entre el 21% de Iva o el 4%");
			switch(numOf)
			{
			case "21":
				numIva= Double.parseDouble(numOf);
				CorrectIva=true;
				break;
				
			case "4":
				numIva= Double.parseDouble(numOf);
				CorrectIva=true;
				break;
				
			default:
				JOptionPane.showMessageDialog(null,"No se ha introducido correctamente, vuelva a ponerlo");
				break;
			}
			
		}
		return numIva;
	
	}
	public static double priceNotIva()
	{
		String priceOf=JOptionPane.showInputDialog("Introduzca el importe de la compra");
		return Double.parseDouble(priceOf);
	}
	public static double priceWithIva(double rPrice, double ivaAp)
	{
		double fullPrice=(rPrice+((rPrice*ivaAp)/100));
		return fullPrice;
	}
	public static double productQuant()
	{
		String productOf=JOptionPane.showInputDialog("Introduzca la cantidad de productos comprados");
		return Double.parseDouble(productOf);
	}
	public static double pagamentDone(double ivaPrice)
	{
		double pagamentPrice=0;
		boolean wellPay=false;
		while(!wellPay)
		{
			String productOf=JOptionPane.showInputDialog("Introduzca la cantidad previamente mencionada de "+ivaPrice+" o mas");
			pagamentPrice=Double.parseDouble(productOf);
			if(ivaPrice>pagamentPrice)
			{
				JOptionPane.showMessageDialog(null,"Con lo que me da no puede comprar, mire bien su cartera");
			}
			else 
			{
				wellPay=true;
			}
		}
		return pagamentPrice;
	}
	public static double changePagament(double priceIva, double pagamentClient)
	{
		return (pagamentClient-priceIva);
		
	}

}
