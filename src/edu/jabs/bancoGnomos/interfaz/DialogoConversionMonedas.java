package edu.jabs.bancoGnomos.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Diálogo para la realización de conversiones.
 */
public class DialogoConversionMonedas extends JDialog
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazBancoGnomos ventanaPrincipal;

    /**
     * Panel para realizar la conversión.
     */
    private PanelConvertidorMonedas panelConvertidorMonedas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el diálogo para realizar conversiones. <br>
     * <b> post: </b> Se creó un diálogo para realizar conversiones. <br>
     * @param ventana Ventana principal. ventana != null.
     */
    public DialogoConversionMonedas( InterfazBancoGnomos ventana )
    {
        super( ventana, true );
        ventanaPrincipal = ventana;
        panelConvertidorMonedas = new PanelConvertidorMonedas( this );

        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 289, 283 ) );
        setResizable( false );
        add( panelConvertidorMonedas, BorderLayout.CENTER );
        pack( );
        setTitle( "Conversión monedas" );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Efectúa la conversión con los datos proporcionados por el usuario.
     */
    public void realizarConversion( )
    {
        try
        {
            String monedaOrigen = panelConvertidorMonedas.darTipoMonedaSeleccionadaOrigen( );
            String monedaDestino = panelConvertidorMonedas.darTipoMonedaSeleccionadaDestino( );
            int cantidad = panelConvertidorMonedas.darCantidadMonedas( );
            ventanaPrincipal.realizarConversion( cantidad, monedaOrigen, monedaDestino );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Banco de Gnomos - Servicio de conversión", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Cierra el diálogo para la realización de conversiones. <br>
     * <b> post: </b> Se cerro el diálogo. <br>
     */
    public void cerrar( )
    {
        dispose( );
    }
}
