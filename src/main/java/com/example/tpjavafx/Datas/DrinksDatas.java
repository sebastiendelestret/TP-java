package com.example.tpjavafx.Datas;

public enum DrinksDatas {
    LIMONADE(4),
    CIDRE_DOUX(5),
    BIERE_SANS_ALCOOL(5),
    JUS_DE_FRUIT(1),
    VERRE_EAU(0);

    private int price;

    private DrinksDatas(int price) { this.price = price; }

    public int getPrice() {
        return price;
    }
}
