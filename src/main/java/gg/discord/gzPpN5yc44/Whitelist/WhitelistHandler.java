package gg.discord.gzPpN5yc44.Whitelist;


import gg.discord.gzPpN5yc44.Starter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WhitelistHandler implements Runnable {

    public static String Raw;

    public static void getPastes() throws IOException {
        URL u = new URL("https://pastebin.com/Yc7uk4W6");
        URLConnection conn = u.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        conn.getInputStream()));
        StringBuffer buffer = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            buffer.append(inputLine);
        in.close();
        System.out.println(buffer.toString());
        Raw = buffer.toString();
        Starter.tested = true;
    }

    @Override
    public void run() {
        try {
            getPastes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
