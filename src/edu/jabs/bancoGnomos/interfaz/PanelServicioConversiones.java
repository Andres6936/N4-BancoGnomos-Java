package edu.jabs.bancoGnomos.interfaz;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel para la realización de conversiones.
 */
public class PanelServicioConversiones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Comando para mostrar el diálogo que realiza la conversión de monedas.
     */
    public static final String CONVERSION = "Conversión";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazBancoGnomos principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Botón para realizar las conversiones.
     */
    private JButton botonConversiones;

    /**
     * Constructor del panel. <br>}
     * <b>post: </b> Se construyó el panel para el servicio de conversiones. <br>
     * @param pPrincipal Ventana principal de la aplicación. ventana!= null.
     */
    public PanelServicioConversiones( InterfazBancoGnomos pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Conversiones" ) );

        botonConversiones = new JButton( "Servicio conversiones" );
        botonConversiones.setActionCommand( CONVERSION );
        botonConversiones.addActionListener( this );

        add( botonConversiones );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );

        if( CONVERSION.equals( comando ) )
        {
            principal.mostrarDialogoConversionMonedas( );
        }
    }

}