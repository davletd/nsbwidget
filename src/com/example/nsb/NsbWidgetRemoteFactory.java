package com.example.nsb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;

public class NsbWidgetRemoteFactory  implements RemoteViewsFactory
{
	private Context context = null;
	private int appWidgetId;
	
	private List<String> widgetList = new ArrayList<String>();
	
	public NsbWidgetRemoteFactory(Context context, Intent intent)
	{
	    this.context = context;
	    appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
	            AppWidgetManager.INVALID_APPWIDGET_ID);
	    Log.d("AppWidgetId", String.valueOf(appWidgetId));
	}
	
	private void updateWidgetListView()
	{
//	    String[] widgetFruitsArray = dbhelper.retrieveFruitsList();
		String[] widgetFruitsArray = {"item1", "item2"};
	    List<String> convertedToList = new ArrayList<String>(Arrays.asList(widgetFruitsArray));
	    this.widgetList = convertedToList;
	}
	
	@Override
	public int getCount()
	{
	    return widgetList.size();
	}
	
	@Override
	public long getItemId(int position)
	{
	    return position;
	}
	
	@Override
	public RemoteViews getLoadingView()
	{
	    // TODO Auto-generated method stub
	    return null;
	}
	
	@Override
	public RemoteViews getViewAt(int position)
	{
	    Log.d("WidgetCreatingView", "WidgetCreatingView");
	    RemoteViews remoteView = new RemoteViews(context.getPackageName(),
	            R.layout.row);
	
	    Log.d("Loading", widgetList.get(position));
	    remoteView.setTextViewText(R.id.widget_image, "HELLO");
	
	    return remoteView;
	}
	
	@Override
	public int getViewTypeCount()
	{
	    // TODO Auto-generated method stub
	    return 1;
	}
	
	@Override
	public boolean hasStableIds()
	{
	    // TODO Auto-generated method stub
	    return false;
	}
	
	@Override
	public void onCreate()
	{
	    // TODO Auto-generated method stub
	    updateWidgetListView();
	}
	
	@Override
	public void onDataSetChanged()
	{
	    // TODO Auto-generated method stub
	    updateWidgetListView();
	}
	
	@Override
	public void onDestroy()
	{
	    // TODO Auto-generated method stub
	    widgetList.clear();
	}
}