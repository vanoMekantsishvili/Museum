package ge.pottersapp.vano.museum;

import java.io.Serializable;
import java.io.StreamCorruptedException;

/**
 * Created by vano on 4/26/2016.
 */
public class ExhibitionObject implements Serializable{
    private String title;
    private String img_url;
    private String link_url;
    public ExhibitionObject(String title, String img_url,String link_url) {
        this.title = title;
        this.img_url = img_url;
        this.link_url = link_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }



}
