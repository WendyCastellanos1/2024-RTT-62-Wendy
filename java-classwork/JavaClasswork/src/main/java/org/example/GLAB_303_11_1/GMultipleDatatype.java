package org.example.GLAB_303_11_1;

public class GMultipleDatatype <DatatypeOne, DatatypeTwo> {

    //fields
    DatatypeOne valueOne;
    DatatypeTwo valueTwo;

    //constructor(s)
    public GMultipleDatatype(DatatypeOne v1, DatatypeTwo v2)
    {
        this.valueOne = v1;
        this.valueTwo = v2;
    }

    //getters and setters
    public DatatypeOne getValueOne() {
        return valueOne;
    }

    public void setValueOne(DatatypeOne valueOne) {
        this.valueOne = valueOne;
    }

    public DatatypeTwo getValueTwo() {
        return valueTwo;
    }

    public void setValueTwo(DatatypeTwo valueTwo) {
        this.valueTwo = valueTwo;
    }
}

