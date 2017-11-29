package com.example.kin.millionaire;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.URLConnection;


/**
 * Created by Kin on 28/9/2017.
 */

public class Database  {
	//AlertDialog alertDialog;
	Database() {
	}

	public String[][]  doInBackground() {
		String[][] data=null;
		String database_url = "https://leungwaikin.000webhostapp.com/database.php";
//leungwaikin.000webhostapp.com
			try {
			URL url = new URL(database_url);
			URLConnection urlCon = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
				String  q;
				String	a;
				String	b;
				String	c;
				String	d;
				String set;
				int size;
				size = Integer.parseInt(br.readLine());
				data = new String [size][5];
				for(int num = 0; num < data.length; num++){
					set=br.readLine();
					String[] tokens = set.split(" ");
					q = tokens[0];
					a = tokens[1];
					b = tokens[2];
					c = tokens[3];
					d = tokens[4];
					data[num][0]=q;
					data[num][1]=a;
					data[num][2]=b;
					data[num][3]=c;
					data[num][4]=d;
				}
				br.close();
		} catch(Exception e){
			// handle errors here...
			}
      return  data;
	}
}