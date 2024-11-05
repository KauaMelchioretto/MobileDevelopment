package com.ifsc.listagemdados;

import java.util.ArrayList;

public class PlanetaDao {
    ArrayList<Planeta> planetas;

    public PlanetaDao() {
        this.planetas = new ArrayList<>();
        planetas.add(new Planeta(R.drawable.mercury, "Mercúrio"));
        planetas.add(new Planeta(R.drawable.venus, "Venus"));
        planetas.add(new Planeta(R.drawable.earth, "Terra"));
        planetas.add(new Planeta(R.drawable.mars, "Marte"));
        planetas.add(new Planeta(R.drawable.neptune, "Netuno"));
        planetas.add(new Planeta(R.drawable.saturn, "Saturno"));
        planetas.add(new Planeta(R.drawable.sun, "Sol"));
        planetas.add(new Planeta(R.drawable.uranus, "Urano"));
        planetas.add(new Planeta(R.drawable.jupter, "Júpiter"));
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }
}
