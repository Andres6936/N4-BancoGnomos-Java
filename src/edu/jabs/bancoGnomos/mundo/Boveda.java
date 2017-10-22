package edu.jabs.bancoGnomos.mundo;

public class Boveda
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para representar el tipo de bóveda: primaria.
     */
    public final static String TIPO_BOVEDA_PRIMARIA = "PRIMARIA";

    /**
     * Constante para representar el tipo de bóveda: secundaria.
     */
    public final static String TIPO_BOVEDA_SECUNDARIA = "SECUNDARIA";

    /**
     * Constante para representar el tipo de bóveda: terciaria.
     */
    public final static String TIPO_BOVEDA_TERCIARIA = "TERCIARIA";

    /**
     * Capacidad máxima de monedas de una bóveda secundaria.
     */
    public final static int CAPACIDAD_MAX_BOVEDA_SECUNDARIA = 2000;

    /**
     * Capacidad máxima de monedas de una bóveda terciaria.
     */
    public final static int CAPACIDAD_MAX_BOVEDA_TERCIARIA = 1000;

    /**
     * Capacidad mínima de monedas de una bóveda secundaria.
     */
    public final static int CANTIDAD_MIN_BOVEDA_SECUNDARIA = 50;

    /**
     * Capacidad mínima de monedas de una bóveda terciaria.
     */
    public final static int CANTIDAD_MIN_BOVEDA_TERCIARIA = 100;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Llave asociada a la bóveda.
     */
    private int llave;

    /**
     * Nombre de la bóveda.
     */
    private String nombre;

    /**
     * Nombre del cliente.
     */
    private String nombreCliente;

    /**
     * Cantidad de galeones que contiene la bóveda.
     */
    private int cantidadGaleones;

    /**
     * Cantidad de sicklets que contiene la bóveda.
     */
    private int cantidadSicklets;

    /**
     * Cantidad de knuts que contiene la bóveda.
     */
    private int cantidadKnuts;

    /**
     * Tipo de la bóveda que determina la cantidad mínima y máxima de monedas a almacenar.
     */
    private String tipoBoveda;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una bóveda con la llave, nombre de cliente, cantidad de galones, cantidad de sicklets, <br>
     * cantidad de knuts, nombre y tipo dados. <br>
     * <b>post: </b> Se creó una bóveda con la información proporcionada. <br>
     * @param laLlave Llave de la bóveda. laLlave>=0.
     * @param nCliente Nombre del cliente a quién pertenece la bóveda. nCliente!=null.
     * @param nombreBoveda Nombre de la bóveda. nombreBoveda!=null.
     * @param cGalones Cantidad de galeones que contiene la bóveda. cGalenones>=0.
     * @param cSickclets Cantidad de sicklets que contiene la bóveda. cSicklet>=0.
     * @param cKnuts Cantidad de knuts que contiene la bóveda. cKnuts>=0.
     * @param tipo Tipo de bóveda. tipo!=null.
     * @throws Exception si el tipo de bóveda no es válido.
     * @throws Exception si no hay capacidad suficiente para almacenar todas las monedas.
     * @throws Exception si no se cumple la restricción sobre la cantidad mínima de monedas que debe tener la bóveda de acuerdo a su tipo.
     */
    public Boveda( int laLlave, String nCliente, String nombreBoveda, int cGalones, int cSickclets, int cKnuts, String tipo ) throws Exception
    {
        llave = laLlave;
        nombreCliente = nCliente;
        cantidadGaleones = 0;
        cantidadKnuts = 0;
        cantidadSicklets = 0;
        tipoBoveda = tipo;
        nombre = nombreBoveda;

        // Si el tipo de bóveda no existe, lanzar la excepción con el mensaje: "El tipo de bóveda " + tipo + " no es válido"
        if( tipoBoveda != TIPO_BOVEDA_PRIMARIA && tipoBoveda != TIPO_BOVEDA_SECUNDARIA && tipoBoveda != TIPO_BOVEDA_SECUNDARIA )
            throw new Exception( "El tipo de bóveda " + this.tipoBoveda + " no es válido" );

        // Si el tipo no hay la capacidad suficiente para almacenar todas las monedas, lanzar la excepción con el mensaje: "No se cumple la restricción sobre la cantidad
        // máxima de monedas que pueden contener las bóvedas de tipo " + tipoBoveda + "."
        if( tipoBoveda == TIPO_BOVEDA_SECUNDARIA )
        {
            if( cantidadGaleones > CAPACIDAD_MAX_BOVEDA_SECUNDARIA || cantidadKnuts > CAPACIDAD_MAX_BOVEDA_SECUNDARIA || cantidadSicklets > CAPACIDAD_MAX_BOVEDA_SECUNDARIA )
                throw new Exception( "No se cumple la restricción sobre la cantidad máxima de monedas que pueden contener la bóvedas de tipo " + this.tipoBoveda + "." );
        }

        if( tipoBoveda == TIPO_BOVEDA_TERCIARIA )
        {
            if( cantidadGaleones > CAPACIDAD_MAX_BOVEDA_TERCIARIA || cantidadKnuts > CAPACIDAD_MAX_BOVEDA_TERCIARIA || cantidadSicklets > CAPACIDAD_MAX_BOVEDA_TERCIARIA )
                throw new Exception( "No se cumple la restricción sobre la cantidad máxima de monedas que pueden contener la bóvedas de tipo " + this.tipoBoveda + "." );
        }

        // Si el tipo no se cumple con la cantidad mínima de monedas, lanzar la excepción con el mensaje: "No se cumple la restricción de la cantidad mínima de monedas
        // que deben contener las bóvedas de tipo " + tipoBoveda + "."
        if( tipoBoveda == TIPO_BOVEDA_SECUNDARIA )
        {
            if( cantidadGaleones < CANTIDAD_MIN_BOVEDA_SECUNDARIA || cantidadKnuts < CANTIDAD_MIN_BOVEDA_SECUNDARIA || cantidadSicklets < CANTIDAD_MIN_BOVEDA_SECUNDARIA )
                throw new Exception( "No se cumple la restricción sobre la cantidad mínima de monedas que pueden contener la bóvedas de tipo " + this.tipoBoveda + "." );
        }

        if( tipoBoveda == TIPO_BOVEDA_TERCIARIA )
        {
            if( cantidadGaleones < CANTIDAD_MIN_BOVEDA_TERCIARIA || cantidadKnuts < CANTIDAD_MIN_BOVEDA_TERCIARIA || cantidadSicklets < CANTIDAD_MIN_BOVEDA_TERCIARIA )
                throw new Exception( "No se cumple la restricción sobre la cantidad mínima de monedas que pueden contener la bóvedas de tipo " + this.tipoBoveda + "." );
        }

        depositarMonedas( cGalones, BancoGnomos.GALEON );
        depositarMonedas( cSickclets, BancoGnomos.SICKLET );
        depositarMonedas( cKnuts, BancoGnomos.KNUT );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Devuelve la llave de la bóveda.
     * @return La llave de la bóveda.
     */
    public int darLlave( )
    {
        return llave;
    }

    /**
     * Devuelve el nombre de la bóveda. <br>
     * @return El nombre de la bóveda.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Devuelve el nombre del cliente a quien pertenece la bóveda. <br>
     * @return El nombre del cliente de la bóveda.
     */
    public String darNombreCliente( )
    {
        return nombreCliente;
    }

    /**
     * Devuelve la cantidad de sicklets que contiene la bóveda. <br>
     * @return La cantidad de sicklets que contiene la bóveda.
     */
    public int darCantidadSicklets( )
    {
        return cantidadSicklets;
    }

    /**
     * Devuelve la cantidad de galeones que contiene la bóveda. <br>
     * @return La cantidad de galeones que contiene la bóveda.
     */
    public int darCantidadGaleones( )
    {
        return cantidadGaleones;
    }

    /**
     * Devuelve la cantidad de knuts que contiene la bóveda. <br>
     * @return La cantidad de knuts que contiene la bóveda
     */
    public int darCantidadKnuts( )
    {
        return cantidadKnuts;
    }

    /**
     * Devuelve el tipo de la bóveda. <br>
     * @return Tipo de la bóveda
     */
    public String darTipoBoveda( )
    {
        return tipoBoveda;
    }

    /**
     * Devuelve la cantidad de monedas que hay en la bóveda. <br>
     * @return La cantidad de monedas total que contiene la bóveda.
     */
    public int darCantidadMonedas( )
    {
        return cantidadSicklets + cantidadGaleones + cantidadKnuts;
    }

    /**
     * Cambia la llave de la bóveda. <br>
     * @param laLlave La nueva llave de la bóveda
     */
    public void cambiarLlave( int laLlave )
    {
        llave = laLlave;
    }

    /**
     * Cambia el nombre de la bóveda. <br>
     * @param nNombre Nuevo nombre de la bóveda
     */
    public void cambiarNombre( String nNombre )
    {
        nombre = nNombre;
    }

    /**
     * Cambia el nombre del cliente al que pertenece la bóveda. <br>
     * @param nNombreCliente Nuevo nombre del cliente al que pertenece la bóveda.
     */
    public void cambiarNombreCliente( String nNombreCliente )
    {
        nombreCliente = nNombreCliente;
    }

    /**
     * Verifica si el tipo de bóveda especificado existe. <br>
     * @param tipo Tipo del que se va a verificar la existencia. tipo!=null
     * @return true si el tipo de bóveda existe o false de lo contrario.
     */
    public boolean existeTipoBoveda( String tipo )
    {
        boolean existe = false;
        if( tipo.equals( TIPO_BOVEDA_PRIMARIA ) || tipo.equals( TIPO_BOVEDA_SECUNDARIA ) || tipo.equals( TIPO_BOVEDA_TERCIARIA ) )
        {
            existe = true;
        }

        return existe;
    }

    /**
     * Verifica si para un tipo especificado de moneda hay una cantidad mayor o igual a un número de consulta. <br>
     * @param cantidadMonedas Cantidad de monedas sobre la que se desea realizar la verificación. cantidadMonedas>=0.
     * @param tipoMoneda Tipo de moneda sobre el que se desea realizar la verificación. tipoMoneda!=null y <br>
     *        tipoMoneda pertenece a {BancoGnomos.GALEON, BancoGnomos.KNUT, BancoGnomos.SICKLET}.
     * @return true si la cantidad de monedas en la bóveda del tipo especificado es mayor o igual a la cantidad de <br>
     *         consulta, false de lo contrario.
     */
    // Crear el método haySuficientesMonedas de acuerdo al contrato.
    public boolean haySuficientesMonedas( int cantidadMonedas, String tipoMoneda )
    {

        if( tipoMoneda == BancoGnomos.GALEON )
        {
            if( this.darCantidadGaleones( ) >= cantidadMonedas )
                return true;
        }
        else if( tipoMoneda == BancoGnomos.KNUT )
        {
            if( this.darCantidadKnuts( ) >= cantidadMonedas )
                return true;
        }
        else if( tipoMoneda == BancoGnomos.SICKLET )
        {
            if( this.darCantidadSicklets( ) >= cantidadMonedas )
                return true;
        }

        // Si ninguna condición se cumple, devolvemos false.
        return false;

    }

    /**
     * Indica si con la cantidad total de monedas especificada en la bóveda cumple la restricción de <br>
     * cantidad máxima de monedas que puede tener. <br>
     * <b>pre: </b> tipoBoveda!=null y pre sobre tipoBoveda pertenece a {TIPO_BOVEDA_PRIMARIA, TIPO_BOVEDA_SECUNDARIA, <br>
     * TIPO_BOVEDA_TERCIARA}.<br>
     * el tipo de bóveda. De lo contrario retornó false. <br>
     * @param cantidadTotalMonedas Cantidad total de monedas contra la que se va a realizar la <br>
     *        verificación. cantidadTotalMonedas>=0.
     * @return true si se cumple la restricción de la cantidad máxima de monedas de acuerdo al tipo de bóveda, <br>
     *         false en caso contrario.
     */
    // TODO: Crear el método cumpleRestriccionCantidadMaximaMonedas de acuerdo al contrato.
    public boolean cumpleRestriccionCantidadMaximaMonedas( int cantidadTotalMonedas )
    {
        return false;
    }

    /**
     * Indica si la cantidad total de monedas especificada cumple la restricción de cantidad <br>
     * mínima de monedas que debe tener la bóveda. <br>
     * <b>pre: </b> tipoBoveda!=null y tipoBoveda pertenece a {TIPO_BOVEDA_PRIMARIA, TIPO_BOVEDA_SECUNDARIA, <br>
     * TIPO_BOVEDA_TERCIARA} <br>
     * @param cantidadTotalMonedas Cantidad total de monedas contra la que se va a realizar la verificación. cantidadTotalMonedas>=0 <br>
     * @return true si se cumple la restricción de la cantidad mínima de monedas de acuerdo al tipo de bóveda, false en caso contrario.<br>
     */
    // TODO: Crear el método cumpleRestriccionCantidadMinimaMonedas de acuerdo al contrato.
    public boolean cumpleRestriccionCantidadMinimaMonedas( int cantidadTotalMonedas )
    {
        return false;
    }

    /**
     * Deposita la cantidad de monedas especificada. <br>
     * <b>pre: </b> tipoBoveda!=null y tipoBoveda pertenece a {TIPO_BOVEDA_PRIMARIA, TIPO_BOVEDA_SECUNDARIA, <br>
     * TIPO_BOVEDA_TERCIARA}.<br>
     * <b>post: </b> Aumentó la cantidad especificada del tipo de monedas dada.<br>
     * @param cMonedas Cantidad de monedas a ser depositada. cMonedas>=0.
     * @param tipoMoneda Tipo de moneda a depositar. tipoMoneda!=null y tipoMoneda pertenece a <br>
     *        {BancoGnomos.GALEON, BancoGnomos.KNUT, BancoGnomos.SICKLET}.
     * @throws Exception Si la bóveda no tiene capacidad suficiente para el número de monedas que se intenta depositar <br>
     *         de acuerdo al tipo de bóveda.
     */
    // TODO: Crear el método depositarMonedas de acuerdo al contrato.
    public void depositarMonedas( int cMonedas, String tipoMoneda ) throws Exception
    {

    }

    /**
     * Retira de la bóveda la cantidad de monedas del tipo especificado. <br>
     * <b>pre: </b> tipoBoveda!=null y tipoBoveda pertenece {TIPO_BOVEDA_PRIMARIA, TIPO_BOVEDA_SECUNDARIA, <br>
     * TIPO_BOVEDA_TERCIARA}.<br>
     * <b>post: </b> Se retiró de la bóveda la cantidad de monedas especificada. <br>
     * @param cMonedas Cantidad de monedas a ser retirada. cMonedas>=0.
     * @param tipoMoneda Tipo de moneda a retirar. tipoMoneda!=null y tipoMoneda pertenece a <br>
     *        {BancoGnomos.GALEON, BancoGnomos.KNUT, BancoGnomos.SICKLET}.
     * @throws Exception Si la bóveda no tiene suficientes monedas del tipo dado para ser retiradas.
     * @throws Exception Si la bóveda no cumple con la restricción de cantidad mínima de monedas de acuerdo al tipo de bóveda.
     */
    // TODO: Crear el método retirarMonedas de acuerdo al contrato.
    public void retirarMonedas( int cMonedas, String tipoMoneda ) throws Exception
    {

    }

}
