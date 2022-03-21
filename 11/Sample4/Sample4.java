package ya.Sample;

import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.xmlpull.v1.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample4 extends Activity
{
   EditText et;
   Button bt;
   ListView lv;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      et = new EditText(this);
      bt = new Button(this);
      lv = new ListView(this);

      bt.setText("ì«çû");
      
      ll.addView(et);
      ll.addView(bt);
      ll.addView(lv);
      
      bt.setOnClickListener(new SampleClickListener());
   }
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
         try
         {
            ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
            
            String uri = et.getText().toString();
            HttpClient hc = new DefaultHttpClient();
            HttpGet hg = new HttpGet();
            hg.setURI(new URI(uri));
            HttpResponse hr = hc.execute(hg);
            
            InputStream is = hr.getEntity().getContent();
    	    BufferedReader br = new  BufferedReader(new InputStreamReader(is));

    	    XmlPullParserFactory xpf = XmlPullParserFactory.newInstance();
    	    XmlPullParser xpp = xpf.newPullParser();
            xpp.setInput(br);
    	 
            int type = 0;
            type = xpp.getEventType();
            HashMap<String,String> mp = null;
            String title = "";
            String description = "";
            boolean isItem = false;
            
            while (type != XmlPullParser.END_DOCUMENT)
            {
               if(type == XmlPullParser.START_TAG)
               {
            	  if(xpp.getName().equals("item")) 
                  {
                     mp = new HashMap<String, String>();           		  
                     isItem = true;
                  }
                  else if(xpp.getName().equals("title") )
        	      {
                	 if(isItem == true) 
                	 {
                         title = xpp.nextText();
            	         mp.put("title", title);
            	      }
                  }
                  else if(xpp.getName().equals("description"))
        	      {
                     if(isItem == true) 
                     {
            	         description = xpp.nextText();
                         mp.put("description", description);
                     }
                  }
               }  
               else if(type == XmlPullParser.END_TAG)
               {
            	  if(xpp.getName().equals("item")) 
             	  {
             		  list.add(mp);        		  
                      isItem = false;
             	  }
                }
                type = xpp.next();
            }
            String[] keys = {"title", "description"};
            int[] ids = {android.R.id.text1, android.R.id.text2};
            SimpleAdapter sa = new SimpleAdapter
               (getApplicationContext(), list, android.R.layout.simple_list_item_2, keys, ids);
            
            lv.setAdapter(sa);
         }
         catch(Exception e){Toast.makeText(getBaseContext(), "URLÇämîFÇµÇƒÇ≠ÇæÇ≥Ç¢ÅB", Toast.LENGTH_LONG).show();}
      }
   }  
}
