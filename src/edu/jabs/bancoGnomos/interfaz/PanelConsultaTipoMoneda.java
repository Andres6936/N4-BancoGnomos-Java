package edu.jabs.bancoGnomos.interfaz;


import java.awt.Color;
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
import javax.swing.JToggleButton;

import edu.jabs.bancoGnomos.mundo.BancoGnomos;

/**
 * Panel para consultar la cantidad de monedas de un tipo determinado.
 */
public class PanelConsultaTipoMoneda extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para realizar la consulta.
     */
    public static final String CONSULTAR = "Consultar";

    /**
     * Comando para cancelar la consulta.
     */
    public static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Diálogo donde se ubica el panel.
     */
    private DialogoConsultaCantidadTipoMoneda dialogo;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con el titulo de la selección.
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
     * Botón con el que se realiza la consulta.
     */
    private JButton botonConsultar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor del panel. <br>
     * <b>post: </b> Se construyó el panel para la consulta de la cantidad de monedas. <br>
     * @param diag Diálogo donde se encuentra el panel. diag!=null.
     */
    public PanelConsultaTipoMoneda( DialogoConsultaCantidadTipoMoneda diag )
    {
        setLayout( new GridBagLayout( ) );
        dialogo = diag;

        //Panel para mostrar el tipo de moneda
        JPanel panelSeleccion= new JPanel();

        panelSeleccion.setLayout( new GridBagLayout( ) );

        etiquetaTitulo = new JLabel( "Tipo moneda" );
        etiquetaTitulo.setForeground( new Color( 0, 128, 0 ) );

        ImageIcon galeon = new ImageIcon( "./data/Galeon.png" );
        botonGaleon = new JToggleButton( galeon );
        botonGaleon.setToolTipText( "Galeón" );

        ImageIcon knut = new ImageIcon( "./data/Knut.png" );
        botonKnut = new JToggleButton( knut );
        botonKnut.setToolTipText( "Knut" );

        ImageIcon sicklet = new ImageIcon( "./data/Sicklet.png" );
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
        panelSeleccion.add( etiquetaTitulo, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelSeleccion.add( botonGaleon, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelSeleccion.add( botonSicklet, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets( 0, 0, 0, 10 );
        panelSeleccion.add( botonKnut, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 10, 0 );
        add( panelSeleccion, gbc );


        //Botón para realizar la consulta
        botonConsultar = new JButton( "Consultar cantidad monedas" );
        botonConsultar.addActionListener( this );
        botonConsultar.setActionCommand( CONSULTAR );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        add( botonConsultar, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el tipo de moneda seleccionada para realizar la consulta.<br>
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
     * Manejo de los eventos de los botones.
     * @param evento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( CONSULTAR.equals( comando ) )
        {
            dialogo.realizarConsulta( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            dialogo.cancelar( );
        }

    }

}