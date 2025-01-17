package com.example;

import java.util.List;

public class Feline implements ReproductivePredator {

    @Override
    public List<String> eatMeat() throws Exception {
        return List.of("Мясо", "Рыба");
    }

    @Override
    public int getKittens() {
        return 1;
    }
}
