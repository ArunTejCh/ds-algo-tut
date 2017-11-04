package com.arun.companies.FB;

import java.util.HashMap;

public class TinyURLEncodeDecode {
    public static void main(String[] args) {
        TinyURLEncodeDecode solution = new TinyURLEncodeDecode();
        String url1 = "http://google.com";
        String url2 = "http://facebook.com";
        String url3 = "https://reddit.com";

        assert solution.decode(solution.encode(url1)).equalsIgnoreCase(url1);
        assert solution.decode(solution.encode(url2)).equalsIgnoreCase(url2);
        assert solution.decode(solution.encode(url3)).equalsIgnoreCase(url3);
    }

    // Encodes a URL to a shortened URL.
    HashMap<String, String> encoder = new HashMap<String, String>();
    HashMap<String, String> decoder = new HashMap<String, String>();
    int counter = 0;

    public String encode(String longUrl) {
        synchronized (this) {
            counter = counter + 1;
            String shortUrl = this.getShortUrl(counter);
            decoder.put(shortUrl, longUrl);
            encoder.put(longUrl, shortUrl);
        }
        return encoder.get(longUrl);
    }

    private String getShortUrl(int counter) {
        StringBuilder shortUrl = new StringBuilder();
        while (counter != 0) {
            int remainder = counter % 26;
            shortUrl.insert(0, (char)( 97 + remainder) );
            counter = counter / 26;
        }
        //System.out.println(shortUrl.toString());
        return shortUrl.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decoder.get(shortUrl);
    }
}
