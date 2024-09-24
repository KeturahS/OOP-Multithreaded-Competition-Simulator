package game.entities.sportsman;

public class simpleWinterSportsman implements IWinterSportsman{

    WinterSportsman WINTERSPORTSMAN;


    public simpleWinterSportsman(WinterSportsman winterSportsman)
    {
        WINTERSPORTSMAN=winterSportsman;
    }

    public WinterSportsman updateWinterSportsman(  )
    {

        return WINTERSPORTSMAN;

    }
}
