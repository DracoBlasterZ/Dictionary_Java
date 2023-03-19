import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ex2_Dictionary {

	public static void main(String[] args) {
		String numOf=JOptionPane.showInputDialog("Introduzca la cantidad de carritos que hay");
		int numCarrito= Integer.parseInt(numOf);
		Hashtable<Integer, ArrayList<Double>> carroInfo= new Hashtable<Integer, ArrayList<Double>>(); 
		for(int i=0;i<numCarrito;i++)
		{
			JOptionPane.showMessageDialog(null,"Bienvenido cliente numero "+(i+1));
			carroInfo.put(i, fillArray());
		}
		
		Enumeration<ArrayList<Double>> enumEle= carroInfo.elements();
		for(int i=0;i<numCarrito;i++)
		{
			System.out.println("El carro "+i+" tiene las caracteristicas de "+enumEle.nextElement());
		}

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
