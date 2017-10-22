package edu.jabs.bancoGnomos.interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.jabs.bancoGnomos.mundo.BancoGnomos;

/**
 * Ventana principal de la aplicación.
 */
public class InterfazBancoGnomos extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private BancoGnomos bancoGnomos;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con las extensiones.
     */
    private PanelExtension panelExtension;

    /**
     * Panel en el que se despliega la información de la bóveda.
     */
    private PanelBoveda panelBoveda;

    /**
     * Panel para realizar retiros y depósitos en las bóvedas.
     */
    private PanelTransacciones panelTransacciones;

    /**
     * Panel para el manejo del convertidor.
     */
    private PanelServicioConversiones panelServicioConversiones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz <br>
     */
    public InterfazBancoGnomos( )
    {
        // Construye la forma
        getContentPane( ).setLayout( new BorderLayout( ) );
        setSize( 748, 389 );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Banco de los Gnomos" );

        // Creación de los paneles aquí
        panelExtension = new PanelExtension( this );
        panelBoveda = new PanelBoveda( this );
        panelTransacciones = new PanelTransacciones( this );
        panelServicioConversiones = new PanelServicioConversiones( this );

        // Panel auxiliar
        JPanel panelAuxiliar = new JPanel( );
        panelAuxiliar.setLayout( new GridBagLayout( ) );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panelAuxiliar.add( panelTransacciones, gbc );

        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panelAuxiliar.add( panelServicioConversiones, gbc );

        getContentPane( ).add( panelAuxiliar, BorderLayout.WEST );
        getContentPane( ).add( panelBoveda, BorderLayout.CENTER );
        getContentPane( ).add( panelExtension, BorderLayout.SOUTH );

        // Crea la clase principal
        bancoGnomos = new BancoGnomos( );
        String archivo = "./data/Bovedas.txt";

        try
        {
            bancoGnomos.cargarBovedas( archivo );
            panelBoveda.actualizarBovedas( bancoGnomos.darBovedas( ) );
        }
        catch( Exception e )
        {

            JOptionPane.showMessageDialog( this, "No se pudo cargar la información de las bóvedas del archivo " + archivo, "Banco Gnomos", JOptionPane.INFORMATION_MESSAGE );
        }

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Realiza la conversión especificada y muestra un diálogo con el resultado. <br>
     * @param cantidad Cantidad a ser convertida.
     * @param monedaOrigen Moneda origen de la conversión. monedaOrigen!=null.
     * @param monedaDestino Moneda destino de la conversión. monedaDestino!=null.
     * @throws Exception si el tipo de moneda origen o destino no existen.
     */
    public void realizarConversion( int cantidad, String monedaOrigen, String monedaDestino ) throws Exception
    {
        double conversion = bancoGnomos.realizarConversion( cantidad, monedaOrigen, monedaDestino );

        String mensaje = construirMensajeConversion( cantidad, conversion, monedaOrigen, monedaDestino );

        JOptionPane.showMessageDialog( this, mensaje, "Banco Gnomos- Conversión monedas", JOptionPane.INFORMATION_MESSAGE );

    }

    /**
     * Realiza la consulta de las monedas de la bóveda especificada. <br>
     * @param llave Llave de la bóveda.
     */
    public void consultarMonedasBoveda( int llave )
    {
        try
        {
            int cantidad = bancoGnomos.consultarCantidadTotalMonedasBoveda( llave );
            String mensaje = construirMensajeConsultaMonedas( llave, cantidad );
            mensaje = "\n" + mensaje;
            panelBoveda.mostrarMensaje( mensaje );

        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Banco Gnomos- Consulta monedas", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Realiza la consulta de la cantidad de monedas del tipo especificado. <br>
     * @param llave Llave de la bóveda.
     * @param tipo Tipo de moneda con la que se realizó la consulta.
     */
    public void consultarCantidadTipoMonedasBoveda( int llave, String tipo )
    {
        try
        {
            int cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( llave, tipo );
            String mensaje = construirMensajeConsultaCantidadTipoMonedas( llave, cantidad, tipo );
            mensaje = "\n" + mensaje;
            panelBoveda.mostrarMensaje( mensaje );

        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Banco Gnomos- Consulta monedas", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Construye el mensaje con el resultado de la conversión. <br>
     * @param cantidad Cantidad de monedas con la que se realizó la conversión.
     * @param conversion Resultado de la conversión.
     * @param monedaOrigen Moneda origen de la conversión. monedaOrigen!=null.
     * @param monedaDestino Moneda destino de la conversión. monedaDestino!=null.
     * @return El mensaje con el resultado de la conversión.
     */
    private String construirMensajeConversion( int cantidad, double conversion, String monedaOrigen, String monedaDestino )
    {
        String conversionS = Double.toString( conversion );
        int posPunto = conversionS.lastIndexOf( '.' );
        String resul;
        String mensaje = "";

        // Transforma el resultado de la conversión a String
        if( posPunto + 4 < conversionS.length( ) )
        {
            resul = conversionS.substring( 0, posPunto + 4 );
        }
        else
        {
            resul = conversionS.substring( 0, posPunto + 2 );
        }

        // Arma la parte del mensaje manejando correctamente el singular y el plural
        if( cantidad != 1 )
        {
            if( !monedaOrigen.equals( BancoGnomos.GALEON ) )
            {
                mensaje += Integer.toString( cantidad ) + " " + monedaOrigen + "s equivalen a ";
            }
            else
            {
                mensaje += Integer.toString( cantidad ) + " " + "Galeones equivalen a ";
            }
        }
        else
        {
            mensaje += Integer.toString( cantidad ) + " " + monedaOrigen + " equivale a ";
        }

        if( conversion != 1 )
        {
            if( !monedaDestino.equals( BancoGnomos.GALEON ) )
            {
                mensaje += resul + " " + monedaDestino + "s.";
            }
            else
            {
                mensaje += resul + " " + "Galeones.";
            }
        }
        else
        {
            mensaje += resul + " " + monedaDestino;
        }

        return mensaje;
    }

    /**
     * Construye un mensaje con la llave y cantidad total dados por parámetro. <br>
     * @param cantidad Cantidad de monedas de la bóveda.
     * @param conversion Resultado de la conversión.
     * @param llave Llave de la bóveda.
     * @return El mensaje con el resultado de la consulta.
     */
    private String construirMensajeConsultaMonedas( int llave, int cantidad )
    {
        String mensaje = "La cantidad de monedas total de la bóveda con llave " + Integer.toString( llave ) + " es " + Integer.toString( cantidad ) + ".";
        return mensaje;
    }

    /**
     * Construye un mensaje con la llave, tipo de moneda y cantidad dados por parámetro. <br>
     * @param llave Llave de la bóveda.
     * @param cantidad Cantidad de monedas de la bóveda.
     * @param tipo Tipo de moneda.
     * @return El mensaje con el resultado de la consulta.
     */
    private String construirMensajeConsultaCantidadTipoMonedas( int llave, int cantidad, String tipo )
    {
        String mensaje = "La cantidad de " + tipo + " de la bóveda con llave " + Integer.toString( llave ) + " es " + Integer.toString( cantidad ) + ".";
        return mensaje;
    }

    /**
     * Construye un mensaje con la llave, nombre del cliente, tipo de moneda y cantidad dados por parámetro. <br>
     * @param llave Llave de la bóveda.
     * @param nombreCliente Nombre del cliente de la bóveda. nombreCliente!=null.
     * @param tipo Tipo de la bóveda. tipo!=null.
     * @param nombreBoveda Nombre de la bóveda. nombreBoveda!=null.
     * @return El mensaje con el resultado de la consulta.
     */
    private String construirMensajeConsultaInformacionBoveda( int llave, String nombreCliente, String tipo, String nombreBoveda )
    {
        String mensaje = "Nombre: " + nombreBoveda + "\nLlave: " + Integer.toString( llave ) + "\nNombre cliente: " + nombreCliente + "\nTipo: " + tipo.toLowerCase( );
        return mensaje;
    }

    /**
     * Muestra el diálogo para realizar la consulta de un tipo de moneda específico en la boveda asociada a la llave dada por parámetro. <br>
     * @param llave La llave de la bóveda sobre la cual se va a realizar la consulta.
     */
    public void mostrarDialogoConsultaMonedas( int llave )
    {
        DialogoConsultaCantidadTipoMoneda dialogo = new DialogoConsultaCantidadTipoMoneda( this, llave );
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible( true );
    }

    /**
     * Muestra el diálogo para realizar la consulta de un tipo de moneda específico. <br>
     */
    public void mostrarDialogoConversionMonedas( )
    {
        DialogoConversionMonedas dialogo = new DialogoConversionMonedas( this );
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible( true );
    }

    /**
     * Realiza el retiro de la cantidad de monedas especificada por el usuario. <br>
     * <b> post: </b> Se realizó el retiro especificado. <br>
     */
    public void realizarRetiro( )
    {
        try
        {
            int llaveBoveda = panelBoveda.darLlaveSeleccionada( );
            int can = panelTransacciones.darCantidadMonedas( );
            String tipo = panelTransacciones.darTipoMonedaSeleccionada( );
            bancoGnomos.retirarMonedasBoveda( llaveBoveda, can, tipo );
            panelBoveda.mostrarMensaje( "El retiro fue realizado con éxito" );

        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Banco Gnomos- Retiro monedas", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Realizar el depósito de la cantidad de monedas especificada por el usuario. <br>
     * <b> post: </b> Se realizó el deposito especificado. <br>
     */
    public void realizarDeposito( )
    {
        try
        {
            int llaveBoveda = panelBoveda.darLlaveSeleccionada( );
            int can = panelTransacciones.darCantidadMonedas( );
            String tipo = panelTransacciones.darTipoMonedaSeleccionada( );
            bancoGnomos.depositarMonedasBoveda( llaveBoveda, can, tipo );
            panelBoveda.mostrarMensaje( "El depósito fue realizado con éxito." );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Banco Gnomos- Depósito monedas", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Consulta la información de la bóveda con la llave especificada. <br>
     * <b> post: </b> Se consultó la información de la bóveda con la llave especificada. <br>
     * @param llave Llave de la bóveda.
     */
    public void consultarInformacionBoveda( int llave )
    {

        try
        {
            String nombre = bancoGnomos.consultarNombreBoveda( llave );
            String nombreCliente = bancoGnomos.consultarNombreClienteBoveda( llave );
            String tipo = bancoGnomos.consultarTipoBoveda( llave );
            String mensaje = construirMensajeConsultaInformacionBoveda( llave, nombreCliente, tipo, nombre );
            panelBoveda.mostrarMensaje( mensaje );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Consulta información bóveda", JOptionPane.ERROR_MESSAGE );

        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String resultado = bancoGnomos.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2( )
    {
        String resultado = bancoGnomos.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param args Argumentos del llamado. No se requiere ninguno.
     */
    public static void main( String[] args )
    {

        InterfazBancoGnomos interfaz = new InterfazBancoGnomos( );
        interfaz.setVisible( true );
    }

}