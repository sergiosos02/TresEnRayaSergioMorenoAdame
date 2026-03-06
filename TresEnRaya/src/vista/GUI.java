package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.TresEnRaya;
import modelo.Coordenada;

public class GUI extends JFrame implements AccesoGUI {

    private JPanel contentPane;
    private JLabel lblMensaje;
    private Botonera botonera;
    private TresEnRaya tresEnRaya;

    /**
     * Create the frame.
     */
    public GUI() {
        int dimension = 3;
        tresEnRaya = new TresEnRaya(); // Initialize the game logic

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Mensaje");
        lblNewLabel.setBounds(10, 11, 75, 14);
        contentPane.add(lblNewLabel);

        lblMensaje = new JLabel(" ");
        lblMensaje.setBounds(104, 11, 320, 14);
        contentPane.add(lblMensaje);

        botonera = new Botonera(contentPane, dimension);

        // Añadir botón de reiniciar el juego
        JButton btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setBounds(10, 240, 100, 25); // Posición y tamaño del botón
        contentPane.add(btnReiniciar);

        // Añadir ActionListener al botón de reiniciar
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tresEnRaya.reiniciarJuego(); // Reiniciar la lógica del juego
                lblMensaje.setText("Juego reiniciado"); // Actualizar el mensaje
                for (Component component : botonera.getComponents()) {
                    if (component instanceof MyButton) {
                        ((MyButton) component).setText(""); // Limpiar el texto de los botones
                        component.setEnabled(true); // Habilitar los botones para una nueva partida
                    }
                }
            }
        });
    }

    @Override
    public Component[] getButtonMatrix() {
        return botonera.getComponents();
    }

    @Override
    public JLabel getLblMensaje() {
        return lblMensaje;
    }

    @Override
    public MyButton getButton(Coordenada coordenada) {
        return (MyButton) botonera.getElemento(coordenada);
    }

    @Override
    public MyButton getBotonCentral() {
        return getButton(new Coordenada(1, 1));
    }
}
