package ohtu;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014087527";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats-2015.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        System.out.println("opiskelijanumero " + studentNr);

        System.out.println("");

        int hours = 0;
        int tehtavat = 0;
        for (int i = 0; i < subs.length; i++) {
            System.out.print("viikko " + (i + 1) + ": ");
            System.out.print(subs[i]);
            System.out.print("\n");
            hours += subs[i].getHours();
            tehtavat += subs[i].tehdytTehtavat();
        }
        System.out.println("");
        System.out.println("yhteensä: " + tehtavat + " tehtavaa " + hours + " tuntia");

    }
}