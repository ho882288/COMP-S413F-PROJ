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

/**
 * Created by Kin on 28/9/2017.
 */

public class Database //extends AsyncTask<String, Void, String>
{
/*
	//AlertDialog alertDialog;
	Context context;

	Database(Context ctx) {
		context = ctx;
	}
	protected String doInBackground(String... params) {

		String database_url = "https://leungwaikin.000webhostapp.com/database.php";

		try {
			URL url = new URL(database_url);
			String username = "lo";
			System.out.print(username);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			OutputStream outputStream = httpURLConnection.getOutputStream();
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
			String post_data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
			bufferedWriter.write(post_data);
			bufferedWriter.flush();
			bufferedWriter.close();
			outputStream.close();
			InputStream inputStream = httpURLConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
			String result = "";
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				result += line;
			}
			result = result.replace("connection success", "");
			System.out.println(result);
			bufferedReader.close();
			inputStream.close();
			httpURLConnection.disconnect();
			return result;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		}

	@Override
	protected void onPreExecute() {


	}

	@Override
	protected void onPostExecute(String result) {
		QuestionData q = (QuestionData) Asyntaskcontext;
		q.setQuestion(result);
		super.onPostExecute(result);

		//QuestionData qa=new QuestionData();
		//String[] parts = result.split("\r\n");
		//qa.setQuestion(parts);
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		super.onProgressUpdate(values);
	}

}

*/
}
/*
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
	*/
