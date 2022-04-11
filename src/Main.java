import Objects.Register;
import Objects.Tools;
import Screens.Principal;



public class Main{

    private static Principal screenMenu;

    public static void main(String[] args){


        Register fileRegister = new Register();

        screenMenu = new Principal();
        screenMenu.update();

        fileRegister.registerIngredientsStocks();
    }


}
