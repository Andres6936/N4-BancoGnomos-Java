package edu.jabs.bancoGnomos.test;

import junit.framework.TestCase;

import edu.jabs.bancoGnomos.mundo.BancoGnomos;
import edu.jabs.bancoGnomos.mundo.Boveda;

/**
 * Clase usada para verificar que los métodos de la clase Boveda estén correctamente implementados.
 */
public class BovedaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * bóveda de prueba.
     */
    private Boveda boveda;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una nueva bóveda con 20 sicklets, 20 knuts y 20 galeones de tipo primaria.
     */
    private void setupEscenario1( )
    {
        try
        {
            boveda= new Boveda(1,"clientePrueba","boveda1",20,20,20,Boveda.TIPO_BOVEDA_PRIMARIA);
        }
        catch( Exception e )
        {
            fail("No se debió arrojar esta excepción");
        }
    }

    /**
     * Escenario 2: Construye una nueva bóveda incumpliendo la restricción de la cantidad mínina de monedas del tipo de bóveda secundaria.
     */
    private void setupEscenario2( ) throws Exception
    {

        boveda= new Boveda(2,"clientePrueba2","boveda2",5,10,20,Boveda.TIPO_BOVEDA_SECUNDARIA);

    }

    /**
     * Escenario 3: Construye una nueva bóveda incumpliendo la restricción de la cantidad máxima de monedas del tipo de bóveda secundaria.
     */
    private void setupEscenario3( ) throws Exception
    {

        boveda= new Boveda(3,"clientePrueba3","boveda3",1000,1000,1000,Boveda.TIPO_BOVEDA_SECUNDARIA);

    }


    /**
     * Escenario 4: Construye una nueva bóveda incumpliendo la restricción de la cantidad mínina de monedas del tipo de bóveda terciaria.
     */
    private void setupEscenario4( ) throws Exception
    {

        boveda= new Boveda(4,"clientePrueba4","boveda4",20,55,20,Boveda.TIPO_BOVEDA_TERCIARIA);

    }

    /**
     * Escenario 5: Construye una nueva bóveda incumpliendo la restricción de la cantidad máxima de monedas del tipo de bóveda terciaria.
     */
    private void setupEscenario5( ) throws Exception
    {

        boveda= new Boveda(5,"clientePrueba5","boveda5",401, 300, 300,Boveda.TIPO_BOVEDA_TERCIARIA);

    }

    /**
     * Escenario 6: Construye una nueva bóveda con un tipo de bóveda que no exista.
     */
    private void setupEscenario6( ) throws Exception
    {

        boveda= new Boveda(6,"clientePrueba6","boveda6",100, 100, 100, "El tipo");

    }

    /**
     * Escenario 7: Construye una nueva bóveda con 0 sicklets, 1970 knuts y 30 galeones de tipo secundaria.
     */
    private void setupEscenario7( )
    {

        try
        {
            boveda= new Boveda(7,"clientePrueba7","boveda7",30, 0, 1970, Boveda.TIPO_BOVEDA_SECUNDARIA);
        }
        catch( Exception e )
        {
            fail("No se debió arrojar esta excepción");
        }

    }

    /**
     * Escenario 8: Construye una nueva bóveda con 980 sicklets, 20 knuts y 0 galeones de tipo terciaria.
     */
    private void setupEscenario8( )
    {

        try
        {
            boveda= new Boveda(8,"clientePrueba8","boveda8",0, 980, 20, Boveda.TIPO_BOVEDA_TERCIARIA);
        }
        catch( Exception e )
        {
            fail("No se debió arrojar esta excepción");
        }

    }

    /**
     * Prueba 1: Verifica que la bóveda se haya creado correctamente.
     */
    public void testBoveda1()
    {
        setupEscenario1();

        assertEquals("La bóveda no se creo correctamente", 1, boveda.darLlave());

        assertEquals("La bóveda no se creo correctamente", "clientePrueba", boveda.darNombreCliente());

        assertEquals("La bóveda no se creo correctamente", 20, boveda.darCantidadGaleones());

        assertEquals("La bóveda no se creo correctamente", 20, boveda.darCantidadKnuts());

        assertEquals("La bóveda no se creo correctamente", 20, boveda.darCantidadSicklets());

        assertEquals("La bóveda no se creo correctamente", Boveda.TIPO_BOVEDA_PRIMARIA, boveda.darTipoBoveda());
    }

    /**
     * Prueba 2: Verifica que el constructor arroje error cuando no se cumpla la restricción sobre la cantidad mínima
     * de monedas de una bóveda de tipo secundario.
     */
    public void testBoveda2()
    {
        try
        {
            setupEscenario2();
            fail("No se debió crear la bóveda");
        }
        catch( Exception e )
        {
        }
    }

    /**
     * Prueba 3: Verifica que el constructor arroje error cuando no se cumpla la restricción sobre la cantidad máxima
     * de monedas de una bóveda de tipo secundario.
     */
    public void testBoveda3()
    {
        try
        {
            setupEscenario3();
            fail("No se debió crear la bóveda");
        }
        catch( Exception e )
        {
        }
    }

    /**
     * Prueba 4: Verifica que el constructor arroje error cuando no se cumpla la restricción sobre la cantidad mínima
     * de monedas de una bóveda de tipo terciario.
     */
    public void testBoveda4()
    {
        try
        {
            setupEscenario4();
            fail("No se debió crear la bóveda");
        }
        catch( Exception e )
        {
        }
    }

    /**
     * Prueba 5: Verifica que el constructor arroje error cuando no se cumpla la restricción sobre la cantidad máxima
     * de monedas de una bóveda de tipo terciario.
     */
    public void testBoveda5()
    {
        try
        {
            setupEscenario5();
            fail("No se debió crear la bóveda");
        }
        catch( Exception e )
        {
        }
    }

    /**
     * Prueba 6: Verifica que el constructor arroje error cuando se cree una bóveda con un tipo que no exista.
     */
    public void testBoveda6()
    {
        try
        {
            setupEscenario6();
            fail("No se debió crear la bóveda");
        }
        catch( Exception e )
        {
        }
    }

    /**
     * Prueba 7: Verifica que el método que cambia la llave de la bóveda.
     */
    public void testCambiarLlave()
    {
        setupEscenario1();

        int nLlave= 1000;
        boveda.cambiarLlave(nLlave);

        assertEquals("La llave no se cambió de forma correcta", nLlave, boveda.darLlave());
    }

    /**
     * Prueba 8: Verifica que el método cambia el nombre del cliente de la bóveda.
     */
    public void testCambiarNombreCliente()
    {
        setupEscenario1();

        String nCliente= "Cliente de prueba";
        boveda.cambiarNombreCliente(nCliente);

        assertEquals("El nombre no se cambió de forma correcta", nCliente, boveda.darNombreCliente());
    }

    /**
     * Prueba 9: Verifica que el método cambia el nombre de la bóveda.
     */
    public void testCambiarNombre()
    {
        setupEscenario1();

        String nBoveda= "Nombre boveda";
        boveda.cambiarNombre(nBoveda);

        assertEquals("El nombre no se cambió de forma correcta", nBoveda, boveda.darNombre());
    }

    /**
     * Prueba 10: Verifica que el método que da la cantidad de monedas total retorne dicho valor de forma correcta.
     */
    public void testDarCantidadMonedas()
    {
        setupEscenario1();

        int cantidad= boveda.darCantidadMonedas();
        int cantidadEsperada= boveda.darCantidadGaleones()+ boveda.darCantidadKnuts()+ boveda.darCantidadSicklets();

        assertEquals("La cantidad de monedas no se retornó de forma correcta", cantidadEsperada, cantidad);
    }

    /**
     * Prueba 11: Verifica que el método para depositar monedas funcione de forma correcta.
     */
    public void testDepositarMonedas1()
    {
        setupEscenario1();

        int cantidadDeposito= 100;
        int galeones= boveda.darCantidadGaleones();
        int knuts= boveda.darCantidadKnuts();
        int sicklets= boveda.darCantidadSicklets();
        int total= boveda.darCantidadMonedas();

        try
        {
            boveda.depositarMonedas(cantidadDeposito, BancoGnomos.GALEON);
            boveda.depositarMonedas(cantidadDeposito, BancoGnomos.KNUT);
            boveda.depositarMonedas(cantidadDeposito, BancoGnomos.SICKLET);

            assertEquals("El número de galeones no es correcto",galeones+cantidadDeposito, boveda.darCantidadGaleones());

            assertEquals("El número de knuts no es correcto",knuts+cantidadDeposito, boveda.darCantidadKnuts());

            assertEquals("El número de sicklets no es correcto",sicklets+cantidadDeposito, boveda.darCantidadSicklets());

            assertEquals("El número total de monedas no es correcto",total+(cantidadDeposito*3), boveda.darCantidadMonedas());
        }
        catch( Exception e )
        {
            fail("No se debió arrojar excepción");
        }
    }

    /**
     * Prueba 12: Verifica que el método para depositar monedas arroje excepción cuando no se cumpla la restricción de cantidad
     * máxima de monedas para bóvedas de tipo secundario.
     */
    public void testDepositarMonedas2()
    {
        setupEscenario7();

        int cantidadDeposito= 2000;
        int galeones= boveda.darCantidadGaleones();
        int knuts= boveda.darCantidadKnuts();
        int sicklets= boveda.darCantidadSicklets();
        int total= boveda.darCantidadMonedas();

        try
        {
            boveda.depositarMonedas(cantidadDeposito, BancoGnomos.GALEON);
            fail("No se debió realizar el depósito");
        }
        catch( Exception e )
        {
            assertEquals("El número de galeones no es correcto",galeones, boveda.darCantidadGaleones());

            assertEquals("El número de knuts no es correcto",knuts, boveda.darCantidadKnuts());

            assertEquals("El número de sicklets no es correcto",sicklets, boveda.darCantidadSicklets());

            assertEquals("El número total de monedas no es correcto",total, boveda.darCantidadMonedas());
        }
    }

    /**
     * Prueba 13: Verifica que el método para depositar monedas arroje excepción cuando no se cumpla la restricción de cantidad
     * máxima de monedas para bóvedas de tipo terciario
     */
    public void testDepositarMonedas3()
    {
        setupEscenario8();

        int cantidadDeposito= 1500;
        int galeones= boveda.darCantidadGaleones();
        int knuts= boveda.darCantidadKnuts();
        int sicklets= boveda.darCantidadSicklets();
        int total= boveda.darCantidadMonedas();

        try
        {
            boveda.depositarMonedas(cantidadDeposito, BancoGnomos.KNUT);
            fail("No se debió realizar el depósito");
        }
        catch( Exception e )
        {
            assertEquals("El número de galeones no es correcto",galeones, boveda.darCantidadGaleones());

            assertEquals("El número de knuts no es correcto",knuts, boveda.darCantidadKnuts());

            assertEquals("El número de sicklets no es correcto",sicklets, boveda.darCantidadSicklets());

            assertEquals("El número total de monedas no es correcto",total, boveda.darCantidadMonedas());
        }
    }

    /**
     * Prueba 14: Verifica que el método para retirar monedas funcione de forma correcta.
     */
    public void testRetirarMonedas1()
    {
        setupEscenario1();

        int cantidadRetiro= 10;
        int galeones= boveda.darCantidadGaleones();
        int knuts= boveda.darCantidadKnuts();
        int sicklets= boveda.darCantidadSicklets();
        int total= boveda.darCantidadMonedas();

        try
        {
            boveda.retirarMonedas(cantidadRetiro, BancoGnomos.GALEON);
            boveda.retirarMonedas(cantidadRetiro, BancoGnomos.KNUT);
            boveda.retirarMonedas(cantidadRetiro, BancoGnomos.SICKLET);

            assertEquals("El número de galeones no es correcto",galeones-cantidadRetiro, boveda.darCantidadGaleones());

            assertEquals("El número de knuts no es correcto",knuts-cantidadRetiro, boveda.darCantidadKnuts());

            assertEquals("El número de sicklets no es correcto",sicklets-cantidadRetiro, boveda.darCantidadSicklets());

            assertEquals("El número total de monedas no es correcto",total-(cantidadRetiro*3), boveda.darCantidadMonedas());
        }
        catch( Exception e )
        {
            fail("No se debió arrojar excepción");
        }
    }

    /**
     * Prueba 15: Verifica que el método para retirar monedas arroje excepción cuando se intente retirar más monedas de las que hay disponibles.
     */
    public void testRetirarMonedas2()
    {
        setupEscenario1();

        int cantidadRetiro= 100;
        int galeones= boveda.darCantidadGaleones();
        int knuts= boveda.darCantidadKnuts();
        int sicklets= boveda.darCantidadSicklets();
        int total= boveda.darCantidadMonedas();

        try
        {
            boveda.retirarMonedas(cantidadRetiro, BancoGnomos.SICKLET);
            fail("No se debió realizar el retiro");
        }
        catch( Exception e )
        {
            assertEquals("El número de galeones no es correcto",galeones, boveda.darCantidadGaleones());

            assertEquals("El número de knuts no es correcto",knuts, boveda.darCantidadKnuts());

            assertEquals("El número de sicklets no es correcto",sicklets, boveda.darCantidadSicklets());

            assertEquals("El número total de monedas no es correcto",total, boveda.darCantidadMonedas());
        }
    }

    /**
     * Prueba 16: Verifica que el método para retirar monedas arroje excepción cuando al retirar monedas no se cumpla la restricción de
     * cantidad mínima de monedas de la bóveda de tipo secundario.
     */
    public void testRetirarMonedas3()
    {
        setupEscenario7();

        int cantidadRetiro= 1970;
        int galeones= boveda.darCantidadGaleones();
        int knuts= boveda.darCantidadKnuts();
        int sicklets= boveda.darCantidadSicklets();
        int total= boveda.darCantidadMonedas();

        try
        {
            boveda.retirarMonedas(cantidadRetiro, BancoGnomos.KNUT);
            fail("No se debió realizar el retiro");
        }
        catch( Exception e )
        {
            assertEquals("El número de galeones no es correcto",galeones, boveda.darCantidadGaleones());

            assertEquals("El número de knuts no es correcto",knuts, boveda.darCantidadKnuts());

            assertEquals("El número de sicklets no es correcto",sicklets, boveda.darCantidadSicklets());

            assertEquals("El número total de monedas no es correcto",total, boveda.darCantidadMonedas());
        }
    }

    /**
     * Prueba 17: Verifica que el método para retirar monedas arroje excepción cuando al retirar monedas no se cumpla la restricción de
     * cantidad mínima de monedas de la bóveda de tipo terciario.
     */
    public void testRetirarMonedas4()
    {
        setupEscenario8();

        int cantidadRetiro= 980;
        int galeones= boveda.darCantidadGaleones();
        int knuts= boveda.darCantidadKnuts();
        int sicklets= boveda.darCantidadSicklets();
        int total= boveda.darCantidadMonedas();

        try
        {
            boveda.retirarMonedas(cantidadRetiro, BancoGnomos.SICKLET);
            fail("No se debió realizar el retiro");
        }
        catch( Exception e )
        {
            assertEquals("El número de galeones no es correcto",galeones, boveda.darCantidadGaleones());

            assertEquals("El número de knuts no es correcto",knuts, boveda.darCantidadKnuts());

            assertEquals("El número de sicklets no es correcto",sicklets, boveda.darCantidadSicklets());

            assertEquals("El número total de monedas no es correcto",total, boveda.darCantidadMonedas());
        }
    }

}