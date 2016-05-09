package com.wsayan28.universityinfo;

import java.util.HashMap;
import java.util.Locale;

import com.wsayan28.universityinfo.R;
import com.wsayan28.universityinfo.R.string;

import android.R.integer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.Loader.ForceLoadContentObserver;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class UniversityGrid extends Activity {
	
	GridView grid;
	String shortnameString[]={"MBSTU","DU","JnU","BUET","CUET","RUET",
			"KUET","SUST","JU","IUT","MIST","BAU","PSTU","BUTex","CU","RU","KU",
			"IU","BSMMU","BSMRAU","HSTU","SbAU","DUET","KNU","CVASU",
			"SAU","UC","NSTU","JSTU","PUST","BRU","BUP","BU","BSMRSTU",
			"NU","BOU","AUW","ICU"};
	double[][] gmp={{24.235371, 89.891952},{23.731583, 90.392506},{23.708849, 90.411499},
			{23.725643, 90.392752},{22.459959, 91.971472},{24.370982, 88.625974},{22.900486, 89.502079},
			{24.921298, 91.833632},{23.881520, 90.267922},{23.948002, 90.379406},{23.837868, 90.358220},
			{24.719669, 90.427291},{22.465247, 90.382466},{23.760334, 90.400035},{22.469941, 91.790822},
			{24.368824, 88.641048},{22.799681, 89.535175},{23.720833, 89.150765},{23.738948, 90.395379},
			{24.037832, 90.399979},{25.696549, 88.651881},{23.771035, 90.376003},{24.018093, 90.418919},{24.582073, 90.376222},
			{22.363172, 91.804949},{24.908703, 91.901789},{23.419369, 91.137059},{22.793364, 91.100535},{23.233409, 89.126137},
			{24.013798, 89.279823},{25.717957, 89.259591},{23.839877, 90.357660},{22.658923, 90.362758},
			{22.966090, 89.817124},{23.949701, 90.380793},{23.951296, 90.380224},{22.358125, 91.823864},{23.745090, 90.427460}};
	
	String[][] emailPhone={{"registrar@mbstu.ac.bd", "+88092151899"},{"registrar@du.ac.bd", "+88029670531"},
			{"chairman@ugc.gov.bd","+88028113242"},{"regtr@regtr.edu.bd","+8809665650"},
			{"registrar@cuet.ac.bd","+88031714946"},{"registrar@ruet.ac.bd","+880721750742"},
			{"info@kuet.ac.bd","+88041769468"},{"registrar@sust.edu","+880821713491"},
			{"registr@juniv.edu","+88027791040"},{"regstrar@iut-dhaka.edu","+88029291254"},
			{"info@mist.ac.bd","+88028035419"},{"registrar@bau.edu.bd","+88028113242"},
			{"vc@pstu.ac.bd","+880442756010"},{"vc@butex.edu.bd","+88029114260"},
			{"vc-cu@spectectg.com","+88031736211"},{"vc@ru.ac.bd","+880721711236"},
			{"regekuly@bttb.net.bd","+88028113242"},{"registrar@iu.ac.bd","+8801716761017"},
			{"provc_admin@bsmmu.edu.bd","+88028610718"},{"info@bsmrau.edu.bd","+88029205323"},
			{"chairman@ugc.gov.bd","+88028113242"},{"vcsau@dhaka.net","+88029144270"},
			{"reg_duet@duet.ac.bd","+88029204703"},{"contact@jkkniu.edu.bd","+880903256212"}
			,{"contact@cvasu.ac.bd","+88028113242"},{"chairman@ugc.gov.bd","+88028113242"},
			{"registrarcou@gmail.com","+8801556426446"},{"chairman@ugc.gov.bd","+88032171486"},
			{"chairman@ugc.gov.bd","+88028113242"},{"bijon16@yahoo.com","+88073166742"},
			{"chairman@ugc.gov.bd","+88028113242"},{"info@bup.edu.bd","+88028000368"},
			{"info.barisaluniv@gmail.com","+8804312177431"},{"chairman@ugc.gov.bd","+88028113242"},
			{"webadmin@nu.edu.bd","+88029291018"},{"registrar@bou.edu.bd","+88029291112"},
			{"info@asian-university.org","+880312854980"},{"info@icu-edu.org","+8801778529973"}};
	HashMap<String, Double> map1 = new HashMap<String, Double>();
	HashMap<String, Double> map2 = new HashMap<String, Double>();
	HashMap<String, String> email = new HashMap<String, String>();
	HashMap<String, String> phone = new HashMap<String, String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_university_grid);
		for(int i=0;i<gmp.length;i++)
		{
			map1.put(shortnameString[i].toLowerCase(), gmp[i][0]);
			map2.put(shortnameString[i].toLowerCase(), gmp[i][1]);
			email.put(shortnameString[i].toLowerCase(), emailPhone[i][0]);
			phone.put(shortnameString[i].toLowerCase(), emailPhone[i][1]);
		}
		
		int logo=getIntent().getExtras().getInt("logo");
		
		final String wiki=getIntent().getExtras().getString("wikilink").toString().toLowerCase();
		final String web=getIntent().getExtras().getString("weblink").toString().toLowerCase();
		
		final int[] img={R.drawable.wikipedia,logo,R.drawable.email,R.drawable.call,R.drawable.location};
		final String[] logoname={"Wikipedia","Official Site","Email","Call","Location"};
		
		grid=(GridView) findViewById(R.id.gridView1);
		grid.setAdapter(new uniGridItem(this,logoname, img));
		
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				//uniGridItem info=(uniGridItem) grid.getItemAtPosition(arg2); 
				//String name=info.getItem(arg2).toString();
				if (logoname[position]=="Wikipedia")
				{
					//Toast.makeText(UniversityGrid.this,"wikipedia", Toast.LENGTH_LONG).show();
					String url="http://en.wikipedia.org/wiki/Universities_in_Bangladesh";
					if(!web.equals("icu"))
					{
					String link=wiki.replace(" ", "_");
					url="http://en.wikipedia.org/wiki/"+link;
					}
					Intent intent=new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse(url));
					startActivity(intent);
				}
				else if(logoname[position]=="Official Site")
				{
					//Toast.makeText(UniversityGrid.this,web, Toast.LENGTH_LONG).show();
					String link=web;
					String url="http://en.wikipedia.org/wiki/Universities_in_Bangladesh";
				
						if(link.equals("icu"))
						{
							url="http://www.icu-edu.org/";
						}
						else if(link.equals("iut"))
						{
							url="http://www.iutoic-dhaka.edu/";
						}
						else if(link.equals("auw"))
						{
							url="http://www.asian-university.org/";
						}
						else if(link.equals("ju"))
						{
							url="http://www.juniv.edu/";
						}
						else if(link.equals("sust"))
						{
							url="http://www.sust.edu/";
						}
						else if(link.equals("knu"))
						{
							url="http://www.jkkniu.edu.bd/";
						}
						else if(link.equals("bau"))
						{
							url="http://www.bau.edu.bd/";
						}
						else if(link.equals("bsmrau"))
						{
							url="http://www.bsmrau.edu.bd/";
						}
						else if(link.equals("sbau"))
						{
							url="http://www.sau.edu.bd/";
						}
						else if(link.equals("bsmmu"))
						{
							url="http://www.bsmmu.edu.bd/";
						}
						else if(link.equals("nstu"))
						{
							url="http://www.nstu.edu.bd/";
						}
						else if(link.equals("jstu"))
						{
							url="http://www.just.edu.bd/";
						}
						else if(link.equals("buetex"))
						{
							url="http://www.buetex.edu.bd/";
						}
						else if(link.equals("bup"))
						{
							url="http://www.bup.edu.bd/";
						}
						else if(link.equals("bsmrstu"))
						{
							url="http://www.bsmrstu.edu.bd/";
						}
						else if(link.equals("bu"))
						{
							url="http://www.barisaluniv.edu.bd/";
						}
						else if(link.equals("nu"))
						{
							url="http://www.nu.edu.bd/";
						}
						else if(link.equals("bou"))
						{
							url="http://www.bou.edu.bd/";
						}
						else if(link.equals("bru"))
						{
							url="http://www.brur.ac.bd/";
						}
						else 
						{
							url="http://www."+link+".ac.bd/";
						}
					Intent intent=new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse(url));
					startActivity(intent);
				}
				else if(logoname[position]=="Location")
				{
					//Toast.makeText(UniversityGrid.this,"Location", Toast.LENGTH_LONG).show();
					/*String url="http://maps.google.com/maps/api/staticmap?center="
							+ map1.get(web).toString()+ "," + map2.get(web).toString()
							+ "&zoom=10&size=480x800&maptype=mobile/&markers=color:green%7Clabel:J%7C"
							+ map1.get(web).toString() + "," + map2.get(web).toString()+"&sensor=false";*/
					String url=String.format(Locale.ENGLISH, "geo:%f,%f",map1.get(web),map2.get(web));
					
					try 
					{
						Intent intent=new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri.parse(url));
						startActivity(intent);
					} 
					catch (Exception e)
					{
						// TODO: handle exception
						Toast.makeText(UniversityGrid.this,"Install maps application", Toast.LENGTH_LONG).show();
					}
				}
				else if(logoname[position]=="Email")
				{
					//Toast.makeText(UniversityGrid.this,"Email", Toast.LENGTH_LONG).show();
					String emailAddress=email.get(web).toString();
					Intent intent=new Intent(Intent.ACTION_SEND);
					intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailAddress});
					
					//need this to prompts email client only
					intent.setType("message/rfc822");
					
					startActivity(Intent.createChooser(intent, "Choose an Email client :"));
					
				}
				else if(logoname[position]=="Call")
				{
					//Toast.makeText(UniversityGrid.this,"Call Them", Toast.LENGTH_LONG).show();
					String number=phone.get(web).toString();
					Intent callIntent=new Intent(Intent.ACTION_CALL);
					callIntent.setData(Uri.parse("tel:"+number));
					startActivity(callIntent);
				}
				
				
			}
			
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.university_grid, menu);
		return true;
	}

}
