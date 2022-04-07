package Objects;

import Datas.IngredientsDatas;

import java.io.*;

public class Register {
    private String ingredientFile = "ressources/ingredients";

    public Register() {
        readIngredientsStocks();
    }

    public void registerIngredientsStocks() {

        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ingredientFile)))) {
            out.writeObject(IngredientsDatas.values());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readIngredientsStocks() {
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ingredientFile)))) {
            IngredientsDatas[] datas = (IngredientsDatas[]) in.readObject();
            for(int i=0; i< datas.length; i++){
                System.out.println(datas[i].getStocks());
                IngredientsDatas.values()[i].setStocks(datas[i].getStocks());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
