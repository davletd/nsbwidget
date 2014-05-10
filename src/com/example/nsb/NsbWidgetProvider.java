package com.example.nsb;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class NsbWidgetProvider extends AppWidgetProvider
{   
    @Override
    public void onDeleted(Context context, int[] appWidgetIds)
    {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) 
    {
        super.onDisabled(context);
    }

    @Override
    public void onEnabled(Context context) 
    {
        super.onEnabled(context);
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
            int[] appWidgetIds) 
    {
        for(int i=0;i<appWidgetIds.length;i++)
        {
            RemoteViews rv = new RemoteViews(context.getPackageName(),
                    R.layout.nsb_widget);

//            Intent intent = new Intent(context, NsbWidgetService.class);
//            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
//                    appWidgetIds[i]);
//            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            rv.setOnClickPendingIntent(R.id.deviation_description, pendingIntent);
            rv.setOnClickPendingIntent(R.id.deviation_description_time, pendingIntent);
            rv.setOnClickPendingIntent(R.id.deviation_icon, pendingIntent);
            rv.setOnClickPendingIntent(R.id.deviation_description_2, pendingIntent);
            rv.setOnClickPendingIntent(R.id.deviation_description_time_2, pendingIntent);
            rv.setOnClickPendingIntent(R.id.deviation_icon_2, pendingIntent);
//            rv.setRemoteAdapter(R.id.Nsb_list, intent);
//            rv.setRemoteAdapter(appWidgetIds[i], R.id.Nsb_list, intent);
            appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}



//public class NsbWidgetProvider extends AppWidgetProvider {
//
//	@Override
//	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
//			int[] appWidgetIds) {
//		Intent intent = new Intent(context, NsbWidgetService.class);
//		intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, R.id.Nsb_list);
//		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
//		remoteViews.setRemoteAdapter(R.id.Nsb_list, intent);
//		remoteViews.setEmptyView(R.id.Nsb_list, R.id.widget_image);
//		remoteViews.setOnClickPendingIntent(R.id.widget_button, buildButtonPendingIntent(context));
//		initWidget(context, remoteViews);
//		pushWidgetUpdate(context, remoteViews);
//	}
//	
//	private void initWidget(Context context, RemoteViews remoteViews) {
//		remoteViews.setTextViewText(R.id.TextView01, "Trikk 12: Innstilt mellom Stortorvet og Homansbyen");
//		
//	}
//
//	public static PendingIntent buildButtonPendingIntent(Context context) {
//		Intent intent = new Intent();
//	    intent.setAction("pl.looksok.intent.action.CHANGE_PICTURE");
//	    return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//	}
//
//	public static void pushWidgetUpdate(Context context, RemoteViews remoteViews) {
//		ComponentName myWidget = new ComponentName(context, NsbWidgetProvider.class);
//	    AppWidgetManager manager = AppWidgetManager.getInstance(context);
//	    manager.updateAppWidget(myWidget, remoteViews);		
//	}
//}