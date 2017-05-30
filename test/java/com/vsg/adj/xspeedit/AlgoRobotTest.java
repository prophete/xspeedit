package com.vsg.adj.xspeedit;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by adjengue on 30/05/2017
 */
public class AlgoRobotTest {
    private static final String emptyStr = "";
    private static final String wrongStr = "aa163841689525773";
    private static final String in = "163841689525773";
    private static final String reverse_in = "377525986148361";
    private static final String in2 = "123456789123456789";
    private static final String in3 = "12345678912300000456789";
    private static final String nullStr = null;

    @Test
    public void shouldThrowIllegalArgumentException1() {
        AlgoRobot algo = new AlgoRobot();
        boolean thrown = false;

        try {
            algo.convertToInteger(emptyStr);
        } catch (IllegalArgumentException iae) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void shouldThrowIllegalArgumentException2() {
        AlgoRobot algo = new AlgoRobot();
        boolean thrown = false;

        try {
            algo.convertToInteger(wrongStr);
        } catch (IllegalArgumentException iae) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void shouldConvertToTabInt() {

        Integer[] intArray = {1, 6, 3, 8, 4, 1, 6, 8, 9, 5, 2, 5, 7, 7, 3};
        Collection<Integer> expected = Arrays.asList(intArray);

        AlgoRobot algo = new AlgoRobot();
        Collection<Integer> articles = algo.convertToInteger(in);

        assert articles != null;
        assert articles .equals( expected );
    }


    @Test
    public void emballerColis() {
        AlgoRobot algo = new AlgoRobot();

        List<Integer> articles = algo.convertToInteger(in);

        Collection<Colis> listColis = algo.emballerColis(articles);

        assert articles != null;
        assert listColis != null;
        assert listColis.size() == 8;

        System.out.println(algo.printColis(listColis) + " => " + listColis.size() + " cartons" );


            /*
        Articles      : 163841689525773
        Robot actuel  : 163/8/41/6/8/9/52/5/7/73 => 10 cartons utilisés
        Robot optimisé: 163/82/46/19/8/55/73/7   => 8  cartons utilisés
     */
    }

}
