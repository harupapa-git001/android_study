package ya.Sample;

import android.app.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu2 extends Activity
{
   TextView tv;
   RadioButton rb1, rb2, rb3;
   RadioGroup rg;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("Hello!");

      rb1 = new RadioButton(this);
      rb2 = new RadioButton(this);
      rb3 = new RadioButton(this);
      
      rb1.setText("�W��");
      rb2.setText("����");
      rb3.setText("�C�^���b�N");
      
      rg = new RadioGroup(this);
      
      rg.addView(rb1);
      rg.addView(rb2);
      rg.addView(rb3);

      rb1.setChecked(true);
      
      ll.addView(tv);
      ll.addView(rg);
      
      rb1.setOnClickListener(new SampleClickListener());
      rb2.setOnClickListener(new SampleClickListener());
      rb3.setOnClickListener(new SampleClickListener());
   }
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
    	 if(v == rb1)
    	 {
    	    tv.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
         }
         else if(v == rb2)
         {
        	 tv.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
         }
         else if(v == rb3)
         {
        	 tv.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
         }    	 
      }  
   }
}
