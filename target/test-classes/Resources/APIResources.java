package Resources;

public enum APIResources {
    //enum is a special class in JAVA which has collection of constants or methods
    //change class to enum keyword
    AddPlaceAPI("/maps/api/place/add/json"),
    getPlaceAPI("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");
    private String resource;

    //create constructor
    APIResources(String resource) {
        this.resource=resource;
    }

    public String getResource(){
        return resource;
    }

}
