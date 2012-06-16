package com.kamalan.internetstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;

public class NetworkReceiver extends BroadcastReceiver {

	private final String TAG = "NetworkReceiver";
	
	private final String CONNECTED 		= "onReceive: Internet found.";
	private final String DISCONNECTED 	= "onReceive: Internet not found!";
	private final String WIFI_AVAILABLE 	= "onReceive: Wifi is available.";
	private final String WIFI_NOTAVAILABLE 	= "onReceive: Wifi is inavailable.";
	private final String _3G_AVAILABLE 	= "onReceive: 3G is available.";
	private final String _3G_NOTAVAILABLE 	= "onReceive: 3G is inavailable.";
	private final String WIFI_CONNECTED 	= "onReceive: Wifi is connected.";
	private final String WIFI_DISCONNECTED 	= "onReceive: Wifi is not connected.";
	private final String _3G_CONNECTED 	= "onReceive: 3G is connected.";
	private final String _3G_DISCONNECTED 	= "onReceive: 3G is not connected.";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "Inside Broadcast Receiver");
		
		boolean isNetworkDown = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);

        	ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        	android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        	android.net.NetworkInfo _3g = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        
		if (isNetworkDown)
		  Log.i(TAG, DISCONNECTED);
		else
		  Log.i(TAG, CONNECTED);
		
		if (wifi.isAvailable())
			Log.i(TAG, WIFI_AVAILABLE);
		else
			Log.i(TAG, WIFI_NOTAVAILABLE);
		
		if (_3g.isAvailable())
			Log.i(TAG, _3G_AVAILABLE);
		else
			Log.i(TAG, _3G_NOTAVAILABLE);
		
		if (wifi.isConnected())
			Log.i(TAG, WIFI_CONNECTED);
		else
			Log.i(TAG, WIFI_DISCONNECTED);
		
		if (_3g.isConnected())
			Log.i(TAG, _3G_CONNECTED);
		else
			Log.i(TAG, _3G_DISCONNECTED);
	}
}
