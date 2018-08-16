package androidacademy.minsk.lecture3lists.data;

import android.net.Uri;

public class Actor {

    private final String name;
    private final Uri avatar;
    private final boolean hasOscar;

    public Actor(String name, Uri avatar, boolean hasOscar) {
        this.name = name;
        this.avatar = avatar;
        this.hasOscar = hasOscar;
    }

    public String getName() {
        return name;
    }

    public Uri getAvatar() {
        return avatar;
    }

    public boolean hasOscar() {
        return hasOscar;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", avatar=" + avatar +
                ", hasOscar=" + hasOscar +
                '}';
    }
}
