package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample5 extends Activity
{
   TextView tv;
   Button bt;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("Ç¢ÇÁÇ¡ÇµÇ·Ç¢Ç‹ÇπÅB");
      bt = new Button(this);
      bt.setText("çwì¸");

      ll.addView(tv);
      ll.addView(bt);
 
      bt.setOnTouchListener(new SampleTouchListener());
   }
   
   class SampleTouchListener implements OnTouchListener
   {
      public boolean onTouch(View v, MotionEvent e)
      {
         if(e.getAction() == MotionEvent.ACTION_DOWN)
    	 {
            tv.setText("Ç±ÇÒÇ…ÇøÇÕ");
         }
         else if(e.getAction() == MotionEvent.ACTION_UP)
         {
            tv.setText("Ç≥ÇÊÇ§Ç»ÇÁ");
         }
         return true;
      }
   }  
}
