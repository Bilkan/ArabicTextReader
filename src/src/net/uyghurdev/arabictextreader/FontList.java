package net.uyghurdev.arabictextreader;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class FontList extends Activity {
	
	ArrayList<HashMap<String,String>> fonts=new ArrayList<HashMap<String,String>>();
	ListView lvfonts;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fonts);
		setTitle(ArabicUtilities.reshape(getString(R.string.settings_fclabel)));
		fonts=Configs.Fonts;
		lvfonts=(ListView)findViewById(R.id.fontitems);
		SimpleAdapter fontadapter=new SimpleAdapter(this,fonts, R.layout.fontlist,new String[] {"fontName"}, new int[] {R.id.item});
//		fontadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		lvfonts.setAdapter(fontadapter);
		lvfonts.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Configs.FontPosition=arg2;
				Intent newIntent = new Intent(FontList.this, Settings.class);
				startActivity(newIntent);
				finish();
			}
			
		});
	}

}
