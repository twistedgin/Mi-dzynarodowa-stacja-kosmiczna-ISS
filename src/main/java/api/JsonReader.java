package api;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

    public class JsonReader {

        private static JSONArray obj;

        private static String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        }

        public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);
                return json;
            } finally {
                is.close();
            }
        }


/*
            JSONArray obj = null;
*//*
            JSONArray checkArray = obj.getJSONArray("checkArray");
            JSONObject checkObj;
            for (int itemIndex=0, totalObject = checkArray.length(); itemIndex < totalObject; itemIndex++) {
                checkObj = checkArray.getJSONObject(itemIndex);
                String craftName = checkObj.getString("name");
                System.out.println(craftName);

                kombinacje do tablicy z jsona :)
                */


        }

