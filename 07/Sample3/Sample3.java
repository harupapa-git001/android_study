package ya.Sample;

import com.google.android.maps.*;
import android.os.*;
import android.widget.*;

public class Sample3 extends MapActivity
{
	MapView mv;
   
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);

      mv= new MapView(this, "XXXXXXXXXXXXX");  //APIキーが必要
      mv.setEnabled(true);
      mv.setClickable(true);
      mv.setBuiltInZoomControls(true);
      
      ll.addView(mv);
      
   }
   protected boolean isRouteDisplayed()
   {
	   return false;
   }
}
