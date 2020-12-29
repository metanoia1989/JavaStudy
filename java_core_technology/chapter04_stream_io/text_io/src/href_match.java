import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class href_match {
    public static void main(String[] args) {
        try {
            // get URL string from command line or use default
            String urlString; 
            if (args.length > 0) {
                urlString = args[0];
            } else {
                urlString ="http://www.anzhuoxfpx.com"; 
            }

            // open reader for URL
            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());
            // read contents into string builder
            StringBuilder input = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1) {
                input.append((char) ch); 
            }
            
            // search for all occurences of pattern
            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                String match = input.substring(start, end);
                System.out.println(match);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }    
        
    }
}
