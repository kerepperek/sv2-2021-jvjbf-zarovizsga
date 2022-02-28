package videos;

import java.nio.file.Path;

public class Channel {

    private String channelName;
    private long subscriptions;
    private long numberOfVideos;

    public Channel(String channelName, long subscriptions, long numberOfVideos) {
        this.channelName = channelName;
        this.subscriptions = subscriptions;
        this.numberOfVideos = numberOfVideos;
    }

    public String getChannelName() {
        return channelName;
    }

    public long getSubscriptions() {
        return subscriptions;
    }

    public long getNumberOfVideos() {
        return numberOfVideos;
    }
}
