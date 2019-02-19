package cs.csmath.complexnumber;

import org.junit.Test;
import sun.security.x509.DeltaCRLIndicatorExtension;

import java.util.concurrent.Delayed;

import static org.junit.Assert.*;

public class ComplexNumberTest {
    static final double DELTA = 0.00001;

    @Test
    public void getImagPart() {
        ComplexNumber cn = new ComplexNumber(1.0,1.0);
        double imagPart = cn.getImagPart();
        assertEquals(1.0,imagPart,0.00001);
    }

    @Test
    public void getRealPart() {
        ComplexNumber cn = new ComplexNumber(1.0,1.0);
        double realPart = cn.getRealPart();
        assertEquals(1.0,realPart, DELTA);
    }

    @Test
    public void setImagPart() {
        ComplexNumber cn = new ComplexNumber();
        cn.setImagPart(2.0);
        assertEquals(2.0,cn.getImagPart(), DELTA);
    }

    @Test
    public void setRealPart() {
        ComplexNumber cn = new ComplexNumber();
        cn.setRealPart(4.0);
        assertEquals(4.0,cn.getRealPart(),DELTA);
    }

    @Test
    public void add() {
        ComplexNumber cn1 = new ComplexNumber(4.5,3.0);
        ComplexNumber cn2 = new ComplexNumber(6.0,4.0);
        cn1.add(cn2);
        assertEquals(10.5+7.0, cn1.getRealPart() + cn1.getImagPart(), DELTA);
    }

    @Test
    public void sub() {
        ComplexNumber cn1 = new ComplexNumber(4.0,2.0);
        ComplexNumber cn2 = new ComplexNumber(3.0,7.0);
        cn1.sub(cn2);
        assertEquals((4.0-3.0) + (2.0-7.0), cn1.getRealPart() + cn1.getImagPart(), DELTA);
    }

    @Test
    public void mult() {

        ComplexNumber cn1 = new ComplexNumber(4.5,3.0);
        ComplexNumber cn2 = new ComplexNumber(6.0,4.0);
        cn1.mult(cn2);
        assertEquals((4.5*6.0-3.0*4.0) + (3.0*6.0+4.5*4.0),cn1.getRealPart() + cn1.getImagPart(),DELTA);

        ComplexNumber cn3 = new ComplexNumber(0.0,4.0);
        ComplexNumber cn4 = new ComplexNumber(3.0,0.0);
        cn3.mult(cn4);
        assertEquals((0.0*3.0-4.0*0.0) + (4.0*3.0+0.0*0.0),cn3.getRealPart() + cn3.getImagPart(),DELTA);
    }

    @Test
    public void div() {
        ComplexNumber cn1 = new ComplexNumber(4.0,4.0);
        ComplexNumber cn2 = new ComplexNumber(2.0,6.0);
        cn1.div(cn2);
        assertEquals(((4.0*2.0+4.0*6.0)/(2.0*2.0+6.0*6.0)) + ((4.0*2.0-4.0*6.0)/(2.0*2.0+6.0*6.0)),cn1.getRealPart()+cn1.getImagPart(), DELTA);
    }

    @Test
    public void conj() {
        ComplexNumber cn1 = new ComplexNumber(1.0,-5.0);
        cn1.conj();
        assertEquals(1.0+5.0,cn1.getRealPart()+cn1.getImagPart(),DELTA);
    }

    @Test
    public void abs() {
        ComplexNumber cn1 = new ComplexNumber(3.0,5.0);
        assertEquals(java.lang.Math.sqrt(3*3+5*5) ,cn1.abs(),DELTA);

    }

    @Test
    public void add1()
    {
        ComplexNumber cn1 = new ComplexNumber(4.5,3.0);
        ComplexNumber cn2 = new ComplexNumber(6.0,4.0);
        ComplexNumber result = ComplexNumber.add(cn1,cn2);
        assertEquals(10.5,result.getRealPart(),DELTA);
        assertEquals(7.0,result.getImagPart(),DELTA);
    }

    @Test
    public void divideByZero()
    {
        ComplexNumber cn1 = new ComplexNumber(4.5,3.0);
        ComplexNumber cn2 = new ComplexNumber(0.0,0.0);
        try {
            cn1.div(cn2);
            fail();
        }
        catch (ArithmeticException e)
        {
        e.printStackTrace();
        }

    }
}



