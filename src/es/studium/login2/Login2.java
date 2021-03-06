package es.studium.login2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * @author clja1
 * @apiNote Hay que poner asteriscos en el login y adem�s cerrar las ventanas una a una y una serie de veces. Para asteriscos usar Hay que poner asteriscos usar
 * setEchoChar()
 */

public class Login2 extends Frame implements WindowListener, ActionListener,TextListener
{
	//Button btnBoton = new Button("Pulsar..."); no sirve
	// Crear el di�logo indicando el padre, el t�tulo y si es o no
	// modal
	private static final long serialVersionUID = 1L;
	Dialog dlgUno = new Dialog(this, "Di�logo con mensaje", true);
	Dialog dlgDos = new Dialog(this, "Otra ventana", true);
	TextField txtUsuario = new TextField (20);
	TextField txtcontrasenia = new TextField (20);
	Label usuario = new Label ("Usuario");
	Label contrasenya = new Label ("Contrase�a");
	JLabel lblincorrecto = new JLabel("Contrase�a erronea", SwingConstants.CENTER);//m�todo para centrar el texto
	JLabel lblcorrecto = new JLabel ("Eres t�",SwingConstants.CENTER);
	Button btnaceptar= new Button ("Aceptar");
	Button btnlimpiar =new Button ("Limpiar");
	String usu= "Manolo";
	String cont="Lolo&";
	String intro="";
	String contra="";
	int numeroveces=0;

	public Login2()
	{
		add(usuario);
		add(txtUsuario);
		add(contrasenya);
		add(txtcontrasenia);
		add(btnaceptar);
		add(btnlimpiar);
		btnaceptar.setBackground(Color.gray);
		//add(btnBoton); no sirve
		btnaceptar.addActionListener(this);
		btnlimpiar.addActionListener(this);
		txtUsuario.addActionListener(this);
		txtcontrasenia.addActionListener(this);
		txtcontrasenia.setEchoChar('*');
		//btnBoton.addActionListener(this);
		addWindowListener(this);
		setLayout(new FlowLayout());
		setTitle("--IDENTIFICACI�N--");
		setSize(300,150);
		addWindowListener(this);
		setResizable(false);
		setLocation(800,200);
		setVisible(true);
		//El primer dialogo
		dlgUno.addWindowListener(this);
		dlgUno.setTitle("Error, foul");
		dlgUno.add(lblincorrecto);
		dlgUno.setResizable(false);
		dlgUno.setBackground(Color.red);
		dlgUno.setLocation(800,400);
		dlgUno.setSize(200,100);
		//Para el segundo dialogo
		dlgDos.addWindowListener(this);
		dlgDos.setTitle("Ventana dentificaci�n correcta");
		dlgDos.add(lblcorrecto);
		dlgDos.setSize(250,200);
		dlgDos.setResizable(false);
		dlgDos.setBackground(Color.getHSBColor(73,210,77));
		dlgDos.setLocation(1000,400);
	}


	public static void main(String[] args)
	{
		new Login2();


	}

	@Override
	public void actionPerformed(ActionEvent event)
	{ 		

		if (event.getSource().equals(btnlimpiar))
		{
			txtUsuario.setText("");
			txtcontrasenia.setText("");
		}
		else if(event.getSource().equals(btnaceptar))
		{

			intro=txtUsuario.getText();
			contra=txtcontrasenia.getText();
			if ((intro.equals(usu))&(contra.equals(cont)))
			{
				dlgDos.setVisible(true);//Aqu� se puede a�adir las ventanas de la BBDD
			}
			else
			{	
				numeroveces=numeroveces+1;
				dlgUno.setVisible(true);
				txtUsuario.setText("Tienes "+(3-numeroveces)+" Intentos m�s");
				if(numeroveces==2)
				{
					txtUsuario.setText("Queda un intento");
				}
				else 
				{
					if (numeroveces==3)
					{
						btnaceptar.setEnabled(false);
						txtUsuario.setText("Ya la has liao, t�s bloqueao");
						//System.exit(0);
					}
				}
			}
		}

	}
	/*System.out.println(intro);
	System.out.println(Otrointro);
	dlgDos.setVisible(true);
	 */

	@Override
	public void windowActivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void windowClosing(WindowEvent even)

	{if (even.getWindow().equals(getWindows()))
	{
		dlgUno.setVisible(true);
	}
	else if (even.getWindow().equals(dlgUno)) 
	{

		dlgUno.setVisible(false);//no exit on dialog close
	}
	else if(even.getWindow().equals(dlgDos))
	{
		dlgDos.setVisible(false);
	}
	else
	{

		System.exit(0);
	}
	}


	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}


	@Override
	public void textValueChanged(TextEvent arg0)
	{

	}

}
