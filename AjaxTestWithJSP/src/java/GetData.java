
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetData 
{
    public static Connection getCon() throws ClassNotFoundException, SQLException
    {
        Connection con = null;
       
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root","");
            
        return con;
    }
    public static ArrayList getNames(String qName)
    {
        ArrayList <String>list = new ArrayList<>();
        Connection con = null;
        try 
        {
            con = getCon();
            Statement stt = con.createStatement();
            ResultSet rs = stt.executeQuery("select * from batch4 where name like '"+qName+"%'");
            while(rs.next())
            {
                list.add(rs.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
