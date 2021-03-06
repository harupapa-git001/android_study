package ya.Sample;

import android.app.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.widget.*;

public class Sample6 extends Activity
{
   ListView lv;
      
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.HORIZONTAL);
      setContentView(ll);
      
      ListView lv = new ListView(this);
      
      String str = "data/data/" + getPackageName() + "/Sample.db";
      SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(str, null);
      
      String qry0 = "DROP TABLE IF EXISTS product";
      String qry1 = "CREATE TABLE product" +
      		  "(id INTEGER PRIMARY KEY, name STRING, price INTEGER)";
      
      String[] qry2 ={"INSERT INTO product(name, price) VALUES ('???M', 80)",
                      "INSERT INTO product(name, price) VALUES ('?????S??', 50)",
                      "INSERT INTO product(name, price) VALUES ('???K', 200)",
                      "INSERT INTO product(name, price) VALUES ('?R???p?X', 300)",
                      "INSERT INTO product(name, price) VALUES ('?{?[???y??', 100)"};
       
      String qry3 = "SELECT * FROM product WHERE name LIKE'%??%'";
      
      db.execSQL(qry0);
      db.execSQL(qry1);
 
      for(int i=0; i<qry2.length; i++)
      {
         db.execSQL(qry2[i]);
      }

      Cursor cr = db.rawQuery(qry3, null);
      startManagingCursor(cr);
      
      ArrayAdapter<String> ad = new ArrayAdapter<String>
         (this, android.R.layout.simple_list_item_1);
      while(cr.moveToNext())
      {
         int i = cr.getColumnIndex("id");
         int n = cr.getColumnIndex("name");
         int p = cr.getColumnIndex("price");
         int id = cr.getInt(i);
         String name = cr.getString(n);
         int price = cr.getInt(p);
         
         String row = id + "------" + name + "?`" + price + "?~";

         ad.add(row);
      }
     
      lv.setAdapter(ad);
       
      ll.addView(lv);        

      db.close();
   }
}
