package androidacademy.minsk.lecture3lists.data;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public static List<Actor> generateActors() {
        List<Actor> actors = new ArrayList<>();
        actors.add(new Actor("Alicia Vikander", Uri.parse("https://image.ibb.co/nKNBrd/Alicia_Vikander.jpg"), true));
        actors.add(new Actor("Amanda Seyfried", Uri.parse("https://image.ibb.co/j142xJ/Amanda_Seyfried.jpg"), false));
        actors.add(new Actor("Anne Hathaway", Uri.parse("https://image.ibb.co/euy6Py/Anne_Hathaway.jpg"), true));
        actors.add(new Actor("Emma Stone", Uri.parse("https://image.ibb.co/dJY6Py/Emma_Stone.jpg"), true));
        actors.add(new Actor("Keira Knightley", Uri.parse("https://image.ibb.co/cxX0jy/Keira_Knightley.jpg"), false));
        actors.add(new Actor("George Clooney", Uri.parse("https://image.ibb.co/ce1t4y/George_Clooney.jpg"), true));
        actors.add(new Actor("Lucy Liu", Uri.parse("https://image.ibb.co/dWurrd/Lucy_Liu.jpg"), false));
        actors.add(new Actor("Matthew McConaughey", Uri.parse("https://image.ibb.co/e3JHWd/Matthew_Mc_Conaughey.jpg"), true));
        actors.add(new Actor("Morgan Freeman", Uri.parse("https://image.ibb.co/h9GhxJ/Morgan_Freeman.jpg"), true));
        actors.add(new Actor("Ryan Gosling", Uri.parse("https://image.ibb.co/buLLjy/Ryan_Gosling.jpg"), false));
        actors.add(new Actor("Will Smith", Uri.parse("https://image.ibb.co/gxoUcJ/Will_Smith.jpg"), false));
        actors.add(new Actor("Robert de Niro", Uri.parse("https://image.ibb.co/e6T6Py/Robert_de_Niro.jpg"), true));
        actors.add(new Actor("Zoe Saldana", Uri.parse("https://image.ibb.co/i9WRPy/Zoe_Saldana.jpg"), false));

        return actors;
    }
}



