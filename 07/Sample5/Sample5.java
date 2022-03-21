package ya.Sample;

import com.google.android.maps.*;
import android.content.*;
import android.location.*;
import android.os.*;
import android.widget.*;

public class Sample5 extends MapActivity
{
	MapView mv;
    LocationManager lm;
	
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
      MapController mc = mv.getController();
      mc.setZoom(12);
      
      lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
      
      ll.addView(mv);
    }
   public void onResume()
   {
      super.onResume();
      lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 50, new SampleLocationListener());   
   }
   protected boolean isRouteDisplayed()
   {
      return false;
   }
   class SampleLocationListener implements LocationListener
   {
      public void onLocationChanged(Location lc)
      {
         int lt = (int) (lc.getLatitude() * 1E6);
         int ln = (int) (lc.getLongitude() * 1E6);
         GeoPoint gp = new GeoPoint(lt, ln);
         mv.getController().animateTo(gp);
      }
      public void onProviderDisabled(String pv){}
      public void onProviderEnabled(String pv){}
      public void onStatusChanged(String pv, int staus, Bundle ex){}
   }
}
