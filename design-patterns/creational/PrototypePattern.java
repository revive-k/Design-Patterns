public class PrototypePattern {
    public static void main(String[] args) {
        HotelRoomWithFeatures originalRoom =
                new HotelRoomWithFeatures("Deluxe", 101, true, new RoomFeatures("Balcony", "Single"));

        // Clone the object
        HotelRoomWithFeatures clonedRoom = originalRoom.clone();

        // Customize the cloned object
        clonedRoom.setRoomNumber(102);
        clonedRoom.setRoomType("Standard");

        // Output the objects to show they are different
        System.out.println("Original Room: " + originalRoom);
        System.out.println("Cloned Room: " + clonedRoom);
    }
}

// Class representing an object that needs deep copying
class RoomFeatures implements Cloneable {
    private String view;
    private String bedType;

    public RoomFeatures(String view, String bedType) {
        this.view = view;
        this.bedType = bedType;
    }

    @Override
    public RoomFeatures clone() {
        try {
            return (RoomFeatures) super.clone(); // Shallow copy of RoomFeatures
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "RoomFeatures{" +
                "view='" + view + '\'' +
                ", bedType='" + bedType + '\'' +
                '}';
    }
}

// HotelRoom with deep copy for RoomFeatures
class HotelRoomWithFeatures implements Cloneable {
    private String roomType;
    private int roomNumber;
    private boolean breakfastIncluded;
    private RoomFeatures features;

    public HotelRoomWithFeatures(String roomType, int roomNumber, boolean breakfastIncluded, RoomFeatures features) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.breakfastIncluded = breakfastIncluded;
        this.features = features;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public HotelRoomWithFeatures clone() {
        try {
            HotelRoomWithFeatures cloned = (HotelRoomWithFeatures) super.clone();
            cloned.features = this.features.clone();  // Deep copy of RoomFeatures
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "HotelRoomWithFeatures{" +
                "roomType='" + roomType + '\'' +
                ", roomNumber=" + roomNumber +
                ", breakfastIncluded=" + breakfastIncluded +
                ", features=" + features +
                '}';
    }
}
