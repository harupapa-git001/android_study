package ya.Sample;

import android.app.*;
import android.os.*;
import android.widget.*;

public class Sample1 extends Activity
{
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      TextView tv = new TextView(this);
      tv.setText("Ç¢ÇÁÇ¡ÇµÇ·Ç¢Ç‹ÇπÅB");
      Button bt = new Button(this);
      bt.setText("çwì¸");

      ll.addView(tv);
      ll.addView(bt);
   }
}
