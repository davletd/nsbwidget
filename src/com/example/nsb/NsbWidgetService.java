package com.example.nsb;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

public class NsbWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new NsbWidgetRemoteFactory(this.getApplicationContext(), intent);
    }
    
    
    
}

/**
 * This is the factory that will provide data to the collection widget.
 */
class StackRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {
    private Context mContext;
    private Cursor mCursor;
    private int mAppWidgetId;

    public StackRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
    }

    public void onCreate() {
        // Since we reload the cursor in onDataSetChanged() which gets called immediately after
        // onCreate(), we do nothing here.
    }

    public void onDestroy() {
        if (mCursor != null) {
            mCursor.close();
        }
    }

    public int getCount() {
        return mCursor.getCount();
    }

    public RemoteViews getViewAt(int position) {
        // Get the data for this position from the content provider
        String city = "Unknown City";
        int temp = 0;
//        if (mCursor.moveToPosition(position)) {
//            final int cityColIndex = mCursor.getColumnIndex(WeatherDataProvider.Columns.CITY);
//            final int tempColIndex = mCursor.getColumnIndex(
//                    WeatherDataProvider.Columns.TEMPERATURE);
//            city = mCursor.getString(cityColIndex);
//            temp = mCursor.getInt(tempColIndex);
//        }

        // Return a proper item with the proper city and temperature.  Just for fun, we alternate
        // the items to make the list easier to read.
        final String formatStr = mContext.getResources().getString(R.string.hello_world);
        final int itemId = (position % 2 == 0 ? R.layout.row
                : R.layout.row);
        RemoteViews rv = new RemoteViews(mContext.getPackageName(), itemId);
        rv.setTextViewText(R.id.textView1, String.format(formatStr, temp, city));

        // Set the click intent so that we can handle it and show a toast message
        final Intent fillInIntent = new Intent();
//        final Bundle extras = new Bundle();
//        extras.putString(WeatherWidgetProvider.EXTRA_CITY_ID, city);
//        fillInIntent.putExtras(extras);
//        rv.setOnClickFillInIntent(R.id.widget_item, fillInIntent);

        return rv;
    }
    public RemoteViews getLoadingView() {
        // We aren't going to return a default loading view in this sample
        return null;
    }

    public int getViewTypeCount() {
        // Technically, we have two types of views (the dark and light background views)
        return 2;
    }

    public long getItemId(int position) {
        return position;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void onDataSetChanged() {
        // Refresh the cursor
        if (mCursor != null) {
            mCursor.close();
        }
//        mCursor = mContext.getContentResolver().query(WeatherDataProvider.CONTENT_URI, null, null,
//                null, null);
    }
}
