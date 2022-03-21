package ya.Sample;

import java.util.*;

import android.appwidget.*;
import android.content.*;
import android.graphics.*;
import android.widget.*;

public class Rensyu2 extends AppWidgetProvider
{
   public void onUpdate(Context cn, AppWidgetManager am, int[] ids)
   {
      RemoteViews rv = new RemoteViews(cn.getPackageName(), R.layout.widget);

      Calendar cl = Calendar.getInstance();
      cl.setTime(new Date());
      int h = cl.get(Calendar.HOUR_OF_DAY);
      
      String str = "‚ ‚¢‚³‚Â";      

      if(6 <= h && h <= 10)
      {
    	  str = "‚¨‚Í‚æ‚¤";      
      }
      else if(11 <= h && h <= 15)
      { 
    	  str = "‚±‚ñ‚É‚¿‚Í"; 
      }
      else if(16 <= h && h <= 20)
      {
    	  str = "‚Ü‚½–¾“ú"; 
      }
      else if(21 <= h && h <= 24)
      {
    	  str = "‚¨‚â‚·‚Ý"; 
      }
      else if(0 <= h && h <= 5)
      {
    	  str = "ZZZ..."; 
      }      
      
      rv.setTextViewText(R.id.SampleTextView, str);
      rv.setTextColor(R.id.SampleTextView, Color.BLACK);
      am.updateAppWidget(ids, rv);
      
   }
}
