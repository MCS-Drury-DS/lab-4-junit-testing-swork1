package cs.csmath.complexnumber;

public class ComplexNumber {

    public double getImagPart() {
        return imagPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public void setImagPart(double imagPart) {
        this.imagPart = imagPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    private double imagPart;
    private double realPart;

    public void add(ComplexNumber otherCN) {
        double newRealPart = this.getRealPart() + otherCN.getRealPart();
        double newImagPart = this.getImagPart() + otherCN.getImagPart();
        this.setRealPart(newRealPart);
        this.setImagPart(newImagPart);
    }

    public void sub(ComplexNumber otherCN) {
        double newRealPart = this.getRealPart() - otherCN.getRealPart();
        double newImagPart = this.getImagPart() - otherCN.getImagPart();
        this.setRealPart(newRealPart);
        this.setImagPart(newImagPart);
    }

    public void mult(ComplexNumber otherCN) {
        double newRealPart = this.getRealPart() * otherCN.getRealPart()
                - this.getImagPart() * otherCN.getImagPart();
        double newImagPart = this.getImagPart() * otherCN.getRealPart()
                + this.getRealPart() * otherCN.getImagPart();
        this.setRealPart(newRealPart);
        this.setImagPart((newImagPart));
    }

    public void div(ComplexNumber otherCN) throws ArithmeticException {
        double newRealPart = ((this.getRealPart() * otherCN.getRealPart() + this.getImagPart() * otherCN.getImagPart()) / (otherCN.getRealPart()*otherCN.getRealPart() + otherCN.getImagPart()*otherCN.getImagPart()));
        double newImagPart = ((this.getImagPart()*otherCN.getRealPart() - this.getRealPart()*otherCN.getImagPart()) / (otherCN.getRealPart()*otherCN.getRealPart() + otherCN.getImagPart()*otherCN.getImagPart()));
        this.setRealPart(newRealPart);
        this.setImagPart(newImagPart);

        double denominator = otherCN.getRealPart()*otherCN.getRealPart() + otherCN.getImagPart()*otherCN.getImagPart();
        if (java.lang.Math.abs(denominator)<0.000001)
        {
            throw new ArithmeticException();
        }
    }

    public ComplexNumber conj() {
        double newImagePart = -this.getImagPart();
        double newRealPart = this.getRealPart();
        this.setRealPart(newRealPart);
        this.setImagPart(newImagePart);
        return this;
    }

    public double abs() {
        double test = this.getRealPart()*this.getRealPart() + this.getImagPart()*this.getImagPart();
        test = java.lang.Math.sqrt(test);
        return test;
    }

    public ComplexNumber() {
        super();
    }

    public ComplexNumber(double realPart, double imagPart) {
        this.realPart = realPart;
        this.imagPart = imagPart;
    }
    /***
    public ComplexNumber(ComplexNumber CN)
    {
        this.realPart = CN.getRealPart();
        this.imagPart = CN.getImagPart();
    }
     ***/


    public static ComplexNumber add(ComplexNumber firstCN, ComplexNumber secondCN)
    {
        ComplexNumber cn1 = firstCN;
        ComplexNumber cn2 = secondCN;
        cn1.add(cn2);
        return cn1;
    }

    public static void main(String[] args) {
        ComplexNumber cn1 = new ComplexNumber();
        ComplexNumber cn2 = new ComplexNumber();
        cn1.mult(cn2);
    }

}