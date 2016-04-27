import java.util.ArrayList;
import java.time.LocalDateTime;

public class CD {
  private int mID;
  private String mName;
  private String mArtist;
  private static ArrayList<CD> cdinstances = new ArrayList<CD>();
  private int mId;

  public CD(String name) {
    mName = name;
    mArtist = "Unknown";
    cdinstances.add(this);
    mId = cdinstances.size();
  }
  public CD(String name, String artist, int id) {
    mName = name;
    mArtist = artist;
    mId = id;
    cdinstances.set(id-1, this);
  }

  public String getName() {
    return mName;
  }
  public String getArtist() {
    return mArtist;
  }

  public static ArrayList<CD> all() {
    return cdinstances;
  }

  public int getId() {
    return mId;
  }

  public static CD find(int id) {
    try {
      return cdinstances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

}
