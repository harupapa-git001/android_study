package ya.Sample;

import java.io.*;
import java.util.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.hardware.*;
import android.hardware.Camera.*;

public class Sample3 extends Activity
{
   Button bt;
   SurfaceView sv;
   SurfaceHolder sh;
   Camera cm;
   
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
     
      bt = new Button(this);
      bt.setText("éBâe");
      
      sv = new SurfaceView(this);
      sh = sv.getHolder();
      
      sh.addCallback(new SampleSurfaceHolderCallback());      
      sh.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
  
      ll.addView(bt);
      ll.addView(sv);
      
      bt.setOnClickListener(new SampleClickListener());
   }
   class SampleSurfaceHolderCallback implements SurfaceHolder.Callback
   {
      public void surfaceCreated(SurfaceHolder holder)
      {
         cm = Camera.open();
         Camera.Parameters pr = cm.getParameters();
         List<Size> ss = pr.getSupportedPictureSizes();
         Size s = ss.get(0);
         pr.setPictureSize(s.width, s.height);
         cm.setParameters(pr);
      }
      public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) 
      {
          try
          {
             WindowManager wm =  (WindowManager)getSystemService(WINDOW_SERVICE);
     	     Display dp = wm.getDefaultDisplay(); 
             int rt = dp.getRotation();
             int d = 0;
             switch (rt)
             {
                case Surface.ROTATION_0:
                   d = 90; break;
                case Surface.ROTATION_90:
                   d = 0; break;
                case Surface.ROTATION_180:
                   d = 270; break;
                case Surface.ROTATION_270:
                   d = 180; break;
              }

              cm.setDisplayOrientation(d);
              cm.setPreviewDisplay(sv.getHolder());
              
              Camera.Parameters pr = cm.getParameters();
              pr.setPreviewSize(width, height);
              cm.setParameters(pr);
              cm.startPreview();
             }
             catch(Exception e){}
      }
      public void surfaceDestroyed(SurfaceHolder holder)
      {
	      cm.stopPreview();
	      cm.release();		
      }
   }
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
         cm.takePicture(null,null, new SamplePictureCallback());
      }
      class SamplePictureCallback implements PictureCallback
      {
         public void onPictureTaken(byte[] data, Camera c)
         {
            try
            {
               File dir = new File(Environment.getExternalStorageDirectory(),"YASample");
               if(dir.exists() == false)
               {
                  dir.mkdir();
               }	  
               File f = new File(dir, "pic.jpeg");  
               FileOutputStream fos = new FileOutputStream(f);
               fos.write(data);
               Toast.makeText(getApplicationContext(), "é ê^Çï€ë∂ÇµÇ‹ÇµÇΩÅB", Toast.LENGTH_LONG).show();
               fos.close();
               cm.startPreview();
            }
            catch(Exception e){}
         }
      }
   }  
}
