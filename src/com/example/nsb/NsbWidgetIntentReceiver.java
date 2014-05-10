//package com.example.nsb;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.widget.RemoteViews;
//
//public class NsbWidgetIntentReceiver extends BroadcastReceiver {
//
//	private static int clickCount = 0;
//
//	@Override
//	public void onReceive(Context context, Intent intent) {
//		initWidget(context);
//		
//		if(intent.getAction().equals("pl.looksok.intent.action.CHANGE_PICTURE")){
//			updateWidgetPictureAndButtonListener(context);
//		}
//	}
//	
//	private void initWidget(Context context) {
//		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
//		remoteViews.setTextViewText(R.id.TextView01, "Trikk 12: Innstilt mellom Stortorvet og Homansbyen");
//		NsbWidgetProvider.pushWidgetUpdate(context.getApplicationContext(), remoteViews);	
//	}
//
//	private void updateWidgetPictureAndButtonListener(Context context) {
//		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
//		remoteViews.setImageViewResource(R.id.widget_image, getImageToSet());
//		remoteViews.setTextViewText(R.id.TextView01, "Trikk 11: Innstilt mellom Stortorvet og Homansbyen");
//		//REMEMBER TO ALWAYS REFRESH YOUR BUTTON CLICK LISTENERS!!!
//		remoteViews.setOnClickPendingIntent(R.id.widget_button, NsbWidgetProvider.buildButtonPendingIntent(context));
//
//		NsbWidgetProvider.pushWidgetUpdate(context.getApplicationContext(), remoteViews);
//	}
//
//	private int getImageToSet() {
//		clickCount++;
//		return clickCount % 2 == 0 ? R.drawable.nsb_white : R.drawable.ic_launcher;
//	}
//}