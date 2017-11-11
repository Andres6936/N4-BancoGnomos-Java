package edu.jabs.bancoGnomos.test;

import java.util.ArrayList;

import junit.framework.TestCase;

import edu.jabs.bancoGnomos.mundo.BancoGnomos;
import edu.jabs.bancoGnomos.mundo.Boveda;

/**
 * Clase usada para verificar que los métodos de la clase BancoGnomos estén correctamente implementados.
 */
public class BancoGnomosTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * banco de prueba.
     */
    private BancoGnomos bancoGnomos;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un nuevo BancoGnomos vacío.
     */
    private void setupEscenario1( )
    {
        bancoGnomos = new BancoGnomos( );
    }

    /**
     * Escenario 2: Construye un nuev BancoGnosmos con 5 bóvedas.
     */
    private void setupEscenario2( )
    {
        bancoGnomos = new BancoGnomos( );
        try
        {
            bancoGnomos.cargarBovedas( "./test/data/bovedasTest.txt" );
        }
        catch( Exception e )
        {

            fail("No se debió arrojar excepción");
        }
    }

    /**
     * Prueba 1: Verifica el método para cargar bóvedas.
     */
    public void testCargarBovedas1( )
    {
        setupEscenario1( );

        try
        {
            bancoGnomos.cargarBovedas( "./test/data/bovedasTest.txt" );
            ArrayList bovedas = bancoGnomos.darBovedas( );

            // Verificar el número de bóvedas
            assertEquals( "El número de bóvedas no es el correcto", 5, bovedas.size( ) );

            // BOVEDA1
            // Verificar que la información de las bóvedas sea correcta
            Boveda boveda = ( Boveda )bovedas.get( 0 );
            String nombre = boveda.darNombre( );
            String nombreCliente = boveda.darNombreCliente( );
            String tipo = boveda.darTipoBoveda( );
            int cantidadGaleones = boveda.darCantidadGaleones( );
            int cantidadSicklets = boveda.darCantidadSicklets( );
            int cantidadKnuts = boveda.darCantidadKnuts( );
            int cantidadTotal = boveda.darCantidadMonedas( );
            int llave = boveda.darLlave( );

            assertEquals( "La llave de la bóveda no es correcta", 2220, llave );
            assertEquals( "El nombre de la bóveda no es correcto", "Boveda 1", nombre );
            assertEquals( "El nombre del cliente no es correcto", "Harry Potter", nombreCliente );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_TERCIARIA, tipo );
            assertEquals( "La cantidad de galeones no es correcta", 100, cantidadGaleones );
            assertEquals( "La cantidad de knuts no es correcta", 50, cantidadKnuts );
            assertEquals( "La cantidad de sicklets no es correcta", 50, cantidadSicklets );
            assertEquals( "El total de monedas no es correcta", 200, cantidadTotal );

            // BOVEDA2
            boveda = ( Boveda )bovedas.get( 1 );
            nombre = boveda.darNombre( );
            nombreCliente = boveda.darNombreCliente( );
            tipo = boveda.darTipoBoveda( );
            cantidadGaleones = boveda.darCantidadGaleones( );
            cantidadSicklets = boveda.darCantidadSicklets( );
            cantidadKnuts = boveda.darCantidadKnuts( );
            cantidadTotal = boveda.darCantidadMonedas( );
            llave = boveda.darLlave( );

            assertEquals( "La llave de la bóveda no es correcta", 2221, llave );
            assertEquals( "El nombre de la bóveda no es correcto", "Boveda 2", nombre );
            assertEquals( "El nombre del cliente no es correcto", "la bella durmiente", nombreCliente );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_TERCIARIA, tipo );
            assertEquals( "La cantidad de galeones no es correcta", 300, cantidadGaleones );
            assertEquals( "La cantidad de knuts no es correcta", 200, cantidadKnuts );
            assertEquals( "La cantidad de sicklets no es correcta", 500, cantidadSicklets );
            assertEquals( "El total de monedas no es correcta", 1000, cantidadTotal );

            // BOVEDA3
            boveda = ( Boveda )bovedas.get( 2 );
            nombre = boveda.darNombre( );
            nombreCliente = boveda.darNombreCliente( );
            tipo = boveda.darTipoBoveda( );
            cantidadGaleones = boveda.darCantidadGaleones( );
            cantidadSicklets = boveda.darCantidadSicklets( );
            cantidadKnuts = boveda.darCantidadKnuts( );
            cantidadTotal = boveda.darCantidadMonedas( );
            llave = boveda.darLlave( );

            assertEquals( "La llave de la bóveda no es correcta", 2222, llave );
            assertEquals( "El nombre de la bóveda no es correcto", "Boveda 3", nombre );
            assertEquals( "El nombre del cliente no es correcto", "Mulan", nombreCliente );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_PRIMARIA, tipo );
            assertEquals( "La cantidad de galeones no es correcta", 1000, cantidadGaleones );
            assertEquals( "La cantidad de knuts no es correcta", 1000, cantidadKnuts );
            assertEquals( "La cantidad de sicklets no es correcta", 1000, cantidadSicklets );
            assertEquals( "El total de monedas no es correcta", 3000, cantidadTotal );

            // BOVEDA4
            boveda = ( Boveda )bovedas.get( 3 );
            nombre = boveda.darNombre( );
            nombreCliente = boveda.darNombreCliente( );
            tipo = boveda.darTipoBoveda( );
            cantidadGaleones = boveda.darCantidadGaleones( );
            cantidadSicklets = boveda.darCantidadSicklets( );
            cantidadKnuts = boveda.darCantidadKnuts( );
            cantidadTotal = boveda.darCantidadMonedas( );
            llave = boveda.darLlave( );

            assertEquals( "La llave de la bóveda no es correcta", 2223, llave );
            assertEquals( "El nombre de la bóveda no es correcto", "Boveda 4", nombre );
            assertEquals( "El nombre del cliente no es correcto", "Blanca Nieves", nombreCliente );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_SECUNDARIA, tipo );
            assertEquals( "La cantidad de galeones no es correcta", 150, cantidadGaleones );
            assertEquals( "La cantidad de knuts no es correcta", 600, cantidadKnuts );
            assertEquals( "La cantidad de sicklets no es correcta", 600, cantidadSicklets );
            assertEquals( "El total de monedas no es correcta", 1350, cantidadTotal );

            // BOVEDA5
            boveda = ( Boveda )bovedas.get( 4 );
            nombre = boveda.darNombre( );
            nombreCliente = boveda.darNombreCliente( );
            tipo = boveda.darTipoBoveda( );
            cantidadGaleones = boveda.darCantidadGaleones( );
            cantidadSicklets = boveda.darCantidadSicklets( );
            cantidadKnuts = boveda.darCantidadKnuts( );
            cantidadTotal = boveda.darCantidadMonedas( );
            llave = boveda.darLlave( );

            assertEquals( "La llave de la bóveda no es correcta", 2224, llave );
            assertEquals( "El nombre de la bóveda no es correcto", "Boveda 5", nombre );
            assertEquals( "El nombre del cliente no es correcto", "Simbad", nombreCliente );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_TERCIARIA, tipo );
            assertEquals( "La cantidad de galeones no es correcta", 10, cantidadGaleones );
            assertEquals( "La cantidad de knuts no es correcta", 700, cantidadKnuts );
            assertEquals( "La cantidad de sicklets no es correcta", 25, cantidadSicklets );
            assertEquals( "El total de monedas no es correcta", 735, cantidadTotal );
        }
        catch( Exception e )
        {
            e.printStackTrace();
            fail("No se debió arrojar excepción");
        }
    }

    /**
     * Prueba 2: Verifica el método cargar bóvedas para el caso en el que el archivo no exista.
     */
    public void testCargarBovedas2( )
    {
        setupEscenario1( );
        try
        {
            bancoGnomos.cargarBovedas( "archi" );
        }
        catch( Exception e )
        {
            assertEquals( "no se debió cargar nada", 0, bancoGnomos.darBovedas( ).size( ) );
        }
    }

    /**
     * Prueba 3: Verifica el método que consulta cantidad de monedas por tipo.
     */
    public void testConsultarCantidadTipoMonedasBoveda1( )
    {
        setupEscenario2( );

        try
        {
            int cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2220, BancoGnomos.GALEON );
            assertEquals( "La cantidad de galeones no es la correcta", 100, cantidad );

            cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2223, BancoGnomos.KNUT );
            assertEquals( "La cantidad de galeones no es la correcta", 600, cantidad );

            cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2221, BancoGnomos.SICKLET );
            assertEquals( "La cantidad de galeones no es la correcta", 500, cantidad );

        }
        catch( Exception e )
        {
            fail("No se debió arrojar excepción");
        }

    }

    /**
     * Prueba 4: Verifica que el método que consulta cantidad de monedas por tipo, arroje una excepción para los casos erróneos.
     */
    public void testConsultarCantidadTipoMonedasBoveda2( )
    {
        setupEscenario2( );

        try
        {
            bancoGnomos.consultarCantidadTipoMonedasBoveda( 2225, BancoGnomos.GALEON );
            fail("No se debió retornar nada");

        }
        catch( Exception e )
        {
            try
            {
                bancoGnomos.consultarCantidadTipoMonedasBoveda( 2220, "una moneda" );
                fail("No se debió retornar nada");
            }
            catch( Exception e1 )
            {
            }
        }

    }

    /**
     * Prueba 5: Verifica el método el que consulta la cantidad total de monedas de una bóveda.
     */
    public void testConsultarCantidadTotalMonedasBoveda1( )
    {
        setupEscenario2( );

        try
        {
            int cantidad = bancoGnomos.consultarCantidadTotalMonedasBoveda( 2220 );
            assertEquals( "La cantidad total de monedas no es correcta", 200, cantidad );

            cantidad = bancoGnomos.consultarCantidadTotalMonedasBoveda( 2224 );
            assertEquals( "La cantidad total de monedas no es correcta", 735, cantidad );

            cantidad = bancoGnomos.consultarCantidadTotalMonedasBoveda( 2223 );
            assertEquals( "La cantidad total de monedas no es correcta", 1350, cantidad );

        }
        catch( Exception e )
        {
            fail("No se debió arrojar excepción");
        }
    }

    /**
     * Prueba 6: Verifica que el método para consultar la cantidad total de monedas, arroje un error cuando se consulte una <br>
     * bóveda que no exista.
     */
    public void testConsultarCantidadTotalMonedasBoveda2( )
    {
        setupEscenario1( );

        try
        {
            bancoGnomos.consultarCantidadTotalMonedasBoveda( 2220 );
            fail("No se debió retornar nada");
        }
        catch( Exception e )
        {
        }
    }

    /**
     * Prueba 7: Verifica el método que da el nombre de una bóveda.
     */
    public void testConsultarNombreBoveda1( )
    {
        setupEscenario2( );
        try
        {
            String nombre = bancoGnomos.consultarNombreBoveda( 2220 );
            assertEquals( "El nombre de la bóveda no es correcta", "Boveda 1", nombre );

            nombre = bancoGnomos.consultarNombreBoveda( 2221 );
            assertEquals( "El nombre de la bóveda no es correcta", "Boveda 2", nombre );

            nombre = bancoGnomos.consultarNombreBoveda( 2222 );
            assertEquals( "El nombre de la bóveda no es correcta", "Boveda 3", nombre );

        }
        catch( Exception e )
        {
            fail("No se debió arrojar excepción");
        }

    }

    /**
     * Prueba 8: Verifica que el método que da el nombre de una bóveda, arroje excepción cuando se consulte una bóveda que no exista.
     */
    public void testConsultarNombreBoveda2( )
    {
        setupEscenario2( );
        try
        {
            bancoGnomos.consultarNombreBoveda( 2228 );
            fail("No se debió retornar nada");

        }
        catch( Exception e )
        {
        }

    }

    /**
     * Prueba 9: Verifica el método que da el nombre del cliente de una bóveda.
     */
    public void testConsultarNombreClienteBoveda1( )
    {
        setupEscenario2( );
        try
        {
            String nombre = bancoGnomos.consultarNombreClienteBoveda( 2220 );
            assertEquals( "El nombre del cliente de la bóveda no es correcto", "Harry Potter", nombre );

            nombre = bancoGnomos.consultarNombreClienteBoveda( 2221 );
            assertEquals( "El nombre del cliente de la bóveda no es correcto", "la bella durmiente", nombre );

            nombre = bancoGnomos.consultarNombreClienteBoveda( 2224 );
            assertEquals( "El nombre del cliente de la bóveda no es correcto", "Simbad", nombre );

        }
        catch( Exception e )
        {
            fail("No se debió arrojar excepción");
        }

    }

    /**
     * Prueba 10: Verifica que el método que da el nombre del cliente de una bóveda, arroje excepción cuando se consulte una bóveda que no exista.
     */
    public void testConsultarNombreClienteBoveda2( )
    {
        setupEscenario2( );
        try
        {
            bancoGnomos.consultarNombreClienteBoveda( 2228 );
            fail("No se debió retornar nada");

        }
        catch( Exception e )
        {
        }

    }

    /**
     * Prueba 11: Verifica el método que da el tipo de una bóveda.
     */
    public void testConsultarTipoBoveda1( )
    {
        setupEscenario2( );
        try
        {
            String tipo = bancoGnomos.consultarTipoBoveda( 2220 );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_TERCIARIA, tipo );

            tipo = bancoGnomos.consultarTipoBoveda( 2221 );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_TERCIARIA, tipo );

            tipo = bancoGnomos.consultarTipoBoveda( 2222 );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_PRIMARIA, tipo );

            tipo = bancoGnomos.consultarTipoBoveda( 2223 );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_SECUNDARIA, tipo );

            tipo = bancoGnomos.consultarTipoBoveda( 2224 );
            assertEquals( "El tipo de la bóveda no es correcto", Boveda.TIPO_BOVEDA_TERCIARIA, tipo );

        }
        catch( Exception e )
        {
            fail("No se debió arrojar excepción");
        }

    }

    /**
     * Prueba 12: Verifica que el método que da el tipo de una bóveda, retorne una excepción cuando se pide el tipo de una bóveda inexistente.
     */
    public void testConsultarTipoBoveda2( )
    {
        setupEscenario1( );
        try
        {
            bancoGnomos.consultarTipoBoveda( 2226 );
            fail("No se debió retornar nada");

        }
        catch( Exception e )
        {
        }

    }

    /**
     * Prueba 13: Verifica el método para depositar monedas en una bóveda.
     */
    public void testDepositarMonedasBoveda1( )
    {
        setupEscenario2( );

        try
        {
            bancoGnomos.depositarMonedasBoveda( 2224, 200, BancoGnomos.GALEON );
            int cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2224, BancoGnomos.GALEON );

            assertEquals( "El depósito no se efectúo de forma correcta", 210, cantidad );

            bancoGnomos.depositarMonedasBoveda( 2223, 100, BancoGnomos.KNUT );
            cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2223, BancoGnomos.KNUT );

            assertEquals( "El depósito no se efectúo de forma correcta", 700, cantidad );

            bancoGnomos.depositarMonedasBoveda( 2222, 500, BancoGnomos.SICKLET );
            cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2222, BancoGnomos.SICKLET );

            assertEquals( "El depósito no se efectúo de forma correcta", 1500, cantidad );

            bancoGnomos.depositarMonedasBoveda( 2220, 800, BancoGnomos.SICKLET );
            cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2220, BancoGnomos.SICKLET );

            assertEquals( "El depósito no se efectúo de forma correcta", 850, cantidad );

            bancoGnomos.depositarMonedasBoveda( 2223, 550, BancoGnomos.GALEON );
            cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2223, BancoGnomos.GALEON );

            assertEquals( "El depósito no se efectúo de forma correcta", 700, cantidad );

        }
        catch( Exception e )
        {
            fail("No se debería arrojar esta excepción");
        }
    }

    /**
     * Prueba 14: Verifica que el método que deposita monedas en una bóveda, arroje excepción por las restricciones<br>
     * del tipo bóveda.
     */
    public void testDepositarMonedasBoveda2( )
    {
        setupEscenario2( );

        try
        {
            bancoGnomos.depositarMonedasBoveda( 2224, 500, BancoGnomos.GALEON );
            fail("No se debió depositar nada");
        }
        catch( Exception e )
        {
            try
            {
                bancoGnomos.depositarMonedasBoveda( 2223, 1000, BancoGnomos.KNUT );
                fail("No se debió depositar nada");
            }
            catch( Exception e1 )
            {
            }

        }
    }

    /**
     * Prueba 15: Verifica el método para retirar monedas en una bóveda.
     */
    public void testRetirarMonedasBoveda1( )
    {
        setupEscenario2( );

        try
        {
            bancoGnomos.retirarMonedasBoveda( 2224, 10, BancoGnomos.GALEON );
            int cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2224, BancoGnomos.GALEON );

            assertEquals( "El retiro no se efectúo de forma correcta", 0, cantidad );

            bancoGnomos.retirarMonedasBoveda( 2223, 500, BancoGnomos.KNUT );
            cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2223, BancoGnomos.KNUT );

            assertEquals( "El retiro no se efectúo de forma correcta", 100, cantidad );

            bancoGnomos.retirarMonedasBoveda( 2222, 500, BancoGnomos.SICKLET );
            cantidad = bancoGnomos.consultarCantidadTipoMonedasBoveda( 2222, BancoGnomos.SICKLET );

            assertEquals( "El retiro no se efectúo de forma correcta", 500, cantidad );

        }
        catch( Exception e )
        {
            fail("No se debió arrojar esta excepción");
        }
    }

    /**
     * Prueba 16: Verifica que el método para retirar monedas de una bóveda, arroje una excepción cuando se trata de retirar más <br>
     * monedas de las existentes o no se cumple la restricción de acuerdo al tipo de bóveda.
     */
    public void testRetirarMonedasBoveda2( )
    {
        setupEscenario2( );

        try
        {
            bancoGnomos.retirarMonedasBoveda( 2224, 20, BancoGnomos.GALEON );
            fail("No se debió retirar nada");

        }
        catch( Exception e )
        {
            try
            {
                bancoGnomos.retirarMonedasBoveda( 2222, 2000, BancoGnomos.KNUT );
                fail("No se debió retirar nada");
            }
            catch( Exception e1 )
            {
                try
                {
                    bancoGnomos.retirarMonedasBoveda( 2220, 100, BancoGnomos.SICKLET );
                    fail("No se debió retirar nada");
                }
                catch( Exception e2 )
                {
                    try
                    {
                        bancoGnomos.retirarMonedasBoveda( 2224, 700, BancoGnomos.KNUT );
                        fail("No se debió retirar nada");
                    }
                    catch( Exception e3 )
                    {
                        try
                        {
                            bancoGnomos.retirarMonedasBoveda( 2223, 600, BancoGnomos.KNUT );
                            bancoGnomos.retirarMonedasBoveda( 2223, 600, BancoGnomos.SICKLET );
                            bancoGnomos.retirarMonedasBoveda( 2223, 110, BancoGnomos.GALEON );
                            fail("No se debió retirar nada");

                        }
                        catch( Exception e4 )
                        {
                        }

                    }

                }
            }
        }
    }

    /**
     * Prueba 17: Verifica el método para realizar conversión de monedas.
     */
    public void testRealizarConversion1( )
    {
        setupEscenario1( );

        try
        {
            // Conversión galeones a galeones
            double conversion = bancoGnomos.realizarConversion( 100, BancoGnomos.GALEON, BancoGnomos.GALEON );
            assertEquals( "La conversión no se efectúo de forma correcta", 100.0, conversion, 0.01 );

            // Conversión galeones a sicklets
            conversion = bancoGnomos.realizarConversion( 1000, BancoGnomos.GALEON, BancoGnomos.SICKLET );
            assertEquals( "La conversión no se efectúo de forma correcta", 14000.0, conversion, 0.01 );

            // Conversión galeones a knuts
            conversion = bancoGnomos.realizarConversion( 2000, BancoGnomos.GALEON, BancoGnomos.KNUT );
            assertEquals( "La conversión no se efectúo de forma correcta", 980000.0, conversion, 0.01 );

            // Conversión sicklets a sicklets
            conversion = bancoGnomos.realizarConversion( 250, BancoGnomos.SICKLET, BancoGnomos.SICKLET );
            assertEquals( "La conversión no se efectúo de forma correcta", 250.0, conversion, 0.01 );

            // Conversión sicklets a galeones
            conversion = bancoGnomos.realizarConversion( 14, BancoGnomos.SICKLET, BancoGnomos.GALEON );
            assertEquals( "La conversión no se efectúo de forma correcta", 1.0, conversion, 0.01 );

            conversion = bancoGnomos.realizarConversion( 100, BancoGnomos.SICKLET, BancoGnomos.GALEON );
            assertEquals( "La conversión no se efectúo de forma correcta", 7, new Double( conversion ).intValue( ) );

            // Conversión sicklets a knuts
            conversion = bancoGnomos.realizarConversion( 500, BancoGnomos.SICKLET, BancoGnomos.KNUT );
            assertEquals( "La conversión no se efectúo de forma correcta", 17500.0, conversion, 0.01 );

            // Conversión knuts a knuts
            conversion = bancoGnomos.realizarConversion( 15720, BancoGnomos.KNUT, BancoGnomos.KNUT );
            assertEquals( "La conversión no se efectúo de forma correcta", 15720.0, conversion, 0.01 );

            // Conversión knuts a sicklets
            conversion = bancoGnomos.realizarConversion( 35, BancoGnomos.KNUT, BancoGnomos.SICKLET );
            assertEquals( "La conversión no se efectúo de forma correcta", 1.0, conversion, 0.01 );

            conversion = bancoGnomos.realizarConversion( 350, BancoGnomos.KNUT, BancoGnomos.SICKLET );
            assertEquals( "La conversión no se efectúo de forma correcta", 10, new Double( conversion ).intValue( ) );

            // Conversión knuts a galeones
            conversion = bancoGnomos.realizarConversion( 490, BancoGnomos.KNUT, BancoGnomos.GALEON );
            assertEquals( "La conversión no se efectúo de forma correcta", 1.0, conversion, 0.00 );

            conversion = bancoGnomos.realizarConversion( 5000, BancoGnomos.KNUT, BancoGnomos.GALEON );
            assertEquals( "La conversión no se efectúo de forma correcta", 10.2, conversion, 0.01 );

        }
        catch( Exception e )
        {
            fail("No se debió arrojar excepción");
        }
    }

    /**
     * Prueba 18: Verifica que el método para realizar conversión de monedas arroje una excepción cuando se introduzca <br>
     * un tipo de moneda inexistente.
     */
    public void testRealizarConversion2( )
    {
        setupEscenario2( );
        try
        {
            bancoGnomos.realizarConversion( 1000, "origen", BancoGnomos.KNUT );
            fail("No se debió realizar la conversión");
        }
        catch( Exception e )
        {
            try
            {
                bancoGnomos.realizarConversion( 1000, BancoGnomos.KNUT, "destino" );
                fail("No se debió realizar la conversión");
            }
            catch( Exception e1 )
            {
                try
                {
                    bancoGnomos.realizarConversion( -1000, BancoGnomos.KNUT, BancoGnomos.GALEON );
                    fail("No se debió realizar la conversión");
                }
                catch( Exception e2 )
                {
                }
            }
        }

    }

}