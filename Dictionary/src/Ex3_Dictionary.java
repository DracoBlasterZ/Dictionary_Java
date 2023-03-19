
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ex3_Dictionary {

	public static void main(String[] args) {
		Hashtable<String, Hashtable<Integer,Integer>> productInfo= new Hashtable<String, Hashtable<Integer,Integer>>();
		productInfo.put("Manzana",priPri(3, 20));
		productInfo.put("Pera", priPri(2, 11));
		productInfo.put("Kiwi", priPri(3, 23));
		productInfo.put("Sandia", priPri(5, 456));
		productInfo.put("Helado", priPri(7, 2));
		productInfo.put("Platano", priPri(3, 60));
		productInfo.put("Zumo", priPri(12, 220));
		productInfo.put("Filete", priPri(13, 30));
		productInfo.put("Ramen", priPri(8, 23));
		productInfo.put("Bocata", priPri(12, 340));
		
		boolean finishNow=false;
		while(!finishNow)
		{
			String consultOf=JOptionPane.showInputDialog("Que operacion quieres realizar: Consultar producto(Product); Producto nuevo(New); Mostrar todo(Full); Finalizar(End)");
			switch(consultOf)
			{
				case "Product":
					String checkName=JOptionPane.showInputDialog("Porfavor introduzca el nombre del producto");
					JOptionPane.showMessageDialog(null,"Los datos del producto "+checkName+" son "+ (productInfo.get(checkName)));
					
					break;
				case "New":
					String productName=JOptionPane.showInputDialog("Porfavor introduzca el nombre del producto");
					String productPrice=JOptionPane.showInputDialog("Introduzca el precio asignado al nuevo producto");
					int productPri= Integer.parseInt(productPrice);
					String productNum=JOptionPane.showInputDialog("Introduzca la cantidad del nuevo producto");
					int quantProdu= Integer.parseInt(productNum);
					productInfo.put(productName, priPri(productPri,quantProdu));
					
					break;
				case "Full":
					Enumeration<String> enumEle=productInfo.keys();
					while(enumEle.hasMoreElements())
					{
						String namePro= enumEle.nextElement();
						System.out.println("El alumno con nombre "+namePro+" con nota "+productInfo.get(namePro));
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
		
		
		
	}
	public static Hashtable<Integer,Integer> priPri(int pricePro, int productQuan)
	{
		Hashtable<Integer,Integer> priceStock= new Hashtable<Integer,Integer>();
		priceStock.put(pricePro, productQuan);
		return priceStock;
	}

}
