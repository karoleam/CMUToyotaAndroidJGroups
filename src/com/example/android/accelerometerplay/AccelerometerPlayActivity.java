/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.accelerometerplay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.BitmapFactory.Options;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cmu.practicum.app.*;

import java.util.List;

import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.RspList;

import cmu.practicum.JgroupsRpc;
import cmu.practicum.app.VehicleDistance;

/**
 * This is an example of using the accelerometer to integrate the device's
 * acceleration to a position using the Verlet method. This is illustrated with
 * a very simple particle system comprised of a few iron balls freely moving on
 * an inclined wooden table. The inclination of the virtual table is controlled
 * by the device's accelerometer.
 * 
 * @see SensorManager
 * @see SensorEvent
 * @see Sensor
 */

public class AccelerometerPlayActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        TextView tv = new TextView(this);
        tv.setText("Query Mode:");
        ll.addView(tv);
        
        
        
        
	
//_____________________________________________________________________________________________________________________________________________________________________

		JgroupsRpc jrpc = JgroupsRpc.getInstance();

		try {
			jrpc.start();
			
			
			
			int count = 10;
			while (count > 0) {
				RspList<VehicleDistance> rsp_list = jrpc.dispatch(
						ResponseMode.GET_ALL, 5000, new VehicleDistance(),
						VehicleDistance.class);
				List<VehicleDistance> it = rsp_list.getResults();
				for (VehicleDistance sinfo : it) {
					System.out.println("Vehiclename =" + sinfo.vehiclename + " , " + " distance=" + sinfo.distance);
					 EditText et = new EditText(this);
					 et.setText("Vehiclename");
					 et.setText("Vehiclename =" + sinfo.vehiclename + " , " + " distance=" + sinfo.distance);
					 ll.addView(et);
					 }

				System.out.println("***************");

				Thread.sleep(5000);
				count--;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//_____________________________________________________________________________________________________________________________________________________________________		

//        
//        for(int i = 0; i <100; i++){
//            EditText et = new EditText(this);
//            et.setText("loop is now:"+i);
//            ll.addView(et);
//        }
        this.setContentView(sv);

	}
}
