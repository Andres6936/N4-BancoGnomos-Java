package edu.jabs.bancoGnomos.interfaz;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import edu.jabs.bancoGnomos.mundo.Boveda;

/**
 * Panel donde se muestran las opciones para realizar las consultas de la una bóveda.
 */
public class PanelBoveda extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para la consulta de monedas totales guardadas en una bóveda.
     */
    public static final String CONSULTAR_MONEDAS_BOVEDA = "Consulta monedas bóveda";

    /**
     * Comando para la consulta de monedas de un tipo guardadas en una bóveda..
     */
    public static final String CONSULTAR_CANTIDAD_TIPO_MONEDA = "Consulta cantidad por tipo de moneda";

    /**
     * Comando para consultar la información de una bóveda.
     */
    public static final String CONSULTA_INFORMACION_BOVEDA = "Consulta información bóveda";

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
     * Área de texto donde se muestran el resultados de una consulta.
     */
    private JTextArea textoContenidoPergamino;

    /**
     * Etiqueta con la imagen de la llave.
     */
    private JLabel etiquetaLlave;

    /**
     * Combo con el listado de las llaves de las bóvedas existentes.
     */
    private JComboBox comboLlaves;

    /**
     * Botón para consultar el total de monedas guardadas.
     */
    private JButton botonConsultarMonedasBoveda;

    /**
     * Botón para consultar la cantidad de monedas por tipo.
     */
    private JButton botonConsultarCantidadTipoMoneda;

    /**
     * Botón para realizar la consulta de información de la bóveda.
     */
    private JButton botonConsultaInformacionBoveda;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se construyó el panel. <br>
     * @param pPrincipal Ventana principal. prin!=null
     */
    public PanelBoveda( InterfazBancoGnomos pPrincipal )
    {
        principal = pPrincipal;
        setLayout( new GridBagLayout( ) );

        textoContenidoPergamino = new JTextArea( );
        textoContenidoPergamino.setWrapStyleWord( true );
        textoContenidoPergamino.setLineWrap( true );
        textoContenidoPergamino.setEditable( false );
        textoContenidoPergamino.setOpaque( false );
        textoContenidoPergamino.setFont( new Font( "Book Antiqua", Font.BOLD, 16 ) );
        textoContenidoPergamino.setPreferredSize( new Dimension( 300, 100 ) );

        // Adición de los componentes
        GridBagConstraints gbc = new GridBagConstraints( );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 50, 0, 0, 0 );
        add( textoContenidoPergamino, gbc );

        botonConsultaInformacionBoveda = new JButton( "Ver detalle bóveda" );
        botonConsultaInformacionBoveda.setActionCommand( CONSULTA_INFORMACION_BOVEDA );
        botonConsultaInformacionBoveda.addActionListener( this );
        botonConsultaInformacionBoveda.setPreferredSize( new Dimension( 180, 30 ) );
        botonConsultaInformacionBoveda.setBackground( new Color( 255, 197, 73 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 5, 0 );
        add( botonConsultaInformacionBoveda, gbc );

        botonConsultarMonedasBoveda = new JButton( "Ver cantidad monedas" );
        botonConsultarMonedasBoveda.setActionCommand( CONSULTAR_MONEDAS_BOVEDA );
        botonConsultarMonedasBoveda.addActionListener( this );
        botonConsultarMonedasBoveda.setPreferredSize( new Dimension( 180, 30 ) );
        botonConsultarMonedasBoveda.setBackground( new Color( 255, 197, 73 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets( 0, 0, 5, 0 );
        add( botonConsultarMonedasBoveda, gbc );

        botonConsultarCantidadTipoMoneda = new JButton( "Ver cantidad tipo moneda" );
        botonConsultarCantidadTipoMoneda.setActionCommand( CONSULTAR_CANTIDAD_TIPO_MONEDA );
        botonConsultarCantidadTipoMoneda.addActionListener( this );
        botonConsultarCantidadTipoMoneda.setPreferredSize( new Dimension( 180, 30 ) );
        botonConsultarCantidadTipoMoneda.setBackground( new Color( 255, 197, 73 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 3;
        add( botonConsultarCantidadTipoMoneda, gbc );

        // Panel con las llaves
        ImageIcon llave = new ImageIcon( "./data/Llave.png" );
        JPanel panelLllaves = new JPanel( );
        panelLllaves.setOpaque( false );
        etiquetaLlave = new JLabel( llave );
        etiquetaLlave.setOpaque( false );
        panelLllaves.add( etiquetaLlave );
        comboLlaves = new JComboBox( );
        panelLllaves.add( comboLlaves );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets( 0, 0, 5, 0 );
        add( panelLllaves, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Muestra el mensaje especificado en el área de texto (pergamino). <br>
     * @param contenido Contenido del mensaje. contenido!=null
     */
    public void mostrarMensaje( String contenido )
    {
        textoContenidoPergamino.setText( contenido );
    }

    /**
     * Actualiza las llaves de las bóvedas. <br>
     * <b>post: </b> Se actualizaron las llaves de las bóvedas existentes. <br>
     * @param bovedas Bóvedas existentes. bovedas!=null
     */
    public void actualizarBovedas( ArrayList bovedas )
    {
        comboLlaves.removeAllItems( );
        for( int cont = 0; cont < bovedas.size( ); cont++ )
        {
            Boveda boveda = ( Boveda )bovedas.get( cont );
            int llave = boveda.darLlave( );
            comboLlaves.addItem( Integer.toString( llave ) );
        }
    }

    /**
     * Retorna la llave que se encuentra seleccionada. <br>
     * @return La llave seleccionada, -1 en caso de que ninguna llave este seleccionada.
     */
    public int darLlaveSeleccionada( )
    {
        int resul = -1;

        if( comboLlaves.getSelectedIndex( ) != -1 )
        {
            String llave = ( String )comboLlaves.getSelectedItem( );
            resul = Integer.parseInt( llave );
        }

        return resul;
    }

    /**
     * Este método se encarga de pintar el panel y sus componentes, haciendo que haya una imagen en el fondo.
     * @param g Es la superficie del panel.
     */
    public void paintComponent( Graphics g )
    {
        ImageIcon icon = new ImageIcon( "./data/Pergamino.png" );
        g.drawImage( icon.getImage( ), 0, 0, null );
        setOpaque( false );
        super.paintComponent( g );

    }

    /**
     * Manejo de los eventos de los botones.
     * @param evento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        int llave;

        if( CONSULTAR_MONEDAS_BOVEDA.equals( comando ) )
        {
            llave = darLlaveSeleccionada( );
            principal.consultarMonedasBoveda( llave );
        }
        else if( CONSULTAR_CANTIDAD_TIPO_MONEDA.equals( comando ) )
        {
            llave = darLlaveSeleccionada( );
            principal.mostrarDialogoConsultaMonedas( llave );

        }
        else if( CONSULTA_INFORMACION_BOVEDA.equals( comando ) )
        {
            llave = darLlaveSeleccionada( );
            principal.consultarInformacionBoveda( llave );
        }

    }

}