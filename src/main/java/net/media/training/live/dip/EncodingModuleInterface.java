package net.media.training.live.dip;

import java.net.URL;

public interface EncodingModuleInterface {
    public void encodeWithFiles();
    public String readURLContents(URL url);
    public void encodeBasedOnNetworkAndDatabase();
}
