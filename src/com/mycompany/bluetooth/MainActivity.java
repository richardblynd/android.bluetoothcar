package com.mycompany.bluetooth;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.bluetooth.*;


public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
		if(bluetooth != null)
		{
		    String status;
			if (bluetooth.isEnabled()) {
				String mydeviceaddress = bluetooth.getAddress();
				String mydevicename = bluetooth.getName();
				int istate = bluetooth.getState();
				String state;
				if (istate == 11)
					state = "Turning On";
				else if (istate == 12)
				    state = "On";
				else if (istate == 13)
				    state = "Turning Off";
				else
				    state = "Off";
					
				status = mydevicename + " : " + mydeviceaddress + " : " + state;
				
				
			}
			else
			{
				status = "Bluetooth is not Enabled.";
			}
			Toast.makeText(this, status, Toast.LENGTH_LONG).show();
		}
		
    }
}
