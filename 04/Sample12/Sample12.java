package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample12 extends Activity
{
   TextView tv;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      TableLayout tl = new TableLayout(this); 
      setContentView(tl);

      tv = new TextView(this);
      tv.setText("��������Ⴂ�܂��B");

      tl.addView(tv);
    }
   public boolean onCreateOptionsMenu(Menu menu)
   {
       menu.add(Menu.NONE, 0, 0, "��p��");     
       menu.add(Menu.NONE, 1, 1, "�^�N�V�[");
       menu.add(Menu.NONE, 2, 2, "�X�[�p�[�J�[");
       menu.add(Menu.NONE, 3, 3, "�I�[�v���J�[");
       return super.onCreateOptionsMenu(menu);
   }
   public boolean onOptionsItemSelected(MenuItem mi)
   {
      String str = null;
      switch(mi.getItemId())
      {
         case 0:
        	 str = "��p��";
        	 break; 
         case 1:
        	 str = "�^�N�V�[";
        	 break;   	 
         case 2:
        	 str = "�X�[�p�[�J�[";
        	 break;         	 
         case 3:
        	 str = "�I�[�v���J�[";
        	 break;  
      }
      tv.setText(str + "�ł��ˁB");
      
      return true;   
   }
}
