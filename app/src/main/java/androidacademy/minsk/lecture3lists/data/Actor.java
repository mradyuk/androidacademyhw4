package androidacademy.minsk.lecture3lists.data;

import android.net.Uri;

public class Actor {

    private final String name;
    private final Uri avatar_thumb;
    private final Uri avatar;
    private final String details;

    public Actor(String name, Uri avatar_thumb, Uri avatar, String details) {
        this.name = name;
        this.avatar_thumb = avatar_thumb;
        this.avatar = avatar;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public Uri getAvatar_thumb() {
        return avatar_thumb;
    }

    public Uri getAvatar() {
        return avatar;
    }

    public String getDetails() {
        return details;
    }
}
