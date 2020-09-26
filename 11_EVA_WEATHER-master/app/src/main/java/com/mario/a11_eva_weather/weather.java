package com.mario.a11_eva_weather;

public class weather {
    /* Nombre de la ciudad - String
    * temperautra -int
    *descripcion - String
    *imagen - int
    * alt+insert para crear
     */
    private String city;
    private int weather;
    private  String description;
    private  int image;

    public weather(){
        this.city = "";
        this.weather = 0;
        this.description = "";
        this.image = -1;
    }

    public weather(String city, int weather, String description, int image) {
        this.city = city;
        this.weather = weather;
        this.description = description;
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public int getWeather() {
        return weather;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWeather(int weather) {
        this.weather = weather;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
