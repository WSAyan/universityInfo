package com.wsayan28.universityinfo;

import com.wsayan28.universityinfo.R;

import android.R.integer;
import android.R.layout;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class uniGridItem extends BaseAdapter {
	private Context context;
	private final String[] itemsStrings;
	private final int[] images;
		public uniGridItem(Context context,String[] itemsStrings, int[] images ) {
		super();
		this.context = context;
		this.itemsStrings = itemsStrings;
		this.images = images;
		}
	
		public Context getContext() {
			return context;
		}

		public void setContext(Context context) {
			this.context = context;
		}

		public String[] getItemsStrings() {
			return itemsStrings;
		}

		public int[] getImages() {
			return images;
		}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemsStrings.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View gridview;
		if (view==null) {
			gridview=new View(context);
			gridview=inflater.inflate(R.layout.uni_grid_item, null);
			
			TextView txtgv=(TextView) gridview.findViewById(R.id.textView1);
			ImageView imgv=(ImageView) gridview.findViewById(R.id.imageView1);
			
			txtgv.setText(itemsStrings[position]);
			imgv.setImageResource(images[position]);
		}
		else {
			gridview=(View)view;
		}
		return gridview;
	}

}
