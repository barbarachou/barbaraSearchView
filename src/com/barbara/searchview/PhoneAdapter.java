package com.barbara.searchview;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


/** 
* @author  barbara_chou@163.com
* @create 2013-10-13 下午12:08:19 
* @illustrate
*/ 
public class PhoneAdapter extends BaseAdapter implements Filterable {
	private ArrayList<Phone> datas;
	private Context _context;
	private ArrayList<Phone> filter;

	public PhoneAdapter(ArrayList<Phone> datas, Context context) {
		this.datas = datas;
		this.filter = datas;
		this._context = context;
	}

	private static class ViewHolder {
		public TextView name;
		public TextView num;
		// public ImageButton dia;
		// public ImageButton msm;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try {
			return filter.size();
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return filter.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater mInflater = (LayoutInflater) _context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder.name = (TextView) convertView.findViewById(R.id.textView1);
			holder.num = (TextView) convertView.findViewById(R.id.textView2);
			// holder.dia = (ImageButton) convertView.findViewById(R.id.dia);
			// holder.msm = (ImageButton) convertView.findViewById(R.id.msm);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
			// holder.spBubble.isChache = true;
		}

		final Phone phone = filter.get(position);
		holder.name.setText(phone.toString());
		holder.num.setText(phone.getNum());
		if (phone.getSex() == 1) {
			holder.name.setTextColor(android.graphics.Color.WHITE);
			holder.num.setTextColor(android.graphics.Color.WHITE);
		} else {
			holder.name.setTextColor(android.graphics.Color.RED);
			holder.num.setTextColor(android.graphics.Color.RED);
		}
		// holder.dia.setOnClickListener(new OnClickListener(){
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
		// + phone.getNum()));
		// startActivity(intent);
		// }
		// });
		// holder.msm.setOnClickListener(new OnClickListener(){
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("smsto:"
		// + phone.getNum()));
		// startActivity(intent);
		// }
		// });
		return convertView;
	}

	@Override
	public Filter getFilter() {
		return new Filter() {
			@Override
			protected FilterResults performFiltering(CharSequence charSequence) {
				FilterResults results = new FilterResults();

				// If there's nothing to filter on, return the original data for
				// your list
				if (charSequence == null || charSequence.length() == 0) {
					results.values = datas;
					results.count = datas.size();
				} else {
					ArrayList<Phone> filterResultsData = new ArrayList<Phone>();

					for (Phone data : datas) {
						// In this loop, you'll filter through originalData and
						// compare each item to charSequence.
						// If you find a match, add it to your new ArrayList
						// I'm not sure how you're going to do comparison, so
						// you'll need to fill out this conditional
						if (data.toString().contains(charSequence)) {
							filterResultsData.add(data);
						}
					}

					results.values = filterResultsData;
					results.count = filterResultsData.size();
				}

				return results;
			}

			@Override
			protected void publishResults(CharSequence charSequence,
					FilterResults filterResults) {
				filter = (ArrayList<Phone>) filterResults.values;
				notifyDataSetChanged();
			}
		};
	}

}
