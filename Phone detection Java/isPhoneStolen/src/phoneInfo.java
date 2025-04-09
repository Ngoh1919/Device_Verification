

public class phoneInfo {
    private String firstName;
    private String lastName;
    private String ownerId;
    private String deviceName;
    private String deviceId;
    private String deviceType;

    public phoneInfo(String firstName, String lastName, String ownerId, String deviceName, String deviceId, String deviceType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ownerId = ownerId;
        this.deviceName = deviceName;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    
}
