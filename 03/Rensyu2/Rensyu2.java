package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu2 extends Activity
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
      tv.setText("��������Ⴂ�܂��B");
      bt = new Button(this);
      bt.setText("�w��");

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
            bt.setText("����ɂ���");
         }
         else if(e.getAction() == MotionEvent.ACTION_UP)
         {
            bt.setText("���悤�Ȃ�");
         }
         return true;
      }
   }  
}
