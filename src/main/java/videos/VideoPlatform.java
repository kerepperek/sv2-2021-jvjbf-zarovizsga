package videos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    public List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return channels;
    }

    public void readDataFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            for (int i = 1; i < lines.size(); i++) {
                String[] splitted = lines.get(i).split(";");
                channels.add(new Channel(splitted[0], Long.valueOf(splitted[1]), Long.valueOf(splitted[2])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot open file for read!", ioe);
        }
    }

    public long calculateSumOfVideos() {
        return channels.stream().mapToLong(o -> o.getNumberOfVideos())
                .reduce(0, Long::sum);
    }
}
