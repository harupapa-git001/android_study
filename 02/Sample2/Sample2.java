package ya.Sample;

import android.app.*;
import android.os.*;
import android.widget.*;

public class Sample2 extends Activity
{
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this);
      setContentView(ll);
      
      TextView tv = new TextView(this);
      tv.setText("�悤�����A���h���C�h��!");

      ll.addView(tv);
   }
}
