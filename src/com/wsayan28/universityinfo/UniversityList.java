package com.wsayan28.universityinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.wsayan28.universityinfo.R;

import android.R.integer;
import android.R.layout;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class UniversityList extends Activity {
	EditText filtertext;
	ListView uniListView;
	ListViewAdapter adapter;
	ArrayList<listItem>arrayList=new ArrayList<listItem>();
	//ArrayList<Bitmap>imgArrayList;
	//BaseAdapter adapter;
	String shortnameString[]={"MBSTU","DU","JnU","BUET","CUET","RUET",
			"KUET","SUST","JU","IUT","MIST","BAU","PSTU","BUTex","CU","RU","KU",
			"IU","BSMMU","BSMRAU","HSTU","SbAU","DUET","KNU","CVASU",
			"SAU","UC","NSTU","JSTU","PUST","BRU","BUP","BU","BSMRSTU",
			"NU","BOU","AUW","ICU"};
	String longnameString[]={"Mawlana Bhashani Science and Technology University",
			"University of Dhaka","Jagannath University",
			"Bangladesh University of Engineering and Technology",
			"Chittagong University of Engineering & Technology",
			"Rajshahi University of Engineering & Technology",
			"Khulna University of Engineering & Technology",
			"Shahjalal University of Science and Technology",
			"Jahangirnagar University",
			"Islamic University of Technology",
			"Military Institute of Science and Technology",
			"Bangladesh Agricultural University","Patuakhali Science and Technology University",
			"Bangladesh University of Textiles","University of Chittagong",
			"University of Rajshahi","Khulna University",
			"Islamic University","Bangabandhu Sheikh Mujib Medical University",
			"Bangabandhu Sheikh Mujibur Rahman Agricultural University",
			"Hajee Mohammad Danesh Science & Technology University",
			"Sher-e-Bangla Agricultural University","Dhaka University of Engineering & Technology","Jatiya Kabi Kazi Nazrul Islam University",
			"Chittagong Veterinary and Animal Sciences University",
			"Sylhet Agricultural University","Comilla University","Noakhali Science and Technology University",
			"Jessore Science & Technology University","Pabna University of Science and Technology",
			"Begum Rokeya University","Bangladesh University of Professionals","Barisal University",
			"Bangabandhu Sheikh Mujibur Rahman Science and Technology University",
			"Bangladesh National University","Bangladesh Open University","Asian University for Women","International Culture University"};
	
	int image[]={R.drawable.mbstu,R.drawable.du,R.drawable.jnu,R.drawable.buet,
			R.drawable.cuet,R.drawable.ruet,
			R.drawable.kuet,R.drawable.sust,R.drawable.ju,R.drawable.iut,R.drawable.mist,
			R.drawable.bau,R.drawable.pstu,R.drawable.butex,R.drawable.cu,R.drawable.ru,R.drawable.ku,
			R.drawable.iu,R.drawable.bsmmu,R.drawable.bsrmu,R.drawable.hstu,
			R.drawable.sbau,R.drawable.duet,R.drawable.knu,R.drawable.cvasu,
			R.drawable.sau,R.drawable.uc,R.drawable.nstu,R.drawable.jstu,
			R.drawable.pust,R.drawable.bru,R.drawable.bup,R.drawable.bu,R.drawable.brsmtu,
			R.drawable.nu,R.drawable.bou,R.drawable.auw,R.drawable.icu};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_university_list);
		//initialize();
		uniListView=(ListView) findViewById(R.id.listView1);
		//listItem item=new listItem("", "",0);
		for(int i=0;i<shortnameString.length;i++)
		{
			listItem item=new listItem(shortnameString[i], longnameString[i],image[i]);
			arrayList.add(item);
		}
		
		
		// Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arrayList);
        uniListView.setAdapter(adapter);
		
       //adapter.notifyDataSetChanged();
        
        filtertext=(EditText) findViewById(R.id.myFilter);
        
        filtertext.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				String text = filtertext.getText().toString().toLowerCase(Locale.getDefault());
	            adapter.filter(text);
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
			}
		});
		
	}
	
	/*private void initialize() {
		uniListView=(ListView) findViewById(R.id.listView1);
		
		arrayList=new ArrayList<listItem>();
		///imgArrayList=new ArrayList<Bitmap>();
		//arrayList.addAll(searchlist);
		adapter=new BaseAdapter() {
			LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			@Override
			public View getView(int position, View view, ViewGroup viewGroup) {
				if(view==null)
				{
					view=inflater.inflate(R.layout.university_list_item, null);
				}
				
				TextView uniShortName=(TextView) view.findViewById(R.id.shortname);	 
				TextView uniLongName=(TextView) view.findViewById(R.id.longname);
				ImageView logoImage=(ImageView) view.findViewById(R.id.unilogo);
				
				String name1=arrayList.get(position).getShortName();
				uniShortName.setText(name1);
				String name2=arrayList.get(position).getLongName();
				uniLongName.setText(name2);
				int img=arrayList.get(position).getImage();
				logoImage.setImageResource(img);
				
				return view;
			}
			
			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return arrayList.get(arg0);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return arrayList.size();
			}
		};
		uniListView.setAdapter(adapter);
		
		listItem item=new listItem("", "",0);
		for(int i=0;i<shortnameString.length;i++)
		{
			item=new listItem(shortnameString[i], longnameString[i],image[i]);
			arrayList.add(item);
		}
		
		adapter.notifyDataSetChanged();
		
		uniListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(UniversityList.this,UniversityGrid.class);
				listItem info=(listItem) uniListView.getItemAtPosition(arg2);
				String shortname=info.getShortName().toString();
				String longname=info.getLongName().toString();
				int img=(int)info.getImage();
				intent.putExtra("wikilink", longname);
				intent.putExtra("weblink",shortname);
				intent.putExtra("logo", img);
				startActivity(intent);
			}
		});
		
	}*/
	
   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.university_list, menu);
		return true;
	}

}
