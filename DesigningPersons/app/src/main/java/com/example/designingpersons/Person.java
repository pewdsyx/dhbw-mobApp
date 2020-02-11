package com.example.designingpersons;

public class Person {

    String _name;
    String _vorname;
    String _geschlecht;
    String _interesse;


    enum geschlecht {
        WEIBLICH("weiblich"), MAENNLICH("männlich");
        String val;

        geschlecht(String val) {
            this.val = val;
        }

        @Override
        public String toString(){
            return val;
        }
    }

    enum interesse {
        SERIEN("Serien"), SPORT("Sport"), LESEN("Lesen");
        String val;

        interesse(String val) {
            this.val = val;
        }

        @Override
        public String toString(){
            return val;
        }
    }

    public Person(String vorname, String nachname, String geschlecht, String interesse) {
        _name = nachname;
        _vorname = vorname;
        _geschlecht = geschlecht;
        _interesse = interesse;
    }
}
