package paramonod.kikos.myapplication;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import ru.yandex.yandexmapkit.utils.GeoPoint;


/**
 * Created by Varvara on 01.12.2016.
 */

public class Search {
    final static String STANDART_URL = "https://geocode-maps.yandex.ru/1.x/?format=json&geocode=";
    final static String NEW_STANDART_URL = "https://search-maps.yandex.ru/v1/?apikey=245e2b86-5cfb-40c3-a064-516c37dba6b2&lang=ru_RU&text=";
    public static URL url = null;
    public static MainActivity mainActivity = null;
    public void doSearch(String obj,MainActivity m) throws MalformedURLException {
        //this.url = new URL(STANDART_URL +obj);
        this.url = new URL(NEW_STANDART_URL + obj);
        System.out.println(url.toString());
        mainActivity = m;
        AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                Log.e("BEFORE I FUCK", "YOU");

                try {
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.connect();
                    // optional default is GET
                    con.setRequestMethod("GET");
                    //int responseCode = con.getResponseCode(); if smth crashes
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    String response = "";

                    while ((inputLine = in.readLine()) != null) {
                        response += inputLine;
                    }
                    in.close();
                    con.disconnect();
                    MainActivity.jsonObject = new JSONObject(response);
                    System.out.println(MainActivity.jsonObject.toString());
                } catch (Exception e) {
                    Log.e("FUCK", "YOU");
                    e.printStackTrace();

                }
                return null;
            }


            @Override
            protected void onPostExecute(Object ob) {
                super.onPostExecute(ob);


                Log.e("PRINT", "IFUCKYOUR MUM");
                mainActivity.updatePins(null);
                String resultString = "";
                try {
              /*      JSONObject j1 = MainActivity.jsonObject.getJSONObject("response");
                    JSONObject j2 = j1.getJSONObject("GeoObjectCollection");
                    JSONArray ja1 = j2.getJSONArray("featureMember");
                    items = new GeoPoint[ja1.length()];
                    */
                    JSONArray ja1 = MainActivity.jsonObject.getJSONArray("features");
                    for (int i = 0; i < ja1.length(); i++) {
                        JSONObject j0 = ja1.getJSONObject(i);
                        JSONObject j11 = j0.getJSONObject("properties");
                      //  JSONObject j21 = j11.getJSONObject("CompanyMetaData");
                        String name = j11.getString("name");
                        String description = j11.getString("description");
                        JSONObject j1 = j0.getJSONObject("geometry");
                        JSONArray ja2 = j1.getJSONArray("coordinates");

                       /* JSONObject j0 = ja1.getJSONObject(i);
                        JSONObject j3 = j0.getJSONObject("GeoObject");
                        System.out.println(j3.toString());
                        JSONObject j4 = j3.getJSONObject("Point");
                        resultString = j4.getString("pos");*/
                        resultString = ja2.get(0).toString()+" "+ja2.get(1).toString();
                        System.out.println(resultString);
                        String[] s1 = resultString.split(" ");
                        GeoPoint curG = new GeoPoint(Double.parseDouble(s1[1]), Double.parseDouble(s1[0]));
                        MainActivity.mc.setPositionAnimationTo(curG);
                        mainActivity.makingFullStackIcon(R.drawable.orpgshop,55,55,curG,name,description);
                    }

                } catch (JSONException js) {
                   System.err.println("F.U.C.K");
                    js.printStackTrace();
                }
            }
        }.execute();

    }

}
