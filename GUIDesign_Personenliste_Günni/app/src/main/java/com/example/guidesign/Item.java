package com.example.guidesign;

public class Item {
    String mName;
    String mVorname;
    Interesse mInteresse;
    Geschlecht mGeschlecht;

    public Item(String mName, String mVorname, Interesse mInteresse, Geschlecht mGeschlecht) {
        this.mName = mName;
        this.mVorname = mVorname;
        this.mInteresse = mInteresse;
        this.mGeschlecht = mGeschlecht;
    }

    public enum Geschlecht{
        männlich, weiblich, binär
    }

    public enum Interesse{
        Lesen, Sport, Serien
    }

}
