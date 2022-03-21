package ya.Sample;

import android.appwidget.*;
import android.content.*;
import android.graphics.*;
import android.widget.*;

public class Sample2 extends AppWidgetProvider
{
   public void onUpdate(Context cn, AppWidgetManager am, int[] ids)
   {
      RemoteViews rv = new RemoteViews(cn.getPackageName(), R.layout.widget);

      rv.setTextViewText(R.id.SampleTextView, "å√írÇ‚\nä^îÚçûÇﬁ\nêÖÇÃâπ");
      rv.setTextColor(R.id.SampleTextView, Color.BLACK);
      am.updateAppWidget(ids, rv);
   }
}
