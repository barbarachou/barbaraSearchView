package com.barbara.searchview;

import java.util.ArrayList;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.app.Activity;


/** 
* @author  barbara_chou@163.com
* @create 2013-10-13 下午12:06:25 
* @illustrate 自定义adapter（自定义list_item），完成listview的filter
*/ 
public class SearchViewTest extends Activity implements
		SearchView.OnQueryTextListener
{
	private SearchView sv;
	private ListView lv;
	private final ArrayList<Phone> nums = new ArrayList<Phone>();
	private final ArrayList<String> num = new ArrayList<String>();
	PhoneAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lv = (ListView) findViewById(R.id.lv);
		nums.add(new Phone("aaaa", "15151", 1));
		nums.add(new Phone("bbbb", "42574", 0));
		nums.add(new Phone("cccc", "24242", 0));
		nums.add(new Phone("eeee", "56565", 1));
		nums.add(new Phone("我我我我", "56565", 1));
		num.add("aaaa");
		num.add("bbbb");
		num.add("cccc");
		num.add("eeee");
		adapter = new PhoneAdapter(nums, getApplicationContext());
		lv.setAdapter(adapter);
//		lv.setAdapter(new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, mStrings));
		lv.setTextFilterEnabled(true);
		sv = (SearchView) findViewById(R.id.sv);
		// 设置该SearchView默认是否自动缩小为图标
		sv.setIconifiedByDefault(false);
		// 为该SearchView组件设置事件监听器
		sv.setOnQueryTextListener(this);
		// 设置该SearchView显示搜索按钮
		sv.setSubmitButtonEnabled(true);
		// 设置该SearchView内默认显示的提示文本
		sv.setQueryHint("查找");
	}

	// 用户输入字符时激发该方法
	@Override
	public boolean onQueryTextChange(String newText)
	{
		if (TextUtils.isEmpty(newText))
		{
			// 清除ListView的过滤
//			lv.clearTextFilter();
			adapter.getFilter().filter("");
			lv.clearTextFilter();
		}
		else
		{
			// 使用用户输入的内容对ListView的列表项进行过滤
//			lv.setFilterText(newText);
			adapter.getFilter().filter(newText.toString());
		}
		return true;
	}

	// 单击搜索按钮时激发该方法
	@Override
	public boolean onQueryTextSubmit(String query)
	{
		// 实际应用中应该在该方法内执行实际查询
		// 此处仅使用Toast显示用户输入的查询内容
		Toast.makeText(this, "您的选择是:" + query
				, Toast.LENGTH_SHORT).show();
		return false;
	}
	
	
}
