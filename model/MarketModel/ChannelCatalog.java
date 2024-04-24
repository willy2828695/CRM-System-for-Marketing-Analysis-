package model.MarketModel;

import java.nio.channels.Channels;
import java.util.ArrayList;
import java.util.Random;

import model.Business.Business;

public class ChannelCatalog {

    Business business;
    ArrayList<Channel> channels;

    public ChannelCatalog(Business b) {
        business = b;
        channels = new ArrayList<Channel>();
    }

    public Channel newChannel(String s) {
        Channel c = new Channel(s);
        channels.add(c);
        return c;
    }

    public ArrayList<Channel> getChannelList() {
        return channels;
    }

    public Channel pickRandomChannel() {
        if (channels.size() == 0)return null;
        Random r = new Random();
        int randomIndex = r.nextInt(channels.size());
        return channels.get(randomIndex);
    }
}
