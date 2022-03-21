package ya.Sample;

import android.app.*;
import android.database.*;
import android.os.*;
import android.provider.*;
import android.widget.*;

public class Sample5 extends Activity
{
   ListView lv;
   
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);

      lv = new ListView(this);

      Cursor cr = managedQuery
         (ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
      startManagingCursor(cr);
      ArrayAdapter<String> ad = new ArrayAdapter<String>
         (this, android.R.layout.simple_list_item_1);
      while(cr.moveToNext())
      {
    	  int i = cr.getColumnIndex("DISPLAY_NAME");
          String str = cr.getString(i);
          ad.add(str);
      }
      cr.close();
      lv.setAdapter(ad);
       
      ll.addView(lv);
   }
}
