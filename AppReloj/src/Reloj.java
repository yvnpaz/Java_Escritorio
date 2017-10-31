import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Reloj {

	public static void main(String[] args) {
		
		HourUpdate listener = new HourUpdate();
		
		Timer timer = new Timer(3000, listener);
		timer.start();
		
		JOptionPane.showMessageDialog(null, "Pulsa Aceptar para finalizar.");
		System.exit(0);
	}

}

class HourUpdate implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Date date = new Date();
		
		System.out.println("Muestra la fecha cada 3 segundos.");
		
	}
}
