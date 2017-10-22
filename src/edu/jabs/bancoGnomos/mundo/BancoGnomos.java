package edu.jabs.bancoGnomos.mundo;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase que representa el banco.
 */
public class BancoGnomos
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el tipo de moneda: Galeón.
     */
    public static final String GALEON = "Galeón";

    /**
     * Constante que representa el tipo de moneda: Sicklet.
     */
    public static final String SICKLET = "Sicklet";

    /**
     * Constante que representa el tipo de moneda: Knut.
     */
    public static final String KNUT = "Knut";

    /**
     * Constante que representa la equivalencia de un galeón a sicklets.
     */
    public static final double EQUIVALENCIA_GALEON_SICKLET = 14;

    /**
     * Constante que representa la equivalencia de un galeón a knuts.
     */
    public static final double EQUIVALENCIA_GALEON_KNUT = 490;

    /**
     * Constante que representa la equivalencia de un sicklet a knuts.
     */
    public static final double EQUIVALENCIA_SICKLET_KNUT = 35;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de bóvedas manejadas por el banco.
     */
    ArrayList<Boveda> bovedas = new ArrayList<Boveda>( );

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el banco con una lista vacía de bóvedas.
     */
    public BancoGnomos( )
    {
        bovedas = new ArrayList<Boveda>( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Carga del archivo los datos iniciales con información del banco. <br>
     * <b>post: </b> Se cargan los datos del banco del archivo eliminando las bóvedas anteriores. <br>
     * @param archivo Nombre del archivo que contiene la información de las bóvedas. archivo!=null
     * @throws Exception si hay datos inválidos en el archivo o no tiene el formato adecuado.
     * @throws Exception si no hay capacidad suficiente para almacenar todas las monedas.
     * @throws Exception si no se cumple la restricción sobre la cantidad mínima de monedas que debe tener la bóveda de acuerdo a su tipo.
     */
    public void cargarBovedas( String archivo ) throws Exception
    {
        int llave;
        int cantidadKnuts;
        int cantidadGaleones;
        int cantidadSicklets;
        int totalBovedas;
        String tipoBoveda;
        String nombreCliente;
        String nombreBoveda;
        String dato;
        Boveda boveda;

        String aux;

        // Limpia los datos iniciales de las bóvedas
        bovedas.clear( );

        // Obtiene los datos
        try
        {
            Properties datos = new Properties( );
            FileInputStream input = new FileInputStream( archivo );
            datos.load( input );

            // Obtiene el número de tarjetas
            totalBovedas = Integer.parseInt( datos.getProperty( "total.bovedas" ) );

            for( int cont = 0; cont < totalBovedas; cont++ )
            {
                // Llave de la bóveda
                dato = "boveda" + cont + ".llave";

                aux = datos.getProperty( dato );
                if( aux == null )
                {
                    throw new Exception( "Falta definir la propiedad " + dato );
                }

                llave = Integer.parseInt( aux );

                // Cantidad Knuts
                dato = "boveda" + cont + ".cantidadKnuts";

                aux = datos.getProperty( dato );

                if( aux == null )
                {
                    throw new Exception( "Falta definir la propiedad " + dato );
                }

                cantidadKnuts = Integer.parseInt( aux );

                // Cantidad sicklets
                dato = "boveda" + cont + ".cantidadSicklets";

                aux = datos.getProperty( dato );

                if( aux == null )
                {
                    throw new Exception( "Falta definir la propiedad " + dato );
                }

                cantidadSicklets = Integer.parseInt( aux );

                // Cantidad Galeones
                dato = "boveda" + cont + ".cantidadGaleones";

                aux = datos.getProperty( dato );

                if( aux == null )
                {
                    throw new Exception( "Falta definir la propiedad " + dato );
                }

                cantidadGaleones = Integer.parseInt( aux );

                // Nombre del cliente
                dato = "boveda" + cont + ".nombreCliente";

                nombreCliente = datos.getProperty( dato );

                if( nombreCliente == null )
                {
                    throw new Exception( "Falta definir la propiedad " + dato );
                }

                // Nombre de la bóveda
                dato = "boveda" + cont + ".nombreBoveda";

                nombreBoveda = datos.getProperty( dato );

                if( nombreBoveda == null )
                {
                    throw new Exception( "Falta definir la propiedad " + dato );
                }

                // Tipo de la bóveda
                dato = "boveda" + cont + ".tipoBoveda";

                tipoBoveda = datos.getProperty( dato );

                if( tipoBoveda == null )
                {
                    throw new Exception( "Falta definir la propiedad " + dato );
                }

                // Crear y adicionar la bóveda
                boveda = new Boveda( llave, nombreCliente, nombreBoveda, cantidadGaleones, cantidadSicklets, cantidadKnuts, tipoBoveda );
                bovedas.add( boveda );
            }
        }
        catch( Exception e )
        {
            throw new Exception( "Error al cargar los datos almacenados de las bóvedas." );
        }
    }

    /**
     * Devuelve las bóvedas existentes. <br>
     * @return Las bóvedas existentes.
     */
    public ArrayList<Boveda> darBovedas( )
    {
        return bovedas;
    }

    /**
     * Devuelve la cantidad total de monedas de la bóveda correspondiente a la llave especificada. <br>
     * <b>pre: </b> bovedas!=null <br>
     * @param llaveBoveda Llave de la bóveda a ser consultada.
     * @return La cantidad total de monedas de la bóveda especificada.
     * @throws Exception si no existe una bóveda con la llave especificada.
     */
    public int consultarCantidadTotalMonedasBoveda( int llaveBoveda ) throws Exception
    {

        boolean encontrada = false;
        int cantidadMonedas = 0;

        for( int i = 0; i < bovedas.size( ) && !encontrada; i++ )
        {
            Boveda bovedaActual = bovedas.get( i );
            if( bovedaActual.darLlave( ) == llaveBoveda )
            {

                encontrada = true;
                cantidadMonedas = bovedaActual.darCantidadMonedas( );

            }
        }

        // Si terminamos de reccorer el 'for' y la variable encontrada sigue siendo 'false' significa que
        // no se ha encontrado la bóveda con esa llave.
        if( !encontrada )
            throw new Exception( "No existe un bóveda con la llave especificada" );

        return cantidadMonedas;

    }

    /**
     * Devuelve la cantidad total de monedas de la bóveda que se le especifican por parámetro. <br>
     * <b>pre: </b> bovedas != null <br>
     * @param llaveBoveda Llave de la bóveda a ser consultada.
     * @param tipoMoneda Tipo de moneda que desea consultar.
     * @return La cantidad total de monedas especificadas.
     * @throws Exception si no existe una bóveda con la llave especificada.
     * @throws Exception si el tipo de moneda no existe.
     */
    public int consultarCantidadTipoMonedasBoveda( int llaveBoveda, String tipoMoneda ) throws Exception
    {
        int cantidad = 0;

        Boveda boveda = buscarBoveda( llaveBoveda );

        if( boveda != null )
        {
            if( existeMoneda( tipoMoneda ) )
            {
                if( tipoMoneda.equals( GALEON ) )
                {
                    cantidad = boveda.darCantidadGaleones( );
                }
                else if( tipoMoneda.equals( SICKLET ) )
                {
                    cantidad = boveda.darCantidadSicklets( );
                }
                else if( tipoMoneda.equals( KNUT ) )
                {
                    cantidad = boveda.darCantidadKnuts( );
                }
            }
            else
            {
                throw new Exception( "El tipo de moneda " + tipoMoneda + " no existe." );
            }
        }
        else
        {
            throw new Exception( "La bóveda con llave " + llaveBoveda + " no existe." );
        }

        return cantidad;
    }

    /**
     * Devuelve el nombre de la bóveda que corresponde a la llave dada. <br>
     * <b>pre: </b> bovedas!=null. <br>
     * @param llave Llave de la bóveda.
     * @return El nombre de la bóveda
     * @throws Exception si la llave no corresponde a ninguna bóveda existente.
     */
    public String consultarNombreBoveda( int llave ) throws Exception
    {
        Boveda boveda = buscarBoveda( llave );
        String nombre = "";

        if( boveda != null )
        {
            nombre = boveda.darNombre( );
        }
        else
        {
            throw new Exception( "La bóveda con llave " + Integer.toString( llave ) + " no existe." );
        }

        return nombre;
    }

    /**
     * Devuelve el nombre del cliente de la bóveda. <br>
     * <b>pre: </b> bovedas!=null. <br>
     * @param llave Llave de la bóveda.
     * @return El nombre del cliente de la bóveda.
     * @throws Exception si la llave no corresponde a ninguna bóveda existente.
     */
    public String consultarNombreClienteBoveda( int llave ) throws Exception
    {
        Boveda boveda = buscarBoveda( llave );
        String nombre = "";

        if( boveda != null )
        {
            nombre = boveda.darNombreCliente( );
        }
        else
        {
            throw new Exception( "La bóveda con llave " + Integer.toString( llave ) + " no existe." );
        }

        return nombre;
    }

    /**
     * Devuelve el tipo de la bóveda que corresponde a la llave dada. <br>
     * <b>pre: </b> bovedas!=null. <br>
     * @param llave Llave de la bóveda.
     * @return El tipo de la bóveda.
     * @throws Exception si la llave no corresponde a ninguna bóveda existente.
     */
    public String consultarTipoBoveda( int llave ) throws Exception
    {
        Boveda boveda = buscarBoveda( llave );
        String tipo = "";

        if( boveda != null )
        {
            tipo = boveda.darTipoBoveda( );
        }
        else
        {
            throw new Exception( "La bóveda con llave " + Integer.toString( llave ) + " no existe." );
        }

        return tipo;
    }

    /**
     * Verifica que el tipo de modena que se pasa por parámetro exista. Si existe devuelve true en caso contrario false. <br>
     * @param tipo Tipo de moneda a verificar
     * @return True si el tipo de moneda existe, en caso contrario false.
     */
    private boolean existeMoneda( String tipo )
    {
        boolean existe = false;

        if( tipo.equals( BancoGnomos.GALEON ) || tipo.equals( BancoGnomos.SICKLET ) || tipo.equals( BancoGnomos.KNUT ) )
        {
            existe = true;
        }

        return existe;
    }

    /**
     * Devuelve la bóveda con la llave especificada. <br>
     * <b> pre: </b> bovedas!=null <br>
     * @param llaveBoveda Llave de la bóveda.
     * @return La bóveda con la llave especificada, null si la llave no corresponde a ninguna bóveda.
     */
    public Boveda buscarBoveda( int llaveBoveda )
    {
        boolean encontrada = false;
        Boveda boveda = null;

        for( int i = 0; i < bovedas.size( ) && !encontrada; i++ )
        {
            Boveda bovedaActual = bovedas.get( i );
            if( bovedaActual.darLlave( ) == llaveBoveda )
            {

                encontrada = true;
                boveda = bovedaActual;
                return boveda;

            }
        }

        return null;
    }

    /**
     * Deposita la cantidad de monedas del tipo dado en la bóveda con la llave especificada. <br>
     * <b>pre: </b> bovedas!=null. <br>
     * <b>post: </b> Se depositó la cantidad total de monedas del tipo especificado en la bóveda. <br>
     * @param llaveBoveda Llave de la bóveda en la que se va a realizar el depósito.
     * @param cantidadMonedas Cantidad de monedas a ser depositadas.
     * @param tipoMoneda Tipo de moneda a depositar. tipoMoneda!=null.
     * @throws Exception si el tipo de moneda no existe.
     * @throws Exception si la cantidad de monedas es menor a 0.
     * @throws Exception si no existe una bóveda con la llave especificada.
     * @throws Exception si no existe una bóveda con la llave especificada.
     * @throws Exception Si la bóveda no tiene capacidad suficiente para el número de monedas que se intenta depositar <br>
     *         de acuerdo al tipo de bóveda.
     */
    // TODO: Crear el método depositarMonedasBoveda de acuerdo al contrato.
    // RECUERDE QUE ESTE MÉTODO DEBE CAPTURAR Y RELANZAR LAS EXCEPCIONES LANZADAS AL INVOCAR EL MÉTODO depositarMonedas DE LA CLASE Boveda.
    public void depositarMonedasBoveda( int llaveBoveda, int cantidadMonedas, String tipoMoneda ) throws Exception
    {

    }

    /**
     * Retira la cantidad de monedas del tipo dado de la bóveda con la llave especificada. <br>
     * <b>pre: </b> bovedas!=null. <br>
     * <b>post: </b> Se retiró la cantidad de monedas del tipo especificado en la bóveda. <br>
     * @param llaveBoveda Llave de la bóveda de la que se va a realizar el retiro.
     * @param cantidadMonedas Cantidad de monedas a ser retiradas.
     * @param tipoMoneda Tipo de moneda a retirar. tipoMoneda!=null.
     * @throws Exception si el tipo de moneda no existe.
     * @throws Exception si la cantidad de monedas es menor a 0.
     * @throws Exception si no existe una bóveda con la llave especificada.
     * @throws Exception Si la bóveda no tiene suficientes monedas del tipo dado para ser retiradas.
     * @throws Exception Si la bóveda no cumple con la restricción de cantidad mínima de monedas de acuerdo al tipo de bóveda.
     */
    // TODO: Crear el método retirarMonedasBoveda de acuerdo al contrato.
    // RECUERDE QUE ESTE MÉTODO DEBE CAPTURAR Y RELANZAR LAS EXCEPCIONES LANZADAS AL INVOCAR EL MÉTODO retirarMonedas DE LA CLASE Boveda.
    public void retirarMonedasBoveda( int llaveBoveda, int cantidadMonedas, String tipoMoneda ) throws Exception
    {

    }

    /**
     * Realiza la conversión de una moneda a otra de acuerdo a los tipos de monedas y cantidad especificadas. <br>
     * @param cantidad Cantidad de monedas a convertir.
     * @param monedaOrigen Tipo de moneda en la que se tiene la cantidad a convertir. monedaOrigen!=null.
     * @param monedaDestino Nuevo tipo de moneda en la que se tendrá la cantidad original. monedaDestino!=null.
     * @return El valor resultante de la conversión.
     * @throws Exception si la moneda origen no existe.
     * @throws Exception si la moneda destino no existe.
     * @throws Exception si la cantidad de monedas a convertir es menor que cero.
     */
    // TODO: Crear el método realizarConversion de acuerdo al contrato.
    public double realizarConversion( int cantidad, String monedaOrigen, String monedaDestino ) throws Exception
    {

        if( monedaOrigen.equals( SICKLET ) && monedaDestino.equals( GALEON ) )
            return convertirAGaleones( cantidad, SICKLET );
        else if( monedaOrigen.equals( SICKLET ) && monedaDestino.equals( KNUT ) )
            return convertirAKnuts( cantidad, SICKLET );

        else if( monedaOrigen.equals( GALEON ) && monedaDestino.equals( SICKLET ) )
            return convertirASicklets( cantidad, GALEON );
        else if( monedaOrigen.equals( GALEON ) && monedaDestino.equals( KNUT ) )
            return convertirAKnuts( cantidad, GALEON );

        else if( monedaOrigen.equals( KNUT ) && monedaDestino.equals( GALEON ) )
            return convertirAGaleones( cantidad, KNUT );
        else if( monedaOrigen.equals( KNUT ) && monedaDestino.equals( SICKLET ) )
            return convertirASicklets( cantidad, KNUT );

        return cantidad;

    }

    /**
     * Convierte la cantidad especifica cuyo tipo de moneda es dada a galeones. <br>
     * @param cantidadMonedas Cantidad de monedas a convertir. cantidadMonedas>=0.
     * @param tipoMoneda Tipo de moneda a convertir a galeones. tipoMoneda!=null y tipMoneda pertenece a {GALEON, KNUT o SICKLET}.
     * @return El valor resultado de la conversión a galeones.
     */
    private double convertirAGaleones( double cantidadMonedas, String tipoMoneda )
    {
        double conversion = 0;

        if( tipoMoneda.equals( GALEON ) )
        {
            conversion = cantidadMonedas;
        }
        else if( tipoMoneda.equals( SICKLET ) )
        {
            conversion = cantidadMonedas / EQUIVALENCIA_GALEON_SICKLET;
        }
        else if( tipoMoneda.equals( KNUT ) )
        {
            conversion = cantidadMonedas / EQUIVALENCIA_GALEON_KNUT;
        }

        return conversion;
    }

    /**
     * Convierte la cantidad especifica cuyo tipo de moneda es dada a sicklets. <br>
     * @param cantidadMonedas Cantidad de monedas a convertir. cantidadMonedas>=0.
     * @param tipoMoneda Tipo de moneda a convertir a sicklets. tipoMoneda!=null y tipMoneda pertenece a {GALEON, KNUT o SICKLET}.
     * @return El valor resultado de la conversión a sicklets.
     */
    private double convertirASicklets( double cantidadMonedas, String tipoMoneda )
    {

        double conversion = 0;

        if( tipoMoneda.equals( GALEON ) )
        {
            conversion = cantidadMonedas * EQUIVALENCIA_GALEON_SICKLET;
        }
        else if( tipoMoneda.equals( SICKLET ) )
        {
            conversion = cantidadMonedas;
        }
        else if( tipoMoneda.equals( KNUT ) )
        {
            conversion = cantidadMonedas / EQUIVALENCIA_SICKLET_KNUT;
        }

        return conversion;
    }

    /**
     * Convierte la cantidad especifica cuyo tipo de moneda es dada a knuts. <br>
     * @param cantidadMonedas Cantidad de monedas a convertir. cantidadMonedas>=0.
     * @param tipoMoneda Tipo de moneda a convertir a knuts. tipoMoneda!=null y tipMoneda pertenece a {GALEON, KNUT o SICKLET}.
     * @return El valor resultado de la conversión a knuts.
     */
    private double convertirAKnuts( double cantidadMonedas, String tipoMoneda )
    {

        double conversion = 0;

        if( tipoMoneda.equals( GALEON ) )
        {
            conversion = cantidadMonedas * EQUIVALENCIA_GALEON_KNUT;
        }
        else if( tipoMoneda.equals( SICKLET ) )
        {
            conversion = cantidadMonedas * EQUIVALENCIA_SICKLET_KNUT;
        }
        else if( tipoMoneda.equals( KNUT ) )
        {
            conversion = cantidadMonedas;
        }

        return conversion;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
