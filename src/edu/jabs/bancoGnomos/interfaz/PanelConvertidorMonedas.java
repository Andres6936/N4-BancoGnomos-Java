package edu.jabs.bancoGnomos.interfaz;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import edu.jabs.bancoGnomos.mundo.BancoGnomos;

/**
 * Panel para el manejo de las conversiones.
 */
public class PanelConvertidorMonedas extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para realizar la conversión de monedas.
     */
    public static final String CONVERSION = "Conversión";

    /**
     * Comando para cerrar el diálogo.
     */
    public static final String CERRAR = "Cerrar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Dialogo para la conversión de monedas.
     */
    private DialogoConversionMonedas dialogo;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta para la moneda origen.
     */
    private JLabel etiquetaTituloOrigen;

    /**
     * Etiqueta para la moneda destino.
     */
    private JLabel etiquetaTituloDestino;

    /**
     * Botón para realizar la conversión.
     */
    private JButton botonRealizarConversion;

    /**
     * Botón para cerrar.
     */
    private JButton botonCerrar;

    /**
     * Botón para selección de galeones como moneda origen.
     */
    private JToggleButton botonGaleonOrigen;

    /**
     * Botón para selección de sicklets  como moneda origen.
     */
    private JToggleButton botonSickletOrigen;

    /**
     * Botón para selección de knuts como moneda origen.
     */
    private JToggleButton botonKnutOrigen;

    /**
     * Botón para selección de galeones como moneda destino.
     */
    private JToggleButton botonGaleonDestino;

    /**
     * Botón para selección de sicklets como moneda destino.
     */
    private JToggleButton botonSickletDestino;

    /**
     * Botón para selección de knuts como moneda destino.
     */
    private JToggleButton botonKnutDestino;

    /**
     * Grupo de botones para la selección de moneda origen.
     */
    private ButtonGroup grupoOrigen;

    /**
     * Grupo de botones para la selección de moneda destino.
     */
    private ButtonGroup grupoDestino;

    /**
     * Texto donde se va a insertar la cantidad.
     */
    private JTextField textoCantidad;

    /**
     * Etiqueta el asociada a la cantidad.
     */
    private JLabel etiquetaCantidad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se construyó el panel para la conversión de monedas. <br>
     * @param diag Diálogo en el que se encuentra el panel. diag!= null
     */
    public PanelConvertidorMonedas( DialogoConversionMonedas diag )
    {
        dialogo = diag;
        setLayout( new GridBagLayout( ) );

        // Panel para la selección de las monedas origen
        JPanel panelMonedasOrigen = new JPanel( );
        panelMonedasOrigen.setLayout( new GridBagLayout( ) );

        etiquetaTituloOrigen = new JLabel( "Moneda origen" );
        etiquetaTituloOrigen.setForeground( new Color( 0, 128, 0 ) );

        ImageIcon galeon = new ImageIcon( "./data/Galeon.png" );
        botonGaleonOrigen = new JToggleButton( galeon );
        botonGaleonOrigen.setToolTipText( "Galeón" );

        ImageIcon knut = new ImageIcon( "./data/Knut.png" );
        botonKnutOrigen = new JToggleButton( knut );
        botonKnutOrigen.setToolTipText( "Knut" );

        ImageIcon sicklet = new ImageIcon( "./data/Sicklet.png" );
        botonSickletOrigen = new JToggleButton( sicklet );
        botonSickletOrigen.setToolTipText( "Sicklet" );

        grupoOrigen = new ButtonGroup( );
        grupoOrigen.add( botonGaleonOrigen );
        grupoOrigen.add( botonKnutOrigen );
        grupoOrigen.add( botonSickletOrigen );

        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        panelMonedasOrigen.add( etiquetaTituloOrigen, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelMonedasOrigen.add( botonGaleonOrigen, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelMonedasOrigen.add( botonSickletOrigen, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelMonedasOrigen.add( botonKnutOrigen, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        add( panelMonedasOrigen, gbc );

        // Panel para la selección de las monedas origen
        JPanel panelMonedasDestino = new JPanel( );
        panelMonedasDestino.setLayout( new GridBagLayout( ) );

        etiquetaTituloDestino = new JLabel( "Moneda destino" );
        etiquetaTituloDestino.setForeground( new Color( 0, 128, 0 ) );

        botonGaleonDestino = new JToggleButton( galeon );
        botonGaleonDestino.setToolTipText( "Galeón" );

        botonKnutDestino = new JToggleButton( knut );
        botonKnutDestino.setToolTipText( "Knut" );

        botonSickletDestino = new JToggleButton( sicklet );
        botonSickletDestino.setToolTipText( "Sicklet" );

        grupoDestino = new ButtonGroup( );
        grupoDestino.add( botonGaleonDestino );
        grupoDestino.add( botonKnutDestino );
        grupoDestino.add( botonSickletDestino );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        panelMonedasDestino.add( etiquetaTituloDestino, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelMonedasDestino.add( botonGaleonDestino, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelMonedasDestino.add( botonSickletDestino, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelMonedasDestino.add( botonKnutDestino, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        add( panelMonedasDestino, gbc );

        // Panel Cantidad
        JPanel panelCantidad = new JPanel( );
        panelCantidad.setLayout( new GridBagLayout( ) );
        textoCantidad = new JTextField( );
        textoCantidad.setPreferredSize( new Dimension( 100, 20 ) );
        etiquetaCantidad = new JLabel( "Cantidad monedas" );
        etiquetaCantidad.setForeground( new Color( 0, 128, 0 ) );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 0, 15 );
        panelCantidad.add( etiquetaCantidad, gbc );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelCantidad.add( textoCantidad, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        add( panelCantidad, gbc );

        // Panel Botones
        JPanel panelBotones = new JPanel( );
        panelBotones.setLayout( new GridBagLayout( ) );
        botonRealizarConversion = new JButton( "Realizar conversión" );
        botonRealizarConversion.setActionCommand( CONVERSION );
        botonRealizarConversion.addActionListener( this );

        botonCerrar = new JButton( "Cerrar" );
        botonCerrar.setActionCommand( CERRAR );
        botonCerrar.addActionListener( this );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelBotones.add( botonRealizarConversion, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelBotones.add( botonCerrar, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 3;
        add( panelBotones, gbc );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el tipo de moneda origen seleccionada para realizar la conversión. <br>
     * @return El tipo de moneda origen seleccionada.
     */
    public String darTipoMonedaSeleccionadaOrigen( )
    {
        if( botonGaleonOrigen.isSelected( ) )
        {
            return BancoGnomos.GALEON;
        }
        else if( botonKnutOrigen.isSelected( ) )
        {
            return BancoGnomos.KNUT;
        }
        else if( botonSickletOrigen.isSelected( ) )
        {
            return BancoGnomos.SICKLET;
        }
        else
        {
            return "";
        }
    }

    /**
     * Retorna el tipo de moneda destino seleccionada para realizar la consulta. <br>
     * @return El tipo de moneda destino seleccionada.
     */
    public String darTipoMonedaSeleccionadaDestino( )
    {
        if( botonGaleonDestino.isSelected( ) )
        {
            return BancoGnomos.GALEON;
        }
        else if( botonKnutDestino.isSelected( ) )
        {
            return BancoGnomos.KNUT;
        }
        else if( botonSickletDestino.isSelected( ) )
        {
            return BancoGnomos.SICKLET;
        }
        else
        {
            return "";
        }
    }

    /**
     * Retorna la cantidad de monedas a convertir. <br>
     * @return La cantidad de monedas a convertir.
     * @throws Exception Si la cantidad de monedas no es un valor numérico.
     */
    public int darCantidadMonedas( ) throws Exception
    {
        try
        {
            int can = Integer.parseInt( textoCantidad.getText( ) );
            return can;
        }
        catch( NumberFormatException e )
        {
            throw new Exception( "La cantidad de monedas debe ser un valor numérico." );
        }

    }

    /**
     * Manejo de los eventos de los botones.
     * @param evento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( CONVERSION.equals( comando ) )
        {
            dialogo.realizarConversion( );
        }
        else if( CERRAR.equals( comando ) )
        {
            dialogo.cerrar( );
        }
    }
}