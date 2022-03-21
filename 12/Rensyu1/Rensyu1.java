package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu1 extends Activity
{

   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      
      Button bt = (Button) findViewById(R.id.SampleButton);
 
      bt.setOnClickListener(new SampleClickListener());
   }
   
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
    	 TextView tv = (TextView) findViewById(R.id.SampleTextView);  
         tv.setText("Ç†ÇËÇ™Ç∆Ç§Ç≤Ç¥Ç¢Ç‹Ç∑ÅB");
      }
   }  
}
