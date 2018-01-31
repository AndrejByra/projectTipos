package sk.akademiasovy.tipos;


public class Bet {
    private int id;
    private int idUser;
    private int date;
    private int draw_id;
    private int ball1;
    private int ball2;
    private int ball3;
    private int ball4;
    private int ball5;

    public Bet(int id, int idUser, int date, int ball1, int ball2, int ball3, int ball4, int ball5) {
        this.id = id;
        this.idUser = idUser;
        this.date = date;
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.ball4 = ball4;
        this.ball5 = ball5;
    }
}

