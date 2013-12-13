package GUI;
import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JPanel;

public class QuickTableFrame extends JPanel
{
   public QuickTableFrame()
   {
      //set Frame properties

      //create a new quicktable
      quick.dbtable.DBTable dBTable1 = new quick.dbtable.DBTable();
      //add to frame
      add(dBTable1);

      //set the database driver to be used, we are using jdbc-odbc driver
      dBTable1.setDatabaseDriver("com.mysql.jdbc.Driver");
     
      /*
      set the jdbc url,"quicktabledemo" is the data source we have created
      for the database
      */
      dBTable1.setJdbcUrl("jdbc:mysql://95.47.119.185:3306/foo");
      dBTable1.setUser("root");
      dBTable1.setPassword("password");
      // set the select statement which should be used by the table
      dBTable1.setSelectSql("select * from Products");

      //to create the navigation bars for the table
      dBTable1.createControlPanel();
      
      try
      {
         //connect to database & create a connection
         dBTable1.connectDatabase();
   
         //fetch the data from database to fill the table
         dBTable1.refresh();
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      catch(ClassNotFoundException e)
      {
         e.printStackTrace();
      }

   }

   public static void main(String[] args)
   {
      //create a new table frame
      QuickTableFrame myframe = new QuickTableFrame();
   }
}

