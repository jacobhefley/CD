import java.util.ArrayList;

public class Artist {
  private String mAArtist;
  private int mId;
  private static ArrayList<Artist> instance = new ArrayList<Artist>();

  public Artist(String artist) {
    mAArtist = artist;
    instance.add(this);
    mId = instance.size();
  }
  public String getArtist() {
    return mAArtist;
  }
  public static ArrayList<Artist> all() {
    return instance;
  }

  public int getId() {
    return mId;
  }
  public static Artist find(int id) {
    try {
      return instance.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

}
