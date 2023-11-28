package inicio;

//import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;

import modelo.Pronostico;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import controlador.ResultadosTotales;


public class VentanaPrincipal extends JFrame {	
	
	private static final long serialVersionUID = 1L;
    private JTextArea resultadosTextArea;

    public VentanaPrincipal(List<Pronostico> listaApuestas) {
        initComponents(listaApuestas);
    }

    private void initComponents(List<Pronostico> listaApuestas) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Resultados Totales");

        JTextArea tituloTextArea = new JTextArea();
        tituloTextArea.setText("Listado de Resultados Totales\n\n");
        tituloTextArea.setEditable(false);

        JLabel titleLabel = new JLabel("Listado de Resultados Totales");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Brush Script MT", Font.BOLD, 32));
        titleLabel.setForeground(new Color(128, 0, 128));

        resultadosTextArea = new JTextArea();
        resultadosTextArea.setEditable(false);
        resultadosTextArea.setFont(new Font("Angsana New", Font.BOLD, 26));

        JScrollPane scrollPane = new JScrollPane(resultadosTextArea);

        JButton mostrarResultadosButton = new JButton("Mostrar Resultados");
        mostrarResultadosButton.setForeground(new Color(128, 0, 128));
        mostrarResultadosButton.setFont(new Font("Angsana New", Font.BOLD, 26));

        JButton cerrarBoton = new JButton("Cerrar");
        cerrarBoton.setForeground(new Color(128, 0, 128));
        cerrarBoton.setFont(new Font("Angsana New", Font.BOLD, 26));

        mostrarResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultados = ResultadosTotales.obtenerResultadosTotales(listaApuestas);
                resultadosTextArea.setText(resultados);
            }
        });

        cerrarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana al presionar el botón "Cerrar"
                dispose();
            }
        });

        // Configurar el diseño del panel con BorderLayout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Crear un panel para contener los botones y agregarlo al sur
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout()); // Puedes ajustar el diseño según tus necesidades
        buttonsPanel.add(mostrarResultadosButton);
        buttonsPanel.add(cerrarBoton);
        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);

        // Ajustar el tamaño de la ventana
        setSize(600, 400);
        
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }
}

	/* private static final long serialVersionUID = 1L;
	    private JTextArea resultadosTextArea;  // Declaración aquí para que sea accesible en todo el método

	    public VentanaPrincipal(List<Pronostico> listaApuestas) {
	        initComponents(listaApuestas);
	    }

	    private void initComponents(List<Pronostico> listaApuestas) {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("Resultados Totales");

	        // Crear un área de texto para mostrar el título
	        JTextArea tituloTextArea = new JTextArea();
	        tituloTextArea.setText("Listado de Resultados Totales\n\n");
	        tituloTextArea.setEditable(false);

	        // Crear un JLabel para el título con estilo personalizado
	        JLabel titleLabel = new JLabel("Listado de Resultados Totales");
	        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
	        titleLabel.setFont(new Font("Brush Script MT", Font.BOLD, 32)); // Fuente, negrita, tamaño 24
	        titleLabel.setForeground(Color.RED); // Color del texto

	        // Crear un área de texto para mostrar los resultados con fuente más grande y color
	        resultadosTextArea = new JTextArea();
	        resultadosTextArea.setEditable(false);
	        resultadosTextArea.setFont(new Font("Angsana New", Font.BOLD, 26)); // Fuente más grande
	        //resultadosTextArea.setForeground(new Color(128, 0, 128));
	        
	        // Crear un JScrollPane para el área de texto
	        JScrollPane scrollPane = new JScrollPane(resultadosTextArea);
	        
	        // Agregar un botón para mostrar los resultados
	        JButton mostrarResultadosButton = new JButton("Mostrar Resultados");
	       // mostrarResultadosButton.setBackground(new Color(0, 128, 255)); // Color de fondo del botón (azul en este caso)
	        mostrarResultadosButton.setForeground(new Color(128, 0, 128)); // Color del texto del botón
	        mostrarResultadosButton.setFont(new Font("Angsana New", Font.BOLD, 26)); // Fuente, negrita, tamaño 18	          

	        JButton cerrarBoton = new JButton("Cerrar");
	        cerrarBoton.setForeground(new Color(128, 0, 128));
	        cerrarBoton.setFont(new Font("Angsana New", Font.BOLD, 26));
	        
	        mostrarResultadosButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Obtener los resultados y mostrarlos en el área de texto
	                String resultados = ResultadosTotales.obtenerResultadosTotales(listaApuestas);
	                resultadosTextArea.setText(resultados);
	            }
	        });
	        
	        cerrarBoton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Cierra la ventana al presionar el botón "Cerrar"
	                dispose();
	            }
	        });

	        // Configurar el diseño del panel con BorderLayout
	        getContentPane().setLayout(new BorderLayout());
	        getContentPane().add(titleLabel, BorderLayout.NORTH);
	        getContentPane().add(scrollPane, BorderLayout.CENTER);
	        getContentPane().add(mostrarResultadosButton, BorderLayout.SOUTH);

	        // Ajustar el tamaño de la ventana
	        setSize(600, 400); // Puedes ajustar estos valores según tus preferencias

	        // Centrar la ventana en la pantalla
	        setLocationRelativeTo(null);
	    }
	}
	
	
	*/
	

	
	
	
	
	
	

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
*/