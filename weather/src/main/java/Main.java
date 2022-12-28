import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            //Public APIs:
            //http://dataservice.accuweather.com/tropical/v1/gov/storms/{yyyy}
            //"http://dataservice.accuweather.com/forecasts/v1/daily/5day/7894?apikey=OXWZnqaHogJarGc2ClSElaARKuCGnybP"
            //"http://dataservice.accuweather.com/currentconditions/v1/7894?apikey=OXWZnqaHogJarGc2ClSElaARKuCGnybP"
            //"http://dataservice.accuweather.com/locations/v1/cities/search?apikey=OXWZnqaHogJarGc2ClSElaARKuCGnybP&q=Buenos%20Aires"
            //URL url = new URL("http://dataservice.accuweather.com/currentconditions/v1/7894?apikey=OXWZnqaHogJarGc2ClSElaARKuCGnybP");

            URL url = new URL("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=OXWZnqaHogJarGc2ClSElaARKuCGnybP&q=Buenos%20Aires");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Revisa si hay conexion
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Cierre de scanner
                scanner.close();

                System.out.println(informationString);


                //Se convierte string a JSON
                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
/*              JSONParser parser = new JSONParser();
                Object dataObject = parser.parse(String.valueOf(informationString));
                JSONArray array = new JSONArray();
                array.add(dataObject);*/

                //Trae todos los resultados de la busqueda "Buenos Aires"
                System.out.println(dataObject.get(0));

                JSONObject countryData = (JSONObject) dataObject.get(0);

                //Trae solo la informacion del codigo "7894" (Buenos Aires)
                System.out.println(countryData.get("7894"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}