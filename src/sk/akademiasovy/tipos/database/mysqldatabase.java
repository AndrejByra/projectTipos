package sk.akademiasovy.tipos.database;
import sk.akademiasovy.tipos.Bet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class mysqldatabase {
    private final String url="jdbc:mysql://localhost:3306/";
    private final String dbName="tipos";
    private final String driver="com.mysql.jdbc.Driver";
    private final String userName2="user2";
    private final String userName1="user1";
    private final String password2="andrej";
    private final String password1="ado";

    private Connection conn;

    public void testConnection(){
        try {
            Class.forName(driver).newInstance();

        conn= DriverManager.getConnection( url+dbName, userName2, password2);
        if (conn == null)
            System.out.println("connection failed");
        else
            System.out.println("connection success");
        conn.close();
        }
        catch (Exception e){
            System.out.println("Error can not to connect to the database"+e.getMessage());
        }
    }

    public boolean insertValueIntoDrawHistory (int arr[])
    {
        try
        {
            Class.forName(driver).newInstance();
            conn=DriverManager.getConnection(url+dbName, userName2,password2);
            String cmd="INSERT INTO draw_history(ball1, ball2, ball3, ball4, ball5)";
            cmd+=" VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement=conn.prepareStatement(cmd);
            preparedStatement.setInt(1,arr[0]);
            preparedStatement.setInt(2,arr[1]);
            preparedStatement.setInt(3,arr[2]);
            preparedStatement.setInt(4,arr[3]);
            preparedStatement.setInt(5,arr[4]);
            preparedStatement.executeUpdate();
            conn.close();
        }

        catch (Exception e)
        {
            System.out.println("Error, cannot connect to database");
        }

        return true;
    }
    public List<Bet> getBets(){

        try
        {
            Class.forName(driver).newInstance();
            List<Bet> list = new ArrayList<>();
            conn= DriverManager.getConnection(url+dbName, userName1,password1);
            String cmd="SELECT * FROM bets"+
                    " INNER JOIN bet_details ON bets.id=bet_details.idb "+
                    " INNER bets.draw_id IS NULL";
            PreparedStatement preparedStatement=conn.prepareStatement(cmd);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("Bet: "+resultSet.getInt("id")+ " user id: "+resultSet.getInt("idu")+" date: "+resultSet.getDate("date"));
                System.out.println(" > "+resultSet.getInt("bet1")+" "+resultSet.getInt("bet2")+" "+resultSet.getInt("bet3")+" "+resultSet.getInt("bet4")+" "+resultSet.getInt("bet5"));
            }
            return list;
        }
        catch (Exception e)
        {
            System.out.println("Error"+e.getMessage());
        }
        return null;
    }


}
