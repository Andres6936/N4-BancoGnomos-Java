package edu.jabs.bancoGnomos.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;

/**
 * Diálogo para consultar la cantidad de monedas de un tipo guardadas en una bóveda.
 */
public class DialogoConsultaCantidadTipoMoneda extends JDialog
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Llave de la bóveda.
     */
    private int llaveBoveda;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
    /**
     * Ventana principal de la aplicación.
     */
    private InterfazBancoGnomos ventanaPrincipal;

    /**
     * Panel para realizar la consulta.
     */
    private PanelConsultaTipoMoneda panelConsulta;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el diálogo para consultar la cantidad de monedas. <br>
     * <b> post: </b> Se creó el diálogo para consultar la cantidad de monedas. <br>
     * @param ventana Ventana principal. ventana != null.
     * @param llave Llave de la bóveda para realizar la consulta.
     */
    public DialogoConsultaCantidadTipoMoneda( InterfazBancoGnomos ventana, int llave )
    {
        ventanaPrincipal = ventana;
        panelConsulta = new PanelConsultaTipoMoneda( this );
        llaveBoveda = llave;
        setLayout( new BorderLayout( ) );
        setPreferredSize( new Dimension( 290, 150 ) );
        setResizable( false );
        add( panelConsulta, BorderLayout.CENTER );
        pack( );
        setTitle( "Consulta monedas por tipo" + Integer.toString( llave ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cancela la consulta. <br>
     * <b> post: </b> Se canceló la consulta. <br>
     */
    public void cancelar( )
    {
        dispose( );
    }

    /**
     * Realiza la consulta de la cantidad de monedas.<br>
     */
    public void realizarConsulta( )
    {
        String tipo = panelConsulta.darTipoMonedaSeleccionada( );

        ventanaPrincipal.consultarCantidadTipoMonedasBoveda( llaveBoveda, tipo );

        dispose( );

    }

}
