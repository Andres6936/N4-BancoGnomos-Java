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
import javax.swing.border.TitledBorder;

import edu.jabs.bancoGnomos.mundo.BancoGnomos;

/**
 * Panel para el manejo de los depósitos y retiros de las bóvedas.
 */
public class PanelTransacciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando asociado al el retiro de monedas de una bóveda.
     */
    public static final String REALIZAR_RETIRO_MONEDAS = "Retiro monedas";

    /**
     * Comando asociado al depósito de monedas en una bóveda.
     */
    public static final String REALIZAR_DEPOSITO_MONEDAS = "Depósito monedas";


    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazBancoGnomos principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para realizar retiros de la bóveda.
     */
    private JButton botonRetiroMonedas;

    /**
     * Botón para realizar depósitos en la bóveda.
     */
    private JButton botonDepositoMonedas;

    /**
     * Etiqueta de la selección.
     */
    private JLabel etiquetaTitulo;

    /**
     * Grupo de botones para la selección.
     */
    private ButtonGroup grupo;

    /**
     * Botón para selección de galeones.
     */
    private JToggleButton botonGaleon;

    /**
     * Botón para selección de sicklets.
     */
    private JToggleButton botonSicklet;

    /**
     * Botón para selección de knuts.
     */
    private JToggleButton botonKnut;

    /**
     * Etiqueta de la cantidad.
     */
    private JLabel etiquetaCantidad;

    /**
     * Campo de texto de la cantidad.
     */
    private JTextField textoCantidad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * @param pPrincipal Ventana principal. prin!=null
     */
    public PanelTransacciones( InterfazBancoGnomos pPrincipal )
    {
        principal = pPrincipal;

        setBorder( new TitledBorder( "Transacciones" ) );
        setLayout( new GridBagLayout( ) );

        // Panel para la selección de las monedas
        JPanel panelMonedas = new JPanel( );
        panelMonedas.setLayout( new GridBagLayout( ) );

        etiquetaTitulo = new JLabel( "Tipo moneda" );
        etiquetaTitulo.setForeground( new Color( 0, 128, 0 ) );

        ImageIcon galeon = new ImageIcon( "./data/galeon.png" );
        botonGaleon = new JToggleButton( galeon );
        botonGaleon.setToolTipText( "Galeón" );

        ImageIcon knut = new ImageIcon( "./data/knut.png" );
        botonKnut = new JToggleButton( knut );
        botonKnut.setToolTipText( "Knut" );

        ImageIcon sicklet = new ImageIcon( "./data/sicklet.png" );
        botonSicklet = new JToggleButton( sicklet );
        botonSicklet.setToolTipText( "Sicklet" );

        grupo = new ButtonGroup( );
        grupo.add( botonGaleon );
        grupo.add( botonKnut );
        grupo.add( botonSicklet );

        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        panelMonedas.add( etiquetaTitulo, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelMonedas.add( botonGaleon, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelMonedas.add( botonSicklet, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelMonedas.add( botonKnut, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        add( panelMonedas, gbc );

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
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        add( panelCantidad, gbc );

        // Botones para las transacciones
        botonDepositoMonedas = new JButton( "Realizar depósito" );
        botonDepositoMonedas.addActionListener( this );
        botonDepositoMonedas.setPreferredSize( new Dimension( 220, 30 ) );
        botonDepositoMonedas.setActionCommand( REALIZAR_DEPOSITO_MONEDAS );

        botonRetiroMonedas = new JButton( "Realizar retiro" );
        botonRetiroMonedas.setActionCommand( REALIZAR_RETIRO_MONEDAS );
        botonRetiroMonedas.addActionListener( this );
        botonRetiroMonedas.setPreferredSize( new Dimension( 220, 30 ) );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        add( botonDepositoMonedas, gbc );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        add( botonRetiroMonedas, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Devuelve el tipo de moneda seleccionada para realizar la transacción. <br>
     * @return El tipo de moneda seleccionada.
     */
    public String darTipoMonedaSeleccionada( )
    {
        if( botonGaleon.isSelected( ) )
        {
            return BancoGnomos.GALEON;
        }
        else if( botonKnut.isSelected( ) )
        {
            return BancoGnomos.KNUT;
        }
        else if( botonSicklet.isSelected( ) )
        {
            return BancoGnomos.SICKLET;
        }
        else
        {
            return "";
        }
    }

    /**
     * Devuelve la cantidad de monedas para realizar la transacción. <br>
     * @return La cantidad de monedas para la transancción.
     * @throws Exception si la cantidad de monedas no es un valor númerico válido.
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
     * Manejo de los eventos de los botones
     * @param evento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( REALIZAR_DEPOSITO_MONEDAS.equals( comando ) )
        {
            principal.realizarDeposito( );
        }
        else if( REALIZAR_RETIRO_MONEDAS.equals( comando ) )
        {
            principal.realizarRetiro( );

        }
    }

}
