package ya.Sample;

import java.util.*;
import android.app.*;
import android.appwidget.*;
import android.content.*;
import android.graphics.*;
import android.os.Bundle;
import android.widget.*;

public class Sample3 extends AppWidgetProvider
{
   String filter = "ya.Sample.09_Sample3.CLICK";
 
   public void onUpdate(Context cn, AppWidgetManager am, int[] ids)
   {
      RemoteViews rv = new RemoteViews(cn.getPackageName(), R.layout.widget);

      rv.setTextViewText(R.id.SampleTextView, "‚¨‚Ý‚­‚¶");
      rv.setTextColor(R.id.SampleTextView, Color.BLACK);
      am.updateAppWidget(ids, rv);
      
      for(int i=0; i<ids.length; i++)
      {
         Intent it = new Intent(filter);
         it.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, ids[i]);
         PendingIntent pi = PendingIntent.getBroadcast(cn, ids[i], it, 0);
         rv.setOnClickPendingIntent(R.id.SampleTextView, pi);
      }
      am.updateAppWidget(ids, rv);
   }
   public void onReceive(Context cn, Intent it)
   {
      super.onReceive(cn, it);
      String ac = it.getAction();
	  if(ac.equals(filter))
	  {
         Bundle ex = it.getExtras();
         int id = ex.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);
		  
         RemoteViews rv = new RemoteViews(cn.getPackageName(),R.layout.widget);

         int f = 0;
         Random r = new Random();
         f = r.nextInt(3);
         String str = "‚¨‚Ý‚­‚¶";
         int c = 0;
         switch(f)
         {
            case 0:
               str = "‚ ‚½‚èI";
               c = Color.RED; 
               break;
            case 1:
                str = "‚Í‚¸‚êI";
                c = Color.BLUE;
                break;
            case 2: 	
                str = "‚à‚¤ˆê‰ñI";
                c = Color.GREEN;
                break; 
         }
         
         rv.setTextViewText(R.id.SampleTextView, str);
         rv.setTextColor(R.id.SampleTextView, c);
         AppWidgetManager am = AppWidgetManager.getInstance(cn);
         am.updateAppWidget(id, rv);
      }
   }
}
