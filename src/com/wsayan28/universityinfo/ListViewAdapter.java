package com.wsayan28.universityinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.wsayan28.universityinfo.R;

import android.R.bool;
import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewAdapter extends BaseAdapter{
	
	Context ncontext;
	LayoutInflater inflater;
	private List<listItem>uniList=null;
	private ArrayList<listItem>arrayList;
	
	
	public ListViewAdapter(Context context, List<listItem> uniList) {
		//super();
		ncontext = context;
		this.uniList = uniList;
		inflater =LayoutInflater.from(ncontext);
		this.arrayList = new ArrayList<listItem>();
		this.arrayList.addAll(uniList);
	}
	
    public class ViewHolder {
    	TextView shortname;
        TextView longname;
        ImageView img;
        }
    
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return uniList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return uniList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
	       final ViewHolder holder;
	        if (view == null) {
	            holder = new ViewHolder();
	            view = inflater.inflate(R.layout.university_list_item, null);
	            // Locate the TextViews in university_list_item.xml
	            holder.img = (ImageView) view.findViewById(R.id.unilogo);
	            holder.shortname = (TextView) view.findViewById(R.id.shortname);
	            holder.longname = (TextView) view.findViewById(R.id.longname);
	            
		        view.setTag(holder);
	        } 
	        else {
	            holder = (ViewHolder) view.getTag();
	        }
	        
	        holder.shortname.setText(uniList.get(position).getShortName());
	        holder.longname.setText(uniList.get(position).getLongName());
	        holder.img.setImageResource(uniList.get(position).getImage());
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(ncontext,UniversityGrid.class);
					intent.putExtra("wikilink", uniList.get(position).getLongName());
					intent.putExtra("weblink",uniList.get(position).getShortName());
					intent.putExtra("logo", uniList.get(position).getImage());
					
					ncontext.startActivity(intent);
				}
			});
		
			return view;
	}
	
    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        uniList.clear();
        if (charText.length() == 0) 
        {
            uniList.addAll(arrayList);
        } 
        else 
        {
            for (listItem item : arrayList) 
            {
            	
                if (item.getShortName().toLowerCase(Locale.getDefault()).startsWith(charText)) 
                {
                    uniList.add(item);
                }
                else if (item.getLongName().toLowerCase(Locale.getDefault()).startsWith(charText)) 
                {
                    uniList.add(item);
                }
                else if (item.getShortName().toLowerCase(Locale.getDefault()).contains(charText)) 
                {
                    uniList.add(item);
                }
                else if (item.getLongName().toLowerCase(Locale.getDefault()).contains(charText)) 
                {
                    uniList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

}
