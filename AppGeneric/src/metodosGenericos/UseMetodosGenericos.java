package metodosGenericos;

import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import arrayList.UseEmpleado;

public class UseMetodosGenericos {

	public static void main(String [] args)
	{
		String [] nombres = {"yvn", "geralt", "celebrimbor"};
		
		String elementos = MisMatrices.getElementos(nombres);
		
		System.out.println(elementos);
		
		Empleado [] listEmpleado = { new Empleado("yvn", 28, 1000),
				new Empleado("yvn", 28, 1000),
				new Empleado("yvn", 28, 1000),
				new Empleado("yvn", 28, 1000)
		};
		
		System.out.println(MisMatrices.getElementos(listEmpleado));
		
		
		System.out.println("MisElementosGenericos: "+MisMatrices.getGenerics(nombres));
		
		Calendar now = Calendar.getInstance();
		now.set(2004,1,7);
		Calendar today = Calendar.getInstance();
		today.set(2016, 1, 17);

		Calendar [] listDate = { now, today };
		
		System.out.println("Zona horaria "+ MisMatrices.getGenerics(listDate));
		
	}
}

class MisMatrices {
	
	public static <T> String getElementos(T[] a)
	{
		return "El array tiene "+ a.length +" elementos.";
	}
	
	public static <T extends Comparable> T getGenerics(T[] a)
	{
		if(a == null || a.length == 0)
		{
			return null;
		}
		else{
			T menor = a[0];
			
			for(int i=1; i < a.length; i++)
			{
				if(menor.compareTo(a[i]) > 0)
				{
					menor = a[i];
				}
			}
			return menor;
		}
	}
}